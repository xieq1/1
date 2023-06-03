package com.graduationproject.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * pre
 * @author 
 */
@Data
public class Pre implements Serializable {
    private Integer preid;

    private String precontent;

    private Date predate;

    private String preperson;

    private BigDecimal precost;

    private Integer clid;

    private String clfeedback;

    private static final long serialVersionUID = 1L;
}