package com.trainline.gateways.mock;

import com.trainline.domains.Line;
import com.trainline.domains.Station;
import com.trainline.gateways.RouteGateway;
import com.trainline.gateways.exception.RouteGatewayException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RouteGatewayMockTest {

    public static final String FROM = "A";
    public static final String TO = "C";

    private RouteGateway routeGatewayMock = new RouteGatewayMock();

    @Mock
    private RouteGatewayMock routeGateway;


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindAndReturnRoute() {
        // Given
        final String from = FROM;
        final String to = TO;

        // When
        final Station station = routeGatewayMock.findByName(from);
        final Line lineFound = routeGatewayMock.findLine();

        // Then
        Assert.assertEquals(from, station.getName());
        Assert.assertNotNull(lineFound);
    }

    @Test
    public void shouldReturnExceptionWhen() {
        // Given
        final Station from = new Station(FROM);

        try {
            // When
            Mockito.doThrow(new RouteGatewayException(FROM)).when(routeGateway).findLine();
            routeGateway.findLine();

            Assert.fail();
        } catch (RouteGatewayException e) {
            // Then
            Assert.assertEquals("Error to find route A", e.getMessage());
        }
    }

    @Test
    public void shouldReturnAllRoutes() {
        // Given
        final String from = "A";
        final String to = "C";

        // When
        final Station stationFound = routeGatewayMock.findByName(from);

        Assert.assertNotNull(stationFound);
    }
}
