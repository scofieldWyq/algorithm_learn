package com.unclew.algorithm.array;

import java.util.Arrays;

/**
 * Created by wuyingqiang
 * on 2020/3/24-10:50 下午.
 * <p>
 * 简单的数组，仅仅就是一个数据结构，并不具备对象或者类的概念
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SimpleArray {
    public static void main(String[] args) {
        // 创建
        int index = 0, deleteVar = -1, size = 7;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        System.out.println("数组:" + Arrays.toString(arr) + ",size:" + size);
        // 插入（更新）
        arr[index] = 8;
        System.out.println("插入 8(" + index + "):" + arr[index]);

        // 查找
        int var = arr[index];
        System.out.println("arr[index]:" + var);

        // 删除，后面元素向前移动，完成之后，元素 size--
        index = 4;
        int offsetIndex = index + 1;
        int tmpEle = arr[index]; // 暂存等待删除的元素

        for (int i = offsetIndex; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        size--;
        System.out.println("删除后(" + tmpEle + "):" + Arrays.toString(arr) + ",size:" + size);
    }
}
