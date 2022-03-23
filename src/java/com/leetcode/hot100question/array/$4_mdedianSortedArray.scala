package com.leetcode.hot100question.array

object $4_mdedianSortedArray {
  def main(args: Array[String]): Unit = {
    val d = findMedianSortedArrays(Array[Int](-2,-1), Array[Int](3))
    println(d)
  }

  //找到两个有序数组合并后的中位数;时间复杂度要求到ln(m+n)
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    /** 中位数一定来自于中间的两个数：有以下几种情况
     * 和为奇数：
     * 一定有一个x(n) > y(m) 且  x(n) < y(m+1);m+n = (x.length + y.length)/2 -1
     * 和为偶数:
     * 一定有一个 x(n) > y(m) 且 x(n) < y(m+1);m+n = (x.length + y.length)/2 -2
     * 如果一个大的都没有，就是-1；
     */
      if(nums1.length>nums2.length){
        return findMedianSortedArrays(nums2,nums1)
      }
    if(nums1.length == 0){
      if (nums2.length % 2 == 1){
        return nums2(nums2.length/2)
      }
      return (nums2(nums2.length/2-1)+nums2(nums2.length/2)).toDouble/2
    }
    val sumLength = nums1
      .length + nums2
      .length
    var n = nums1
      .length / 2
    if (sumLength % 2 == 1) {
      while (n >= 0 && n < nums1
        .length -1) {
        if (nums1(n) >= nums2(sumLength / 2 - 1 - n)) {
          if (nums1(n) <= nums2(sumLength / 2 - n)) {
            return nums1(n)
          }
          //往小滚
          n = n - 1
        }
        if (nums1(n) <= nums2(sumLength/2 -1 - n)){
          if (nums1(n+1) >= nums2(sumLength/2 -1 - n)){
            return nums2(sumLength/2 -1 - n)
          }
          //往大滚
          n = n + 1
        }
      }
      if(n == nums1.length-1){
        if (nums1(n) >= nums2(sumLength / 2 - 1 - n)) {
          if (nums1(n) <= nums2(sumLength / 2 - n)) {
            return nums1(n)
          }
        }
        if(n == 0){
          if(nums2(sumLength/2)<=nums1(n)){
            return nums2(sumLength/2)
          }
        }

        return nums2(sumLength/2  - nums1.length)
      }
      return nums2(sumLength/2)
    }
    while (n >= 0 && n < nums1
      .length -1) {
      if (nums1(n) >= nums2(sumLength / 2 - 2 - n)) {
        if (nums1(n) <= nums2(sumLength / 2 - 1 - n)) {
          return (nums1(n) + min(nums1(n+1),nums2(sumLength / 2 - 1 - n))).toDouble / 2
        }
        //往小滚
        n = n - 1
      }
      if (nums1(n) <= nums2(sumLength/2 -2 - n)){
        if (nums1(n+1) >= nums2(sumLength/2 -2 - n)){
          return (nums2(sumLength/2 - 2 - n) + min(nums1(n+1),nums2(sumLength / 2 - 1 - n))).toDouble / 2
        }
        //往大滚
        n = n + 1
      }
    }
    if(n == nums1.length-1){
      if(nums1.length == nums2.length){
        return (nums1(n)+ nums2(sumLength/2 - nums1.length)).toDouble / 2
      }
      return (nums2(sumLength/2 - nums1.length - 1) + nums2(sumLength/2 - nums1.length)).toDouble / 2
    }
    if(nums1.length == nums2.length){
      return (nums1(n)+ nums2(sumLength/2 - nums1.length -1)).toDouble / 2
    }
    (nums1(sumLength/2 - nums2.length) + nums1(sumLength/2 - nums2.length - 1)).toDouble / 2
  }

  def min(int1: Int,int2:Int): Int ={
    if(int1>int2){
      return int2
    }
    int1
  }
}
