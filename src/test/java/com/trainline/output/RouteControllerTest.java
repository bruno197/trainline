package com.trainline.output;

public class RouteControllerTest {
//    private static Logger log = Logger.getLogger(RouteController.class.getName());
//    private static OutputStream logCapturingStream;
//    private static StreamHandler customLogHandler;
//
//    @Before
//    public void attachLogCapturer()
//    {
//        logCapturingStream = new ByteArrayOutputStream();
//        Handler[] handlers = log.getParent().getHandlers();
//        customLogHandler = new StreamHandler(logCapturingStream, handlers[0].getFormatter());
//        log.addHandler(customLogHandler);
//    }
//
//    public String getTestCapturedLog() throws IOException
//    {
//        customLogHandler.flush();
//        return logCapturingStream.toString();
//    }
//
//    public static final String TRIP = "A-B-C";
//    public static final String TRIPS = "A-B-C, A-D, A-D-C, A-E-B-C-D, A-E-D";
//
//    public static List<_Route> routes = new ArrayList<_Route>() {{
//        add(new _Route("A", "B", 5));
//        add(new _Route("B", "C", 4));
//        add(new _Route("C", "D", 8));
//        add(new _Route("D", "C", 8));
//        add(new _Route("D", "E", 6));
//        add(new _Route("A", "D", 5));
//        add(new _Route("C", "E", 2));
//        add(new _Route("E", "B", 3));
//        add(new _Route("A", "E", 7));
//    }};
//
//    @Mock
//    private RouteSearch routeSearch;
//
//    private RouteController controller;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        controller = new RouteController();
//    }
//
//    @Test
//    public void shouldFindAndReturnRoute() {
//        // Given
//        final String trip = TRIP;
//
//        Mockito.doReturn(routes).when(routeSearch).find(trip);
//
//        controller.showRoutes(trip);
//
//        try {
//            String capturedLog = getTestCapturedLog();
//            assertTrue(capturedLog.contains("Output #"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void shouldFindAndReturnManyRoutes() {
//        // Given
//        final String trips = TRIPS;
//
//        Mockito.doReturn(routes).when(routeSearch).find(trips);
//
//        controller.showRoutes(trips);
//
//        try {
//            String capturedLog = getTestCapturedLog();
//            assertTrue(capturedLog.contains("Output #"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}