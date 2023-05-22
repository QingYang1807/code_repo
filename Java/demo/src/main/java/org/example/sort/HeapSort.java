package org.example.sort;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // 构建一个最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 一个个从堆顶取出元素
        for (int i = n - 1; i > 0; i--) {
            // 交换当前元素和堆顶元素
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 堆的大小减一，重新heapify
            heapify(arr, i, 0);
        }
    }

    // 使以root为根的子树成为最大堆
    void heapify(int arr[], int n, int root) {
        int largest = root; // 初始化最大元素为root
        int left = 2 * root + 1; // 左子节点的索引
        int right = 2 * root + 2; // 右子节点的索引

        // 如果左子节点存在，且大于当前最大元素，则更新最大元素
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点存在，且大于当前最大元素，则更新最大元素
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大元素不是root
        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // 递归调用，使得修改后的子树仍满足堆的性质
            heapify(arr, n, largest);
        }
    }

    // 打印数组
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 测试
    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}