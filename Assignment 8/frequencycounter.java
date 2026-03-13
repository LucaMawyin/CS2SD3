import java.util.Random;

// INVARIANT: counts[i] >= 0 for all i in 0..max-1
class FrequencyCounter {

    int[] counts;
    int max;

    // Precondition: max > 0
    FrequencyCounter(int max) {
        // Create a frequency counter for events numbered 0 to max - 1.

        this.max = max;
        counts = new int[max];
    }
    void count(int event) {
        // Increment the frequency of event by 1.

        counts[event] += 1;
    }
    int frequency(int event) {
        // Return the frequency of event since creation.

        return counts[event];
    }
}
class Eventer extends Thread {
    FrequencyCounter fc;
    Eventer(FrequencyCounter fc) {
        this.fc = fc;
    }
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 20000; i++) {
            fc.count(r.nextInt(10));
        }
    }
}
class TestFrequencyCounter {
    public static void main(String[] args) {
        final int E = 1000; // number of eventers
        FrequencyCounter fc = new FrequencyCounter(10);
        Eventer ev[] = new Eventer[E];
        for (int i = 0; i < E; i++) ev[i] = new Eventer(fc);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < E; i++) ev[i].start();
        for (int i = 0; i < E; i++) {
            try {ev[i].join();} catch (Exception e) {}
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
