package draw;

import java.util.ArrayList;
import java.util.List;

class Physic {

    private static final List<Contact> contacts = new ArrayList<>();
    static List<Ball> playerBalls = new ArrayList<>();
    static List<Ball> computerBalls = new ArrayList<>();

    static void step() {
        List<Ball> balls = new ArrayList<>();
        balls.addAll(playerBalls);
        balls.addAll(computerBalls);
        putContacts();
        for (int i = 0; i < Constants.solveIterationCount; i++) {
            contacts.forEach(Contact::solve);
        }
        balls.forEach(Ball::integrateLocation);
    }

    static void removeLeft() {
        playerBalls.removeIf(Ball::isLeft);
        computerBalls.removeIf(Ball::isLeft);
    }

    static void saveState() {
        playerBalls.forEach(Ball::saveState);
        computerBalls.forEach(Ball::saveState);
    }

    static void rollbackState() {
        playerBalls.forEach(Ball::rollbackState);
        computerBalls.forEach(Ball::rollbackState);
    }

    private static void putContacts() {
        List<Ball> balls = new ArrayList<>();
        balls.addAll(playerBalls);
        balls.addAll(computerBalls);
        contacts.clear();
        for (int i = 0; i < balls.size() - 1; i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                Vector ballJumper = Vector.getDiff(balls.get(i).location, balls.get(j).location);
                if (ballJumper.getLen() < balls.get(i).R + balls.get(j).R) {
                    ballJumper.normalize();
                    contacts.add(new Contact(balls.get(i), balls.get(j), ballJumper));
                }
            }
        }
    }
}
