package day20211022;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            //计算杨辉三角每行数据
            List<Integer> rowData=new ArrayList<>(i+1);
            for(int j=0;j<=i;j++){
                if(j==0||i==j){
                    rowData.add(1);
                }else{
                    //计算到第三行
                    rowData.add(list.get(i-1).get(j)+
                            list.get(i-1).get(j-1));
                }
            }
            list.add(rowData);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
