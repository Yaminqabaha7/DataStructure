package com.mycompany.mystackk;

public class Mystack<T> {

private T arr[];
private int size;

    public Mystack() {
       arr=(T[])new Object[5];
        size=0;
    }
     private void resise(){
           T[] temb = (T[]) new Object[arr.length*2];
        for (int i = 0; i < size; i++) {
            temb[i] = arr[i];
        }
        arr=temb;
     }
     public int size(){
         return size;
     }
     public void push(T a){
         if(size==arr.length)
         {  resise();}
         arr[size++]=a;
     }
     public T pop(){
          if(isempty()){
             throw new ArrayIndexOutOfBoundsException();
          }
          return arr[size-- - 1];
     }
      public T peek(){
          if(isempty()){
             throw new ArrayIndexOutOfBoundsException();
          }
          return arr[size - 1];
     }
     
     public boolean isempty(){
         return size==0;
     }
 
    @Override
    public String toString() {
       String s="[";
       int a=size;
        for (int i = 0; i < a; i++) {
            s+=arr[i];
            if(i<size-1)
                s+=",";
               }
        return s+"]";
    }
     
}

