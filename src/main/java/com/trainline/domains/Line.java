package com.trainline.domains;

import java.util.HashSet;
import java.util.Set;

public class Line {
    private Set<Station> stations = new HashSet<>();

    public void addStation(Station nodeA) {
        stations.add(nodeA);
    }

    public Set<Station> getStations() {
        return stations;
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    public Integer getDistance(String from, String to) {
        try {
            Station stationFrom = stations.stream()
                    .filter(s -> s.getName().equals(from))
                    .findAny().orElseThrow(Exception::new);
            Station stationTo = stations.stream()
                    .filter(s -> s.getName().equals(to))
                    .findAny().orElseThrow(Exception::new);
            return stationFrom.getAdjacentStation().get(stationTo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
