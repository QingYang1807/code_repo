package org.example.sort;

public class MergeSort {
    // 定义归并排序方法
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // 找到中间点，以便于分割数组
            int m = l + (r - l) / 2;

            // 递归调用归并排序，对两个子数组进行排序
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // 合并两个已排序的子数组
            merge(arr, l, m, r);
        }
    }

    // 定义合并方法
    public static void merge(int[] arr, int l, int m, int r) {
        // 计算两个子数组的大小
        int n1 = m - l + 1;
        int n2 = r - m;

        // 创建两个临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 复制数据到临时数组
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // 合并两个临时数组

        // 初始索引
        int i = 0, j = 0;

        // 初始索引 of merged subarray
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制剩余元素（如果有的话）
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}