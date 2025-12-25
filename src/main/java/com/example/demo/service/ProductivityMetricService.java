public interface ProductivityMetricService {

    ProductivityMetricRecord recordMetric(ProductivityMetricRecord record);

    ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record);

    Optional<ProductivityMetricRecord> getMetricById(Long id);

    List<ProductivityMetricRecord> getAllMetrics();
}
