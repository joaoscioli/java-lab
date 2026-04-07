package daily_question.walkingRobotSimulationII;

class Robot {

        int width, height;
        int x = 0, y = 0;
        int dir = 0; // 0=East, 1=North, 2=West, 3=South
        int perimeter;

        int[][] dirs = {
                {1, 0},   // East
                {0, 1},   // North
                {-1, 0},  // West
                {0, -1}   // South
        };

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.perimeter = 2 * (width + height) - 4;
        }

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

        public int[] getPos() {
            return new int[]{x, y};
        }

        public String getDir() {
            if (dir == 0) return "East";
            if (dir == 1) return "North";
            if (dir == 2) return "West";
            return "South";
        }
    }