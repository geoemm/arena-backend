package com.emmanoug.abe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emmanoug.abe.dtos.Notifications;
import com.emmanoug.abe.services.DataService;

@RestController
@RequestMapping("/notifications_api")
public class NotificationsController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/getNotifications", method = RequestMethod.GET)
	public List<Notifications> getNotifications() {
		return dataService.getNotifications();
	}
	
	@RequestMapping(value = "/markNotificationAsRead/{id}", method = RequestMethod.GET)
	public void updateNotificationAsRead(@PathVariable("id") Integer id) {
		dataService.markNotiAsRead(id);
	}
}
