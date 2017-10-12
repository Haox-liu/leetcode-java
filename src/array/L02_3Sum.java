package array;

import java.util.*;

/**
 * Created by hao on 17-9-2.
 */
public class L02_3Sum {

    public static void main(String[] args) {

        L02_3Sum sum = new L02_3Sum();
        int[] num = {-1, 0, 1, 2, -1, -4, 3};
        List<List<Integer>> intList = sum.threeSumZero(num);

        for (List<Integer> ints : intList) {
            System.out.println(ints);
        }

    }

    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSumZero(int[] num) {
        if (num == null || num.length < 3)
            return list;

        Arrays.sort(num);

        int len = num.length;
        for (int i=0; i < len-2; i++) {
            if (i > 0 && num[i] == num[i-1])
                continue;

            find(num, i+1, len-1, num[i]);
        }

        return list;
    }

    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] +target == 0) {
                List<Integer> ints = new ArrayList<Integer>();
                ints.add(target);
                ints.add(num[l]);
                ints.add(num[r]);
                list.add(ints);

                while (l < r && num[l] == num[l+1])
                    l++;
                while (l < r && num[r] == num[r-1])
                    r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}
