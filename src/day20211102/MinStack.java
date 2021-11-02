package day20211102;

import day20211030.Stack;

public class MinStack {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public MinStack(){

    }

    public void push(int val){
        if(s2.empty()||val<=s2.peek()){
            s2.push(val);
        }
        s1.push(val);
    }

    public void pop(){
        if(s1.peek().equals(s2.peek())){
            s2.pop();
        }
        s1.pop();
    }

    public int top(){
        return s1.peek();
    }

    public int getMin(){
        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack ms=new MinStack();
        ms.push(512);
        ms.push(-1024);
        ms.push(-1024);
        ms.push(512);

        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
