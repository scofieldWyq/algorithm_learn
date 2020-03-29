package com.unclew.algorithm.array;

/**
 * Created by wuyingqiang
 * on 2020/3/29-8:35 下午.
 *
 * @author wuyingqiang
 * @since 1.0
 */
public class TelescopicArray<T> implements TelescopicStrategy, Array<T> {
    private Object[] arr;
    private int size = 0;

    @Override
    public int stretch() {
        if (arr == null || size + 1 >= arr.length) {
            // 伸展
            int stretchLength = size * 2;
            if (stretchLength == 0) {
                stretchLength = 2;
            }
            Object[] arrBak = new Object[stretchLength];
            if (arr != null)
                System.arraycopy(arr, 0, arrBak, 0, arr.length);

            arr = arrBak;
        }

        return arr.length;
    }

    @Override
    public int shrink() {
        if (size > 2 && 2 * size < arr.length) {
            // 收缩
            Object[] arrBak = new Object[arr.length / 2];
            System.arraycopy(arr, 0, arrBak, 0, size);
            arr = arrBak;
        }

        return arr.length;
    }

    @Override
    public void insert(T ele, int index) {
        if (index < 0 || index > size) {
            return;
        }

        T ele1 = (T) arr[index];
        size++;

        // 开始处理
        stretch();
        arr[index] = ele;
        arr[size - 1] = ele1;
    }

    @Override
    public T get(int index) {
        if (index < size && index >= 0) {
            return (T) arr[index];
        }

        return null;
    }

    @Override
    public int indexOf(T e) {
        int i = 0;
        while (i < size) {
            if (arr[i].equals(e)) {
                return i;
            }

            i++;
        }

        return -1;
    }

    @Override
    public void add(T e) {
        stretch();
        arr[size++] = e;
    }

    @Override
    public void rem(T e) {
        int i = indexOf(e);
        arr[i] = arr[--size];
        shrink();
    }

    @Override
    public T rem(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        T ele = (T) arr[index];
        this.rem(ele);

        return ele;
    }


    public static void main(String[] args) {
        // 测试
    }
}
