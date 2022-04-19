package com.leetcode.hot100question.array

import scala.::
import scala.collection.immutable.Nil.:::

object CharSort {
  def minNumber(nums: Array[Int]): String = {
    val array = nums
      .toList
      .map(a => a
        .toString)
    quickSort(array).mkString("")

  }

  def quickSort(array: List[String]):List[String]={
    array match {
      case Nil => Nil
      case List() => List()
      case head :: tail=>
        val (left,right) = tail.partition(p => (p + head).compareTo(head + p) < 0)
        quickSort(left) ::: head :: quickSort(right)
    }
  }
}
