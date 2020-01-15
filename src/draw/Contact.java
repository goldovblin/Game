package draw;

class Contact {

    private final Vector aVelocity;
    private final Vector bVelocity;
    private final Vector normal;
    private final double iSumiMass;
    private final Vector projectorA;
    private final Vector projectorB;
    private final double distanceVelocity;

    Contact(Ball ballA, Ball ballB, Vector normal) {
        this.aVelocity = ballA.velocity;
        this.bVelocity = ballB.velocity;
        this.normal = normal;
        this.iSumiMass = 1.0d / (ballA.iMass + ballB.iMass);
        this.projectorA = Vector.getProduct(normal, ballA.iMass);
        this.projectorB = Vector.getProduct(normal, ballB.iMass);
        this.distanceVelocity = Vector.getDotProduct(Vector.getDiff(ballB.velocity, ballA.velocity), normal) * Constants.E;
    }

    private double calcLambda(Vector aVelocity, Vector bVelocity, Vector normal, double distanceVelocity) {
        double impulse = Vector.getDotProduct(Vector.getDiff(bVelocity, aVelocity), normal);
        impulse += distanceVelocity;
        impulse *= iSumiMass;
        return impulse;
    }

    void solve() {
        double impulse = calcLambda(aVelocity, bVelocity, normal, distanceVelocity);
        if (impulse < 0) {
            return;
        }
        aVelocity.add(projectorA, impulse);
        bVelocity.add(projectorB, -impulse);
    }
}
