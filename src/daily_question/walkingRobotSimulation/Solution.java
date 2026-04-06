package daily_question.walkingRobotSimulation;

import java.util.HashSet;
import java.util.Set;

/// # Walking Robot Simulation
///
/// Simulates the movement of a robot on an infinite 2D grid starting at `(0, 0)`
/// and initially facing **north**.
///
/// The robot processes a sequence of commands:
///
/// - `-2`: Turn left 90°
/// - `-1`: Turn right 90°
/// - `1 <= k <= 9`: Move forward `k` steps (one unit at a time)
///
/// The robot must avoid obstacles placed on the grid. If the next step leads to
/// an obstacle, the robot stops moving for that command and proceeds to the next.
///
/// ## Objective
///
/// Return the **maximum squared Euclidean distance** from the origin `(0, 0)`
/// reached at any point during the simulation.
///
/// ## Approach
///
/// - Use a `HashSet` to store obstacles for **O(1)** lookup.
/// - Represent directions using an index:
///   - `0 = North`, `1 = East`, `2 = South`, `3 = West`
/// - Use a direction vector array to move the robot.
/// - Process movement **step-by-step** to properly handle obstacles.
/// - Track the maximum distance after each valid move.
///
/// ## Complexity
///
/// - **Time Complexity:** `O(n + m)`
///   - `n` = number of commands
///   - `m` = number of obstacles
/// - **Space Complexity:** `O(m)`
///
/// ## Parameters
///
/// - `commands`: Array of movement and rotation instructions.
/// - `obstacles`: 2D array representing blocked grid positions.
///
/// ## Returns
///
/// - The maximum squared distance from the origin reached by the robot.
class Solution {

    /// Executes the robot simulation and computes the maximum squared distance
    /// from the origin reached during its movement.
    ///
    /// @param commands  the sequence of movement and rotation instructions
    /// @param obstacles the list of obstacle coordinates on the grid
    /// @return the maximum squared Euclidean distance from `(0, 0)`
    public int robotSim(int[] commands, int[][] obstacles) {

        /// Stores obstacle positions as "x,y" strings for constant-time lookup.
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(o[0] + "," + o[1]);
        }

        /// Direction vectors:
        /// North, East, South, West
        int[][] dirs = {
                {0, 1},   // North
                {1, 0},   // East
                {0, -1},  // South
                {-1, 0}   // West
        };

        /// Current position of the robot.
        int x = 0, y = 0;

        /// Current direction index (0 = North).
        int dir = 0;

        /// Tracks the maximum squared distance reached.
        int maxDist = 0;

        /// Process each command.
        for (int cmd : commands) {

            if (cmd == -1) {
                /// Turn right (clockwise).
                dir = (dir + 1) % 4;

            } else if (cmd == -2) {
                /// Turn left (counterclockwise).
                dir = (dir + 3) % 4;

            } else {
                /// Move forward step-by-step.
                for (int i = 0; i < cmd; i++) {

                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    /// Stop if the next position is an obstacle.
                    if (obs.contains(nx + "," + ny)) {
                        break;
                    }

                    /// Update position.
                    x = nx;
                    y = ny;

                    /// Update maximum squared distance.
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}