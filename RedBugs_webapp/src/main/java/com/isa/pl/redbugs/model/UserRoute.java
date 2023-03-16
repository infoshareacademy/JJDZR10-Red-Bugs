package com.isa.pl.redbugs.model;



public class UserRoute {

    private String journeyStart;

    private String journeyEnd;

    private Integer time;




    public String getJourneyStart() {
        return journeyStart;
    }

    public void setJourneyStart(String journeyStart) {
        this.journeyStart = journeyStart;
    }

    public String getJourneyEnd() {
        return journeyEnd;
    }

    public void setJourneyEnd(String journeyEnd) {
        this.journeyEnd = journeyEnd;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
