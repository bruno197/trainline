package com.trainline.domains;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Station {
    private String name;
    public boolean visited;

//    private List<Station> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<Station, Integer> adjacentStation = new HashMap<>();

    public void addDestination(Station destination, int distance) {
        adjacentStation.put(destination, distance);
    }

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public List<Station> getShortestPath() {
//        return shortestPath;
//    }
//
//    public void setShortestPath(List<Station> shortestPath) {
//        this.shortestPath = shortestPath;
//    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Station, Integer> getAdjacentStation() {
        return adjacentStation;
    }

    @Override public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final Station station = (Station) o;

        return name != null ? name.equals(station.name) : station.name == null;
    }

    @Override public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
