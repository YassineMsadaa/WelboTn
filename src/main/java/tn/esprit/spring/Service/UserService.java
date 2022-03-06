package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.IUserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository IUserRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String email;

    public boolean verify(String verificationCode) {
        User user = IUserRepository.findByVerificationCode(verificationCode);

        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            IUserRepository.save(user);

            return true;
        }

    }
    public void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = email;
        String senderName = "WelboTn";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "WelboTn.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getUserName());
        String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }
    @Override
    public User addUser(User user) {
        IUserRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        IUserRepository.deleteById(id);
    }

    @Override
    public List<User> getUsers() {

        return (List<User>) IUserRepository.findAll();
    }

    @Override
    public User updateUser( User User) {
        IUserRepository.save(User);
        return User;
    }

    @Override
    public User getUser(Long UserId) {
        return IUserRepository.findById(UserId).get();
    }
}