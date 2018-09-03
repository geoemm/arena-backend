package com.emmanoug.abe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emmanoug.abe.dtos.Notifications;

@Repository
public interface NotificationsRepo extends JpaRepository<Notifications, Long> {

}
