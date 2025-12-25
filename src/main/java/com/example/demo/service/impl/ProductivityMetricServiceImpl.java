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
        return repo.save(record);
    }

    @Override
    public ProductivityMetricRecord updateMetric(Long id, ProductivityMetricRecord record) {
        record.setId(id); // 🔥 REQUIRED
        return repo.save(record);
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
}
