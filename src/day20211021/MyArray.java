package day20211021;

public class MyArray {
    int[] array;
    int size;  //有效元素的个数

    public MyArray(int initCapacity){
        if(initCapacity<=0){
            initCapacity=10;
            array=new int[initCapacity];
        }
    }
    public void add(int e){
        if(size==array.length){
            System.out.println("MyArray已经存满了");
            return;
        }
        array[size]=e;
        size++;
    }

    //获取index位置上的元素
    public int get(int index){
        if(index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException(
                    "MyArray--get:下标越界");
        }
        return array[index];
    }

    public static void main(String[] args) {
        MyArray ma=new MyArray(100);
        ma.add(1);
        ma.add(2);
        ma.add(3);
        ma.add(4);
        ma.add(5);

        MyArray ma2=new MyArray(10);
        //ma2.add("1111");错
    }
}
