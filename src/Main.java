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
 * Individuals within the
 * group interact to solve the global objective by exchanging locally available information,
 * which in the end propagates through the entire group such that the problem is solved
 * more efficiently than can be done by a single individual.

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



    public static void main(String[] args) {

    }
}
