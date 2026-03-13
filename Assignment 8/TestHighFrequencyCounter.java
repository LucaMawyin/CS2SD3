// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
class TestHighFrequencyCounter {
   TestHighFrequencyCounter() {
   }

   public static void main(String[] var0) {
      HighFrequencyCounter var1 = new HighFrequencyCounter(10);
      HEventer[] var2 = new HEventer[1000];

      for(int var3 = 0; var3 < 1000; ++var3) {
         var2[var3] = new HEventer(var1);
      }

      long var8 = System.currentTimeMillis();

      for(int var5 = 0; var5 < 1000; ++var5) {
         var2[var5].start();
      }

      for(int var9 = 0; var9 < 1000; ++var9) {
         try {
            var2[var9].join();
         } catch (Exception var7) {
         }
      }

      long var10 = System.currentTimeMillis();
      System.out.println(var10 - var8);
   }
}
