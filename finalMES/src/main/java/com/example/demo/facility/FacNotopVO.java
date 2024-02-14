package com.example.demo.facility;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FacNotopVO {
    private String facNotCode;
    private String facCode;
    //private String facPerson;
    //private String notopCode;
    //private String businessCode;
    //private String notopContent;
    private String facName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date facNotSdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date facNotLdate;
    private String facNotPerson;
    private int facNotSituation;
    private String facNotReason;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //private Date facDate;
}