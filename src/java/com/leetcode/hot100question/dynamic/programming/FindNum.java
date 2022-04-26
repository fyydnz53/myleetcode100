package com.leetcode.hot100question.dynamic.programming;

/**
 * @author jiang
 */
public class FindNum {
    public static void main(String[] args) {
        FindNum findNum = new FindNum();
        System.out.println(findNum.findNthDigit(1000000000));
    }

    /**
     * k 神优化版
     * @param n
     * @return
     */
    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }


    /**
     * 1-9 位数为 9    位数  9 * 1      是 1
     * 10~99 个数为 9 * 10   9 * 10 * 2 开始值 是 10
     * 100~999 个数为 9 * 100 9 * 100 * 3   是 100
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if (n < 10){
            return n;
        }
        //查询时间级
        int level = getLevel(n,1);
        //找到开始的值;干掉前面等级的值
        int start = (int) Math.pow(10,level - 1);
        //计算上一个时间级的个数
        int lastNum = getLastNum(level - 1);

        //获得具体的数字与第几位
        int k = (n - lastNum) / level;
        int v = (n - lastNum) % level;
        if (v == 0){
            v = level;
            k--;
        }
        return Integer.parseInt(String.valueOf(start+k).substring(v-1,v));
    }

    /**
     * 拿到高一截的时间级  100 拿到 3
     * @param n
     * @return
     */
    public int getLevel(int n,int k) {
        double pow = k * 9 * Math.pow(10,
                k - 1);
        if (n > pow){
            return getLevel(n - (int)pow,k + 1);
        }
        return k;
    }

    public int getLastNum(int level){
        if (level > 1){
            return (int)(9 * level * Math.pow(10,level-1) + getLastNum(level-1));
        }
        return 9;
    }
}
