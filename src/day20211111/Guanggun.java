package day20211111;

import java.util.Scanner;

//知道前序推出中序
public class Guanggun {
    //对二叉树的节点进行定义
    public static class TreeNode{
        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value){
            this.value=value;
        }
    }

    //指向二叉树的根节点
    TreeNode root;

    int index=0;
    void createBinaryTree(String preStr,char invalid){
        index=0;
        root=createBinaryTreeN(preStr, invalid);
    }

    TreeNode createBinaryTreeN(String preStr,int invalid){
        TreeNode treeRoot=null;
        if(index<preStr.length() &&
                preStr.charAt(index)!=invalid){
            //创建根节点
            treeRoot=new TreeNode(preStr.charAt(index));
            //左子树
            ++index;
            treeRoot.left=createBinaryTreeN(preStr,invalid);
            //右子树
            ++index;
            treeRoot.right=createBinaryTreeN(preStr, invalid);
        }
        return treeRoot;
    }

    public void InOrder(){
        InOrder(root);
        System.out.println();
    }

    private void InOrder(TreeNode treeRoot){
        if(treeRoot != null){
            InOrder(treeRoot.left);
            System.out.print(treeRoot.value+" ");
            InOrder(treeRoot.right);
        }
    }


    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){
            String str=scanner.nextLine();

            Guanggun tree=new Guanggun();
            tree.createBinaryTree(str,'#');
            tree.InOrder();
        }
    }
}
