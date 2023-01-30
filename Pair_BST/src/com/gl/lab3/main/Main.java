package com.gl.lab3.main;

import java.util.HashSet;


class Node{
	int data;
	Node left = null; 
	Node right = null;
	
	Node(int data){
		this.data=data;
	}
}

public class Main {
	public static Node insert(Node root, int key) {
		if(root == null) {
			return new Node(key);
		}
		
		if(key<root.data) {
			root.left = insert(root.left, key);
			
		}
		else {
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	
	
	public static boolean findPairs(Node root, int target, HashSet<Integer> set) {
		
		if(root==null) {
			return false;
		}
		
		
		if(findPairs(root.left, target, set)) {
			return true;
		}
		
		if (set.contains(target - root.data))
        {
            System.out.println("Pair obtained (" + (target - root.data) + ", "
                                    + root.data + ")");
            return true;
        }

        else {
            set.add(root.data);
        }

        return findPairs(root.right, target, set);
    }
	
	public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25};
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
        int target = 35;
 
        HashSet<Integer> set = new HashSet<>();
 
        if (!findPairs(root, target, set)) {
            System.out.println("Pair does not exist");
        }
    }
}
