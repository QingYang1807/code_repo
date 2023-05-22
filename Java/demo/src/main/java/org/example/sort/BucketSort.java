package org.example.sort;

import java.util.*;

public class BucketSort {

    public static void bucketSort(int[] arr) {
        // 获取数组中的最大值和最小值
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // 计算桶的数量。这里假设每个桶里面最多有2个元素，并且所有元素均匀分布。
        int bucketCount = (max - min) / 2 + 1;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }

        // 将每个元素放入桶
        for (int num : arr) {
            int index = (num - min) / 2;
            LinkedList<Integer> bucket = buckets.get(index);
            // 保持桶内元素的有序性。这里假设输入的数据服从均匀分布，所以可以使用插入排序
            if (bucket.isEmpty()) {
                bucket.offer(num);
            } else {
                boolean insertFlag = true;
                ListIterator<Integer> it = bucket.listIterator();
                while (it.hasNext()) {
                    if (num < it.next()) {
                        it.previous();
                        it.add(num);
                        insertFlag = false;
                        break;
                    }
                }
                if (insertFlag) {
                    bucket.offer(num);
                }
            }
        }

        // 输出桶中的元素
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bucketSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}