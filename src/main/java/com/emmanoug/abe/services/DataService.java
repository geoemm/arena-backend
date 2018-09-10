package com.emmanoug.abe.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanoug.abe.dtos.DeviceData;
import com.emmanoug.abe.dtos.Notifications;
import com.emmanoug.abe.dtos.Registry;
import com.emmanoug.abe.repositories.DeviceDataRepository;
import com.emmanoug.abe.repositories.DeviceRepo;
import com.emmanoug.abe.repositories.NotificationsRepo;

@Service
public class DataService {
	
	@Autowired
	private DeviceDataRepository dataRepository;
	
	@Autowired
	private DeviceRepo deviceRepo;
	
	@Autowired
	private NotificationsRepo notificationsRepo;

	public List<DeviceData> getRecordsByNameAndDate(String deviceName, Date dateFrom, Date dateTo) {
		List<DeviceData> tempList = dataRepository.findByDeviceName(deviceName);
		List<DeviceData> finalList = tempList.stream().filter(x -> x.getTimestamp().after(dateFrom) && x.getTimestamp().before(dateTo))
				.collect(Collectors.toList());
		return finalList;
	}
	
	public List<DeviceData> getRecordsNyNameAndNumOfRecords(String deviceName, int numberOfRecords) {
		return dataRepository.findByDeviceName(deviceName).subList(0, numberOfRecords);
	}
	
	public List<DeviceData> getAllRecords() {
		return dataRepository.findAll();
	}
	
	public int getNumberOfDevices() {
		return deviceRepo.findAll().size();
	}
	
	public List<Registry> getListOfDevices() {
		return deviceRepo.findAll();
	}
	
	public List<Notifications> getNotifications() {
		return notificationsRepo.findAll();
	}
	
	public void markNotiAsRead(Integer id) {
		notificationsRepo.markNotiAsRead(id);
	}
}
