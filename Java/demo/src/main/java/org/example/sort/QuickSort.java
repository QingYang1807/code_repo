package org.example.sort;

public class QuickSort {
    // 定义快速排序方法
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi 是分区的索引，arr[pi] 已经在正确的位置
            int pi = partition(arr, low, high);

            // 递归调用快速排序算法，对左右两个分区进行排序
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 定义分区方法
    public static int partition(int[] arr, int low, int high) {
        // 选择最右边的元素作为基准值
        int pivot = arr[high];
        int i = (low - 1); // 小于基准值元素的索引

        // 遍历数组，将小于基准值的元素放到基准值的左边，大于基准值的元素放到基准值的右边
        for (int j = low; j <= high - 1; j++) {
            // 如果当前元素小于基准值
            if (arr[j] < pivot) {
                i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和 arr[high] (或者基准值)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // 返回基准值的索引
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}