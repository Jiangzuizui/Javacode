package day20211030;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Observable;

public class Stack<E> {
    E[] array;
    int size;//表示栈中有多少元素 size-1栈顶元素位置
    public Stack(){
        array=(E[])new Object[10];
        size=0;
    }
    public void push(E e){
        //1.先确保栈中空间足够
        ensureCapacity();
        //2.插入元素
        array[size]=e;
        size++;
    }

    public E pop(){
        if(empty()){
            throw new RuntimeException("pop:栈是空的");
        }
        E ret=peek();
        size--;
        return ret;
    }

    public E peek(){
        if(empty()){
            throw new RuntimeException("peek:栈是空的");
        }
        return array[size-1];
    }

    public boolean empty(){
        return 0==size;
    }

    public int size(){
        return size;
    }

    private void ensureCapacity(){
        if(array.length==size){
            int newCapacity=size*2;
            array=Arrays.copyOf(array,newCapacity);
        }
    }

    public static void main(String[] args) {
        Stack<String> s=new Stack<>();
        s.push("1111");
        s.push("2222");
        s.push("3333");
        s.push("4444");
        s.push("5555");
        s.push("6666");
        s.push("7777");
        System.out.println(s.size);
        System.out.println(s.peek());

        s.pop();
        s.pop();
        System.out.println(s.size);
        System.out.println(s.peek());
    }
}
