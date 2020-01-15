package draw;

class Computer {

    static Step selectStep() {
        Step bestStep = null;
        int bestStepResult = -Integer.MAX_VALUE;
        for (Ball computerBall : Physic.computerBalls) {
            for (int i = 0; i < Physic.playerBalls.size(); i++) {
                Step frontStep = new Step(computerBall, Physic.playerBalls.get(i).location, Constants.computerForce);
                int frontStepResult = frontStep.simulate();
                if (frontStepResult > bestStepResult) {
                    bestStep = frontStep;
                    bestStepResult = frontStepResult;
                }
                for (int j = i + 1; j < Physic.playerBalls.size(); j++) {
                    Vector ballJumper = Vector.getDiff(Physic.playerBalls.get(i).location, Physic.playerBalls.get(j).location);
                    if (ballJumper.getLen() < computerBall.D + Physic.playerBalls.get(i).R + Physic.playerBalls.get(j).R) {
                        Vector jumperCenter = Vector.getSum(Physic.playerBalls.get(i).location, Vector.getProduct(ballJumper, 0.5d));
                        Step betweenStep = new Step(computerBall, jumperCenter, Constants.computerForce);
                        int betweenStepResult = betweenStep.simulate();
                        if (betweenStepResult > bestStepResult) {
                            bestStep = betweenStep;
                            bestStepResult = betweenStepResult;
                        }
                    }
                }
            }
        }
        return bestStep;
    }
}