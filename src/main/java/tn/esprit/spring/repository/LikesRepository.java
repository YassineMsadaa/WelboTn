package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Likes;

@Repository
public interface LikesRepository extends CrudRepository <Likes,Long>{
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO notification_object (forum_post_id, news_feed_post_id,type) VALUES (:forum_post_id,:news_feed_post_id, :type)",nativeQuery = true)
	void insertnotifobj(@Param("forum_post_id") Long long1, @Param("news_feed_post_id") Long long2, @Param("type") int i);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO notifications (notification_object_id, status,user_id) VALUES (:notification_object_id,:status, :user_id)",nativeQuery = true)
	void insertnotification(@Param("notification_object_id") Long notification_object_id, @Param("status") boolean status, @Param("user_id") Long user_id);

	@Query(value = "SELECT id FROM notification_object ORDER BY id DESC LIMIT 1",nativeQuery = true)
	Long retrieveLastNotificationObjectId();
}