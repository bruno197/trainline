package com.trainline;

import com.trainline.output.RouteController;
import java.util.logging.Logger;

public class TrainlineApplication {
    private final static Logger LOGGER = Logger.getLogger(TrainlineApplication.class.getName());

    public static void main(String [] args) {
        RouteController controller = new RouteController();

        LOGGER.info("Problem one: Trains\n" + "\n");
        LOGGER.info("The distance of the route A-B-C.");
        LOGGER.info("The distance of the route A-D.");
        LOGGER.info("The distance of the route A-D-C.");
        LOGGER.info("The distance of the route A-E-B-C-D.");
        LOGGER.info("The distance of the route A-E-D.");
        LOGGER.info("The number of trips starting at C and ending at C with a maximum of 3 stops.");
        LOGGER.info("The number of trips starting at A and ending at C with exactly 4 stops.");
        LOGGER.info("The length of the shortest route (in terms of distance to travel) from A to C.");
        LOGGER.info("The length of the shortest route (in terms of distance to travel) from B to B.");
        LOGGER.info("The number of different routes from C to C with a distance of less than 30.");


        System.out.println("Output #1 : " + controller.getSequentialTrip("A-B-C"));
        System.out.println("Output #2 : " + controller.getSequentialTrip("A-D"));
        System.out.println("Output #3 : " + controller.getSequentialTrip("A-D-C"));
        System.out.println("Output #4 : " + controller.getSequentialTrip("A-E-B-C-D"));
        System.out.println("Output #5 : " + controller.getSequentialTrip("A-E-D"));
        System.out.println("Output #6 : " + controller.getNumberOfRouteBetween("C",3));
        System.out.println("Output #7 : " + controller.getNumberOfTripsWithStops("A","C",4));
        System.out.println("Output #8 : " + controller.getShortestRoute("A","C"));
        System.out.println("Output #9 : " + controller.getShortestRoute("B","B"));

//        System.out.println("Output #10 : " + parseRouteDistance(trainHelper.findRoutesInRange(new String[]{"CDC", "CEBC", "CEBCDC", "CDCEBC", "CDEBC", "CEBCEBC", "CEBCEBCEBC"},
//                30)));

//        String result = System.getProperty("trip");
//        LOGGER.info("INPUT: " + result);
//
//        controller.showRoutes(result);
    }
}
