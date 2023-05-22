package org.example.sort;

public class ShellSort {
    // 希尔排序方法
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // 初始步长设为数组长度的一半，之后步长逐次减半，直到步长为1
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 从第gap个元素开始，逐个对其所在组进行直接插入排序
            for (int i = gap; i < n; i++) {
                int j = i;
                int current = arr[i];
                // 如果当前元素小于其同组前面的元素，则将前面的元素后移，然后继续向前比较
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                // 找到了比当前元素大的元素的位置，将当前元素插入到这个位置
                arr[j] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        shellSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}