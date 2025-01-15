
package com.mycompany.implemanitionqueue;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1; 
    Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("تم إدخال العنصر: " + data);
    }

  
    public int dequeue() {
        if (stack2.isEmpty()) {
           
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("is empty!");
            return -1;
        }

        
        return stack2.pop();
    }

    
    public void display() {
        System.out.println("");
        if (!stack2.isEmpty()) {
            System.out.println(stack2);
        }
        if (!stack1.isEmpty()) {
            System.out.println(stack1);
        }
    }

    
}

