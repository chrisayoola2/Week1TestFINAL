package com.example.week1testfinal;

class Outbreak {

    public static void main(String[] args) {
        Room[][] verticalTrue = new Room[][]{
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)}
        };

        Boolean isInfected = isOutbreak(verticalTrue);
        System.out.println(isInfected);

    }

    private static boolean isOutbreak(Room[][] floor) {
        int result = 0;
        for (int i = 0; floor.length > i; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                int temp = checkRoom(0, floor, i, j);
                if (temp >= result) {
                    result = temp;
                }
            }
        }

        boolean b = result >= 5;
        return b;
    }

    private static int checkRoom(int num, Room[][] floor, int y, int x) {
        int result = num;

        if (y < 0 || y > floor.length)
            return 0;
        if (y < 0 || x > floor[0].length)
            return 0;

        if ((floor[y][x]).visited) return 0;
        if (!(floor[y][x]).isInfected) return 0;

        floor[y][x].visited = true;

        result += 1;
        return result + checkRoom(0, floor, y + 1, x)
                + checkRoom(0, floor, y - 1, x)
                + checkRoom(0, floor, y, x - 1)
                + checkRoom(0, floor, y, x + 1);

    }
}
