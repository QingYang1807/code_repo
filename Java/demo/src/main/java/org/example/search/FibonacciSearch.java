package org.example.search;

import java.util.Arrays;

/**
 * 斐波那契查找算法
 * 斐波那契查找是一种搜索算法，它利用斐波那契数列的性质在有序数组中进行查找。它比二分查找更有优势，尤其是对于大型有序序列。
 *
 * 斐波那契查找的原理是：将数组分成两部分，前半部分的元素个数为F(k)-1，后半部分的元素个数为F(k-1)-1。则中间元素的下标为mid=low+F(k-1)-1。
 *
 * 时间复杂度分析：
 * O(log n)。这是因为每一步查找过程都可以将查找范围缩小为原来的一部分。
 *
 * 空间复杂度分析：
 * O(n)。这是因为在实现斐波那契查找算法时，我们创建了一个临时数组，这个数组的大小与输入数组的大小相同。
 *
 * 斐波那契查找的优点是：只需要用加法和减法运算，不需要用除法运算，而除法运算比加减法运算要慢得多。
 * 斐波那契查找的缺点是：需要事先准备好斐波那契数列，而且斐波那契数列的长度不能超过数组的长度。
 *
 * 斐波那契查找的步骤如下：
 *  1. 用斐波那契数列的值F(k)减1，得到的值为n，即F(k)-1=n。
 *  2. 将数组分成两部分，前半部分的元素个数为F(k)-1，后半部分的元素个数为F(k-1)-1。
 *  3. 比较中间元素和要查找的元素的大小。
 *  4. 如果中间元素大于要查找的元素，则在前半部分继续查找。
 *  5. 如果中间元素小于要查找的元素，则在后半部分继续查找。
 *  6. 如果中间元素等于要查找的元素，则查找成功。
 *  7. 如果查找失败，则继续用斐波那契数列分割数组，直到找到要查找的元素或者数组被分割成只有一个元素的子数组。
 */
public class FibonacciSearch {
    static int fibM_minus_2 = 0;  // 初始化斐波那契数列的前两个值
    static int fibM_minus_1 = 1;  // 初始化斐波那契数列的前两个值
    static int fibM = fibM_minus_2 + fibM_minus_1;  // 初始化斐波那契数列的第三个值

    static int OFFSET = -1;  // 初始化偏移量

    // 初始化斐波那契数列
    static int fibonacci(int length) {
        // 当前的斐波那契数小于数组长度时，继续生成斐波那契数列
        while (fibM < length) {
            fibM_minus_2 = fibM_minus_1;
            fibM_minus_1 = fibM;
            fibM = fibM_minus_2 + fibM_minus_1;
        }
        return fibM;
    }

    // 返回两个数中的较小值
    static int min(int x, int y) {
        return (x <= y) ? x : y;
    }

    // 斐波那契查找
    static int fibonacciSearch(int arr[], int x, int n) {
        // 生成足够长度的斐波那契数列
        fibonacci(n);

        // 当前的斐波那契数大于1时，继续查找
        while (fibM > 1) {
            // 确定分割元素的位置
            int i = min(OFFSET + fibM_minus_2, n - 1);

            // 如果分割元素小于查找元素，则在右子数组中查找
            if ((arr[i] < x)) {
                fibM = fibM_minus_1;
                fibM_minus_1 = fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
                OFFSET = i;
            }

            // 如果分割元素大于查找元素，则在左子数组中查找
            else if (arr[i] > x) {
                fibM = fibM_minus_2;
                fibM_minus_1 = fibM_minus_1 - fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
            }

            // 如果分割元素等于查找元素，返回分割元素的索引
            else return i;
        }

        // 如果查找元素等于数组的最后一个元素，返回最后一个元素的索引
        if (fibM_minus_1 == 1 && arr[OFFSET + 1] == x)
            return OFFSET + 1;

        // 查找失败，返回-1
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // 初始化数组
        int length = arr.length;  // 获取数组长度
        int element = 7;  // 设置查找元素
        int index = fibonacciSearch(arr, element, length);  // 调用斐波那契查找方法
        // 判断元素是否找到
        if (index >= 0)
            System.out.println("Element found at index " + index);  // 如果找到，打印元素的索引
        else
            System.out.println("Element not found");  // 如果未找到，打印元素未找到的信息
    }
}