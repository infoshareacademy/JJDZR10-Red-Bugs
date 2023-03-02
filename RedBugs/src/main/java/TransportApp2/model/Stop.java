package TransportApp2.model;

public class Stop {
    private long stopId;
    private String stopName;

    public Stop(Integer stopId, String stopName) {
        this.stopId = stopId;
        this.stopName = stopName;
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", stopName='" + stopName + '\'' +
                '}';
    }
}
