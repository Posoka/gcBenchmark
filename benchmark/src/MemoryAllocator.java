import java.util.Random;

public class MemoryAllocator {
    final static int arraySize = 10000000;

    public static void main(String[] args) {
        GarbageGenerator[] garbage = new GarbageGenerator[arraySize];
        int i = 0;
        int j = 0;
        Random random = new Random();
        long start = System.nanoTime();
        while (true) {
            garbage[random.nextInt(arraySize)] = new GarbageGenerator();
            if (i++ % arraySize == 0) {
                System.out.print(j++ + " ");
                if (j % 100 == 0) {
                    System.out.println(System.nanoTime() - start);
                }
            }
        }
    }

    static class GarbageGenerator {
        long a1 = 1;
        long a2 = 2;
        long a3 = 3;
        long a4 = 4;
        long a5 = 5;
        long a6 = 6;
        long a7 = 7;
        long a8 = 8;
        long a9 = 9;
        long a10 = 10;
        long a11 = 11;
        long a12 = 12;
        long a13 = 13;
        long a14 = 14;
        long a15 = 15;
        long a16 = 16;
        long a17 = 17;
        long a18 = 18;
        long a19 = 19;
        long a20 = 20;

        public GarbageGenerator() {
        }
    }
}
