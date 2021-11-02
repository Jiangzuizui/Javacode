package day20211102;

import day20211030.Stack;

public class MyQueue {
    //用两个栈模拟实现队列
    Stack<Integer> s1=new Stack<>();//s1实现入队列
    Stack<Integer> s2=new Stack<>();//s2实现出队列

    public MyQueue(){

    }

    public void offer(int x){
        s1.push(x);
    }

    public int poll(){
        if(s2.empty()){
            //将s1中的所有元素全部导入s2中
            while(s1.size()>0){
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek(){
        if(s2.empty()){
            //将s1中的所有元素全部导入s2中
            while(s1.size()>0){
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean isEmpty(){
        return s1.empty()&&s2.empty();
    }
}
