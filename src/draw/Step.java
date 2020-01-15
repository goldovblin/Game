package draw;

import java.util.ArrayList;
import java.util.List;

class Step {

    private Ball attackingBall;
    private Vector attackVector;

    Step(Ball attackingBall, Vector targetLocation, double force) {
        this.attackingBall = attackingBall;
        this.attackVector = Vector.getProduct(Vector.getDiff(targetLocation, attackingBall.location).getNormalized(), force);
    }

    int simulate() {
        Physic.saveState();
        execute();
        List<Ball> balls = new ArrayList<>();
        balls.addAll(Physic.playerBalls);
        balls.addAll(Physic.computerBalls);
        while (balls.stream().anyMatch(Ball::isMove)) {
            Physic.step();
        }
        long result = Physic.playerBalls.stream().filter(Ball::isLeft).count();
        Physic.rollbackState();
        return (int) result;
    }

    void execute() {
        attackingBall.velocity.add(attackVector);
    }

    public boolean toggle() {
        return !Physic.playerBalls.contains(attackingBall) && !Physic.computerBalls.contains(attackingBall);
    }
}
