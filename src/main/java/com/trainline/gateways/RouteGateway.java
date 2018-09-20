package com.trainline.gateways;

import com.trainline.domains.Line;
import com.trainline.domains.Station;

public interface RouteGateway {
    Line findLine();

    Station findByName(String name);
}
