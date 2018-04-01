public interface PSOConstants {
    int SWARM_SIZE = 50;
    int DIMENSION = 2;
    int MAX_ITERATION = 300;
    double C1 = 1.49445; // Cognitive weight (particle best influence)
    double C2 = 1.49445; // Social weight (Swarm overall best influence)
    double INERTIA_HIGH = 1.0; // Inertia weight
    double INERTIA_LOW = 0.0; // Inertia weight
}
