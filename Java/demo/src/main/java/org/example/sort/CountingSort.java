package org.example.sort;

public class CountingSort {
    public static void countingSort(int[] array) {
        int n = array.length;
        // 寻找数组中最大元素
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 创建计数数组，大小为最大元素+1
        int[] countArray = new int[max + 1];
        // 计数数组初始化
        for (int i = 0; i <= max; i++) {
            countArray[i] = 0;
        }
        // 遍历原数组，计数
        for (int i = 0; i < n; i++) {
            countArray[array[i]]++;
        }
        // 计数数组变形
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 创建结果数组
        int[] sortedArray = new int[n];
        // 遍历原数组，完成排序
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
        // 将结果拷贝回原数组
        System.arraycopy(sortedArray, 0, array, 0, n);
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 5, 2, 3, 5};
        countingSort(array);
        System.out.println("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}