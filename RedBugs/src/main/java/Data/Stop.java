package Data;

public class Stop {

    private int id;
    private String name;
    private Schedule schedule;

    public Stop(int id, String name, Schedule schedule) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
    }

    public Stop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
