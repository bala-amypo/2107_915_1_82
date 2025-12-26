@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord metric) {
        metric.setProductivityScore(
                ProductivityCalculator.computeScore(
                        metric.getHoursLogged(),
                        metric.getTasksCompleted(),
                        metric.getMeetingsAttended()
                )
        );
        return metric;
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return List.of();
    }
}
