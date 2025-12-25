public interface AnomalyFlagRecordRepository
        extends JpaRepository<AnomalyFlagRecord, Long> {
    List<AnomalyFlagRecord> findByMetricId(Long id);
}
