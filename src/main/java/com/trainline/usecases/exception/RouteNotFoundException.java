package com.trainline.usecases.exception;

public final class  RouteNotFoundException extends RuntimeException  {
    public RouteNotFoundException() {
        super("NO SUCH ROUTE");
    }
}