package tn.esprit.spring.Controller;

import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.RssFeedProvider;
import tn.esprit.spring.Entity.RssSubscription;
import tn.esprit.spring.Service.IRssProviderService;
import tn.esprit.spring.Service.IRssSubscriptionService;
import tn.esprit.spring.component.RssFeedView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="/api/RSS")
public class RssFeedController {
    @Autowired
    private RssFeedView view;
    @Autowired
    IRssProviderService iRssProviderService;
    @Autowired
    IRssSubscriptionService iRssSubscriptionService;

    @RequestMapping(value = "", produces = "application/*")
    public View getFeed() {
        return view;
    }
//RSS

    @GetMapping("/for/{userId}")
    public ResponseEntity<Object> rssByUser(@PathVariable Long userId){
       return iRssSubscriptionService.rssByUser(userId);
    }
//RSS provider crud

    @GetMapping("/providers")
    public ResponseEntity<Object> getNewsFeedPosts(){
        return iRssProviderService.getRssFeedProviders();
    }

    @GetMapping({"/provider/{id}"})
    public ResponseEntity<Object> getNewsFeedPost(@PathVariable Long id){
        return iRssProviderService.getRssFeedProvider(id);
    }
    @PostMapping
    @RequestMapping(path = "/provider/new")
    @ResponseBody
    public ResponseEntity<Object> addProvider(@RequestBody RssFeedProvider rssFeedProvider){

        return iRssProviderService.ajouterRssFeedProvider(rssFeedProvider);
    }
    @DeleteMapping({"/provider/delete/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return iRssProviderService.deleteRssFeedProvider(id);
    }
    @PutMapping
    @RequestMapping(path = "/provider/edit")
    @ResponseBody
    public ResponseEntity<Object> edit(@RequestBody RssFeedProvider rssFeedProvider){
        return iRssProviderService.modifierRssFeedProvider(rssFeedProvider);
    }
    //RSS subscription
    @PostMapping
    @RequestMapping(path = "/subscribe/{subscriberId}/{providerId}")
    @ResponseBody
    public ResponseEntity<Object> addSubscription(@PathVariable(value = "subscriberId") Long subscriber, @PathVariable(value = "providerId") Long providerId){

            return iRssSubscriptionService.subscribe(subscriber,providerId);

    }
    @PostMapping
    @RequestMapping(path = "/unsubscribe/{subscriberId}/{providerId}")
    @ResponseBody
    public ResponseEntity<Object> deleteSubscription(@PathVariable(value = "subscriberId") Long subscriber, @PathVariable(value = "providerId") Long providerId){

        return iRssSubscriptionService.unsubscribe(subscriber,providerId);

    }

}
