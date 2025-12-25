@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    @Autowired
    private AnomalyFlagRecordRepository repo;

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord record) {
        return repo.save(record);
    }

    @Override
    public AnomalyFlagRecord resolveAnomaly(Long id) {
        AnomalyFlagRecord f = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        f.setResolved(true);
        return repo.save(f);
    }

    @Override
    public List<AnomalyFlagRecord> getAllFlags() {
        return repo.findAll();
    }
}
