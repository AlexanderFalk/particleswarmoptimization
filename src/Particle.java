public class Particle {

    private int id;
    private double local /*0-1*/, global /*0-1*/;
    private Location location;
    private Velocity velocity;
    private double fitness;

    public Particle(Location location, Velocity velocity) {
        this.location = location;
        this.velocity = velocity;
    }

    public void calculateBestPosition() {
        double x = this.location.getLoc()[0];
        double y = this.location.getLoc()[1];
        fitness = Math.pow((2.8125 - x + x * Math.pow(y, 4)), 2) +
                  Math.pow((2.25 - x + x * Math.pow(y, 2)), 2) +
                  Math.pow((1.5 - x + x * y), 2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public double getFitness() {
        calculateBestPosition();
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }


}
