package com.leetcode.list

object TestTake {

  def main(args: Array[String]): Unit = {
    val ints = Array[Int](1, 2, 3, 4, 5, 6, 7)
    val list = ints
      .toList
    list.take(3).foreach(println)
    list.takeRight(4).foreach(println)
  }

}
