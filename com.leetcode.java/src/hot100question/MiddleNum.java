package hot100question;
/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MiddleNum {
    public static void main(String[] args) {
        MiddleNum m1=new MiddleNum();
        int[] i1 ={3,4};
        int[] i2 ={1,2};
        double c =m1.findMedianSortedArrays(i1,i2);
        System.out.println(c);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先找到两个数组的长度,和需要求中位数的辅助长度
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = (l1+l2+1)/2;
        int j = (l1+l2+2)/2;
        //找到两个数组的中位数,给出数组起点
       int m =0;
       int n =0;
       int tmp=0;
       return findNum(nums1,nums2,m,n,i,j,tmp);
    }
    public double findNum(int[] is1,int[] is2,int m,int n,int i,int j,int tmp){
        if(m>=is1.length) return (is2[i-is1.length-1]+ is2[j-is1.length-1])/2.0;
        if(n>=is2.length) return (is1[i-is2.length-1]+ is1[j-is2.length-1])/2.0;
/*        if((m+n)==(i-2)){
            tmp = is1[m]>is2[n]?is1[m]:is2[n];
        }
        if((m+n)==(j-2)){
            return ((is1[m]>is2[n]?is1[m]:is2[n])+tmp)/2.0;
        }*/
        while (is1[m]>=is2[n]){
            n++;
            return findNum(is1,is2,m,n,i,j,tmp);
        }
        while (is1[m]<is2[n]){
            m++;
            return findNum(is1,is2,m,n,i,j,tmp);
        }
        return findNum(is1,is2,m,n,i,j,tmp);
    }
}
