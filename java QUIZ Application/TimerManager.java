public class TimerManager {

    private int timeLeft;
    private Thread timerThread;

    public TimerManager() {
        timeLeft = 15;
    }

    public void startTimer(Runnable timeUpAction) {

        timeLeft = 15;

        timerThread = new Thread(() -> {

            while (timeLeft > 0) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }

                timeLeft--;
            }

            timeUpAction.run();
        });

        timerThread.start();
    }

    public void stopTimer() {

        if (timerThread != null) {
            timerThread.interrupt();
        }
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}
