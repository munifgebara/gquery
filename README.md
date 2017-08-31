# gquery

```
 *
 * @author munif
 */
@Service
public class QueriesService {

    @PersistenceContext
    private EntityManager em;

    public SearchResult query(String classe, GQuery gQuery) {
        gQuery = gQuery.and(new Criteria("obj.oi", ComparisonOperator.STARTS_WITH, GumgaThreadScope.organizationCode.get()));
        String hql = "FROM " + classe + " obj where " + gQuery.toString();
        System.out.println("hql----->" + hql);
        Query q = em.createQuery(hql);
        List resultList = q.getResultList();
        SearchResult result = new SearchResult(0, resultList.size(), resultList.size(), resultList);
        return result;
    }

}

```
