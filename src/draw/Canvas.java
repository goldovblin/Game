package draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Canvas extends JFrame implements ActionListener {

    static Timer timer;

    public static void main(String[] args) {
        timer = new Timer(Constants.defaultDelay, new Canvas());
        timer.start();
    }

    {
        setTitle(Constants.mainFrameTitle);
        setSize(Constants.boardSize + 20, Constants.boardSize + 40);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TODO: переосмыслить c Артемием
        add(new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if (Game.step() != null) {
                    timer.stop();
                    return;
                }
                Physic.step();
                Physic.removeLeft();
                Canvas.draw(g);
            }
        });
        Controller controller = new Controller();
        addMouseMotionListener(controller);
        addMouseListener(controller);
        setVisible(true);
    }

    private static void draw(Graphics g) {
        g.setColor(Constants.board);
        g.drawRect(0, 0, Constants.boardSize, Constants.boardSize);
        for (int i = 0; i < Constants.cellsCount; i++) {
            for (int j = 0; j < Constants.cellsCount; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Constants.lightField);
                } else {
                    g.setColor(Constants.darkField);
                }
                g.fillRect(i * Constants.cellSize, j * Constants.cellSize, Constants.cellSize, Constants.cellSize);
            }
        }
        g.setColor(Constants.lightChecker);
        Physic.playerBalls.forEach(ball -> g.fillOval((int) (ball.location.x - ball.R), (int) (ball.location.y - ball.R), (int) ball.D, (int) ball.D));
        g.setColor(Constants.darkChecker);
        Physic.computerBalls.forEach(ball -> g.fillOval((int) (ball.location.x - ball.R), (int) (ball.location.y - ball.R), (int) ball.D, (int) ball.D));
        //TODO: отрисовать стрелку
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
