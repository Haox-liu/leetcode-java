package array;

import java.util.HashMap;
import java.util.Map;

public class L01_TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2, 2, 2};
        int target = 4;
         for(int i : twoSum(arr, target)) {
            System.out.println(i);
         }
    }


    public static int[] twoSum(int[] array, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < array.length; i++) {
            map.put(target - array[i], i);
        }

        System.out.println(map);

        for(int j=0; j < array.length; j++) {
            Integer v = map.get(array[j]);

            if(v != null && v.intValue() != j) {
                return new int[]{j+1, v+1};
            }
        }

        return null;
    }

}
