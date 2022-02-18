package newRecords

object MergeLists {

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    var step01 = list1
    var step02 = list2
    val res =  new ListNode()
    var step03: ListNode = res;

    while(step01 != null && step02 != null){
      if(step01.x > step02.x){
        step03.next = step02
        step02 = step02.next
      }else{
        step03.next = step01
        step01 = step01.next
      }
      step03 = step03.next

    }

    if(step01 != null) step03.next = step01

    if(step02 != null) step03.next =step02

    res.next
  }

  def mergeTwoLists2(list1: ListNode, list2: ListNode): ListNode = {
    if(list1 == null){
      return list2
    }

    if(list2 == null){
      return list1
    }

    if(list1.x < list2.x){
      list1.next = mergeTwoLists2(list1.next,list2)
      return list1
    }
    list2.next = mergeTwoLists2(list2.next,list1)
    list2
  }

}
