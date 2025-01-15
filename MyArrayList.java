package com.mycompany.arraylist5;

public class Myarraylist<T> {

    private T arr[];
    private int size;

    public Myarraylist() {
        arr = (T[]) new Object[3];
        size = 0;
    }
    

    public void add(T a) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = a;
    }
    public void swap( T value1, T value2 )
    {
               if((con(value1)&&con(value2))==true)
               {
               int a=indexof(value1);
               T l=(T)new Object();
                l=get(a);
               int b=indexof(value2);
               arr[a]=get(b);
               arr[b]=l;
                   
               }
    }

    public void addin(int index, T b) {
        if (index >= 0 && index <= size) {
            if (size == arr.length) {
                resize();
            }
            shiftrahit(index);
            arr[index] = b;
        }

    }
    public int comoonelement(Myarraylist<Integer>a,Myarraylist<Integer>b){
       Integer c = 0;
        for (int i = 0; i < a.size; i++) {
            for (int j = 0; j < b.size; j++) {
                if(a.get(i)==b.get(j))
                {
                  c+=a.get(i);
                }
            }
        }
        return c;
    }

    public T get(int index) {

        if (index >= 0 && index <= size) {
            return arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void set(int index, T a) {
        if (index >= 0 && index <= size) {
            arr[index] = a;
        } else {
            
            throw new ArrayIndexOutOfBoundsException("index iviled");
        }
    }

    public int indexof(T a) {

        for (int i = 0; i < size; i++) {
            if (arr[i] == a) {
             return i;
            }
        }
throw new ArrayIndexOutOfBoundsException();
    }

    boolean con(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    T remove(int index) {
        if (index <0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            T old =get(index);
            for(int i=index;i<size-1;i++)
            {
                arr[i]=arr[i+1];
            }
           size--;    
            return old;
        }
        
    }

    private void shiftleft(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    private void shiftrahit(int index) {
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        size++;
    }

    public void resize() {
        T[] temb = (T[]) new Object[arr.length*2];
        for (int i = 0; i < size; i++) {
            temb[i] = arr[i];
        }
        arr = temb;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += arr[i];
            if (i != size - 1) {
                s += ",";
            }
        }
        s += "]";
        return s;
    }


}
