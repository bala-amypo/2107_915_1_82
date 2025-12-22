@RestController
@RequestMapping("/api/metrics")
public class ProductivityMetricController {

    private final ProductivityMetricService service;

    public ProductivityMetricController(ProductivityMetricService service) {
        this.service = service;
    }

    @PostMapping
    public ProductivityMetricRecord save(@RequestBody ProductivityMetricRecord record) {
        return service.save(record);   // stored in DB
    }

    @GetMapping
    public List<ProductivityMetricRecord> getAll() {
        return service.findAll();     // fetched from DB
    }
}
