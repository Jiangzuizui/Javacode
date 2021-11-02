package day20211102;

import day20211101.Queue;

import java.util.LinkedList;

public class MyStack {
    //用两个队列来模拟实现栈
    Queue<Integer> q1= new Queue<Integer>();
    Queue<Integer> q2= new Queue<Integer>();

    public MyStack(){

    }

    public void push(int x){
        if(q2.isEmpty()){
            q1.offer(x);
        }else{
            q2.offer(x);
        }
    }

    public int pop(){
        //哪个队列中有元素,将队列中前n-1个元素转移到另一个队列中去
        int ret=0;
        if(!q1.isEmpty()){
            //q1中有元素
            while(q1.size()>1){
                q2.offer((q1.poll()));
            }
            ret=q1.poll();
            //return ret;
        }else{
            //q2中有元素
            while(q2.size()>1){
                q1.offer(q2.poll());
            }
            ret=q2.poll();
            //return ret;
        }
        return ret;
    }

    public int top(){
        //将队列中的前n-1的元素搬移
        int ret=0;
        if(!q1.isEmpty()){
            //q1中有元素
            while(q1.size()>1){
                q2.offer((q1.poll()));
            }
            ret=q1.poll();
            q2.offer(ret);
            //return ret;
        }else{
            //q2中有元素
            while(q2.size()>1){
                q1.offer(q2.poll());
            }
            ret=q2.poll();
            q1.offer(ret);
            //return ret;
        }
        return ret;
    }

    public boolean empty(){
        return q1.isEmpty()&&q2.isEmpty();
    }
}
