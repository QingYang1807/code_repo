package org.example.linked_list;

public class LinkedList<T> {
    // 节点类
    private class Node {
        T data;      // 节点数据
        Node next;   // 指向下一个节点的引用
        Node prev;   // 指向上一个节点的引用

        // 节点构造函数
        Node(T data) {
            this.data = data;
        }
    }

    private Node head;  // 链表头节点
    private Node tail;  // 链表尾节点
    private int size;   // 链表长度

    // 链表构造函数
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 检查链表是否为空
    public boolean isEmpty() {
        return size == 0;  // 如果链表长度为0，返回true，否则返回false
    }

    // 获取链表长度
    public int getSize() {
        return size;
    }

    // 在链表头部添加节点
    public void addFirst(T data) {
        Node newNode = new Node(data); // 创建新的节点
        if (isEmpty()) {               // 如果链表为空
            head = tail = newNode;     // 新节点既是头节点又是尾节点
        } else {
            newNode.next = head;       // 新节点的next指向原来的头节点
            head.prev = newNode;       // 原来的头节点的prev指向新节点
            head = newNode;            // 更新头节点为新节点
        }
        size++;                        // 链表长度加1
    }

    // 在链表尾部添加节点
    public void addLast(T data) {
        Node newNode = new Node(data); // 创建新的节点
        if (isEmpty()) {               // 如果链表为空
            head = tail = newNode;     // 新节点既是头节点又是尾节点
        } else {
            newNode.prev = tail;       // 新节点的prev指向原来的尾节点
            tail.next = newNode;       // 原来的尾节点的next指向新节点
            tail = newNode;            // 更新尾节点为新节点
        }
        size++;                        // 链表长度加1
    }

    // 删除头节点
    public T removeFirst() {
        if (isEmpty())                 // 如果链表为空
            return null;
        Node temp = head;              // 临时保存头节点
        if (head == tail) {            // 如果只有一个节点
            head = tail = null;        // 清空链表
        } else {
            head = head.next;          // 更新头节点为原来头节点的下一个节点
            head.prev = null;          // 新的头节点的prev设置为null
        }
        size--;                        // 链表长度减1
        return temp.data;              // 返回被删除的头节点数据
    }

    // 删除尾节点
    public T removeLast() {
        if (isEmpty())                 // 如果链表为空
            return null;
        Node temp = tail;              // 临时保存尾节点
        if (head == tail) {            // 如果只有一个节点
            head = tail = null;        // 清空链表
        } else {
            tail = tail.prev;          // 更新尾节点为原来尾节点的前一个节点
            tail.next = null;          // 新的尾节点的next设置为null
        }
        size--;                        // 链表长度减1
        return temp.data;              // 返回被删除的尾节点数据
    }

    // 获取头节点数据
    public T getFirst() {
        if (isEmpty())                 // 如果链表为空
            return null;
        return head.data;              // 返回头节点数据
    }

    // 获取尾节点数据
    public T getLast() {
        if (isEmpty())                 // 如果链表为空
            return null;
        return tail.data;              // 返回尾节点数据
    }

    // 打印链表
    public void print() {
        Node temp = head;              // 从头节点开始
        while (temp != null) {
            System.out.print(temp.data + " ");  // 打印节点数据
            temp = temp.next;          // 移动到下一个节点
        }
        System.out.println();
    }
}
