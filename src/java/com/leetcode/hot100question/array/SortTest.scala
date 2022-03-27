package com.leetcode.hot100question.array

object SortTest {

  /**
   * 冒泡排序
   *
   * @param array
   * @return
   */
  def bubbleSort(array: Array[Int]): Array[Int] = {
    var tmp = 0;
    for (n <- array
      .indices
         ) {
      var flag = true
      for (m <- 0 until array
        .length - n) {
        if (array(m) > array(m + 1)) {
          tmp = array(m + 1)
          array(m + 1) = array(m)
          array(m) = tmp
          flag = false
        }
      }
      if(flag){
        //完全通畅直接返回
        return array
      }
    }
    array
  }

  /**
   * 快排
   *
   * @param array
   * @return
   */
  def quickSort(array: List[Int]): List[Int] = {
    array match {
      case Nil => Nil;
      case List() => List();
      case head :: tail => {
        val (left, right) = tail.partition(_ < head)
        quickSort(left) ::: head :: quickSort(right)
      }
    }
  }

  /**
   * 归并排序
   *
   * @param list
   * @param list1
   * @return
   */
  def mergeSort(list: List[Int], list1: List[Int]): List[Int] = {
    (list, list1) match {
      case (_, Nil) => _
      case (Nil, _) => _
      case (head1 :: tail1, head2 :: tail2) => {
        if (head1 < head2) {
          head1 :: mergeSort(tail1, list1);
        } else {
          head2 :: mergeSort(tail2, list)
        }
      }
    }
  }
}
