package com.trainline.usecases;

import com.trainline.domains.Line;
import com.trainline.domains.Station;

import java.util.*;

public class DepthFirstSearchTrip {

    public String DFS(Line line, String s, String to) {
        Vector<Boolean> visited = new Vector<>(line.getStations().size());
        String trips = "";
        for (int i = 0; i < line.getStations().size(); i++) {
            visited.add(false);
        }

        Stack<String> stack = new Stack<>();

        stack.push(s);

        while(stack.empty() == false) {
            s = stack.peek();
            stack.pop();

            if(visited.get(getIndex(s)) == false) {
                trips.concat(s+" ");
                System.out.print(s + " ");
                if(s.equals(to)) {
                    stack.clear();
                    break;
                }
                visited.set(getIndex(s), true);
            }

            final String from = s;
            Station itr = line.getStations().stream()
                    .filter(station -> station.getName().equals(from))
                    .findAny().orElse(null);

            for( Map.Entry<Station, Integer> adj : itr.getAdjacentStation().entrySet()) {
                Station v = adj.getKey();
                if(!visited.get(getIndex(v.getName())))
                    stack.push(v.getName());
            }

        }

        return trips;
    }

    private int getIndex(String s) {
        switch (s) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            default:
                return 0;
        }
    }
}