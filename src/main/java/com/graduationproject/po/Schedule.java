package com.graduationproject.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * schedule
 * @author 
 */
@Data
public class Schedule implements Serializable {
    private Integer scheduleid;

    private String projectname;

    private Date timescaleplan;

    private String practicalscale;

    private String cause;

    private String staffallocation;

    private String solution;

    private static final long serialVersionUID = 1L;
}