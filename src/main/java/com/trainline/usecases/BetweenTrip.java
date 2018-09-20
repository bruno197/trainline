package com.trainline.usecases;

import com.trainline.domains.Line;
import com.trainline.domains.Station;
import com.trainline.usecases.exception.RouteNotFoundException;

import java.util.Map;

public class BetweenTrip {

    public Integer getNumberOfRouteBetween(Line line, String from, int stops) {
        try {
            Station stationFrom = line.getStations().stream()
                    .filter(s -> s.getName().equals(from))
                    .findAny().orElseThrow(RouteNotFoundException::new);

            int routes = 0;

            for (Map.Entry<Station, Integer> adjacency_1 : stationFrom.getAdjacentStation().entrySet()) {
                for (Map.Entry<Station, Integer> adjacency_2 : adjacency_1.getKey().getAdjacentStation().entrySet()) {
                    if(checkStation(stationFrom, adjacency_2.getKey()) && stops >= 2){
                        routes++;
                    }
                    for (Map.Entry<Station, Integer> adjacency_3 : adjacency_2.getKey().getAdjacentStation().entrySet()) {
                        if(checkStation(stationFrom, adjacency_3.getKey()) && stops >= 3){
                            routes++;
                        }
                        for (Map.Entry<Station, Integer> adjacency_4 : adjacency_3.getKey().getAdjacentStation().entrySet()) {
                            if(checkStation(stationFrom, adjacency_4.getKey()) && stops >= 4){
                                routes++;
                            }
                        }
                    }
                }
            }
            if(routes == 0) {
                throw new RouteNotFoundException();
            }
            return routes;
        } catch (Exception e) {
            throw new RouteNotFoundException();
        }
    }

    private static boolean checkStation(Station from, Station  to){
        return from.getName().equals(to.getName());
    }
}
