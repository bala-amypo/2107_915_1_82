@RestController
@RequestMapping("/metrics")
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
    public List<ProductivityMetricRecord> getAll() {
        return service.getAllMetrics();
    }

    @PutMapping("/{id}")
    public ProductivityMetricRecord update(@PathVariable Long id,
                                           @RequestBody ProductivityMetricRecord r) {
        return service.updateMetric(id, r);
    }
}
