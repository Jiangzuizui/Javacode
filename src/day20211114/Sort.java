package day20211114;

public class Sort {

    public static void printArray(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //插入排序
    //空间复杂度O(1)
    //时间复杂度 最优情况下接近有序O(N)
    // 最差O(N^2)
    public static void insertSort(int[] array){
        //外层循环目的:取到数组中的每个元素
        for (int i = 1; i < array.length; i++) {

            //将单个元素插入到序列中
            //[0,i)已经排好了 i是要插入的位置
            int key=array[i];
            int end=i-1;

            //key<=不加等号稳定
            while(end>=0 && key<array[end]){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=key;
        }
    }

    //时间复杂度:O(
    //空间复杂度:O(1)
    //稳定性:不稳定 因为是间隔的来插入 隔了一定的区间
    //应用场景:数据量比较大,比较凌乱
    public static void shellSort(int[] array){
        int gap=3;
        while(gap>0){
            for (int i = gap; i < array.length; i++) {

                //将单个元素插入到序列中
                //[0,i)已经排好了 i是要插入的位置
                int key=array[i];
                int end=i-gap;

                //key<=不加等号稳定
                while(end>=0 && key<array[end]){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=key;
            }
            gap-=1;
        }
    }

    public static void main(String[] args) {
        int[] array={4,2,8,6,9,1,3,5,0,7};
        //insertSort(array);
        shellSort(array);
        printArray(array);
    }
}
