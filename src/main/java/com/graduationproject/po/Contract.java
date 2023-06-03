package com.graduationproject.po;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Lob;

/**
 * contract
 * @author 
 */
@Data
public class Contract implements Serializable {
    private Integer contractid;

    @Lob
    private String contractcontent;

    private String contractcontentname;

    private String contracslary;

    private String type;

    private static final long serialVersionUID = 1L;
}