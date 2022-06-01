package com.leetcode.hot100question.twoPointer

import scala.collection.mutable

/**
 * 最长不重复子串.
 */
object $3_longest_children_str {

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("aswekwds"))
  }
  def lengthOfLongestSubstring(s: String): Int = {
    val array = s
      .toCharArray
    val map = new mutable.HashMap[Char, Int]()
    var start:Int = 0
    var length:Int = 1
    for(i <- 0 until s.length){
       if(map.contains(array(i)) && map.getOrElse(array(i),0) >= start){
         val tmpL = i-start
         if(tmpL > length){
           length = tmpL
         }
         start = map.getOrElse(array(i),0)
       }
         map.put(array(i),i)
    }
    length
  }
}
