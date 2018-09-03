package com.emmanoug.abe.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emmanoug.abe.dtos.DeviceData;
import com.emmanoug.abe.services.DataService;

@RestController
@RequestMapping("/data_api")
public class DeviceDataController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/getRecordsForDevice", method = RequestMethod.GET)
	public List<DeviceData> getRecordsForOneDevice(@RequestParam(value="deviceName", required=true) String deviceName,
												   @RequestParam(value="dateFrom", required=false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date dateFrom,
												   @RequestParam(value="dateTo", required=false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date dateTo,
												   @RequestParam(value="numberOfRecords", required=false) Integer numberOfRecords) {
		
		if (numberOfRecords == null && dateFrom == null && dateTo == null) {
			return Collections.emptyList();
		}
			
		if (dateFrom == null && dateTo == null) {
			return dataService.getRecordsNyNameAndNumOfRecords(deviceName, numberOfRecords);
		} else {
			return dataService.getRecordsByNameAndDate(deviceName, dateFrom, dateTo);
		}
	}
	
	@RequestMapping(value = "/getLatestRecordsForAllDevices", method = RequestMethod.GET)
	public List<DeviceData> getLatestRecordsForAllDevices() {
		return dataService.getAllRecords();
	}
}
