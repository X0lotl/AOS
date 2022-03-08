public class Timer {
    private long startTime;

    public void stopWatchAtStart(){
        startTime = System.nanoTime();
    }

    public double getElapsedTime(){
        long timeAtEnd = System.nanoTime();
        return (timeAtEnd - startTime) / 1000;
    }

}
