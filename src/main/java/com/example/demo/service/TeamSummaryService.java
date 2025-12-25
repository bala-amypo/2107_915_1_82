public interface TeamSummaryService {

    TeamSummaryRecord saveSummary(TeamSummaryRecord record);

    List<TeamSummaryRecord> getAllSummaries();
}
