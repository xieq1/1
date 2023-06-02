package com.graduationproject.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * purchase
 * @author 
 */
@Data
public class Purchase implements Serializable {
    private Integer purid;

    private String item;

    private Integer purquantity;

    private String supplier;

    private Date purtime;

    private static final long serialVersionUID = 1L;
}