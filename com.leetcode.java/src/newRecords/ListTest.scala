package newRecords

import java.util

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */
object $2_AddTwoNumbers {

  def main(args: Array[String]): Unit = {
    /*    val l1 = new ListNode(4, new ListNode(5, new ListNode(3, new ListNode(5))))
        val l2 = new ListNode(6, new ListNode(4))
        var node = addTwoNumbers(l1, l2)
        var node2 = reverseBetween3(l1, 1, 4)
        while (node2 != null) {
          println(node2
            .x)
          node2 = node2
            .next
        }*/
    val l1 = new ListNode(1)
    val l2 = new ListNode(2)
    val l3 = new ListNode(3)
    l1
      .next = l2
    l2
      .next = l3
    l3
      .next = l1
    println(detectCycle(l1))
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var n1, n2, tmp = 0
    val result = new ListNode()
    var tmpR = result
    var tmp1 = l1
    var tmp2 = l2
    while (tmp1 != null || tmp2 != null || tmp > 0) {
      n1 = 0
      n2 = 0;
      if (tmp1 != null) {
        n1 = tmp1
          .x
        tmp1 = tmp1
          .next
      }
      if (tmp2 != null) {
        n2 = tmp2
          .x
        tmp2 = tmp2
          .next
      }
      tmpR
        .next = new ListNode((n1 + n2 + tmp) % 10)
      tmpR = tmpR
        .next
      tmp = (n1 + n2 + tmp) / 10
    }
    result
      .next
  }

  /**
   * 反转链表的指定位数
   * 值替换
   *
   * @param head  链表头节点
   * @param left  起始位置
   * @param right 结束位置
   * @return
   */
  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    if (left == right) {
      return head
    }

    val map = new util.HashMap[Int, ListNode]()
    val size = right + left
    val vir = new ListNode(0, head)
    var tmp = vir
    var node: ListNode = null
    for (i <- 0 until right) {
      if (i >= left - 1) {
        node = map.get(size - i - 1)
        if (node == null) {
          map.put(i + 1, tmp
            .next)
        } else {
          val tmpValue = node
            .x
          node
            .x = tmp
            .next
            .x
          tmp
            .next
            .x = tmpValue
        }
      }
      tmp = tmp
        .next
    }

    head
  }

  /**
   * 反转链表的指定位数
   * 反转指针
   *
   * @param head  链表头节点
   * @param left  起始位置
   * @param right 结束位置
   * @return
   */
  def reverseBetween2(head: ListNode, left: Int, right: Int): ListNode = {
    if (left == right) {
      return head
    }
    //新建一个头
    val vir = new ListNode(0, head)
    var tmp = vir
    //找到起点前一个节点；
    for (i <- 1 until left) {
      tmp = tmp
        .next
    }
    val started = tmp
    tmp = tmp
      .next
    var pre: ListNode = null
    var current: ListNode = null
    //开始进行中间互换
    for (i <- left to right) {
      //先查到下游再进行替换
      current = tmp
      tmp = tmp
        .next
      current
        .next = pre
      pre = current
    }

    started
      .next
      .next = tmp
    started
      .next = pre

    vir
      .next
  }

  /**
   * 反转链表的指定位数
   * 步步为营
   *
   * @param head  链表头节点
   * @param left  起始位置
   * @param right 结束位置
   * @return
   */
  def reverseBetween3(head: ListNode, left: Int, right: Int): ListNode = {
    if (left == right) {
      return head
    }
    //新建一个头
    val vir = new ListNode(0, head)
    var tmp = vir
    //找到起点前一个节点；
    for (i <- 1 until left) {
      tmp = tmp
        .next
    }
    val started = tmp
      .next
    //开始进行中间互换
    for (i <- left until right) {
      //先查到下游再进行替换
      val nex = started
        .next
      started
        .next = nex
        .next
      nex
        .next = tmp
        .next
      tmp
        .next = nex
    }


    vir
      .next
  }

  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    if (headA == null || headB == null) {
      return null
    }
    var a = headA
    var b = headB
    while (a != b) {
      if (a == null) {
        a = headB
      } else {
        a = a
          .next
      }

      if (b == null) {
        b = headA
      } else {
        b = b
          .next
      }
    }
    a
  }


  def hasCycle(head: ListNode): Boolean = {
    var step01 = head
    var step02: ListNode = null
    if (step01 != null) {
      step02 = head
        .next
    }

    while (step02 != null && step01 != null) {
      if (step01 == step02) {
        return true
      }

      step01 = step01
        .next

      if (step02
        .next != null) {
        step02 = step02
          .next
          .next
      } else {
        return false
      }
    }

    false

  }

  /**
   * x1 头到环的距离
   * x2 慢节点被追上的距离
   * x3 追上点到结尾的距离
   * x1 + x2 = l1
   * x1 + 2x2 + x3 = l2
   * l2 = 2 * l1
   * 所以 x1 = x3
   *
   * @param head
   * @return
   */
  def detectCycle(head: ListNode): ListNode = {
    if (head == null) return null
    var step01 = head;
    var step02 = head
    if (step01 != null) {
      step02 = head
        .next
    }
    var step03: ListNode = head;

    while (step02 != null && step01 != null) {
      if (step01 == step02) {
        while (step01 != null && step03 != null) {
          step01 = step01
            .next
          if (step01 == step03) {
            return step03
          }

          step03 = step03
            .next
        }
      } else {

        step01 = step01
          .next

        if (step02
          .next != null) {
          step02 = step02
            .next
            .next
        } else {
          return null
        }
      }
    }

    null
  }
}

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
