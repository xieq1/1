package com.graduationproject.po;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * materials
 * @author 
 */
@Data
public class Materials implements Serializable {
    private Integer materialsid;

    private String materialsname;

    private String speciaficarion;

    private String inventory;

    private BigDecimal price;

    private String variety;

    private static final long serialVersionUID = 1L;
}