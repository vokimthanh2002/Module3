package textstackandqueue;

import java.util.Stack;

public class TextStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        for(Integer i: stack){
            System.out.print(i);
        }
        stack.pop();
        System.out.println();
        for(Integer i: stack){
            System.out.print(i);
        }
    }
}
