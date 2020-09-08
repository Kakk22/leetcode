package com.cyf.stack;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.

import java.util.Stack;

/**解题思路 一开始用list每次查询遍历最小值 性能太差
 * 改用两个栈实现 一个栈记录最小值，一个栈正常压入
 * 当压入时 判断压入值是否比最小栈顶小 如果是则压入最小栈
 * 当弹出时 如果弹出的等于最小栈栈顶  则弹出最小栈顶元素
 * @author by cyf
 * @date 2020/9/7.
 */
class MinStack{
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //如果最小栈是空栈或压入值比最小栈顶值要小 则入栈
        if (minStack.isEmpty() || x < minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        //如果出栈为最小值  则存储最小值的栈也要出栈
        if (stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}