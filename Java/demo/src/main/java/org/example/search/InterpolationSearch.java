package org.example.search;

/**
 * 插值查找算法
 * 插值查找是一种改进的二分查找算法，它在数据量大、关键字分布比较均匀的查找表中，其平均性能要比二分查找算法好。
 * 插值查找的基本思想是：根据要查找的关键字 key 与查找表中最大最小记录的关键字比较得出 key 落在查找表的什么地方，估计这个位置，
 * 然后与记录进行比较，这个过程与人类在字典中查找单词或在电话簿中查找订阅者名字的方法类似。
 *
 * 时间复杂度分析：
 * 如果关键字在数组中均匀分布，插值查找的平均时间复杂度为 O(log log n)。
 * 然而，在最坏的情况下（例如，当元素在数组中的分布极不均匀时），其时间复杂度可以退化为O(n)。
 *
 * 空间复杂度分析：
 * 插值查找算法的空间复杂度为 O(1)，这是因为它只需要固定的额外空间来存储一些变量，而无需额外的空间来存储数据。
 * 这使得它在空间效率上是非常高的，特别是对于大型数据集。
 */
public class InterpolationSearch {
    // 插值查找函数
    int interpolationSearch(int arr[], int lo, int hi, int x) {
        int pos;

        // 因为数组是排序的，所以元素必须在数组的大小范围内
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

            // 使用插值公式来估计位置
            pos = lo + ((x - arr[lo]) * (hi - lo)) / (arr[hi] - arr[lo]);

            // 如果找到元素，直接返回位置
            if (arr[pos] == x)
                return pos;

            // 如果元素大于 pos 的位置，继续在右边查找
            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi, x);

            // 如果元素小于 pos 的位置，继续在左边查找
            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1, x);
        }
        // 如果元素不存在，返回 -1
        return -1;
    }

    public static void main(String args[]) {
        InterpolationSearch is = new InterpolationSearch();
        int arr[] = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int n = arr.length;

        int x = 18; // 要查找的元素
        int index = is.interpolationSearch(arr, 0, n - 1, x);

        // 如果元素找到，打印索引
        if (index != -1)
            System.out.println("Element found at index " + index);
        else
            System.out.println("Element not found.");
    }
}