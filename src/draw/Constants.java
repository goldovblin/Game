package draw;

import java.awt.*;

class Constants {

    //TODO: sort, clear
    final static double DT = 1.0d / 200.0d;
    final static double E = 0.75d;
    final static double F = 0.25d;
    final static double G = 9.8d * Constants.DT;
    final static double playerForce = 12000.0d;
    //FIXME: вычисляемое значение
    final static double screenCoefficient = 500.0d;
    final static double computerForce = 12000.0d;
    final static int solveIterationCount = 50;
    final static int boardSize = 800;
    final static int cellsCount = 5;
    final static int cellSize = boardSize / cellsCount;
    final static int halfCellSize = cellSize / 2;
    final static double density = 2.0d;
    final static double R = cellSize * 0.45d;
    final static Color board = Color.black;
    final static Color darkField = Color.darkGray;
    final static Color lightField = Color.lightGray;
    final static Color darkChecker = Color.black;
    final static Color lightChecker = Color.white;
    final static Color arrow = Color.red;
    final static String mainFrameTitle = "Чапаев";
    final static int defaultDelay = 15;
    final static double movableVelocity = 1;
}
