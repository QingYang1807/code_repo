package org.example.sort;

public class BubbleSort {
    // 定义冒泡排序方法
    public static void bubbleSort(int[] arr) {
        // 如果数组为空或者长度小于等于1，不需要排序，直接返回
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 外层循环，用于控制排序的轮数，每轮确定一个最大（或最小）值的位置
        for (int i = 0; i < arr.length; i++) {
            // 定义一个标志，用于优化冒泡排序，如果在一轮排序中没有发生交换，说明数组已经有序，无需继续排序
            boolean swapped = false;

            // 内层循环，用于比较每一对相邻元素，如果顺序错误就把他们交换过来
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前一个元素大于后一个元素，交换它们
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // 如果在这一轮排序中没有发生交换，说明数组已经有序，直接返回
            if (!swapped) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
