import java.util.List;
import java.util.Random;
import java.util.Vector;
public class Swarm implements PSOConstants {

    private Vector<Particle> swarm = new Vector<>();
    private double[] pBest = new double[SWARM_SIZE];
    private Vector<Location> pBestLocation = new Vector<>();
    private double gBest;
    private Location gBestLocation;
    private double[] fitnessList = new double[SWARM_SIZE];
    Random randomGen = new Random();
    private void initSwarm() {
        Particle particle;

        double posX, posY, velX, velY;
        double[] location = new double[DIMENSION];
        double[] vel = new double[DIMENSION];
        Location addedLocation;
        Velocity velocity;
        for (int i = 0; i < SWARM_SIZE; i++) {
            location[0] = ProblemSet.LOC_X_LOW + randomGen.nextDouble() * (ProblemSet.LOC_X_HIGH - ProblemSet.LOC_X_LOW);
            location[1] = ProblemSet.LOC_Y_LOW + randomGen.nextDouble() * (ProblemSet.LOC_Y_HIGH - ProblemSet.LOC_Y_LOW);
            addedLocation = new Location(location);

            vel[0] = ProblemSet.VEL_LOW + randomGen.nextDouble() * (ProblemSet.VEL_HIGH - ProblemSet.VEL_LOW);
            vel[1] = ProblemSet.VEL_LOW + randomGen.nextDouble() * (ProblemSet.VEL_HIGH - ProblemSet.VEL_LOW);
            velocity = new Velocity(vel);
            particle = new Particle(addedLocation, velocity);
            swarm.add(particle);
        }
    }
    public void updateFitnessList() {
        for(int i=0; i<SWARM_SIZE; i++) {
            fitnessList[i] = swarm.get(i).getFitness();
        }
    }

    public void startSwarm() {
        initSwarm();
        updateFitnessList();

        for (int i = 0; i < SWARM_SIZE; i++) {
            pBest[i] = fitnessList[i];
            pBestLocation.add(swarm.get(i).getLocation());
        }

        int time = 0;
        double inertia;
        double err = 9999;
        Velocity velocity;
        Location location;
        while (time < MAX_ITERATION && err > ProblemSet.ERR_TOLERANCE) {
            // Update pBest
            for (int i = 0; i < SWARM_SIZE; i++) {
                if (fitnessList[i] < pBest[i]) {
                    pBest[i] = fitnessList[i];
                    pBestLocation.set(i, swarm.get(i).getLocation());
                }
            }

            // Update gBest
            int bestParticleIndex = getMinPos(fitnessList);
            if (time == 0 || fitnessList[bestParticleIndex] < gBest) {
                gBest = fitnessList[bestParticleIndex];
                gBestLocation = swarm.get(bestParticleIndex).getLocation();
            }

            inertia = INERTIA_HIGH - (((double) time) / MAX_ITERATION) * (INERTIA_HIGH - INERTIA_LOW);

            for (int i = 0; i < SWARM_SIZE; i++) {
                double r1 = randomGen.nextDouble();
                double r2 = randomGen.nextDouble();

                Particle p = swarm.get(i);

                // Update velocity
                double[] newVel = new double[DIMENSION];
                /*X*/newVel[0] = (inertia * p.getVelocity().getVelocity()[0]) +
                        (r1 * C1) * (pBestLocation.get(i).getLoc()[0] - p.getLocation().getLoc()[0]) +
                        (r2 * C2) * (gBestLocation.getLoc()[0] - p.getLocation().getLoc()[0]);
                /*Y*/newVel[1] = (inertia * p.getVelocity().getVelocity()[1]) +
                        (r1 * C1) * (pBestLocation.get(i).getLoc()[1] - p.getLocation().getLoc()[1]) +
                        (r2 * C2) * (gBestLocation.getLoc()[1] - p.getLocation().getLoc()[1]);
                velocity = new Velocity(newVel);
                p.setVelocity(velocity);
                // step 4 - update location
                double[] newLoc = new double[DIMENSION];
                newLoc[0] = p.getLocation().getLoc()[0] + newVel[0];
                newLoc[1] = p.getLocation().getLoc()[1] + newVel[1];
                location = new Location(newLoc);
                p.setLocation(location);
            }

            err = ProblemSet.evaluate(gBestLocation) - 0; // minimizing the functions means it's getting closer to 0

            System.out.println("ITERATION " + time + ": ");
            System.out.println("     Best X: " + gBestLocation.getLoc()[0]);
            System.out.println("     Best Y: " + gBestLocation.getLoc()[1]);
            System.out.println("     Value: " + ProblemSet.evaluate(gBestLocation));

            time++;
            updateFitnessList();
        }

        System.out.println("\nSolution found at iteration " + (time - 1) + ", the solutions is:");
        System.out.println("     Best X: " + gBestLocation.getLoc()[0]);
        System.out.println("     Best Y: " + gBestLocation.getLoc()[1]);
    }


    private static int getMinPos(double[] list) {
        int pos = 0;
        double minValue = list[0];

        for(int i=0; i<list.length; i++) {
            if(list[i] < minValue) {
                pos = i;
                minValue = list[i];
            }
        }

        return pos;
    }
    /*
     * The Z value is determined by the following expression:
     *      z = x * exp(– x*x – y*y)
     */

    public double findGlobal(List<Particle> particleList) {
        return 0.0;
    }

    public List<Particle> neighbours(Particle p, List<Particle> particleList) {
        return null;
    }

    public double calculateVelocity(Particle p) {
        return 0.0;

    }

    public void setSearchObjective(Landscape landscape, double output) {
        landscape.setOutput(output);
    }

}
