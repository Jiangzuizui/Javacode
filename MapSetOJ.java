package day20211123;

import day20211023.SingleLinkList;
import day20211103.Node;

import java.util.*;

public class MapSetOJ {
    //找出只出现一次的数据
    public int singleNumber(int[] nums){
        //最佳方式:讲述组中的所有元素进行异或
        // 异或的结果就是只出现一次的数据

        //直接将nums中的元素往HashSet中插入
        //插入时:如果该元素已存在(即插不进去),则删除
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!s.add(nums[i])){
                s.remove(nums[i]);
            }
        }
        Iterator<Integer> iterator =s.iterator();
        return iterator.next();
    }

    //复制随机指针链表
    /*public Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        //1.在原链表每个结点后插入一个值相等的新结点
        Node cur=head;
        while(cur!=null){
            Node newNode=new Node(cur.val);
            newNode.next=cur.next;
            cur.next=newNode;
            cur=newNode.next;
        }
        //2.给新插入结点的随机指针域引用赋值
        cur=head;
        while(cur!=null){
            Node newNode=cur.next;
            if(cur.random!=null){
                newNode.random=cur.random.next;
            }
            cur=newNode.next;
        }
        //3.将新插入的节点拆下来
        Node newHead=head.next;
        cur=head;
        while(cur!=null){
            Node curNext=cur.next;
            cur.next=curNext.next;
            cur=curNext;
        }
        return newHead;
    }*/



    public List<String> topKFrequent(String[] words,int k){
        //1.统计每个单词出现的次数
        Map<String,Integer> m=new HashMap<>();
        for (int i = 0; i <words.length ; i++) {
            m.put(words[i],m.getOrDefault(words[i],0)+1);
        }
        //2.找Top-k 出现次数最多的前k个单词
        //a.用前k个单词建一个小堆
        PriorityQueue<Map.Entry<String,Integer>> p=new PriorityQueue<>(new Less());
        Set<Map.Entry<String,Integer>> s=m.entrySet();
        int i=0;
        for (Map.Entry<String,Integer> kv:s){
            if(i<k){
                p.offer(kv);
                i++;
            }else{
                if(kv.getValue()>=p.peek().getValue()){
                    p.poll();
                    p.offer(kv);
                }
            }
        }
        List<String> list=new ArrayList<>(k);
        for (int j = 0; j < k; j++) {
            list.add(p.poll().getKey());
        }
        return list;
    }
    

    //石头中宝石的个数
    public int numJewelsInStones(String jewels,String stones){
        //1.统计每个石头出现的次数
        Map<Character,Integer> m=new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            Character ch=stones.charAt(i);
            m.put(ch,m.getOrDefault(ch,0)+1);
        }

        //2.统计宝石的个数
        int count=0;
        for (int i = 0; i <jewels.length() ; i++) {
            Character ch=jewels.charAt(i);
            count+=m.getOrDefault(ch,0);
        }
        return count;
    }

    public static void main(String[] args) {
        //看键盘上那几个键坏了
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String in=sc.nextLine().toUpperCase();
            String out=sc.nextLine().toUpperCase();

            Set<Character> s=new HashSet<>();
            for(int i=0;i<out.length();i++){
                s.add(out.charAt(i));
            }
            for (int i = 0; i <in.length() ; i++) {
                if(s.add(in.charAt(i))){
                    //如果能插入,就是坏键
                    System.out.print(in.charAt(i));
                }
            }
            System.out.println();
        }
    }


}
