package com.emmanoug.abe.dtos;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sensor_data")
public class RecordsPerDevice {
	
	private String deviceName;
	private int records;
}
