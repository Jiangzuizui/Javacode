package day20211111;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//用循环的(非递归)的方式遍历二叉树
public class BianLi {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }

        public TreeNode(int val){
            this.val=val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //前序遍历
    class Solution{
        public List<Integer> preorderTravelsal(TreeNode root){
            List<Integer> list=new ArrayList<>();
            if(root==null){
                return list;
            }
            //从上往下遍历最左侧路径中的每个结点,
            //并将其右子树保存到栈中
            Stack<TreeNode> s=new Stack<>();
            TreeNode cur=root;
            while(!s.empty() || cur!=null){
                while(cur!=null){
                    list.add(cur.val);
                    if(cur.right!=null){
                        s.push(cur.right);
                    }
                    cur=cur.left;
                }
                if(!s.empty()){
                    cur=s.pop();
                }
            }
            return list;
        }
    }


    //中序遍历
    class Solution2{
        public List<Integer> inOrderTraversal(TreeNode root){
            List<Integer> list=new ArrayList<>();
            if(root==null){
                return list;
            }

            TreeNode cur=root;
            Stack<TreeNode> s=new Stack<>();
            while(!s.empty() || cur!=null){
                while(cur!=null){
                    s.push(cur);
                    cur=cur.left;
                }
                cur=s.pop();
                list.add(cur.val);

                cur=cur.right;
            }
            return list;
        }
    }

    //后序遍历
    class solution3{
        public List<Integer> postorderTraversal(TreeNode root){
            List<Integer> list=new ArrayList<>();
            if(root==null){
                return list;
            }
            Stack<TreeNode> s=new Stack<>();
            TreeNode cur=root;
            while(!s.empty() || cur!=null){
                while(cur!=null){
                    s.push(cur);
                    cur=cur.left;
                }

                TreeNode top=s.peek();
                if(top.right==null){
                    list.add(top.val);
                    s.pop();
                }else{
                    cur=top.right;
                }
            }
            return list;
        }
    }




}





