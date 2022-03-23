package datastructures;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    List<T> l = new LinkedList<>();
    public void push(T value){
        l.add(value);
    }
    public T pop(){
        T e = peek();
        l.remove(l.size() - 1);
        return e;
    }
    public T peek(){
        return l.get(l.size() - 1);
    }
    public boolean isEmpty(){
        return l.isEmpty();
    }
    public void printValues(){
        l.forEach(e -> System.out.print(""+e+" "));
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.printValues(); // 1 2 3 4
        System.out.println(s.pop()); // 4
        System.out.println(s.pop()); // 3
        System.out.println(s.peek());// 2
        s.printValues(); // 1 2
    }
    
    
}
