package draw;

import java.awt.event.*;

//TODO: переосмыслить с Артемием
public class Controller implements MouseListener, MouseMotionListener {

    static Vector mouseLocation;
    static Ball attackingBall;
    static double force;

    static {
        mouseLocation = new Vector();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (attackingBall != null && Physic.playerBalls.stream().noneMatch(Ball::isMove) && Physic.computerBalls.stream().noneMatch(Ball::isMove)) {
            force = -Math.min(Constants.playerForce, Vector.getDiff(mouseLocation, attackingBall.location).getLen() * Constants.screenCoefficient);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseLocation.x = e.getX();
        mouseLocation.y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseLocation.x = e.getX();
        mouseLocation.y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Round.isPlayerStep && Physic.playerBalls.stream().noneMatch(Ball::isMove) && Physic.computerBalls.stream().noneMatch(Ball::isMove)) {
            attackingBall = Physic.playerBalls.stream().filter(ball -> Vector.getDiff(mouseLocation, ball.location).getLen() < ball.R).findFirst().orElse(null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
