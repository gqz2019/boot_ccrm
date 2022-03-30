package com.gqz.crm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：yp
 * @description : 封装分页返回结果
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class PageResult<T> implements Serializable{
    private Long total;
    private Long page;
    private Long size;
    private List<T> rows;
}
