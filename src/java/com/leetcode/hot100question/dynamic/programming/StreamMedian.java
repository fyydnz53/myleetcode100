package com.leetcode.hot100question.dynamic.programming;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiang
 */
public class StreamMedian {

    public static void main(String[] args) {
        //compare 越小则优先级越大
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        System.out.println(Integer.valueOf(2).compareTo(3));
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(1);
        integers.add(5);
        integers.add(0);
        while(integers.size()>0){
            System.out.println(integers.poll());
        }
    }

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap ;

    public StreamMedian() {
        //小顶堆，保留最大的一半
        maxHeap = new PriorityQueue<>();
        //大顶堆，保存小的一半
        minHeap = new PriorityQueue<>((o1, o2) -> o2 -o1);
    }

    public void addNum(int num) {
        if(maxHeap.size() != minHeap.size()){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+ minHeap.peek()) /2;
        }
        return maxHeap.peek();
    }


}
