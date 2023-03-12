package TransportApp2.writeAnsReadTxt.model;

public class Stops {
    private Long stopId;
    private String stopName;

    public Stops(String stopName, Long stopId ) {
        this.stopName = stopName;
        this.stopId = stopId;
    }

    @Override
    public String toString() {
        return "Stops{" +
                "stopId=" + stopId +
                ", stopName='" + stopName + '\'' +
                '}' + "\n";
    }

    public Long getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }
}
