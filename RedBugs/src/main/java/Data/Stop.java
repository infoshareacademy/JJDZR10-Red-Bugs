package Data;

public class Stop {

    private String nameStop;

    private Integer idStop;

    private Schedule schedule;

    public Stop(int id, String name, Schedule schedule) {
        this.idStop = id;
        this.nameStop = name;
        this.schedule = schedule;
    }
    public String getNameStop() {
        return nameStop;
    }

    public void setNameStop(String nameStop) {
        this.nameStop = nameStop;
    }

    public Integer getIdStop() {
        return idStop;
    }

    public void setIdStop(Integer idStop) {
        this.idStop = idStop;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
