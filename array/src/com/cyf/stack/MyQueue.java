package com.cyf.stack;

import java.util.Stack;
//使用栈实现队列的下列操作：
//
//
// push(x) -- 将一个元素放入队列的尾部。
// pop() -- 从队列首部移除元素。
// peek() -- 返回队列首部的元素。
// empty() -- 返回队列是否为空。
//
//
//
//
// 示例:
//
// MyQueue queue = new MyQueue();
//
//queue.push(1);
//queue.push(2);
//queue.peek();  // 返回 1
//queue.pop();   // 返回 1
//queue.empty(); // 返回 false
//
//
//
// 说明:
//
//
// 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
//
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

/**
 * @author by cyf
 * @date 2020/9/12.
 */
public class MyQueue {

    /**
     * 存入进队元素
     */
    private Stack<Integer> a;
    /**
     * 存入出队元素 及栈顶为第一个元素
     */
    private Stack<Integer> b;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        a.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //当b为空时则需压入a的元素
//        if (b.isEmpty()) {
//            while (!a.isEmpty()) {
//                b.push(a.pop());
//            }
//        }
        //当b不为空 则直接弹出栈顶元素
//        return b.pop();

        //别的地方看到的更优雅的解法 调用peek()方法后所有元素都到b栈
        peek();
        return  b.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return b.isEmpty() && a.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
