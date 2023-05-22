package org.example.search;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希查找算法
 *
 * 时间复杂度分析：
 * 哈希查找的平均时间复杂度为O(1)。这是因为哈希表的查找操作的平均时间复杂度为O(1)。在最好的情况下，哈希表没有冲突，查找操作的时间复杂度为O(1)。在最坏的情况下，所有的键都发生了冲突，查找操作的时间复杂度为O(n)，其中n为哈希表的大小。但是，如果哈希函数选择得当，哈希表的查找操作的平均时间复杂度可以接近O(1)。
 *
 * 空间复杂度分析：
 * 哈希查找的空间复杂度为O(n)，其中n为哈希表的大小。这是因为在初始化哈希表的过程中，我们将所有的元素都存入了哈希表中，因此哈希表的大小和输入数组的大小是一样的。
 */
public class HashSearch {
    // 创建一个哈希表
    Map<Integer, Integer> hashTable = new HashMap<>();

    // 用哈希表保存数组的元素和索引
    public HashSearch(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], i);
        }
    }

    // 查找元素的方法
    public int search(int target) {
        // 如果哈希表中包含目标元素，返回其索引
        if (hashTable.containsKey(target)) {
            return hashTable.get(target);
        }
        // 如果哈希表中不包含目标元素，返回-1
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        HashSearch hashSearch = new HashSearch(nums);
        System.out.println(hashSearch.search(7));  // 输出: 6
    }
}