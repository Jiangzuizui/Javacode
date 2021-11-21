package day20211121;

public class MyArray<E> {
    E array[];
    int size;

    public MyArray(int initCap){
        array=(E[])new Object[initCap];
    }

    public void add(E data){
        //考虑是否需要扩容

        //插入元素
        array[size++]=data;
    }

    public E get(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();

        }
        return array[index];
    }

    public static void main(String[] args) {
        //ma1在定义的时候已经显示实例化,将来ma1只能放置在Integer类里
        MyArray<Integer> ma1=new MyArray<>(10);
        ma1.add(1);
        ma1.add(2);
        ma1.add(3);
        ma1.add(4);

        //裸类型
        MyArray ma2=new MyArray(10);
        ma2.add(1);
        ma2.add("1234");
        ma2.add(new Person());
        ma2.add(new Animal());

    }
}
