package com.graduationproject.po;

import java.io.Serializable;
import lombok.Data;

/**
 * flow
 * @author 
 */
@Data
public class Flow implements Serializable {
    private Integer flowid;

    private String flowname;

    private Integer projectid;

    private Integer projectcast;

    private String builders;

    private String describe;

    private String cstrinfo;

    private String result;

    private static final long serialVersionUID = 1L;
}