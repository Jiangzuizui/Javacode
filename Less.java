package day20211123;

import java.util.Comparator;
import java.util.Map;

public class Less implements Comparator<Map.Entry<String,Integer>> {
    public int compare(Map.Entry<String,Integer> o1,
                       Map.Entry<String,Integer> o2){

        if(o1.getValue()> o2.getValue()){
            return 1;
        }
        if(o1.getValue()== o2.getValue()&&
                o2.getKey().compareTo(o1.getKey())>0){
            return 1;
        }
        return -1;
    }
}
