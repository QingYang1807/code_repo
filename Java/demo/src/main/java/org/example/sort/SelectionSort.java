package org.example.sort;

public class SelectionSort {
    // 定义选择排序方法
    public static void selectionSort(int[] arr) {
        // 如果数组为空或者长度小于等于1，不需要排序，直接返回
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 外层循环，用于控制排序的轮数，每轮确定一个最小值的位置
        for (int i = 0; i < arr.length; i++) {
            // 初始化当前轮次的最小值索引为i
            int minIndex = i;

            // 内层循环，用于查找最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                // 如果发现新的最小值，更新最小值索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 如果最小值索引不等于i，说明找到了新的最小值，需要交换
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr);
        System.out.println("Sorted array: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}