@RestController
@RequestMapping("/api/metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService service;

    public ProductivityMetricController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord create(@RequestBody ProductivityMetricRecord r) {
        return service.recordMetric(r);
    }

    @GetMapping
    public List<ProductivityMetricRecord> all() {
        return service.getAllMetrics();
    }
}
