package day20211206;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
        int toGuess=random.nextInt(100);
        int count=0;
        while(count<10){
            count++;
            System.out.println("请输入数字:(1-100)");
            int num=sc.nextInt();
            if(num<toGuess){
                System.out.println("猜低了");
            }else if(num>toGuess){
                System.out.println("猜高了");
            }else{
                System.out.println("猜对了");
                break;
            }
        }
        sc.close();
    }
}


