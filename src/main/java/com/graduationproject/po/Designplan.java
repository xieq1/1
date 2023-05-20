package com.graduationproject.po;

import java.io.Serializable;
import lombok.Data;

/**
 * designplan
 * @author 
 */
@Data
public class Designplan implements Serializable {
    private Integer designplanid;

    private String designsketch;

    private String consumable;

    private String cast;

    private String auditstatus;

    private String difficulty;

    private String quotation;

    private static final long serialVersionUID = 1L;
}