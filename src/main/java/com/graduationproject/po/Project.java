package com.graduationproject.po;

import java.io.Serializable;
import lombok.Data;

/**
 * project
 * @author 
 */
@Data
public class Project implements Serializable {
    private Integer projectid;

    private String projectname;

    private String projectcast;

    private String principal;

    private String buiders;

    private Integer designplanid;

    private static final long serialVersionUID = 1L;
}