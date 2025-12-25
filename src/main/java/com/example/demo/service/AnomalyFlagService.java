public interface AnomalyFlagService {

    AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord record);

    AnomalyFlagRecord resolveAnomaly(Long id);

    List<AnomalyFlagRecord> getAllFlags();
}
