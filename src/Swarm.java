import java.util.List;
import java.util.Vector;

public class Swarm {

    public double distance(double max, double min, int x, int y) {
        return 0.0;
    }

    public void addParticle(Particle p, Vector<Particle> particleList) {
        particleList.add(p);
    }

    /*
     * The Z value is determined by the following expression:
     *      z = x * exp(– x*x – y*y)
     */
    public void addToLandscape(Particle p, Landscape l) {
        double xVal = p.getX()* p.getX();
        double yVal = p.getY()*p.getY();
        double z = p.getX() * Math.exp(xVal - yVal);

        l.setOutput(z); // Z VALUE
    }

    public double findGlobal(List<Particle> particleList) {
        return 0.0;
    }

    public List<Particle> neighbours(Particle p, List<Particle> particleList) {
        return null;
    }

    public double calculateVelocity(Particle p) {
        return 0.0;
    }
}
