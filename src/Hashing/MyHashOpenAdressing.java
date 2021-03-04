package Hashing;


public class MyHashOpenAdressing {


    private int size;
    private int cap;
    private int[] table;

    public MyHashOpenAdressing(int b) {
        this.cap = b;
        size = 0;
        table = new int[b];
        for(int i = 0; i < b; i++) {
            table[i] = -1;
        }
    }

    private int hash(int key) {
        return key % cap;
    }

    public boolean search(int key) {
        int h = hash(key);

        int i = h;

        while(table[i] != -1) {

            if(table[i] == key) {
                return true;
            }

            i = (i+1) % cap;

            if(i == h) {
                return false;
            }
        }
        return false;
    }

    public boolean insert(int key) {
        if(size ==cap) {
            return false;
        }

        int i = hash(key);

        while(table[i] != - 1 && table[i] != -2 && table[i] != key) {

            i = (i+1) % cap;
        }

        if(table[i] == key) {
            return false;
        } else {
            table[i] = key;
            size++;
            return true;
        }

    }


    public boolean delete(int key) {
        int h = hash(key);

        int i = h;

        while(table[i] != -1) {
            if(table[i] == key) {
                table[i] = -2;
            }

            i = (i+1) % cap;

            if(i == h) {
                return false;
            }
        }
        return false;
    }
}
