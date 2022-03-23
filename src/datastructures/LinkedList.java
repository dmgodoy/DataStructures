package datastructures;

public class LinkedList {
    public static class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    Node head;
    
    public LinkedList append(int value){
        Node n = new Node(value);
        if(head == null){
            head = n;
            return this;
        }
        Node current = head;
        while(current.next != null)
            current = current.next;
        
        current.next = n;
        return this;
    }
    public LinkedList prepend(int value){
        Node n = new Node(value);
        if(head == null){
            head = n;
            return this;
        }
        n.next = head;
        head = n;
        return this;
    }
    public void printValues(){
        Node current = head;
        while(current != null){
            System.out.print("" + current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    
    public LinkedList deleteWithValue(int value){
        if(head == null)
            return this;
        if(head.value == value){
            head = head.next;
            return this;
        }
        Node current = head;
        while(current != null){
            if(current.next != null && current.next.value == value){
                current.next = current.next.next;
                return this;
            }
            current = current.next;
        }
        return this;
    }
    public static void main(String[] args) {
        
        LinkedList l = new LinkedList();
        l.append(1).append(2).append(3).append(4).prepend(0).prepend(-1).prepend(-2).prepend(-2).printValues();
        l.deleteWithValue(-2).deleteWithValue(4).printValues();
    }
}
