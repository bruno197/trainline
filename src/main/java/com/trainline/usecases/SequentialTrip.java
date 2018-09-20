package com.trainline.usecases;

import com.trainline.domains.Line;
import com.trainline.domains.Station;
import com.trainline.usecases.exception.RouteNotFoundException;

public class SequentialTrip {


    public Integer getDistance(Line line, String from, String to) {
        try {
            Station stationFrom = line.getStations().stream()
                    .filter(s -> s.getName().equals(from))
                    .findAny().orElseThrow(RouteNotFoundException::new);

            Station stationTo = line.getStations().stream()
                    .filter(s -> s.getName().equals(to))
                    .findAny().orElseThrow(RouteNotFoundException::new);
            Integer distance = stationFrom.getAdjacentStation().get(stationTo);
            return distance.intValue();
        } catch (Exception e) {
            throw new RouteNotFoundException();
        }
    }
}
