package com.gqz.crm.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 描述
 *
 * @author gqz20
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    private boolean flag;
    private String message;
    private T data;
}
