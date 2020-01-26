package draw;

class Round {

    static boolean isPlayerStep;

    static {
        isPlayerStep = true;
    }

    static void putBalls(int playerPoints, int computerPoints) {
        Physic.playerBalls.clear();
        Physic.computerBalls.clear();
        int computerY = Constants.cellSize * computerPoints + Constants.halfCellSize;
        int playerY = Constants.boardSize - Constants.cellSize * playerPoints - Constants.halfCellSize;
        for (int i = 0; i < Constants.cellsCount; i++) {
            Physic.playerBalls.add(new Ball(new Vector(i * Constants.cellSize + Constants.halfCellSize, playerY), new Vector(), Constants.density, Constants.R));
            Physic.computerBalls.add(new Ball(new Vector(i * Constants.cellSize + Constants.halfCellSize, computerY), new Vector(), Constants.density, Constants.R));
        }
    }

    static Step step;

    //TODO: переосмыслить c Артемием
    static Game.Result step() {
        if (Physic.playerBalls.isEmpty() && Physic.computerBalls.isEmpty()) {
            return Game.Result.DRAW;
        }
        if (Physic.playerBalls.isEmpty()) {
            isPlayerStep = false;
            return Game.Result.COMPUTER_WIN;
        }
        if (Physic.computerBalls.isEmpty()) {
            isPlayerStep = true;
            return Game.Result.PLAYER_WIN;
        }
        if (Physic.playerBalls.stream().noneMatch(Ball::isMove) && Physic.computerBalls.stream().noneMatch(Ball::isMove)) {
            if (step != null && step.toggle()) {
                isPlayerStep = !isPlayerStep;
                step = null;
            }
            if (isPlayerStep) {
                if (Controller.force != 0) {
                    step = new Step(Controller.attackingBall, Controller.mouseLocation, Controller.force);
                    step.execute();
                    Controller.attackingBall = null;
                    Controller.force = 0;
                }
            } else {
                step = Computer.selectStep();
                step.execute();
            }
        }
        return null;
    }

}
