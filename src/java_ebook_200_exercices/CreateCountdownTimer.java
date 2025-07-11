package java_ebook_200_exercices;

import java.time.Duration;
import java.time.LocalDateTime;

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

/*
Countdown: 0d 0h 0m 56s
Countdown expired!
*/