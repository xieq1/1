package com.graduationproject.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * maintainid
 * @author 
 */
@Data
public class Maintainid implements Serializable {
    private Integer maintainid;

    private String macont;

    private Date madate;

    private BigDecimal macost;

    private String maintainer;

    private String maresult;

    private static final long serialVersionUID = 1L;
}