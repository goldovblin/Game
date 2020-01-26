package draw;

class Vector {

    double x, y;
    double savedX, savedY;

    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        x = 0.0d;
        y = 0.0d;
    }

    public void add(Vector v) {
        x += v.x;
        y += v.y;
    }

    void add(Vector v, double val) {
        x += v.x * val;
        y += v.y * val;
    }

    void normalize() {
        double len = getLen();
        if (len != 0) {
            x /= len;
            y /= len;
        }
    }

    double getSquareLen() {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }

    double getLen() {
        return Math.sqrt(getSquareLen());
    }

    Vector getNormalized() {
        double len = getLen();
        if (len != 0) {
            return new Vector(x / len, y / len);
        }
        return new Vector();
    }

    static double getDotProduct(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    static Vector getSum(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y);
    }

    static Vector getDiff(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y);
    }

    static Vector getProduct(Vector v1, double val) {
        return new Vector(v1.x * val, v1.y * val);
    }

    public void saveState() {
        savedX = x;
        savedY = y;
    }

    public void rollbackState() {
        x = savedX;
        y = savedY;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
