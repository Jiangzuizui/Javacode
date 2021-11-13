package day20211112;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void method1(){
        PriorityQueue<Integer> p1=new PriorityQueue<>();//默认容量11
        PriorityQueue<Integer> p2=new PriorityQueue<>(100);

        List<Integer> list=new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        PriorityQueue<Integer> p3=new PriorityQueue<>(list);


    }

    public static void method2(){
        PriorityQueue<Integer> p=new PriorityQueue<>();
        p.offer(5);
        p.offer(1);
        p.offer(4);
        p.offer(2);
        p.offer(3);
        System.out.println(p.size());

        //p.offer(null);//报错 空指针异常
        System.out.println(p.peek());//获取堆顶的元素 最大或最小

        p.poll();
        p.poll();
        p.poll();
        System.out.println(p.peek());

        p.clear();
        if(p.isEmpty()){
            System.out.println("kong");
        }else{
            System.out.println("bukong");
        }
    }

    //创建大堆
    public static void method3(){
        PriorityQueue<Integer> p=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//o1-o2小堆
            }
        });
        p.offer(5);
        p.offer(1);
        p.offer(4);
        p.offer(2);
        p.offer(3);
    }

    public static void swap(int[] array,int left,int right){
        int tmp=array[left];
        array[left]=array[right];
        array[right]=tmp;
    }

    public static void shiftDown(int[] array,int size,int parent){
        int child=parent*2+1;

        while(child<size){
            //找左右孩子中较大的孩子
            if(child+1<size && array[child+1]>array[child]){
                child+=1;
            }
            //双亲小于孩子就交换
            if(array[parent]<array[child]){
                swap(array,parent,child);
                parent=child;
                child=parent*2+1;
            }else{
                return;
            }
        }
    }

    //假设:升序
    public static void heapSort(int[] array){
        //1.建堆  向下调整
        //  升序--大堆   降序--小堆
        for (int root=(array.length-2)/2;root>=0;root--) {
            shiftDown(array,array.length,root);
        }

        //2.利用堆删除的思想来排序 向下调整
        int end=array.length-1;//标记最后一个元素
        while(end != 0){
            swap(array,0,end);
            shiftDown(array,end,0);
            end--;
        }
    }

    public static void main(String[] args) {
        //method1();
        //method2();
        //method3();
        int[] array={65,37,34,49,28,19,27,18,25,15};
        heapSort(array);
    }
}
