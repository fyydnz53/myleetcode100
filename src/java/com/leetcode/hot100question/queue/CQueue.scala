package com.leetcode.hot100question.queue

import scala.collection.mutable

class CQueue {

  private val in = new mutable.Stack[Int]()
  private val out = new mutable.Stack[Int]()

  def appendTail(value: Int) {
      in.push(value)
  }

  def deleteHead(): Int = {
      if(out
        .isEmpty){
        if(in.isEmpty){
          return -1
        }
        for(i<-1 to in.length){
          out.push(in.pop())
        }
      }
    out.pop()
  }
}
