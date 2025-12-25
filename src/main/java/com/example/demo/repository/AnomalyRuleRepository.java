public interface AnomalyRuleRepository extends JpaRepository<AnomalyRule, Long> {
    List<AnomalyRule> findByActiveTrue();
}
