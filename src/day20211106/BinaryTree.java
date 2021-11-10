package day20211106;

import java.util.Queue;
import java.util.LinkedList;

//孩子表示法
public class BinaryTree {
    public static class BTNode{
        BTNode left; //引用当前节点的左孩子
        BTNode right;//引用当前节点的右孩子
        int data;

        public BTNode(int data){
            this.data=data;
        }
    }

    BTNode root;//根节点
    //自己手动创建一个二叉树
    void creatBinaryTree(){
        BTNode node1=new BTNode(1);
        BTNode node2=new BTNode(2);
        BTNode node3=new BTNode(3);
        BTNode node4=new BTNode(4);
        BTNode node5=new BTNode(5);
        BTNode node6=new BTNode(6);

        node1.left=node2;
        node1.right=node4;

        node2.left=node3;

        node4.left=node5;
        node4.right=node6;

        root=node1;
    }


    int index=0;
    public void creatBinaryTree2(int[] array) {
        index = 0;
        root = creatBinaryTree2N(array);
    }


    //用数组创建一个二叉树
    private BTNode creatBinaryTree2N(int[] array){
        BTNode treeRoot=null;
        if(index<array.length&&array[index]!=-1){
            //先创建根节点
            treeRoot=new BTNode(array[index]);

            //递归创建根的左子树
            ++index;
            treeRoot.left=creatBinaryTree2N(array);

            //递归创建根的右子树
            ++index;
            treeRoot.right=creatBinaryTree2N(array);
        }
        return treeRoot;
    }




    int count=0;

    //层序遍历
    public void levelOrder(){
        if(root==null){
            return;
        }
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BTNode cur=q.poll();//出队列并返回
            System.out.print(cur.data+" ");
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }
        }
        System.out.println();
    }

    //前序遍历--操作:对节点中的值域进行打印
    private void preOrder(BTNode treeRoot){
        /*if(treeRoot==null){
            return;
        }
        //非空
        //1.先遍历根节点
        System.out.print(treeRoot.data+" ");
        //2.左子树
        preOrder(treeRoot.left);
        //3.右子树
        preOrder(treeRoot.right);*/

        if(treeRoot!=null){
            count++;
            System.out.print(treeRoot.data+" ");
            preOrder(treeRoot.left);
            preOrder(treeRoot.right);
        }
    }

    //将上述递归的方式再包装一层--避免多次传参
    public void preOrder(){
        System.out.print("前序遍历");
        preOrder(root);
    }

    //中序遍历
    private void midOrder(BTNode treeRoot){
        if(treeRoot!=null){
            midOrder(treeRoot.left);
            System.out.print(treeRoot.data+" ");
            midOrder(treeRoot.right);
        }
    }

    public void midOrder(){
        System.out.println();
        System.out.print("中序遍历");
        midOrder(root);
    }

    //后序遍历
    private void lastOrder(BTNode treeRoot){
        if(treeRoot!=null){
            lastOrder(treeRoot.left);
            lastOrder(treeRoot.right);
            System.out.print(treeRoot.data+" ");
        }
    }

    public void lastOrder(){
        System.out.println();
        System.out.print("后序遍历");
        lastOrder(root);
    }

    //获取二叉树中结点的个数
    private int size(BTNode treeRoot){
        if(treeRoot==null){
            return 0;
        }
        return 1+size(treeRoot.left)+
                size(treeRoot.right);
    }

    public int size(){
        return size(root);
    }

    //获取叶子结点的个数
    private int getLeafNode(BTNode treeRoot){
        if(treeRoot==null){
            return 0;
        }
        //遇到叶子结点,无需往下递归,本次递归直接退出
        if(treeRoot.left==null&&treeRoot.right==null){
            return 1;
        }
        return getLeafNode(treeRoot.left)+
                getLeafNode(treeRoot.right);
    }

    public int getLeafNode(){
        return getLeafNode(root);
    }

    //获取第k层结点的个数,根在第一层
    private int getLevelNode(BTNode treeRoot,int k){
        if(treeRoot==null||k<=0){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getLevelNode(treeRoot.left,k-1)+
                getLevelNode(treeRoot.right,k-1);
    }

    public int getLevelNode() {
        return getLevelNode(root,3);
    }

    //获取二叉树的高度
    private int height(BTNode treeRoot){
        if(treeRoot==null){
            return 0;
        }
        int leftHeight=height(treeRoot.left);
        int rightHeight=height(treeRoot.right);
        return leftHeight>rightHeight?leftHeight+1:
                rightHeight+1;
    }

    public int height(){
        return height(root);
    }

    //查找值为data的结点,并返回
    private BTNode find(BTNode treeRoot,int data){
        if(treeRoot==null){
            return null;
        }
        if(treeRoot.data==data){
            return treeRoot;
        }
        BTNode ret=find(treeRoot.left,data);
        if(ret!=null){
            return ret;
        }
        return find(treeRoot.right,data);
    }

    public BTNode find(int data){
        return find(root,data);
    }

    //判断是否为完全二叉树
    public boolean isCompleteTree(){
        if(root==null){
            return true;
        }
        //按照层序遍历的方式找第一个不饱和的节点
        Queue<BTNode> q=new LinkedList<>();
        q.offer(root);
        boolean flag=false;//用来标记不饱和节点
        while(!q.isEmpty()){
            BTNode cur=q.poll();
            if(flag){
                //从该结点往后的结点都不能有孩子
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
            }else{
                if(cur.left!=null&&cur.right!=null){
                    //左右孩子都存在
                    q.offer(cur.left);
                    q.offer(cur.right);
                }else if(cur.left!=null){
                    //cur只有左孩子无右孩子
                    q.offer(cur.left);
                    flag=true;
                }else if(cur.right!=null){
                    //cur只有右孩子
                    return false;
                }else{
                    //cur是一个叶子结点
                    flag=true;
                }
            }

        }
        return true;
    }


    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        //bt.creatBinaryTree();

        int[] arr={1,2,3,-1,-1,-1,4,5,-1,-1,6,-1,-1};
        bt.creatBinaryTree2(arr);

        bt.preOrder();
        bt.midOrder();
        bt.lastOrder();

        System.out.println();
        System.out.println(bt.size());
        System.out.println(bt.getLevelNode());
        System.out.println(bt.height());

        BTNode r=bt.find(5);
        if(r!=null){
            System.out.println("有5");
        }else{
            System.out.println("没5");
        }

        bt.levelOrder();

        if(bt.isCompleteTree()){
            System.out.println("是完全二叉树");
        }else{
            System.out.println("不是完全二叉树");
        }
    }
}
