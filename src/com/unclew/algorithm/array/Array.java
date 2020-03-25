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
public interface Array {
    void add(Object e);
    Object get(int index);
    void rem(Object e);
    long length();
}
