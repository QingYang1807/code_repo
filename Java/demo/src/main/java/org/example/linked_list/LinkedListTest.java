package org.example.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    // 测试添加头节点的功能
    @Test
    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<>();  // 创建一个空的链表
        list.addFirst(1);                          // 在链表头部添加一个元素
        assertEquals(1, list.getSize());        // 验证链表长度是否为1
        assertEquals(1, list.getFirst());       // 验证链表头节点的数据是否为1
        list.print();                                   // 打印链表
    }

    // 测试添加尾节点的功能
    @Test
    public void testAddLast() {
        LinkedList<Integer> list = new LinkedList<>();  // 创建一个空的链表
        list.addLast(1);                           // 在链表尾部添加一个元素
        assertEquals(1, list.getSize());        // 验证链表长度是否为1
        assertEquals(1, list.getLast());        // 验证链表尾节点的数据是否为1
        list.print();                                   // 打印链表
    }

    // 测试删除头节点的功能
    @Test
    public void testRemoveFirst() {
        LinkedList<Integer> list = new LinkedList<>();  // 创建一个空的链表
        list.addFirst(1);                          // 在链表头部添加一个元素
        list.addFirst(2);                          // 在链表头部添加一个元素
        list.print();                                   // 打印链表
        assertEquals(2, list.removeFirst());    // 验证删除的头节点的数据是否为2
        assertEquals(1, list.getSize());        // 验证链表长度是否为1
        assertEquals(1, list.getFirst());       // 验证链表头节点的数据是否为1
        list.print();                                   // 打印链表
    }

    // 测试删除尾节点的功能
    @Test
    public void testRemoveLast() {
        LinkedList<Integer> list = new LinkedList<>();  // 创建一个空的链表
        list.addLast(1);                           // 在链表尾部添加一个元素
        list.addLast(2);                           // 在链表尾部添加一个元素
        list.print();                                   // 打印链表
        assertEquals(2, list.removeLast());     // 验证删除的尾节点的数据是否为2
        assertEquals(1, list.getSize());        // 验证链表长度是否为1
        assertEquals(1, list.getLast());        // 验证链表尾节点的数据是否为1
        list.print();                                   // 打印链表
    }
}
