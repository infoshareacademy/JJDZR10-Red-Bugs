package TransportApp2.model;

public class Route {
    private long routeId;
    private long numberVehicle;
    private String nameRoute;
    private long[] stops;

    public Route(long routeId, long numberVehicle, String nameRoute, long[] stops) {
        this.routeId = routeId;
        this.numberVehicle = numberVehicle;
        this.nameRoute = nameRoute;
        this.stops = stops;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public long getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(long numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public String getNameRoute() {
        return nameRoute;
    }

    public void setNameRoute(String nameRoute) {
        this.nameRoute = nameRoute;
    }

    public long[] getStops() {
        return stops;
    }

    public void setStops(long[] stops) {
        this.stops = stops;
    }
}
