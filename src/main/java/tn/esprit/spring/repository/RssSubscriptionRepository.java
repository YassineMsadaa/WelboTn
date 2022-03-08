package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Entity.RssFeedProvider;
import tn.esprit.spring.Entity.RssSubscription;

import java.util.List;

@Repository
public interface RssSubscriptionRepository extends CrudRepository<RssSubscription,Long> {
    RssSubscription findRssSubscriptionByProviderAndSubscriber(RssFeedProvider provider, User subscriber);
    Boolean existsRssSubscriptionBySubscriberAndProvider(User subscriber, RssFeedProvider provider);
    List<RssSubscription> findRssSubscriptionBySubscriber(User subscriber);
}
