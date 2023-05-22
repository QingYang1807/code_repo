package org.example.sort;

import java.util.*;

public class PigeonholeSort {
    public static void pigeonholeSort(int arr[]) {
        // 获取数组的最小和最大值
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        // 计算鸽巢（桶）的数量
        int range = max - min + 1;
        int[] phole = new int[range];

        // 初始化鸽巢
        Arrays.fill(phole, 0);

        // 将每个元素放入对应的鸽巢中
        for (int i = 0; i < arr.length; i++) {
            phole[arr[i] - min]++;
        }

        // 将鸽巢中的元素取出，放入原数组
        int index = 0;
        for (int j = 0; j < range; j++) {
            while (phole[j]-- > 0) {
                arr[index++] = j + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        pigeonholeSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}