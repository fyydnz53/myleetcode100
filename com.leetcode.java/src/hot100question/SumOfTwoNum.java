package hot100question;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNum {
    public static void main(String[] args) {
        int[] ints={13,1596,12,25,6121,254,21541,58141,15123,25,12153,546812,123421};
        int a= 123421+546812;
        long l1 = System.currentTimeMillis();
        int[] ints1 = SumOfTwoNum.twoSum(ints, a);
        for (int i : ints1) {
            System.out.println(i);
        }
        long l2 = System.currentTimeMillis();
        int[] ints2 = SumOfTwoNum.twoSum2(ints, a);
        for (int i : ints2) {
            System.out.println(i);
        }
        long l3 = System.currentTimeMillis();
        System.out.println("第一种"+(l2-l1)+"第二种"+(l3-l2));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                ints[0] = i;
                ints[1] = (int) map.get(target-nums[i]);
            }else map.put(nums[i],i);
        }
        return ints;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j] == target){
                    ints[0]=i;
                    ints[1]=j;
                    return ints;
                }
            }
        }
        return ints;
    }
}
