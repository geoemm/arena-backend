package com.emmanoug.abe.dtos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Registry {

	@Id
    private Long id;

    private String name;

    private String description;
    
    private DeviceStatus status;
    
    private LocalDateTime lastState;
}
