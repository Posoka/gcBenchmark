echo "Compiling benchmark"
javac MemoryAllocator.java

echo "Making simulations for Serial GC"
java -Xmx256m -XX:+UseSerialGC -Xlog:gc:serial_256m.log MemoryAllocator serial_256m_time.log
java -Xmx1g -XX:+UseSerialGC -Xlog:gc:serial_1g.log MemoryAllocator serial_1g_time.log
java -Xmx4g -XX:+UseSerialGC -Xlog:gc:serial_4g.log MemoryAllocator serial_4g_time.log
java -Xmx16g -XX:+UseSerialGC -Xlog:gc:serial_16g.log MemoryAllocator serial_16g_time.log

echo "Making simulations for Parallel GC"
java -Xmx256m -XX:+UseParallelGC -Xlog:gc:parallel_256m.log MemoryAllocator parallel_256m_time.log
java -Xmx1g -XX:+UseParallelGC -Xlog:gc:parallel_1g.log MemoryAllocator parallel_1g_time.log
java -Xmx4g -XX:+UseParallelGC -Xlog:gc:parallel_4g.log MemoryAllocator parallel_4g_time.log
java -Xmx16g -XX:+UseParallelGC -Xlog:gc:parallel_16g.log MemoryAllocator parallel_16g_time.log

echo "Making simulations for G1 GC"
java -Xmx256m -Xlog:gc:g1_256m.log MemoryAllocator g1_256m_time.log
java -Xmx1g -Xlog:gc:g1_1g.log MemoryAllocator g1_1g_time.log
java -Xmx4g -Xlog:gc:g1_4g.log MemoryAllocator g1_4g_time.log
java -Xmx16g -Xlog:gc:g1_16g.log MemoryAllocator g1_16g_time.log

echo "Making simulaions for ZGC"
java -Xmx256m -XX:+UseZGC -Xlog:gc:zgc_256m.log MemoryAllocator zgc_256m_time.log
java -Xmx1g -XX:+UseZGC -Xlog:gc:zgc_1g.log MemoryAllocator zgc_1g_time.log
java -Xmx4g -XX:+UseZGC -Xlog:gc:zgc_4g.log MemoryAllocator zgc_4g_time.log
java -Xmx16g -XX:+UseZGC -Xlog:gc:zgc_16g.log MemoryAllocator zgc_16g_time.log

echo "Making simulations for Epsilon GC"
java -Xmx256m -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xlog:gc:epsilon_256m.log MemoryAllocator epsilon_256m_time.log
java -Xmx1g -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xlog:gc:epsilon_1g.log MemoryAllocator epsilon_1g_time.log
java -Xmx4g -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xlog:gc:epsilon_4g.log MemoryAllocator epsilon_4g_time.log
java -Xmx16g -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xlog:gc:epsilon_16g.log MemoryAllocator epsilon_16g_time.log
