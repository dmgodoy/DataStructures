package datastructures;

public class Vector {
    final static int initialCapacity = 10;
    int[] data;
    int size = 0;
    public Vector() {
        data = new int[initialCapacity];
    }
    public int getSize() {
        return size;
    }
    public void add(int elem){
        if(size == data.length){
            int[] d = new int[data.length * 2];
            for (int i = 0; i < data.length; i++)
                d[i] = data[i];
            data = d;
            System.out.println(data.length);
        }
        data[size++] = elem;
    }
    
    
    public int get(int i){
        if(i >= size)
            throw new Error("Index out of bounds");
        return data[i];
    }
    public void add(int i, int value){
        if(i >= size)
            throw new Error("Index out of bounds");
        data[i] = value;
    }

    
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 100; i++)
            v.add(i);
        System.out.println(v.getSize());
        for (int i = 0; i < v.getSize(); i++)
            System.out.println(v.get(i));
            
        
        
    }
}
