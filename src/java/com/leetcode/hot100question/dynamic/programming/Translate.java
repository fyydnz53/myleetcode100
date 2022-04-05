package com.leetcode.hot100question.dynamic.programming;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Translate {
    /**
     * 这是一道有条件的爬楼梯,即两步时候不能超过25
     */
    public int translateNum(int num) {
        if (num < 10){
            return 1;
        }

        String s = String.valueOf(num);
        int first = 1;
        int second = Integer.parseInt(s.substring(0,2)) < 26?2:1;//前两位不会出现0x的事件
        int result = second;
        for (int i = 2; i < s.length(); i++) {
            int i1 = Integer.parseInt(s.substring(i - 1,
                    i + 1));
            if (i1 <26 && i1 > 9){
                result = first + second;
            }else {
                result = second;
            }
            first = second;
            second = result;
        }
        return result;
    }
}
