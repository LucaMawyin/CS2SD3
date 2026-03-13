import java.util.Random;

// INVARIANT: counts[i] >= 0 for all i in 0..max-1
class HighFrequencyCounter extends FrequencyCounter {

    Object[] locks;

    HighFrequencyCounter(int max) {
        super(max);
        locks = new Object[max];

        for (int i = 0; i < max; i++){
            locks[i] = new Object();
        }
    }
    void count(int event) {
        synchronized (locks[event]){
            counts[event] += 1;
        }
    }
}
class HEventer extends Thread {
    HighFrequencyCounter hfc;
    HEventer(HighFrequencyCounter hfc) {
        this.hfc = hfc;
    }
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 20000; i++) {
            hfc.count(r.nextInt(10));
        }
    }
}
class TestHighFrequencyCounter {
    public static void main(String[] args) {
        final int E = 1000; // number of eventers
        HighFrequencyCounter hfc = new HighFrequencyCounter(10);
        HEventer hev[] = new HEventer[E];
        for (int i = 0; i < E; i++) hev[i] = new HEventer(hfc);
        long hstartTime = System.currentTimeMillis();
        for (int i = 0; i < E; i++) hev[i].start();
        for (int i = 0; i < E; i++) {
            try {hev[i].join();} catch (Exception e) {}
        }
        long hendTime = System.currentTimeMillis();
        System.out.println(hendTime - hstartTime);
    }
}
