package com.gl.lab3.driver;

import java.util.Stack;
//import java.util.Scanner;

public class Main {
	public static boolean balancedParenthesis(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			char x = str.charAt(i);
			if(x == '(' || x == '{' || x == '[' ) {
				stack.push(x);
				continue;
			}
			
			if(stack.isEmpty())
				return false;
			
			char ele;
			switch(x) {
				case ')':
					ele = stack.pop();
					if(ele == '{' || ele == '[') return false;
					break;
					
				case '}':
					ele = stack.pop();
					if(ele == '(' || ele == '[') return false;
					break;
					
				case ']':
					ele = stack.pop();
					if(ele == '(' || ele == '{') return false;
					break;
			}
		}
		return(stack.isEmpty());
			
		}
	
	public static void main(String[] args) {
		
		String str = "{[()]}";
        if (balancedParenthesis(str))
            System.out.println("Balanced Brackets");
        else
            System.out.println("Unbalanced Brackets");
    }
}