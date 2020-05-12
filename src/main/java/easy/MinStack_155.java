package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:queena
 * @Date:2020/5/120859
 * @Description:
 */
public class MinStack_155 {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack_155() {
        stack=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        if (min.size()==0){
            min.push(x);
        }
        else if (min.peek()>=x){
            min.push(x);
        }
        stack.push(x);

    }

    public void pop() {
        if (min.peek().intValue()==stack.peek().intValue()){
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack_155 minStack_155=new MinStack_155();
        minStack_155.push(512);
        minStack_155.push(-1024);
        minStack_155.push(-1024);
        minStack_155.push(512);
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
    }
}

/*
用一个min栈来维护最小值，即栈顶永远为当前栈的最小值。
当压入的元素比min栈的栈顶大的时候，就无需将其压入min栈
 */