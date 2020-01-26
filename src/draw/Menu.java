package draw;

import javax.swing.*;

class Menu extends JFrame {
    {
        setTitle(Constants.mainFrameTitle);
        setSize(Constants.menuFrameWidth, Constants.menuFrameHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JTextArea rulesTextArea = new JTextArea(Constants.rulesText);
        rulesTextArea.setEditable(false);
        add(rulesTextArea);
        JButton minDistanceStrategyStart = new JButton(Constants.minDistanceStrategyStartButtonText);
        minDistanceStrategyStart.addActionListener(actionEvent -> Canvas.startGame(false));
        add(minDistanceStrategyStart);
        JButton bestResultStrategyStart = new JButton(Constants.bestResultStrategyStartButtonText);
        bestResultStrategyStart.addActionListener(actionEvent -> Canvas.startGame(true));
        add(bestResultStrategyStart);
        setVisible(true);
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
    }
}
