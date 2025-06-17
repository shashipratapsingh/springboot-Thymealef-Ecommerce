package ShopingApp.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOdd {

    public static void main(String[] args){
        List<Integer> dd= Arrays.asList(1,4,5,6,7,9);

      Map<Boolean, List<Integer>> odd1=  dd.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println(odd1);

    }
}
