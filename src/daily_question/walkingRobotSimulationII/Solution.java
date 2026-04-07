package daily_question.walkingRobotSimulationII;

class Robot {

    /// ## Fields
    ///
    /// - `width`: Width of the grid.
    /// - `height`: Height of the grid.
    /// - `x`, `y`: Current position of the robot.
    /// - `dir`: Current direction encoded as:
    ///     - `0` → East
    ///     - `1` → North
    ///     - `2` → West
    ///     - `3` → South
    /// - `perimeter`: Total number of steps in one full cycle along the grid boundary.
    ///
    /// - `dirs`: Direction vectors corresponding to each direction.
    int width, height;
    int x = 0, y = 0;
    int dir = 0;
    int perimeter;

    int[][] dirs = {
            {1, 0},   // East
            {0, 1},   // North
            {-1, 0},  // West
            {0, -1}   // South
    };

    /// ## Constructor
    ///
    /// Initializes the robot on a `width x height` grid.
    ///
    /// The robot starts at position `(0, 0)` facing **East**.
    ///
    /// ### Parameters
    /// - `width`: Grid width.
    /// - `height`: Grid height.
    ///
    /// ### Notes
    /// - The robot only moves along the perimeter.
    /// - The perimeter is precomputed to optimize movement cycles.
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }

    /// ## step
    ///
    /// Moves the robot forward by `num` steps.
    ///
    /// ### Behavior
    /// - The robot attempts to move one step at a time.
    /// - If the next step is out of bounds:
    ///     - It rotates 90° counterclockwise.
    ///     - Retries the step.
    ///
    /// ### Optimization
    /// - Movement is reduced using modulo of the perimeter.
    /// - A full cycle (`num % perimeter == 0`) is treated as a complete loop.
    ///
    /// ### Parameters
    /// - `num`: Number of steps to move.
    ///
    /// ### Time Complexity
    /// - `O(perimeter)` in the worst case.
    public void step(int num) {
        num %= perimeter;

        if (num == 0) num = perimeter;

        while (num > 0) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
            num--;
        }
    }

    /// ## getPos
    ///
    /// Returns the current position of the robot.
    ///
    /// ### Returns
    /// - An array `[x, y]` representing the robot's position.
    ///
    /// ### Time Complexity
    /// - `O(1)`
    public int[] getPos() {
        return new int[]{x, y};
    }

    /// ## getDir
    ///
    /// Returns the current facing direction of the robot.
    ///
    /// ### Returns
    /// - `"East"`, `"North"`, `"West"`, or `"South"`
    ///
    /// ### Time Complexity
    /// - `O(1)`
    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}