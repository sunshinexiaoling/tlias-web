package com.tliasweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ling
 * @desc:
 * @date 2024/3/16 1:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private long total;
    private List rows;
}
