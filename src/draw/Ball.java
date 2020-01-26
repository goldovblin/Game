package draw;

class Ball {

    final Vector velocity;
    final Vector location;
    final double R;
    final double D;
    final double mass;
    final double iMass;
    final double reactionForce;

    Ball(Vector location, Vector velocity, double density, double R) {
        this.location = location;
        this.velocity = velocity;
        this.R = R;
        this.D = R * 2;
        this.mass = density * Math.PI * R * R;
        this.iMass = 1.0d / mass;
        this.reactionForce = mass * Constants.G;
    }

    void integrateLocation() {
        velocity.add(velocity.getNormalized(), -Math.min(velocity.getLen(), reactionForce * Constants.F));
        location.add(velocity, Constants.DT);
    }

    void saveState() {
        location.saveState();
        velocity.saveState();
    }

    void rollbackState() {
        location.rollbackState();
        velocity.rollbackState();
    }

    public boolean isLeft() {
        return location.x  < 0 || location.x > Constants.boardSize
                || location.y < 0 || location.y > Constants.boardSize;
    }

    public boolean isMove() {
        return velocity.getLen() > Constants.movableVelocity;
    }
}
