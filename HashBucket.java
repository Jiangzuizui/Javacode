package day20211128;


public class HashBucket {
    public static class ListNode{
        Integer key;
        Integer value;
        ListNode next;
        public ListNode(Integer key,Integer value){
            this.key=key;
            this.value=value;
        }

    }
    //数组--
    ListNode[] table;
    int size; //哈希桶中有效元素的个数

    public HashBucket(int initCapacity){
        initCapacity=initCapacity<=0?16:initCapacity;
        table=new ListNode[initCapacity];

    }

    //O(1)
    public Integer put(Integer key,Integer value){
        //0.是否需要扩容
        checkCapacity();

        //1.根据哈希函数计算key插入的桶号
        int bucketNo=hashFunc(key);

        //2.检测key在bucketNo桶中是否存在
        //相当于在链表中查找一个元素是否存在
        ListNode cur=table[bucketNo];
        while(cur!=null){
            if(key.equals(cur.key)){
                Integer oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }
            cur=cur.next;
        }

        //2.将元素插入到bucketNo桶中
        ListNode newNode=new ListNode(key,value);
        newNode.next=table[bucketNo];
        table[bucketNo]=newNode;
        ++size;
        return value;
    }

    //O(1)
    public Integer get(Integer key){
        //1.通过哈希函数计算key对应的桶号
        int bucketNo=hashFunc(key);

        //2.到bucketNo桶中找key
        ListNode cur=table[bucketNo];
        while(cur!=null){
            if(key.equals(cur.key)){
                return cur.value;
            }
            cur=cur.next;
        }
        return null;
    }

    public Integer getOrDefault(Integer key,Integer value){
        Integer ret=get(key);
        if(ret != null){
            return ret;
        }
        return value;
    }

    public Integer remove(Integer key){
        //1.通过哈希函数计算key对应的桶号
        int bucketNo=hashFunc(key);
        //2.在bucketNo桶中找待删除的节点
        ListNode cur=table[bucketNo];
        ListNode prev=null;
        while(cur!=null){
            if(key.equals(cur.key)){
                Integer oldValue=cur.value;

                //要删除的节点刚好是第一个
                if(table[bucketNo]==cur){
                    table[bucketNo]=cur.next;
                    //cur.next=null;
                }else{
                    prev.next=cur.next;
                    //cur.next=null;
                }
                cur.next=null;
                --size;
                return oldValue;

            }
            cur=cur.next;

        }
        return null;
    }

    //O(1)
    public boolean containsKey(Integer key){
        //可以按照哈希的特性来查找
        return get(key)!=null;

    }

    //O(N)
    public boolean containsValue(Integer value){
        for(int bucketN0=0;bucketN0<table.length;bucketN0++){
            ListNode cur=table[bucketN0];
            while(cur!=null){
                if(value.equals(cur.value)){
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    private void checkCapacity(){
        //自定义扩容--当桶里的元素大于桶的个数
        if(size>=table.length){
            int newCapacity=table.length*2;
            ListNode[] newTable=new ListNode[newCapacity];

            //将table中所有的结点搬移到newTable中
            //注意:每个结点都需要搬移
            for (int i = 0; i <table.length ; i++) {
                //逐个桶进行搬移--逐条链表进行搬移
                ListNode cur=table[i];
                while(cur!=null){
                    //将cur从table[i]头删
                    table[i]=cur.next;
                    //将cur往newTable中插入
                    int bucketNo= cur.key%newTable.length;//hashFunc(cur.key);
                    cur.next=newTable[bucketNo];
                    newTable[bucketNo]=cur;

                    cur=table[i];
                }
            }
            table=newTable;
        }
    }

    private int hashFunc(int key){
        return key%table.length;
    }

    public static void main(String[] args) {
        HashBucket hb=new HashBucket(10);
        int[] array={1,7,6,4,5,9};
        for (int i = 0; i < array.length; i++) {
            hb.put(array[i],array[i]);
        }

        System.out.println(hb.size());//6

        hb.put(7,8);
        System.out.println(hb.size());//6

        System.out.println(hb.get(7));//8
        System.out.println(hb.getOrDefault(7,7));//8
        System.out.println(hb.getOrDefault(10,10));//10

        System.out.println(hb.containsKey(7));//true
        System.out.println(hb.containsValue(7));//false

        hb.remove(7);
        System.out.println(hb.containsKey(7));//false

    }
}
