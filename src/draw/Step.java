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
        long result = Physic.computerBalls.stream().anyMatch(Ball::isLeft) ? 0 : Physic.playerBalls.stream().filter(Ball::isLeft).count();
        Physic.rollbackState();
        return (int) result;
    }

    private static int playerBallCount;
    private static int computerBallCount;

    void execute() {
        playerBallCount = Physic.playerBalls.size();
        computerBallCount = Physic.computerBalls.size();
        attackingBall.velocity.add(attackVector);
    }

    boolean toggle() {
        if (Round.isPlayerStep) {
            return playerBallCount > Physic.playerBalls.size() || computerBallCount == Physic.computerBalls.size();
        } else {
            return computerBallCount > Physic.computerBalls.size() || playerBallCount == Physic.playerBalls.size();

        }
    }
}
