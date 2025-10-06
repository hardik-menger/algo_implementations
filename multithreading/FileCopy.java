
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

class FileCopy {

    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destinationFile = new File("destination.txt");
        try {
            long t0 = System.nanoTime();
            copyFile(sourceFile, destinationFile);
            long t1 = System.nanoTime();
            System.out.println("Time taken: " + (t1 - t0) / 1000000000.0 + " seconds");
        } catch (IOException ex) {
        }
    }

    public static void copyFile(File sourceFile, File destinationFile) throws FileNotFoundException, IOException {
        AtomicLong offset = new AtomicLong(0);
        long chunkSize = 4 * 1024 * 1024; // 4MB
        long bufferSize = 64 * 1024; // 64KB
        long fileSize = sourceFile.length();

        // Pre-allocate destination file
        RandomAccessFile out = new RandomAccessFile(destinationFile, "rw");
        out.setLength(fileSize);
        out.close();

        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                try {
                    RandomAccessFile source = new RandomAccessFile(sourceFile, "r");
                    RandomAccessFile dest = new RandomAccessFile(destinationFile, "rw");

                    long start;
                    while ((start = offset.getAndAdd(chunkSize)) < fileSize) {
                        long chunkLength = Math.min(chunkSize, fileSize - start);
                        long bytesProcessed = 0;

                        byte[] buffer = new byte[(int) bufferSize];
                        // Process chunk in 64KB buffers
                        while (bytesProcessed < chunkLength) {
                            long toRead = Math.min(bufferSize, chunkLength - bytesProcessed);

                            // Read buffer
                            source.seek(start + bytesProcessed);
                            source.readFully(buffer, 0, (int) toRead);

                            // Write buffer
                            dest.seek(start + bytesProcessed);
                            dest.write(buffer, 0, (int) toRead);

                            bytesProcessed += toRead;
                        }
                    }

                    source.close();
                    dest.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
