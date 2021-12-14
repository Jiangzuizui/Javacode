package day20211030;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        System.out.println(q.size());
        System.out.println(q.peek());//获取队头元素

        q.poll();
        q.poll();


        System.out.println(q.size());
        System.out.println(q.peek());


    }
}
