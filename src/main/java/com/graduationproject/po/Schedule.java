package com.graduationproject.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * schedule
 * @author 
 */
@Data
public class Schedule implements Serializable {
    private Integer scheduleid;

    private Integer flowid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timescaleplan;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date practicalscale;

    private String cause;

    private String staffallocation;

    private String solution;

    private static final long serialVersionUID = 1L;
}