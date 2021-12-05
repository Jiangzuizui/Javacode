package day20211114;

import java.util.Stack;

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

    //冒泡排序
    //时间复杂度O(N^2)  空O(1)
    //稳定性:稳定
    public static void bubbleSort(int[] array){
        int size=array.length;
        for(int bound=0;bound<size;bound++){
            for(int cur=size-1;cur>bound;cur--){
                if(array[cur-1]>array[cur]){
                    swap(array,cur-1,cur);
                }
            }
        }
    }

    //快速排序
    //没运用三数取中法找基准值:时间复杂度:O(N^2) 最差情况下(有序的降序改为升序)

    //最好情况下 每次取基准值都在最中间(运用三数取中法后) O(Nlog2 N)
    //最好情况下 空间复杂度 递归深度O(log2N)
    //稳定性:不稳定 隔着区间交换了
    //应用场景:适合比较凌乱的数据
    public static void quickSort(int[] array,int left,int right){
        if(right-left<47){
            insertSortQuick(array,left,right);
        }else{
            //假设升序
            //找一个基准值将[left,right)区间分割成两个部分
            if(right-left>1){
                int div=partition(array,left,right);

                //左侧部分比基准值小
                //[left,div)
                quickSort(array,left,div);

                //右侧部分比 基准值大
                //[div+1,right)
                quickSort(array,div+1,right);
            }
        }
    }

    //找基准值的下标--三数取中法
    public static int getIndexOfMiddle(int[] array,int left,int right){
        //left
        //mid:left+((right-left)>>1)
        //right-1
        int mid=left+((right-left)>>1);
        if(array[left]<array[right-1]){
            if(array[mid]<array[left]){
                return left;
            }else if(array[mid]>array[right-1]){
                return right-1;
            }else{
                return mid;
            }
        }else{
            if(array[mid]>array[left]){
                return left;
            }else if(array[mid]<array[right-1]){
                return right-1;
            }else{
                return mid;
            }
        }
    }

    //分割的方法
    //方法一：Hoare版
    //时间复杂度:O(N)
    public static int partition1(int[] array,int left,int right){
        int index=getIndexOfMiddle(array,left,right);
        if(index != right-1){
            swap(array,index,right-1);
        }
        int key=array[right-1];
        int begin=left;
        int end=right-1;

        while(begin<end){
            //让begin从前往后找比key大的元素,找到之后停下来
            while(begin<end && array[begin]<=key){
                begin++;
            }

            //让end从后往前找比key小的元素,找到之后停下来
            while(begin<end && array[end]>=key){
                end--;
            }
            if(begin!=end){
                swap(array,begin,end);
            }
        }

        if(begin!=right-1){
            swap(array,begin,right-1);
        }
        return begin;
    }

    //分割的方法 方式二 挖坑法
    public static int partition2(int[] array,int left,int right){
        int index=getIndexOfMiddle(array,left,right);
        if(index != right-1){
            swap(array,index,right-1);
        }
        int key=array[right-1];
        int begin=left;
        int end=right-1;

        while(begin<end){
            //从begin从前往后找比基准值大的元素
            while(begin<end && array[begin]<=key){
                begin++;
            }

            if(begin<end){
                //begin位置上找到了一个比key大的元素
                //需要用begin去填end位置上的坑
                array[end]=array[begin];
                //begin位置上就形成了一个新的坑
            }

            //让end从后往前找比基准值小的元素
            while(begin<end && array[end]>=key){
                end--;
            }

            if(begin<end){
                //end位置就找到了一个比key小的元素
                //需要用end去填刚才begin产生的新坑
                array[begin]=array[end];
                //end位置又产生了一个新坑
            }
        }
        //begin和end相等 他俩的位置是最后的一个坑位
        //需要用基准值key去填这个坑位
        array[begin]=key;

        return begin;
    }

    //分割的方法 方式三:前后标记
    public static int partition(int[] array,int left,int right){
        int cur=left;
        int prev=cur-1;
        int index=getIndexOfMiddle(array,left,right);
        if(index != right-1){
            swap(array,index,right-1);
        }
        int key=array[right-1];

        //让cur从前往后找比key小的元素
        while(cur<right){
            if(array[cur]<key && ++prev!=cur){
                swap(array,cur,prev);
            }
            ++cur;
        }
        //将基准值的位置上放置好
        if(++prev != right-1){
            swap(array,prev,right-1);
        }
        return prev;
    }

    //插入和快排的结合
    public static void insertSortQuick(int[] array,int left,int right){
        //外层循环目的:取到数组中的每个元素
        for (int i = left+1; i < right; i++) {

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


    //快排 非递归
    public static void quickSort(int[] array){
        Stack<Integer> s=new Stack<>();
        s.push(array.length);
        s.push(0);

        while(!s.empty()){
            int left=s.pop();
            int right=s.pop();

            if(right-left < 47){
                insertSortQuick(array,left,right);
            }else{
                int div=partition2(array,left,right);

                //先压入基准值右侧部分
                //[div+1,right)
                s.push(right);
                s.push(div+1);

                //后压入基准值左侧部分
                //[left,div)
                s.push(div);
                s.push(left);

            }
        }
    }

    //合并两组数据
    public static void mergeData(int[] array,int left,int mid,int right,int[] temp){
        int begin1=left,end1=mid;
        int begin2=mid,end2=right;
        int index=left;

        while(begin1<end1 && begin2<end2){
            if(array[begin1]<=array[begin2]){
                temp[index++]=array[begin1++];
                //index++;
                //begin1++;
            }else{
                temp[index++]=array[begin2++];
                //index++;
                //begin2++;
            }
        }
        while(begin1<end1){
            //1中的元素还没有搬移完
            temp[index++]=array[begin1++];
        }
        while(begin2<end2){
            temp[index++]=array[begin2++];
        }
    }

    //归并排序
    //时间复杂度O(NlogN)
    //空间复杂度O(N) temp开辟了一段新空间
    //稳定性:稳定
    //应用场景:外部排序
    private static void mergeSort(int[] array,int left,int right,int[] temp){
        if(right-left > 1){
            //先对[left,right)区间中的元素进行均分
            int mid=left+((right-left)>>1);

            //[left,mid)
            mergeSort(array,left,mid,temp);

            //[mid,right)
            mergeSort(array,mid,right,temp);

            mergeData(array,left,mid,right,temp);
            //把temp中的数据拷贝到原数组array中去
            System.arraycopy(temp,left,array,left,right-left);
        }
    }

    public static void mergeSort(int[] array){
        int[] temp=new int[array.length];
        mergeSort(array,0,array.length,temp);
    }

    //归并排序 非递归
    public static void mergeSortNor(int[] array){
        int size=array.length;
        int[] temp=new int[size];

        int gap=1;
         while(gap<size){
            for (int i = 0; i < size; i+=2*gap) {
                int left=i;
                int mid=left+gap;
                int right=mid+gap;
                if(mid>size){
                    mid=size;
                }
                if(right>size){
                    right=size;
                }

                mergeData(array,left,mid,right,temp);
            }
            System.arraycopy(temp,0,array,0,size);

            gap<<=1;
        }
    }

    //计数排序
    //时间O(N)--N表示数组中元素个数
    //空间O(M)--M表示范围的大小
    //稳定性:稳定
    //应用场景:数据密集集中在某个范围中
    public static void countSort(int[] array){
        //找数据范围
        int minValue=array[0];
        int maxValue=array[0];
        for (int i = 0; i <array.length ; i++) {
            if(array[i]>maxValue){
                maxValue=array[i];
            }
            if(array[i]<minValue){
                minValue=array[i];
            }
        }

        //计算计数空间的大小
        int range=maxValue-minValue+1;
        int[] count=new int[range];

        //1.统计array中每个数据出现的次数
        for (int i = 0; i <array.length ; i++) {
            count[array[i]-minValue]++;
        }
        //2.根据统计结果回收
        int index=0;
        for (int i = 0; i <range ; i++) {
            while(count[i]>0){
                array[index++]=i+minValue;
                count[i]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] array={4,2,8,6,9,1,3,5,0,7};

        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //selectSortOP(array);
        //heapSort(array);
        printArray(array);
        //bubbleSort(array);
        //quickSort(array,0,array.length);
        //quickSort(array);
        //mergeSort(array);
        //mergeSortNor(array);
        countSort(array);
        printArray(array);
    }
}
