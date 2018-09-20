package com.trainline.output.dto.mapper;

import com.trainline.domains.Station;
import com.trainline.output.dto.DistanceDTO;

public class RouteMapper {

    public DistanceDTO routeToDistanceDTO(int record, Station routes) {
        return new DistanceDTO(record, routes.getDistance());
    }
}
