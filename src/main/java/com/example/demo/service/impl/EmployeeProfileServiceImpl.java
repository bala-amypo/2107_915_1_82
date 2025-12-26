@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile e) {
        return e;
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        throw new RuntimeException("Employee not found");
    }

    @Override
    public Optional<EmployeeProfile> findByEmployeeId(String employeeId) {
        return Optional.empty();
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile e = new EmployeeProfile();
        e.setActive(active);
        return e;
    }
}
