package day20211121;

public class Sort {
    //泛型冒泡
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
}
