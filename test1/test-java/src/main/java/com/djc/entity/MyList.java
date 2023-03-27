package com.djc.entity;

import lombok.Data;

import java.util.List;

/**
 * 用于接收批量操作的json数据
 * @param <E>
 */
@Data
public class MyList<E> {
    private List<E> list;
}
