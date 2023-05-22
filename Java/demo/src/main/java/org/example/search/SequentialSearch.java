package org.example.search;

/**
 * 顺序查找算法
 * 顺序查找是一种简单的查找算法，它的工作原理是从数组的一端开始，逐个检查每个元素直到找到所需的元素。
 *
 * 时间复杂度分析：
 * 顺序查找算法的时间复杂度为O(n)，这是因为在最坏的情况下，你可能需要检查数组中的每个元素。这种情况发生在你要找的元素位于数组的末尾或者元素不在数组中。
 * 同样，平均情况下的时间复杂度也是O(n)。虽然在某些情况下，你可能会提前找到元素，但是平均来看，你可能需要查看大约n/2个元素，因此时间复杂度为O(n)。
 *
 * 空间复杂度分析：
 * 由于顺序查找算法只需要固定的额外空间来存储变量，因此它的空间复杂度为O(1)。
 */
public class SequentialSearch {
    public static int search(int arr[], int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;  // 返回找到的元素的索引
        }
        return -1;  // 如果没有找到元素，则返回 -1
    }

    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int x = 30;
        int index = search(arr, x);
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found in array");
    }
}
