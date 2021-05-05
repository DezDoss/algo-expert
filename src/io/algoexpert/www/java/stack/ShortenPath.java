package io.algoexpert.www.java.stack;

import java.util.Stack;

public class ShortenPath {
    public static void main(String[] args) {
        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
    }

    public static String shortenPath(String path) {
        Stack<String> stack = new Stack();
        String[] strings = path.split("/");

        for(String s : strings) {
            if(!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if(s.isEmpty() || s.equals(".")) {
                continue;
            } else {
                stack.add(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(stack.pop());
        }


        return stringBuilder.toString();
    }
}
