package day20211121;

public class MyArrayList {
    Object[] array;
    int size;

    public MyArrayList(int initCap){
        array=new Object[initCap];
    }

    public void add(Object o){
        //是否扩容
        array[size]=o;
        size++;
    }

    public Object get(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public static void main(String[] args) {
        MyArrayList ma=new MyArrayList(10);

        ma.add(new Person());
        ma.add(new Person());
        ma.add(new Person());

        ma.add(new Animal());
        ma.add(new Animal());
        ma.add(new Animal());

        Object o=ma.get(0);
        Animal a=(Animal) ma.get(3);
    }
}
