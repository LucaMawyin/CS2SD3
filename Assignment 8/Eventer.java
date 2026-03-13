// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Random;

class Eventer extends Thread {
   FrequencyCounter fc;

   Eventer(FrequencyCounter var1) {
      this.fc = var1;
   }

   public void run() {
      Random var1 = new Random();

      for(int var2 = 0; var2 < 20000; ++var2) {
         this.fc.count(var1.nextInt(10));
      }

   }
}
