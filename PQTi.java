package day20211112;

import java.util.PriorityQueue;

public class PQTi {
    //返回数组最小的前k个数
    class Solution{
        public int[] smallestK(int[] arr,int k){
            if(arr==null || k<=0){
                return new int[0];
            }

            //用数组中的所有元素构造一个小堆
            PriorityQueue<Integer> p=new PriorityQueue<>();
            for (int i = 0; i <arr.length ; i++) {
                p.offer(arr[i]);
            }

            //获取堆中的前k个元素
            int[] ret=new int[k];
            for (int i = 0; i < k; i++) {
                ret[i]=p.poll();
            }
            return ret;
        }
    }
}
