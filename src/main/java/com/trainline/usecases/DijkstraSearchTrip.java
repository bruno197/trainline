package com.trainline.usecases;

import com.trainline.domains.Line;
import com.trainline.domains.Station;

public class DijkstraSearchTrip {
    public int calculateShortestPathFromSource(String from, String to, Line line) {
        try {
            Station fromStation  = line.getStations().stream()
                    .filter(s -> from.equals(s.getName()))
                    .findFirst()
                    .orElse(null);

            fromStation.setDistance(0);

            Station toStation  = line.getStations().stream()
                    .filter(s -> to.equals(s.getName()))
                    .findFirst()
                    .orElse(null);

            return fromStation.getAdjacentStation().get(toStation);
        } catch (Exception e) {
            throw e;
        }

    }
}
