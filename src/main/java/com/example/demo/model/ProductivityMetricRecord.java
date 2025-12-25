@Entity
public class ProductivityMetricRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private LocalDate date;

    private Double hoursLogged;
    private Integer tasksCompleted;
    private Integer meetingsAttended;
    private Double productivityScore;

    private String rawDataJson;

    // 🔥 REQUIRED
    public ProductivityMetricRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // getters & setters for ALL fields
    @Entity
public class TeamSummaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private Double avgHoursLogged;
    private Double avgScore;
    private Integer anomalyCount;
    private LocalDate summaryDate;

    // 🔥 REQUIRED
    public TeamSummaryRecord() {}

    // getters & setters
}

}
