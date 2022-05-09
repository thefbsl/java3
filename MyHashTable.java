package com.company;

public class MyHashTable <K, V>{
    
    private class HashNode<K, v>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    
    private HashNode<K, V>[] ChainArray;
    private int M = 11;
    private int size;
    
    public MyHashTable(){
        ChainArray = new HashNode[M];
    }
    
    public MyHashTable(int M){
        int newM = (int)(M * 0.75);
        if(newM < 1){
            ChainArray = new HashNode[M];
            return;
        }

        M = newM;
        ChainArray = new HashNode[M];
    }
    
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public void put(K key, V value){
        HashNode<K, V> node = new HashNode<>(key, value);
        int x = hash(key);

        if (ChainArray[x] == null) {
            ChainArray[x] = node;
        }else {
            node.next = ChainArray[x];
            ChainArray[x] = node;
        }
        size++;
    }
    
    public V get(K key){
        int x = hash(key);
        return (V)ChainArray[x];
    }
    
    public V remove(K key){
        int x = hash(key);
        for(int i = x; i < size - 1; i++){
            ChainArray[i] = ChainArray[i + 1];
        }
        ChainArray[size - 1] = null;
        size--;
        return (V)ChainArray[size];
    }

    public boolean contains(V value){
        for(int i = 0; i < size - 1; i++){
            if(value.equals(ChainArray[i]))
            return true;
        }
        return false;
    }

    public K getKey(V value){
        HashNode node = null;
        for(int i = 0; i < size - 1; i++){
            if(value.equals(ChainArray[i]))
                node = ChainArray[i];
        }
        return (K)node.key;
    }
}
