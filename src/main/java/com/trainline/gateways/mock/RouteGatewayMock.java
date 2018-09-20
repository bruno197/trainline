package com.trainline.gateways.mock;

import com.trainline.domains.Line;
import com.trainline.domains.Station;
import com.trainline.gateways.RouteGateway;
import com.trainline.gateways.exception.RouteGatewayException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteGatewayMock implements RouteGateway {
    private final static Logger LOGGER = Logger.getLogger(RouteGatewayMock.class.getName());

    @Override
    public Line findLine() {
        Line line = new Line();

        line.addStation(RouteRepository.getInstance().getStationA());
        line.addStation(RouteRepository.getInstance().getStationB());
        line.addStation(RouteRepository.getInstance().getStationC());
        line.addStation(RouteRepository.getInstance().getStationD());
        line.addStation(RouteRepository.getInstance().getStationE());

        return line;
    }

    @Override
    public Station findByName(String name) {
        try {
            return findLine().getStations().stream()
                    .filter(station -> station.getName().equals(name))
                    .findFirst().orElse(null);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "error to find.", new RouteGatewayException(name));

            throw new RouteGatewayException(name);
        }
    }
}
