package com.emmanoug.abe.dtos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Notifications {

	@Id
    private Long id;

    private String notification;

    private String deviceFrom;
    
    private LocalDateTime date;
}
