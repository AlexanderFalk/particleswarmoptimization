public class Velocity {
    // store the Velocity in an array to accommodate multi-dimensional problem space
    private double[] velocity;

    public Velocity(double[] velocity) {
        super();
        this.velocity = velocity;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }
}
