package day20211029;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        //入栈
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.size());
        System.out.println(s.peek());//获取栈顶元素

        //出栈两元素
        s.pop();
        s.pop();
        System.out.println(s.peek());

        s.pop();
        s.pop();
        s.pop();

        if(s.empty()){
            System.out.println("栈空了");
        }else{
            System.out.println("不空");
        }
    }
}
