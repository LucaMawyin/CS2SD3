// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Random;

class HEventer extends Thread {
   HighFrequencyCounter hfc;

   HEventer(HighFrequencyCounter var1) {
      this.hfc = var1;
   }

   public void run() {
      Random var1 = new Random();

      for(int var2 = 0; var2 < 20000; ++var2) {
         this.hfc.count(var1.nextInt(10));
      }

   }
}
