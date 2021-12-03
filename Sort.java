package day20211121;

import java.util.Comparator;

public class Sort {
    //泛型冒泡排序
    public static <E extends Comparable<E>> void bubbleSort(E[] array){
        int size=array.length;

        for (int i = 0; i < size-1; i++) {
            boolean isChange=false;
            for (int j = 1; j < size-1; j++) {
                if(array[j-1].compareTo(array[j])>0){
                    E tmp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=tmp;
                    isChange=true;
                }
            }
            if(!isChange){
                return;
            }
        }
    }

    public static <E> void bubbleSort(E[] array, Comparator<E> com){
        int size=array.length;

        for (int i = 0; i < size-1; i++) {
            boolean isChange=false;
            for (int j = 1; j < size-1; j++) {
                if(com.compare(array[j-1],array[j])>0){
                    E tmp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=tmp;
                    isChange=true;
                }
            }
            if(!isChange){
                return;
            }
        }
    }


    public static void main(String[] args) {
        Integer arr[]={3,2,7,6,1,0,5};
        Sort.bubbleSort(arr);

        String arr1[]={"222","111","333"};
        Sort.bubbleSort(arr1);

        Person[] p={new Person(10),new Person(17),new Person(12)};
        //Sort.bubbleSort(p);

        Sort.bubbleSort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;//升序
            }
        });
        System.out.println();

        Sort.bubbleSort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age-o1.age;
            }
        });
    }
}
