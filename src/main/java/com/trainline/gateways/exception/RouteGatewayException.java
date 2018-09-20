package com.trainline.gateways.exception;

public final class RouteGatewayException extends RuntimeException {
    private static final String MESSAGE = "Error to find route %s";

    public RouteGatewayException(final String name) {
        super(String.format(MESSAGE, name));
    }
}
