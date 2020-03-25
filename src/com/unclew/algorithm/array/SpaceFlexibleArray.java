package com.unclew.algorithm.array;

import java.util.Arrays;

/**
 * Created by wuyingqiang
 * on 2020/3/25-10:59 下午.
 * <p>
 * 数组伸缩
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class SpaceFlexibleArray implements Array {
    private Object[] arr;
    private int size;
    private int length;
    public long deleteCompareTimes = 0;

    public static void main(String[] args) {
        /**
         * 使劲的进行数组伸缩，直到没有连续的空间使用
         *
         */
        System.out.println("测试数据： 1 .. 10000");

        SpaceFlexibleArray arr = new SpaceFlexibleArray(8);
        for (int i = 0; i < 10000; i++) {
            arr.add(i);
        }

        for (int i = 9999; i > 4; i--) {
            arr.rem(i);
        }
    }

    public SpaceFlexibleArray(int size) {
        arr = new Object[size];
        length = 0;
        this.size = size;
    }


    @Override
    public void add(Object e) {
        if (length * 2 > size) {
            // 申请更大的数组，扩大数组
            Object[] arr1 = arr;
            arr = new Object[size * 2];
            size = arr.length;
            // 迁移数据
            System.arraycopy(arr1, 0, arr, 0, length);
            System.out.println("数组空间扩张: " + size);
        }

        arr[length++] = e;
    }

    @Override
    public Object get(int index) {
        return arr[index];
    }

    @Override
    public void rem(Object e) {
        if (length * 2 < size && size > 8) {
            // 压缩数据
            Object[] arr1 = arr;
            arr = new Object[size / 2];
            size = arr.length;

            for (int i = 0; i < length; i++) {
                arr[i] = arr1[i];
            }
            System.out.println("数组压缩：" + size);
        }

        int remIndex = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(e)) {
                remIndex = i;
                break;
            }
        }


        for (int i = remIndex; i < length; i++) {
            deleteCompareTimes++;
            arr[i] = arr[i + 1];
        }

        length--;
    }

    @Override
    public long length() {
        return (long) length;
    }

    public String print() {
        return Arrays.toString(arr);
    }
}
