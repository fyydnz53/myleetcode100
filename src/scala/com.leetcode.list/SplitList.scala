package com.leetcode.list

object SplitList {
  def main(args: Array[String]): Unit = {
    val node = new ListNode(1, new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))))
    val node1 = partition(node, 3)
    println(node1.x+"======"+node1.next.x)
  }

  def partition(head: ListNode, x: Int): ListNode = {

    val big = new ListNode()
    val small = new ListNode()
    var tmpB = big
    var tmpS = small
    var tmp = head

    while (tmp != null){
      if(tmp.x < x){
        tmpS.next = tmp
        tmpS = tmpS.next
      }else {
        tmpB
          .next = tmp
        tmpB = tmpB
          .next
      }
      tmp = tmp.next
    }
    tmpB.next = null
    tmpS.next = big.next
    small.next
  }

}
