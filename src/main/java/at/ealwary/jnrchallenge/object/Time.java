package at.ealwary.jnrchallenge.object;

public class Time {
    private int counter;
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int counter) {
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

    public boolean isCountdownFinished() {
        if (counter == 0) return false;
        return counter % (60 * 5) == 0;
    }

    public boolean isCountdownFinished(int counter) {
        if (counter == 0) return false;
        return counter % (60 * 5) == 0;
    }
}
