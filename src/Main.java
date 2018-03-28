/**
 * BEES
 * Ask landscape
 * Tell bee hive own values
 * Ask bee hive best position - XBest, YBest, ZBest - SAVE THESE VALUES
 * Calculate Vx & Vy - See Velocity
 * Move
 *      X = X + Vx
 *      Y = Y + Vy
 *
 * BEEHIVE
 * Keep Track of time
 * Best bee -
 *      nextBee.calculateVAndMove(XBest, YBest)
 * Collection of bees
 *
 *
 * VELOCITY - Hastighed
 *      Vx = inertia * Vx + RHOLOCAL * (XOwnBest - x) + RHOGlobal(XBest - x)
 *      Vy = inertia * Vy + RHOLOCAL * (YOwnBest - y) + RHOGlobal(YBest - y)
 *      VTotal = Math.sqrt(Vx * Vx + Vy * Vy)
 *      if VTOtal > VMax {
 *          Vx = Vx * VMax / VTotal
 *          Vy = Vy * VMax / VTotal
 *      }
 *
 *
 *   Inertia
 *   Hvor meget fart den har på og hvad den skal falde med.
 *
 *   GLOBAL
 *   Globale værdi = Z
 *
 *   LOCAL
 *   Er det her bedre end det var før? Sammenligner hvert step
 *
 *
 *
 *
 * We throw in 25 bees and each bee will get a Z value that it has to search.
 * While it is searching for its value, the Beehive will collect the Z values
 * of all the Bees. The highest Z value will be the one that all other bees
 * will have to go to. So they will gather around the highest value.
 *
 * The Z value is determined by the following expression:
 *      z = x * exp(– x*x – y*y)
 *
 *
*
 */
public class Main {

    class Landscape {
        double input; // X , Y
        double output; // Z

        public double getInput() {
            return input;
        }

        public void setInput(double input) {
            this.input = input;
        }

        public double getOutput() {
            return output;
        }

        public void setOutput(double output) {
            this.output = output;
        }
    }

    class Bee {
        double x, y, vx /*v = velocity*/, vy, z;
        double inertia /*0-1*/, local /*0-1*/, global /*0-1*/;


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

        public double getInertia() {
            return inertia;
        }

        public void setInertia(double inertia) {
            this.inertia = inertia;
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

    public double distance(double max, double min, int x, int y) {

    }

    public static void main(String[] args) {

    }
}
