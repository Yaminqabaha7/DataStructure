
package com.mycompany.mystackk;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {

    Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int data) {
        int size = queue.size();
        queue.add(data);

        for (int i = 0; i < size; i++) {
            
            queue.add(queue.remove());
        }
        System.out.println("تم إدخال العنصر: " + data);
    }

    public int pop() {
        if (queue.isEmpty()) {
            System.out.println("is empty");
            return -1;
        }
        return queue.remove();
    }

    public int top() {
        if (queue.isEmpty()) {
            System.out.println("is empty");
            return -1;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
    
}
