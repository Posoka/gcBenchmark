import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MemoryAllocator {
    final static int arraySize = 1000000;

    public static void main(String[] args) throws IllegalAccessException {
        Logger LOGGER = Logger.getLogger("MemoryAllocator");
        try {
            FileHandler fh = new FileHandler("/Users/jacekbosiacki/IdeaProjects/gcBenchmark/benchmark/src/" + args[0]);
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GarbageGenerator[] garbage = new GarbageGenerator[arraySize];
        int i = 0;
        int j = 0;
        Random random = new Random();
        long start = System.nanoTime();
        while (true) {
            GarbageGenerator garbageGenerator = new GarbageGenerator();
            garbage[random.nextInt(arraySize)] = garbageGenerator;
            garbageGenerator.generateMoreGarbage();
            if (i++ % arraySize == 0) {
                j++;
                float timeInSec = (float)(System.nanoTime() - start)/1000000000;
                System.out.printf("%5.3f \n", timeInSec);
                LOGGER.info("Step " + j + " made in " + timeInSec + "s");
            }
            if (j == 10) {
                break;
            }
        }

        LOGGER.info("This run ended after: " + (float)(System.nanoTime() - start)/1000000000 + "s");
    }

    static class GarbageGenerator {
        String a1;
        String a2 ;
        String a3 ;
        String a4 ;
        String a5 ;
        String a6 ;
        String a7 ;
        String a8 ;
        String a9 ;
        String a10;

        public GarbageGenerator() throws IllegalAccessException {
            Random random = new Random();
            for (Field field : this.getClass().getDeclaredFields()) {
                field.set(this, "" + random.nextInt());
            }
        }

        public void generateMoreGarbage() {
            String concat = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10;
            concat.replaceAll("", "");
        }
    }
}
