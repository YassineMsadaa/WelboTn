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
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.component.RssFeedView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RssFeedController {
    @Autowired
    private RssFeedView view;
    @RequestMapping(value = "/rss", produces = "application/*")
    public View getFeed() {
        return view;
    }



    @GetMapping("/rss/all")
    public List<NewsfeedPost> rssreader(){
       String args = "https://feeds.skynews.com/feeds/rss/uk.xml";
        boolean ok = false;
        List<NewsfeedPost> list = new ArrayList<>();

        if (args != "") {
            try {
                URL feedUrl = new URL(args);

                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));

                List res = feed.getEntries();
                for(Object o : res) {
                    NewsfeedPost postFromXml = new NewsfeedPost();
                  //System.out.println(((SyndEntryImpl) o).getDescription().getValue());
                    String content = ((SyndEntryImpl) o).getDescription().getValue();
                    System.out.println(content);
                    postFromXml.setContent(content);
                    list.add(postFromXml);
                }

                ok = true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ERROR: "+ex.getMessage());
            }
        }


        return list;
    }
    /*@GetMapping({"rss/{id}"})
    public ResponseEntity<Object> getNewsFeedPost(@PathVariable Long id){
        return iNewsFeedPostService.getNewsfeedPost(id);
    }*/

}
