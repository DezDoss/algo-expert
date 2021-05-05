package io.algoexpert.www.java.stack;

import javax.xml.stream.events.StartElement;
import java.util.*;

public class SunsetVIews {

    public static void main(String[] args) {
        System.out.println(sunsetViews2(new int[] {1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8}, "WEST"));
    }


    //This is my complicated solution
    public static List<Integer> sunsetViews(int[] buildings, String direction) {
        List<Integer> list = new ArrayList<>();
        if(direction.equals("EAST")) {
            Stack<Integer> stack = new Stack();
            stack.push(buildings.length - 1);

            for(int i = buildings.length - 2; i >= 0; i--) {
                if(buildings[stack.peek()] < buildings[i]) {
                    stack.push(i);
                }
            }
            while(!stack.isEmpty()) {
                list.add(stack.pop());
            }
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < buildings.length; i++) {
                if(buildings[i] > buildings[stack.peek()]) {
                    stack.push(i);
                }
            }
                while(!stack.isEmpty()) {
                    list.add(stack.pop());
                }
            Collections.reverse(list);
        }

        return list;
    }


    //solutions from algoexpert
     public static ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {
        ArrayList<Integer> candidateBuildings = new ArrayList<>();

        int startIdx = buildings.length - 1;
        int step = -1;

        if(direction.equals("EAST")) {
            startIdx = 0;
            step = 1;
        }

        int idx = startIdx;

        while(idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];

            while(candidateBuildings.size() > 0
            && candidateBuildings.get(candidateBuildings.size() - 1) <= buildingHeight) {
                candidateBuildings.remove(candidateBuildings.size() - 1);
            }

            candidateBuildings.add(idx);

            idx += step;
        }

        if(direction.equals("WEST")) {
            Collections.reverse(candidateBuildings);
        }

        return candidateBuildings;
     }


}
