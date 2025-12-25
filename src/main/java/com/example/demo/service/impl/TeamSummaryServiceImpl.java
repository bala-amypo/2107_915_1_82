@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    @Autowired
    private TeamSummaryRepository repo;

    @Override
    public TeamSummaryRecord saveSummary(TeamSummaryRecord record) {
        return repo.save(record);
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return repo.findAll();
    }
}
