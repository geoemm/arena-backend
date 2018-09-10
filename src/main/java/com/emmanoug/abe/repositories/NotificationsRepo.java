package com.emmanoug.abe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emmanoug.abe.dtos.Notifications;

@Transactional
@Repository
public interface NotificationsRepo extends JpaRepository<Notifications, Long> {
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE device_registry.notifications SET notification_read = 1 where id = :id")
	public void markNotiAsRead(@Param("id") Integer id);
}
