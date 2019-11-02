package com.xiayk.api.common.result;

import lombok.Data;

import java.util.List;

/**
 * @ClassName LimitResult
 * @Author XiaYk
 * @Date 2019-10-22 13:37
 * @Version 1.0
 */
@Data
public class LimitResult {

    private Integer count;

    private List<?> data;
}
