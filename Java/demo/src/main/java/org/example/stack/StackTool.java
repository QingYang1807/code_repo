package org.example.stack;

import java.util.EmptyStackException;

public class StackTool {
    // 初始化一个Object数组来存储栈元素
    private Object[] elements;
    // 定义一个栈顶指针，初始化为-1，表示栈为空
    private int top = -1;

    // 栈的构造函数，定义栈的大小
    public StackTool(int capacity) {
        // 设置栈的大小
        elements = new Object[capacity];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        // 当top为-1时，栈为空
        return top == -1;
    }

    // 获取栈的大小
    public int size() {
        // 栈的大小等于top指针+1
        return top + 1;
    }

    // 向栈中压入元素
    public void push(Object element) {
        // 先检查栈是否已满
        if (top == elements.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        // 向栈顶增加元素，top指针+1
        elements[++top] = element;
    }

    // 从栈中弹出元素
    public Object pop() {
        // 先检查栈是否为空
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // 返回栈顶元素，同时top指针-1
        return elements[top--];
    }

    // 查看栈顶元素但不移除
    public Object peek() {
        // 先检查栈是否为空
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // 返回栈顶元素
        return elements[top];
    }
}
