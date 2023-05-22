package org.example.sort;

import java.util.*;

public class RadixSort {
    // 获取数组中的最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 基数排序主函数
    public static void radixSort(int[] arr) {
        int max = getMax(arr); // 获取最大值

        // 从最低位开始，对每一位进行计数排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortByDigit(arr, exp);
        }
    }

    // 对数组按指定位数进行计数排序
    public static void countSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 存储排序后的数组
        int[] count = new int[10]; // 存储0-9各个位数的计数

        // 初始化计数数组
        Arrays.fill(count, 0);

        // 对指定位数进行计数
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 计算count数组的前缀和，使count[i]表示小于等于i的元素的个数，为后续的排序做准备
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 构建输出数组
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将排序后的数组复制到原数组中
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        radixSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}