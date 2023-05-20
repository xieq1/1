package com.graduationproject.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * statement
 * @author 
 */
@Data
public class Statement implements Serializable {
    private Integer statementid;

    private String statementname;

    private Date time;

    private String statementcontent;

    private static final long serialVersionUID = 1L;
}