package com.caro.code;

public class Time {
    private int minute;
    private int second;

    public Time(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int minute, int second) {
        this.second = second;
        this.minute = minute;
    }

    public void previousSecond() {
        if (second == 0) {
            minute--;
            second = 59;
            return;
        }
        second--;
    }

    public boolean endTime() {
        return minute == 0 && second == 0;
    }

    @Override
    public String toString() {
        String minuteString = minute >= 10 ? String.valueOf(minute) : "0" + minute;
        String secondString = second >= 10 ? String.valueOf(second) : "0" + second;
        return minuteString + ":" + secondString;
    }
}
