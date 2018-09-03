package com.emmanoug.abe.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emmanoug.abe.dtos.DeviceData;

public interface DeviceDataRepository extends MongoRepository<DeviceData, String> {

	List<DeviceData> findByDeviceName(String deviceName);
}
