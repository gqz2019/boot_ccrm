package com.gqz.crm.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * 封装查询条件
 * @author gqz20
 */
@Data
public class QueryPageDto<T> implements Serializable{
    private Integer currentPage;
    private Integer pageSize;
    private T queryString;

}