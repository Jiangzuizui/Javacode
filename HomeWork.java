package day20211023;

import java.util.Arrays;

public class HomeWork {
    public static void bubbleSort(int[] arr,int size){
        int bound=0;
        for(;bound<size;bound++){
            for(int cur=size-1;cur>bound;cur--){
                if(arr[cur-1]>arr[cur]){
                    int tmp=arr[cur-1];
                    arr[cur-1]=arr[cur];
                    arr[cur]=tmp;
                }
            }
        }
    }

    public static boolean induge(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] arr,int size,int toFind){
        int left=0;
        int right=size-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(toFind<arr[mid]){
                right=mid-1;
            }else if(toFind>arr[mid]){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int[] copeOf(int[] arr){
        int[] arr2=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i]=arr[i];
        }
        return arr2;
    }

    public static String toString(int[] arr){

        String ret="[";
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1){
                ret+=arr[i]+",";
            }else if(i==arr.length-1){
                ret+=arr[i]+"]";
            }
        }

        return ret;
    }

    public static int[] transForm(int[] a){
        int left=0;
        int right=a.length-1;
        while(left<right){
            while(left<right&&a[left]%2==0){
                left++;
            }
            while(left<right&&a[right]%2!=0){
                right--;
            }
            int tmp=a[left];
            a[left]=a[right];
            a[right]=tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(transForm(arr)));
    }

    public static void main5(String[] args) {
        int[] arr={1,2,3};
        System.out.println(toString(arr));
    }

    public static void main4(String[] args) {
        int[] arr={1,2,3,4,5};
        int[] newarr=copeOf(arr);
        System.out.println(Arrays.toString(newarr));
    }


    public static void main3(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int size=arr.length;
        System.out.println(binarySearch(arr,size,6));
    }

    public static void main2(String[] args) {
        int[] arr={1,2,3,44,5,6};
        System.out.println(induge(arr));
    }

    public static void main1(String[] args) {
        int[] arr={9,5,2,7,3,6};
        int size=arr.length;
        bubbleSort(arr,size);
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
