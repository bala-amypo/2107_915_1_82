@Service
public class ProductivityMetricServiceImpl implements ProductivityMetricService {

    @Autowired
    private ProductivityMetricRecordRepository repo;

    @Override
    public ProductivityMetricRecord recordMetric(ProductivityMetricRecord m) {
        return repo.save(m);
    }

    @Override
    public Optional<ProductivityMetricRecord> getMetricById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ProductivityMetricRecord> getMetricsByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    @Override
    public List<ProductivityMetricRecord> getAllMetrics() {
        return repo.findAll();
    }
}
