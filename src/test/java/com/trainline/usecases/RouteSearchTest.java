package com.trainline.usecases;

import com.trainline.domains.Line;
import com.trainline.domains.Station;
import com.trainline.gateways.RouteGateway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RouteSearchTest {
    public static final String FROM = "A";
    public static final String TO = "B";
    public static final String TRIP = "A-B-C";
    public static final String TRIP_SEQ = "A-E-B-C-D";
    public static final String TRIP_FAIL = "A-F";


    private Station station;
    private Line line;

    private RouteSearch routeSearch;

    @Mock
    private RouteGateway routeGateway;

    @Before
    public void setUp() {
        routeSearch = new RouteSearch();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindAndReturnDistanceByFixTrip() {
        // Given
        final String from = FROM;
        station = new Station(FROM);
        line = new Line();

        line.addStation(station);

        Mockito.doReturn(station).when(routeGateway).findByName(from);

        String distance = routeSearch.findSequentialTrip(TRIP);

        Assert.assertEquals(String.valueOf(9), distance);
    }

    @Test
    public void shouldFindAndReturnDistance() {
        // Given
        final String from = FROM;
        station = new Station(FROM);
        station.addDestination(new Station(TO), 9);
        line = new Line();

        line.addStation(station);

        Mockito.doReturn(station).when(routeGateway).findByName(from);

        String s = routeSearch.findSequentialTrip(TRIP);

        Assert.assertEquals(String.valueOf(9), s);
    }

    @Test
    public void shouldFindAndReturnDistanceWhenSpecifiRoute() {
        // Given
        final String from = FROM;
        station = new Station(FROM);
        line = new Line();

        line.addStation(station);

        Mockito.doReturn(station).when(routeGateway).findByName(from);

        String s = routeSearch.findSequentialTrip(TRIP_SEQ);

        Assert.assertEquals(String.valueOf(19), s);
    }
}