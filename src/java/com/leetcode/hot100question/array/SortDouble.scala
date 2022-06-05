package com.leetcode.hot100question.array

import java.util

/**
 * 调整数组顺序使奇数位于偶数前面
 */
object SortDouble {
  def main(args: Array[String]): Unit = {
    val ints = Array(1, 2, 3, 4)
    println(exchange(ints).toList)
  }

  def exchange(nums: Array[Int]): Array[Int] = {
    nums.toList match {
      case Nil => Nil.toArray
      case List() => List().toArray
      case a =>{
        val (sin,dou) = a.partition(t=>t%2 == 1)
        (sin:::dou).toArray
      }
    }
  }

}
