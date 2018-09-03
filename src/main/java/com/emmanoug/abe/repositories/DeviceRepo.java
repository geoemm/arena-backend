package com.emmanoug.abe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emmanoug.abe.dtos.Registry;

@Repository
public interface DeviceRepo extends JpaRepository<Registry, Long> {

}
