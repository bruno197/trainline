package com.trainline.output.dto;

public class DistanceDTO {
    public static final String DESCRIPTION = "Output #";
    public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    private int record;
    private int distance;

    public DistanceDTO(int record, int distance) {
        this.record = record;
        this.distance = distance;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public static String getNoSuchRoute() {
        return NO_SUCH_ROUTE;
    }

    @Override
    public String toString() {
        return DESCRIPTION +
                record +
                ":" + distance;
    }
}
