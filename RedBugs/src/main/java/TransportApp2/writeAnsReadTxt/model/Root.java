package TransportApp2.writeAnsReadTxt.model;

import java.util.List;

public class Root {
    private String fileJson;
    private List<Stops> stops;

    public String getFileJson() {
        return fileJson;
    }

    public void setFileJson(String fileJson) {
        this.fileJson = fileJson;
    }

    public List<Stops> getStops() {
        return stops;
    }

    public void setStops(List<Stops> stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "Root{" +
                "fileJson='" + fileJson + '\'' + "\n" +
                "stops=" + stops  +
                '}' ;
    }
}
