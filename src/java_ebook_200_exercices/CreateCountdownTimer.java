package java_ebook_200_exercices;

import java.time.Duration;
import java.time.LocalDateTime;

/// # CreateCountdownTimer
///
/// Demonstrates how to implement a simple countdown timer using Java's `LocalDateTime` and `Duration`.
///
/// ## Description
/// This program sets a target time for 1 minute in the future and continuously calculates the remaining time.
/// It displays the countdown in days, hours, minutes, and seconds, updating every second until the countdown expires.
///
/// ## Features
/// - Uses `LocalDateTime.now().plusMinutes(1)` to set a countdown target.
/// - Calculates remaining time with `Duration.between()`.
/// - Breaks down the duration into days, hours, minutes, and seconds.
/// - Sleeps for 1 second between updates using `Thread.sleep(1000)`.
/// - Exits the loop when the countdown reaches zero or becomes negative.
///
/// ## Example Output
/// ```
/// Countdown: 0d 0h 0m 56s
/// ...
/// Countdown expired!
/// ```
///
/// ## Note
/// The countdown duration can be adjusted by changing the `plusMinutes(1)` line.
///
public class CreateCountdownTimer {
    public static void main(String[] args) throws InterruptedException {

        // Set the target date to 1 minute from now
        LocalDateTime targetDate = LocalDateTime.now().plusMinutes(1);
        while (true) {

            // Calculate the remaining time
            Duration timeDiff = Duration.between(LocalDateTime.now(), targetDate);
            if (timeDiff.isNegative() || timeDiff.isZero()) {
                break; // Exit the loop if the countdown has expired
            }

            long days = timeDiff.toDays();
            long hours = timeDiff.toHours() % 24;
            long minutes = timeDiff.toMinutes() % 60;
            long seconds = timeDiff.getSeconds() % 60;

            // Display the countdown
            System.out.printf("Countdown: %dd %dh %dm %ds%n", days, hours, minutes, seconds);
            Thread.sleep(1000); // Sleep for 1 second
        }
        System.out.println("Countdown expired!");
    }
}
