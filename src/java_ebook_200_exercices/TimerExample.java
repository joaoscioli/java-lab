package java_ebook_200_exercices;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/// # TimerExample
///
/// This class demonstrates how to use a `ScheduledExecutorService` to execute
/// a task after a specified delay. It defines a method that receives a parameter
/// and prints it to the console, then schedules its execution with a delay.
///
/// ## Usage
/// The program will:
/// - Define a string parameter (`"Hello, world!"`).
/// - Schedule a task that calls `myFunction` with the parameter after a 1-second delay.
/// - Shut down the executor once the task has been executed.
///
/// ## Example Output
/// ```text
/// Parameter received: Hello, world!
/// ```
public class TimerExample {

    /// Prints the provided parameter to the console.
    ///
    /// ## Parameters
    /// - `parameter`: The string value to be printed.
    public static void myFunction(String parameter) {
        System.out.println("Parameter received: " + parameter);
    }

    /// Entry point of the program.
    ///
    /// This method:
    /// - Creates a `ScheduledExecutorService` with a single thread.
    /// - Defines a task (`Runnable`) that calls `myFunction` with a parameter.
    /// - Schedules the task to run after 1 second.
    /// - Shuts down the executor after execution.
    ///
    /// ## Parameters
    /// - `args`: Command-line arguments (not used in this example).
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
