package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.Entity.RssFeedProvider;

import java.util.List;

public interface IRssProviderService {
    public ResponseEntity<Object> ajouterRssFeedProvider(RssFeedProvider rssprovider);
    public ResponseEntity<Object> deleteRssFeedProvider(Long rssproviderId);
    public ResponseEntity<Object> getRssFeedProviders();
    public ResponseEntity<Object> modifierRssFeedProvider(RssFeedProvider rssprovider);
    public ResponseEntity<Object> getRssFeedProvider(Long rssproviderId);
}
