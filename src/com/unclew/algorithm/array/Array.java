package com.unclew.algorithm.array;

/**
 * Created by wuyingqiang
 * on 2020/3/24-10:50 下午.
 *
 * 提供数组的操作接口
 *
 * @author wuyingqiang
 * @since 1.0
 */
public interface Array<T> {
    void insert(T ele, int index);
    T get(int index);
    int indexOf(T e);
    void add(T e);
    void rem(T e);
    T rem(int index);
}
