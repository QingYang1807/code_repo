package org.example.search;

/**
 * 二分查找算法
 * 二分查找是一种在排序数组中查找特定元素的搜索算法。它的工作原理是将数组分为两半，然后根据所查找的值与中间元素的比较结果来确定下一步在哪半部分数组中查找。
 *
 * 时间复杂度分析：
 * 二分查找算法的时间复杂度为O(log n)。每次比较后，搜索空间都会减半，因此在最坏的情况下，该算法需要O(log n)的时间来查找元素。
 *
 * 空间复杂度分析：
 * 如果使用递归版本的二分查找算法，空间复杂度为O(log n)，因为递归过程中需要用到栈空间。如果使用非递归（迭代）版本的二分查找算法，空间复杂度为O(1)，因为它只需要固定的额外空间来存储变量。
 */
public class BinarySearch {
    // 二分查找函数，使用递归
    int binarySearch(int arr[], int left, int right, int x) {
        if (right >= left) {  // 如果右边索引大于等于左边索引
            int mid = left + (right - left) / 2;  // 找到中间索引

            // 如果中间元素就是要查找的元素，直接返回中间索引
            if (arr[mid] == x)
                return mid;

            // 如果中间元素大于要查找的元素，搜索左半部分数组
            if (arr[mid] > x)
                return binarySearch(arr, left, mid - 1, x);

            // 如果中间元素小于要查找的元素，搜索右半部分数组
            return binarySearch(arr, mid + 1, right, x);
        }

        // 如果未找到元素，返回 -1
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = bs.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element found at index " + result);
    }
}