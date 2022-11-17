package com.example.user.models;

import java.util.List;

public class SpotSchedule {
    private String startHour;
    private String endHour;
    private List<String> weekdays;

    public SpotSchedule(String startHour, String endHour, List<String> weekdays) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.weekdays = weekdays;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public List<String> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List<String> weekdays) {
        this.weekdays = weekdays;
    }
}
