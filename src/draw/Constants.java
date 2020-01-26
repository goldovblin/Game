package draw;

import java.awt.*;

class Constants {

    //TODO: sort, clear
    final static double DT = 1.0d / 500.0d;
    final static double E = 0.75d;
    final static double F = 0.25d;
    final static double G = 9.8d * Constants.DT;
    final static double playerForce = 12000.0d;
    //FIXME: вычисляемое значение
    final static double screenCoefficient = 500.0d;
    final static double computerForce = 12000.0d;
    final static int solveIterationCount = 50;
    final static int boardSize = 800;
    final static int cellsCount = 8;
    final static int cellSize = boardSize / cellsCount;
    final static int halfCellSize = cellSize / 2;
    final static double density = 2.0d;
    final static double R = cellSize * 0.45d;
    final static Color board = Color.black;
    final static Color darkField = Color.black;
    final static Color lightField = Color.white;
    final static Color darkChecker = Color.gray;
    final static Color lightChecker = Color.red;
    final static Color arrow = Color.red;
    final static String mainFrameTitle = "Чапаев";
    final static int defaultDelay = 15;
    final static double movableVelocity = 1;

    static int menuFrameWidth = 400;
    static int menuFrameHeight = 500;

    static String rulesText = "В начале игры на шахматной доске шашки противоположных цветов (по 8 штук) расставляются в два горизонтальных ряда друг напротив друга, после чего игроки по очереди пытаются щелчком выбить чужие шашки, при этом оставляя свои в игре. Если игрок роняет свою шашку или не выбивает чужую, то ход передается противнику. Чаще всего правила таковы, что игрок, выбивший все чужие шашки, в следующем раунде передвигает свои на одну линию вперед. Игра длится несколько раундов (от семи и выше). После шестого раунда ряды шашек становятся друг напротив друга. Проигравший после шестого раунда должен отступить на одну линию назад. Побеждает тот, кто выбьет вражеские шашки с последней линии. Для того, чтобы сделать удар нужно нажать на шашку и оттянуть мышку в противоположном от удара направлении, после чего отпустить. Отменить выбранный ход нельзя! В программе присутствует возможность изменять размер доски. Для этого нужно выйти из игры, зайти в класс MainFrame и изменить значение переменной cellsCount. Доска может быть только квадратной";
    static String minDistanceStrategyStartButtonText = "Начать игру с первым автоматическим игроком";
    static String bestResultStrategyStartButtonText = "Начать игру со вторым автоматическим игроком";
}
