package com.trainline.usecases;

import com.trainline.domains.Line;
import com.trainline.gateways.RouteGateway;
import com.trainline.gateways.mock.RouteGatewayMock;
import com.trainline.usecases.exception.RouteNotFoundException;

public class RouteSearch {

    private RouteGateway routeGateway;

    private SequentialTrip sequentialTrip;

    private BetweenTrip betweenTrip;

    private DepthFirstSearchTrip depthFirstSearchTrip;

    private DijkstraSearchTrip dijkstraSearchTrip;

    public RouteSearch() {
        this.routeGateway = new RouteGatewayMock();
        this.sequentialTrip = new SequentialTrip();
        this.betweenTrip = new BetweenTrip();
        this.depthFirstSearchTrip = new DepthFirstSearchTrip();
        this.dijkstraSearchTrip = new DijkstraSearchTrip();
    }

    public String findSequentialTrip(String trip) {
        Integer distance = 0;
        String[] tripSequence = trip.split("-");
        Line line = routeGateway.findLine();
        try {
            for(int i = 0 ; i < (tripSequence.length-1) ; i++) {
                distance += sequentialTrip.getDistance(line, tripSequence[i], tripSequence[i+1]);
            }
            return String.valueOf(distance);
        } catch (RouteNotFoundException e) {
            return e.getMessage();
        }
    }

    public String findNumberOfRouteBetween(String from, int stops) {
        Line line = routeGateway.findLine();
        try {
            Integer distance = betweenTrip.getNumberOfRouteBetween(line, from, stops);
            return String.valueOf(distance);
        } catch (RouteNotFoundException e) {
            return e.getMessage();
        }
    }

    public String findNumberOfTripsWithStops(String from, String to) {
        Line line = routeGateway.findLine();
        try {
            return depthFirstSearchTrip.DFS(line, from, to);
        } catch (RouteNotFoundException e) {
            return e.getMessage();
        }
    }

    public String findShortestRoute(String from, String to) {
        Line line = routeGateway.findLine();
        try {
            Integer distance = dijkstraSearchTrip.calculateShortestPathFromSource(from, to, line);
            return String.valueOf(distance);
        } catch (RouteNotFoundException e) {
            return e.getMessage();
        }
    }

}
