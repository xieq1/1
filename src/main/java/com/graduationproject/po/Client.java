package com.graduationproject.po;

import java.io.Serializable;
import lombok.Data;

/**
 * client
 * @author 
 */
@Data
public class Client implements Serializable {
    private Integer clientid;

    private String clientname;

    private String phone;

    private String communicationrecord;

    private String shopname;

    private String feedback;

    private String sex;

    private String evaluate;

    private static final long serialVersionUID = 1L;
}