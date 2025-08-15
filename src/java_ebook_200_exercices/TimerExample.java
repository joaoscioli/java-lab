package java_ebook_200_exercices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerExample {
    // Function that takes a parameter and prints it
    public static void myFunction(String parameter) {
        System.out.println("Parameter received: " + parameter);
    }

    public static void main(String[] args) {

        // Define the parameter
        String myParameter = "Hello, world!";

        // Create a scheduled executor service with a single thread
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Define a task to be executed after a delay
        Runnable delayedExecution = () -> myFunction(myParameter);

        // Schedule the task with a 1-second delay
        executor.schedule(delayedExecution, 1, TimeUnit.SECONDS);

        // Shutdown the executor after the task completes
        executor.shutdown();
    }
}
