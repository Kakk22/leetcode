package com.cyf.stack;
//使用队列实现栈的下列操作：
//
//
// push(x) -- 元素 x 入栈
// pop() -- 移除栈顶元素
// top() -- 获取栈顶元素
// empty() -- 返回栈是否为空
//
//
// 注意:
//
//
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
//

import java.util.LinkedList;
import java.util.Queue;

/**解题思路
 *
 * 栈为先进后出
 * 队列为先进先出
 *
 * 队列实现栈 思路为：用两个队列 一个a队列每次push完后保持空队列 b队列则为出队队列
 * 每一次push 由于a为空 则都是首个元素  再将b队列的所有元素依次移到a队列 此时再交换a 和b的指针
 * 则b队列首元素为刚入队元素 出栈则是第一个出栈
 *
 * 核心思想： 把每次最新进栈的元素都保持在队列头一个元素
 *
 * @author by cyf
 * @date 2020/9/8.
 */
public class MyStack {

    /**
     * 输入队列
     */
    private Queue<Integer> a;
    /**
     * 输出队列
     */
    private Queue<Integer> b;

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
        //将a和b交换 始终维持a队列在push前为一个空队列
        Queue temp = a;
        a = b;
        b = temp;

    }

    public int pop() {
        return b.poll();
    }

    public int top() {
        return b.peek();
    }

    public boolean isEmpty() {
        return b.isEmpty();
    }

}
