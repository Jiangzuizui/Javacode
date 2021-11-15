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

    //希尔排序
    //时间复杂度:不确定  //空间复杂度:O(1)
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

    //选择排序 方式一
    //时间复杂度:O(N^2) 空间复杂度O(1)
    //稳定性:不稳定  因为间隔着交换了
    public static void selectSort(int[] array){
        int size=array.length;
        for(int i=0;i<size;i++){ //控制具体选择的趟数
            //具体选择的方式
            int pos=0;
            for(int j=0;j<size-i;j++){
                if(array[j]>array[pos]){
                    pos=j;
                }
            }
            //用pos标记的最大元素与区间最后一个位置上的元素进行交换
            if(pos!=size-1-i){
                //如果pos是最后一个元素就不用进行交换了
                swap(array,pos,size-1-i);
            }
        }
    }

    //选择排序 方式二
    public static void selectSortOP(int[] array){
        int begin=0;
        int end=array.length-1;
        while(begin<end){
            //在[begin,end]区间中找最大和最小元素的位置
            //最大元素的位置使用maxPos标记
            //最小元素的位置使用minPos标记
            int minPos=begin;
            int maxPos=begin;
            int index=begin+1;
            while(index<=end){
                if(array[index]>array[maxPos]){
                    maxPos=index;
                }
                if(array[index]<array[minPos]){
                    minPos=index;
                }
                index++;
            }
            //在[begin,end]区间中已经找到最大和最小元素了
            if(maxPos != end){
                swap(array,maxPos,end);
            }

            if(minPos == end){
                minPos=maxPos;
            }

            if(minPos != begin){
                swap(array,minPos,begin);
            }

            begin++;
            end--;
        }
    }

    //堆排序
    //时间复杂度O(NlogN)      空间复杂度O(1)
    //稳定性:不稳定  因为交换的时候间隔元素了
    //应用场景:需要一个序列中前k个最大或最小
    public static void heapSort(int[] array){
        //1.建堆
        //a.找倒数第一个非叶子结点
        int size=array.length;
        int lastLeaf=(size-2)>>>1; //((size-1)-1)/2
        for(int root=lastLeaf;root>=0;root--){
            shiftDown(array,size,root);
        }

        //2.利用堆删除的思想排序 升序大堆 降序小堆
        int end=size-1;
        while(end>0){
            //用堆顶元素与堆中最后一个元素交换
            swap(array,0,end);

            //将堆中有效元素个数减一
            //将堆顶元素向下调整
            shiftDown(array,end,0);

            end--;
        }

    }

    public static void swap(int[] array,int left,int right){
        int tmp=array[left];
        array[left]=array[right];
        array[right]=tmp;
    }

    public static void shiftDown(int[] array,int size,int parent){
        int child=parent*2+1;
        //int size=array.length;
        while(child<size){
            if(child+1<size && array[child+1]>array[child]){
                child+=1;
            }
            if(array[parent]<array[child]){
                swap(array,parent,child);
                parent=child;
                child=parent*2+1;
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array={4,2,8,6,9,1,3,5,0,7};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //selectSortOP(array);
        heapSort(array);
        printArray(array);
    }
}
