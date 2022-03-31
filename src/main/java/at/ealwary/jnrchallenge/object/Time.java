package at.ealwary.jnrchallenge.object;

public class Time {
    private int counter;
    private int hours;
    private int minutes;
    private int seconds;
    private int finishedCountdowns;

    public Time(int counter) {
        finishedCountdowns = 0;
        this.counter = counter;

        seconds = counter % 60;
        minutes = ((counter - seconds) / 60 % 60);
        hours = (counter - seconds - minutes * 60) / 60 / 60;

    }


    public int getSeconds() {
        seconds = counter % 60;
        return seconds;
    }

    public int getMinutes() {
        seconds = counter % 60;
        minutes = ((counter - seconds) / 60 % 60);
        return minutes;
    }

    public int getHours() {
        seconds = counter % 60;
        minutes = ((counter - seconds) / 60 % 60);
        hours = (counter - seconds - minutes * 60) / 60 / 60;

        return hours;
    }

    public int getCounter() {
        return counter;
    }

    public int getFinishedCountdowns() {
        finishedCountdowns = (counter - (counter % (60 * 5))) / 60 * 5;
        return finishedCountdowns;
    }

    public void addCounter() {
        this.counter = counter++;
    }

    public boolean isCountdownFinished() {
        if (counter == 0) return false;
        return counter % (60 * 5) == 0;
    }

    public boolean isCountdownFinished(int counter) {
        if (counter == 0) return false;
        return counter % (60 * 5) == 0;
    }
}
