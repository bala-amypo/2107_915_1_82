@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile e) {
        return service.createEmployee(e);
    }

    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeProfile get(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeProfile update(@PathVariable Long id,
                                  @RequestBody EmployeeProfile e) {
        return service.updateEmployee(id, e);
    }

    @PutMapping("/{id}/status")
    public EmployeeProfile status(@PathVariable Long id,
                                  @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }
}
