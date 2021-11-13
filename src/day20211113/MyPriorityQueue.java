package day20211113;

import java.util.Arrays;

public class MyPriorityQueue {
    Integer[] array;
    int size;//有效元素的个数

    public MyPriorityQueue(){
        array=new Integer[11];
        size=0;
    }

    public MyPriorityQueue(int initCapacity){
        if(initCapacity<1){
            throw new IllegalArgumentException("初识容量<1");
        }
        array=new Integer[initCapacity];
        size=0;
    }

    public MyPriorityQueue(Integer[] arr){
        //1.将arr中的元素拷贝到数组中
        array=new Integer[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            array[i]=arr[i];
        }
        size=arr.length;
        //2.找当前完全二叉树中倒数第一个非叶子节点
        //刚好是最后一个节点的双亲
        //最后一个节点size-1  倒数第一个非叶子节点(size-1-1)/2
        int lastLeafParent=(size-2)/2;

        //3.从倒数第一个叶子结点位置开始一直到根节点的位置使用向下调整
        for (int root = lastLeafParent; root >=0 ; root--) {
            shiftDown(root);
        }
    }

    //向下调整:以parent为跟的二叉树
    //条件:parent的左右子树已经满足堆的特性
    //时间复杂度O(log2 N)
    private void shiftDown(int parent){
        //默认让child先标记左孩子
        int child=parent*2+1;

        //while循环可以保证parent的左孩子一定存在
        //不能保证parent的右孩子是否存在
        while(child<size){
            //1.找到左右孩子中较小的孩子
            if(child+1<size && array[child+1]<array[child]){
                child+=1;
            }

            //2.较小的孩子已经找到了
            //检测双亲和孩子之间是否满足堆的特性
            if(array[parent] > array[child]){
                swap(parent,child);

                //大的双亲往下走了,可能导致子树又不满足堆得特性
                //因此需要继续往下调整
                parent=child;
                child=parent*2+1;
            }else{
                //以parent为根的二叉树已经是堆了
                return;
            }
        }
    }

    private void shiftUp(int child){
        int parent=(child-1)/2;

        while(child != 0){
            if(array[child] < array[parent]){
                swap(child,parent);
                child=parent;
                parent=(child-1)/2;
            }else{
                return;
            }
        }

    }

    //left和right是数组的下标
    private void swap(int left,int right){
        int tmp=array[left];
        array[left]=array[right];
        array[right]=tmp;
    }

    boolean offer(Integer e){
        if(e==null){
            throw new NullPointerException("插入元素为null");
        }
        ensureCapacity();

        array[size++]=e;

        //注意:当新元素插入之后,可能会破坏堆的性质--需要向上调整
        shiftUp(size-1);
        return true;
    }

    //将堆顶元素删除掉
    public Integer poll(){
        if(isEmpty()){
            return null;
        }

        Integer ret=array[0];
        //1.将堆顶的元素与堆中的最后一个元素交换
        swap(0,size-1);

        //2.将堆中有效元素个数减一
        size--;

        //3.将堆顶元素往下调整到合适的位置
        shiftDown(0);
        return ret;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void Clear(){
        size=0;
    }

    private void ensureCapacity(){
        if(array.length==size){
            int newCapacity=array.length*2;
            array=Arrays.copyOf(array,newCapacity);
        }
    }



    public static void main(String[] args) {
        Integer[] array={65,37,34,49,28,19,27,18,25,15};
        MyPriorityQueue mp=new MyPriorityQueue(array);
    }
}
