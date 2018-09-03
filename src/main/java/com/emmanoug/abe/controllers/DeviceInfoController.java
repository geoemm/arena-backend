package com.emmanoug.abe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emmanoug.abe.dtos.Registry;
import com.emmanoug.abe.services.DataService;

@RestController
@RequestMapping("/device_api")
public class DeviceInfoController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/getAllDevices", method = RequestMethod.GET)
	public List<Registry> getAllDevices() {
		return dataService.getListOfDevices();
	}
	
	@RequestMapping(value = "/getNumOfDevices", method = RequestMethod.GET)
	public int getNumOfDevices() {
		return dataService.getNumberOfDevices();
	}
}
