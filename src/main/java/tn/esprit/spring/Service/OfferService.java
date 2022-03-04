package tn.esprit.spring.Service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.spring.Entity.Offer;
import tn.esprit.spring.Repository.OfferRepository;
import tn.esprit.spring.response.ResponseHandler;
import org.apache.commons.io.FileUtils;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService implements IOfferService{
    @Autowired
    OfferRepository offerRepository;
    @Override
    public ResponseEntity<Object> ajouterOffer(Offer offer) {
        try{
            if(offer.getImageUrl() != null){
                //get file extension
                String fileextension = FilenameUtils.getExtension(Paths.get(offer.getImageUrl()).getFileName().toString()).toLowerCase();
                //file must be an image
                if (fileextension.equals("png") || fileextension.equals("jpg") || fileextension.equals("jpeg") ){
                    offer.setImageUrl(uploadImgAndGetUrl(offer.getImageUrl()));
                }else {
                    return ResponseHandler.generateResponse("file extension "+fileextension+" is not allowed this is the list of allowed extensions: [png, jpg, jpeg]", HttpStatus.MULTI_STATUS, null);
                }
            }else {
                return ResponseHandler.generateResponse("offer image is required !", HttpStatus.MULTI_STATUS, null);
            }

            if(offer.getDescription().length()<=0){
                return ResponseHandler.generateResponse("You should set offer description!", HttpStatus.NOT_FOUND, offer);
            }
            if(offer.getTitle().length()<=0){
                return ResponseHandler.generateResponse("You should set offer title!", HttpStatus.MULTI_STATUS, offer);
            }
            if(!offer.getStartsAt().isBefore(offer.getExpiresAt())){
                return ResponseHandler.generateResponse("error : expires at < starts at!", HttpStatus.MULTI_STATUS, offer);
            }
            if(offer.getExpiresAt().isBefore(LocalDateTime.now())){
                return ResponseHandler.generateResponse("error : expires at must be > dcurrent date!", HttpStatus.MULTI_STATUS, offer);
            }

            offer.setState(false);
            offer.setCreatedAt(LocalDateTime.now());
            offerRepository.save(offer);
            return ResponseHandler.generateResponse("Successfully added offer!", HttpStatus.OK, offer);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }


    }

    @Override
    public ResponseEntity<Object> deleteOffer(Long offerId) {
        try{
            offerRepository.deleteById(offerId);
            return ResponseHandler.generateResponse("Successfully deleted offer!", HttpStatus.OK, null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }


    }

    @Override
    public ResponseEntity<Object> getOffers() {
        List<Offer> offers = (List<Offer>) offerRepository.findAll();
        LocalDateTime currentDate = LocalDateTime.now();
        for(Offer offer : offers){
            if((offer.getStartsAt().isBefore(currentDate) || offer.getStartsAt().equals(currentDate) ) &&( offer.getExpiresAt().isAfter(currentDate) || offer.getExpiresAt().equals(currentDate)) ){
                offer.setState(true);
                offerRepository.save(offer);
            }else {
                offer.setState(false);
                offerRepository.save(offer);
            }
        }
        offers = (List<Offer>) offerRepository.findAll();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, (List<Offer>) offers);
    }
    @Override
    public ResponseEntity<Object> getOffersByState(boolean state) {
        List<Offer> offers = (List<Offer>) offerRepository.findAll();
        LocalDateTime currentDate = LocalDateTime.now();
        for(Offer offer : offers){
            if((offer.getStartsAt().isBefore(currentDate) || offer.getStartsAt().equals(currentDate) ) &&( offer.getExpiresAt().isAfter(currentDate) || offer.getExpiresAt().equals(currentDate)) ){
                offer.setState(true);
                offerRepository.save(offer);
            }else {
                offer.setState(false);
                offerRepository.save(offer);
            }
        }
        offers = (List<Offer>) offerRepository.findAllByState(state);
        return ResponseHandler.generateResponse(!offers.isEmpty()?"Success":"No offers with state = "+state, HttpStatus.OK, (List<Offer>) offers);
    }

    @Override
    public void uploadFile(MultipartFile file) {

    }

    @Override
    public ResponseEntity<Object> modifierOffer( Offer offer) {
        LocalDateTime currentDate = LocalDateTime.now();
        if (offerRepository.findById(offer.getId()).isEmpty()){
            return ResponseHandler.generateResponse("No record with this id", HttpStatus.MULTI_STATUS, null);

        }
        if(offer.getDescription().length()<=0){
            return ResponseHandler.generateResponse("You should set offer description!", HttpStatus.NOT_FOUND, offer);
        }
        if(offer.getTitle().length()<=0){
            return ResponseHandler.generateResponse("You should set offer title!", HttpStatus.MULTI_STATUS, offer);
        }
        if(!offer.getStartsAt().isBefore(offer.getExpiresAt())){
            return ResponseHandler.generateResponse("error : expires at < starts at!", HttpStatus.MULTI_STATUS, offer);
        }
        if(offer.getExpiresAt().isBefore(LocalDateTime.now())){
            return ResponseHandler.generateResponse("error : expires at must be > dcurrent date!", HttpStatus.MULTI_STATUS, offer);
        }
        if(offer.getStartsAt().isBefore(currentDate) && offer.getExpiresAt().isAfter(currentDate)){
            offer.setState(true);
        }else{
            offer.setState(false);
        }
        offerRepository.save(offer);
        return ResponseHandler.generateResponse("Updated successfully!", HttpStatus.OK, offer);

    }

    @Override
    public ResponseEntity<Object> getOffer(Long offerId) {

        return ResponseHandler.generateResponse("success!", HttpStatus.OK, offerRepository.findById(offerId).get());

    }

    @Override
    public ResponseEntity<Object> updateOfferState(Long offerId) {
        Offer offer = offerRepository.findById(offerId).get();
        offer.setState(!offer.getState());
        offerRepository.save(offer);
        return ResponseHandler.generateResponse("state updated!", HttpStatus.OK, offer);

    }
    public String uploadImgAndGetUrl(String imageUrlFromComputer) throws IOException {
        byte[] image = Files.readAllBytes(Paths.get(imageUrlFromComputer));
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        FileUtils.writeByteArrayToFile(new File("images/offers/"+formattedDateTime+Paths.get(imageUrlFromComputer).getFileName()), image);
        return formattedDateTime+Paths.get(imageUrlFromComputer).getFileName().toString();
    }

}
