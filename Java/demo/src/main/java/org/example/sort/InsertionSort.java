package org.example.sort;

public class InsertionSort {
    // 定义插入排序方法
    public static void insertionSort(int[] arr) {
        // 如果数组为空或者长度小于等于1，不需要排序，直接返回
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 外层循环，从第二个元素开始（因为单个元素总是已排序的）
        for (int i = 1; i < arr.length; i++) {
            // 记录当前元素值
            int key = arr[i];
            int j = i - 1;

            // 内层循环，将比当前元素大的元素向右移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // 找到了比当前元素小的元素，将当前元素插入到这个位置
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}