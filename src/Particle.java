public class Particle {

    int id;
    double x, y, vx /*v = velocity*/, vy, z;
    double local /*0-1*/, global /*0-1*/;

    public static final double C1 = 1.49445; // Cognitive weight (particle best influence)
    public static final double C2 = 1.49445; // Social weight (Swarm overall best influence)
    public static final double w = 0.729; // Inertia weight

    public Particle(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getLocal() {
        return local;
    }

    public void setLocal(double local) {
        this.local = local;
    }

    public double getGlobal() {
        return global;
    }

    public void setGlobal(double global) {
        this.global = global;
    }
}
