package com.trainline.output;

import com.trainline.output.dto.DistanceDTO;
import com.trainline.output.dto.mapper.RouteMapper;
import com.trainline.usecases.RouteSearch;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteController {
    private final static Logger LOGGER = Logger.getLogger(RouteController.class.getName());

    private RouteSearch routeSearch;

    private RouteMapper mapper;

    public RouteController() {
        this.routeSearch = new RouteSearch();
        this.mapper = new RouteMapper();
    }

    public String getSequentialTrip(String trip) {
        return this.routeSearch.findSequentialTrip(trip);
    }

    public String getNumberOfRouteBetween(String trip, int stops) {
        return routeSearch.findNumberOfRouteBetween(trip, stops);
    }

    public String getNumberOfTripsWithStops(String from, String to, int stops) {
        return routeSearch.findNumberOfTripsWithStops(from, to);
    }

    public String getShortestRoute(String from, String to) {
        return routeSearch.findShortestRoute(from, to);
    }
}
