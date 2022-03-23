package datastructures;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
    List<T> l = new LinkedList<>();
    public void add(T e){
        l.add(0, e);
    }
    public T remove(){
        T e = l.get(l.size() - 1);
        l.remove(l.size() - 1);
        return e;
    }
    public boolean isEmpty(){
        return l.isEmpty();
    }
    public void printValues(){
        l.forEach(e -> System.out.print(""+e+" "));
        System.out.println();
    }
    public static void main(String[] args) {
        Queue<String> q = new Queue<>(); 
        for (char i = 0; i < 26; i++)
            q.add(Character.toString((char)(i+'a')));
            
        while(!q.isEmpty())
            System.out.println(q.remove());
    }

}
