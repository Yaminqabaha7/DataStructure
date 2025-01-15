package com.mycompany.linkedlistt;

class node {

    int val;
    node next;

    public node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Mylinkedlist {

    int size;
    node head, tail;

    public Mylinkedlist() {
        size = 0;
        head = tail = null;
    }

    void addFirst(int v) {
        node x = new node(v);
        if (head == null) {
            head = tail = x;
        } else {
            x.next = head;
            head = x;
        }
        size++;
    }

    void addLast(int v) {
        node x = new node(v);
        if (head == null) {
            head = tail = x;
        } else {
            tail.next = x;
            tail = x;
        }
        size++;
    }

    void addByIndex(int ind, int value) {
        if (ind < 0 || ind > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (ind == 0) {
            addFirst(value);
        } else if (ind == size) {
            addLast(value);
        } else {
            node a = new node(value);
            node p = head;
            for (int i = 0; i < ind - 1; i++) {
                p = p.next;
            }
            a.next = p.next;
            p.next = a;
            size++;
        }
    }

    public int removeFirst() {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int a = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return a;
    }

    public int removeLast() {
        if (head == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (head == tail) {
            int val = head.val;
            head = tail = null;
            size--;
            return val;
        } else {
            node s = head;
            while (s.next != tail) {
                s = s.next;
            }
            int d = tail.val;
            tail = s;
            tail.next = null;
            size--;
            return d;
        }
    }

    public int removeByIndex(int ind) {
        if (ind < 0 || ind >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (ind == 0) {
            return removeFirst();
        } else if (ind == size - 1) {
            return removeLast();
        } else {
            node r = head;
            for (int i = 0; i < ind - 1; i++) {
                r = r.next;
            }
            int q = r.next.val;
            r.next = r.next.next;
            size--;
            return q;
        }
    }

    public void addSorted(int val) {
        node b = new node(val);
        if (head == null || head.val > b.val) {
            b.next = head;
            head = b;
            return;
        } else {
            node x = head;
            while (x.next != null && x.next.val <= b.val) {
                x = x.next;
            }
            b.next = x.next;
            x.next = b;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (node cur = head; cur != null; cur = cur.next) {
            s.append(cur.val);
            if (cur.next != null) {
                s.append(", ");
            }
        }
        return s.append("]").toString();
    }
}
