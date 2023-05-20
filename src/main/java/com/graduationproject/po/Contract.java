package com.graduationproject.po;

import java.io.Serializable;
import lombok.Data;

/**
 * contract
 * @author 
 */
@Data
public class Contract implements Serializable {
    private Integer contractid;

    private String contractcontent;

    private String contractcontentname;

    private String contracslary;

    private static final long serialVersionUID = 1L;
}