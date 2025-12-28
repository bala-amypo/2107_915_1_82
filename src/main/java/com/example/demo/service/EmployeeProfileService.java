public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    List<EmployeeProfile> getAllEmployees();

    EmployeeProfile getEmployeeById(Long id);          // ✅ CHANGED

    EmployeeProfile findByEmployeeId(String employeeId); // ✅ CHANGED

    EmployeeProfile updateEmployee(EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    void deleteEmployee(Long id);
}
