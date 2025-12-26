public interface ProductivityMetricRecordRepository
        extends JpaRepository<ProductivityMetricRecord, Long> {
    List<ProductivityMetricRecord> findByEmployeeId(Long employeeId);
}
