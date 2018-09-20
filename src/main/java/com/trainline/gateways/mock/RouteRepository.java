package com.trainline.gateways.mock;

import com.trainline.domains.Station;

public class RouteRepository {
    private static RouteRepository INSTANCE;

    private static Station stationA = new Station("A");
    private static Station stationB = new Station("B");
    private static Station stationC = new Station("C");
    private static Station stationD = new Station("D");
    private static Station stationE = new Station("E");

    private RouteRepository(){
        stationA.addDestination(stationB, 5);
        stationA.addDestination(stationD, 5);
        stationA.addDestination(stationE, 7);

        stationB.addDestination(stationD, 12);
        stationB.addDestination(stationC, 4);

        stationC.addDestination(stationD, 8);
        stationC.addDestination(stationE, 2);

        stationD.addDestination(stationE, 6);
        stationD.addDestination(stationC, 8);

        stationE.addDestination(stationB, 3);
    }

    public static RouteRepository getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new RouteRepository();
        }

        return INSTANCE;
    }

    public static Station getStationA() {
        return stationA;
    }

    public static Station getStationB() {
        return stationB;
    }

    public static Station getStationC() {
        return stationC;
    }

    public static Station getStationD() {
        return stationD;
    }

    public static Station getStationE() {
        return stationE;
    }
}
