@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    @Autowired
    private ProductivityMetricRecordRepository repo;

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord record) {
        record.setProductivityScore(
            ProductivityCalculator.computeScore(
                record.getHoursLogged(),
                record.getTasksCompleted(),
                record.getMeetingsAttended()
            )
        );
        return record;
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return List.of();
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record) {
        record.setId(id);
        return record;
    }
}
