package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.RssFeedProvider;
import tn.esprit.spring.Entity.RssSubscription;

import java.util.List;

@Repository
public interface RssSubscriptionRepository extends CrudRepository<RssSubscription,Long> {
    RssSubscription findRssSubscriptionByProviderAndSubscriber(RssFeedProvider provider, BsUser subscriber);
    Boolean existsRssSubscriptionBySubscriberAndProvider( BsUser subscriber,RssFeedProvider provider);
    List<RssSubscription> findRssSubscriptionBySubscriber(BsUser subscriber);
}
