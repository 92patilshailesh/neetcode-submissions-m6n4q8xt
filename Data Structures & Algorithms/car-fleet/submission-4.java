class Solution {
    record Car(int position, int speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        if (target <= 0) return 0;
        if (position == null || speed == null || position.length != speed.length) return 0;

        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b.position(), a.position()));

        Stack<Double> fleetTimes = new Stack<>();

        for (Car car : cars) {
            double timeToReachTarget = (double) (target - car.position()) / car.speed();
            fleetTimes.push(timeToReachTarget);

            if (fleetTimes.size() >= 2 &&
                fleetTimes.peek() <= fleetTimes.get(fleetTimes.size() - 2)) {
                fleetTimes.pop();
            }
        }

        return fleetTimes.size();
    }
}
