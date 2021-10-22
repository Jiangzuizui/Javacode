package day20211022;

public class ArrayList<E>{
    private E[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY=10;
    ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    ArrayList(int initCapacity){
        if(initCapacity<=0){
            initCapacity=DEFAULT_CAPACITY;
        }
        elementData=(E[]) new Object[initCapacity]
    }

    public boolean add(E e){
        //考虑扩容问题
        /*elementData[size++]=e;
        return true;*/
        add(size(),e);
        return true;
    }

    //在任意位置插入
    public void add(int index,E e){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("add:index越界")
        }
        //ensureCapacity();
        for (int i = size-1;i>=index;i--) {
            elementData[i+1]=elementData[i];
        }
        elementData[index]=e;
        size++;
    }

    public int size() {
        return size;
    }
}
