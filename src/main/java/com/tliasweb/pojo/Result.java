package com.tliasweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ling
 * @desc: 返回数据类
 * @date 2024/3/15 23:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {//增删改 成功
        return new Result(1, "success", null);
    }
    public static Result success(Object data) {//查询 成功
        return new Result(1, "success", data);
    }
    public static Result error(String message) {//失败响应
        return new Result(0, message, null);
    }
}
