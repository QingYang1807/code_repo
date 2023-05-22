package org.example.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class StackToolTest {
    private StackTool stack;

    // 使用@Before标签的方法会在每个测试用例开始之前执行
    @Before
    public void setup() {
        // 在每个测试用例开始之前，我们都会创建一个新的StackTool对象，这是为了确保每个测试用例都在清楚无误的环境下开始
        stack = new StackTool(5);
    }

    // 使用@Test标签的方法是一个测试用例
    @Test
    public void testPushAndPop() {
        // 我们首先测试push方法和pop方法
        stack.push("Test");

        // 通过Assert.assertEquals方法，我们断言栈顶的元素应该是我们刚刚压入的那个
        Assert.assertEquals("Test", stack.pop());
    }

    @Test
    public void testPeek() {
        // 接下来我们测试peek方法
        stack.push("Test");

        // 通过Assert.assertEquals方法，我们断言查看栈顶的元素应该是我们刚刚压入的那个
        Assert.assertEquals("Test", stack.peek());

        // 我们还要断言，通过peek方法查看栈顶元素并不会导致栈顶元素被弹出
        Assert.assertEquals("Test", stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopWhenEmpty() {
        // 我们测试在空栈上调用pop方法会抛出EmptyStackException
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekWhenEmpty() {
        // 我们测试在空栈上调用peek方法会抛出EmptyStackException
        stack.peek();
    }

    @Test(expected = StackOverflowError.class)
    public void testPushWhenFull() {
        // 我们测试在满栈上调用push方法会抛出StackOverflowError
        for (int i = 0; i < 6; i++) {
            stack.push("Test");
        }
    }
}
