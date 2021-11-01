package day20211101;

//设计循环队列
public class MyCircularQueue {
    int[] array;
    int front=0;//表示队头
    int rear=0;//表示队尾
    int count=0;//记录队列中有效元素的个数--判断队列为空还是满
    int N=array.length;

    public MyCircularQueue(int k){
        array=new int[k];
        N=k;
    }

    //向循环队列插入一个元素
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        //直接往rear位置插入
        array[rear]=value;
        rear++;
        if(rear==N){
            rear=0;
        }
        count+=1;
        return true;
    }

    //删除队列中的第一个元素
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        front++;
        front%=N;
        count=count-1;
        return true;
    }

    //从队首获取元素
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }

    //获取队尾元素
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        return array[(rear-1+N)%N];
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count==array.length;
    }
}
