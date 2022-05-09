package com.company;

public class BST <K extends Comparable<K>, V> {

    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val){
        boolean added = false;
        Node node = new Node(key, val);
        if(root == null){
            root = node;
        }else{
            Node node1;
            node1 = root;
            Node upTree;
            while(!added){
                upTree = node1;
                if(node.key.compareTo(node1.key) > 0) {
                    node1 = node1.right;
                    if(node1 == null){
                        upTree.right = node;
                    }
                } else {
                    node1 = node1.left;
                    if(node1 == null){
                        upTree.left = node;
                    }
                }
            }
        }
    }

    public V get (K key){
        Node node = root;
        if(key.compareTo(node.key) > 0){
            while(node != null){
                if(key.compareTo(node.key) == 0){
                    return node.val;
                }else{
                    node = node.right;
                }
            }
        } else if (key.compareTo(node.key) < 0) {
            while(node != null){
                if(key.compareTo(node.key) == 0){
                    return node.val;
                }else{
                    node = node.left;
                }
            }
        }
        return null;
    }



    public void delete(K key){
        boolean deleted = false;
        Node node = root;
        while(!deleted){
            if(key.compareTo(node.key) > 0) {
                if (key.compareTo(node.key) == 0) {
                    if (node.right != null) {
                        node.right = node;
                    } else {
                        node.left = node;
                    }
                } else {
                    node = node.right;
                }
            }else{
                if (key.compareTo(node.key) == 0) {
                    if (node.right != null) {
                        node.right = node;
                    } else {
                        node.left = node;
                    }
                } else {
                    node = node.left;
                }
            }
        }
    }

    public Iterable<K> iterator(){

    }
}