package io.gumga.core.gquery;

import java.util.List;

/**
 *
 * @author munif
 */
public class GQuery {

    private LogicalOperator logicalOperator;
    private Criteria criteria;
    private List<GQuery> subQuerys;

    public GQuery() {
        this.logicalOperator = LogicalOperator.SIMPLE;
    }

    public GQuery(LogicalOperator logicalOperator, Criteria criteria, List<GQuery> subQuerys) {
        this.logicalOperator = logicalOperator;
        this.criteria = criteria;
        this.subQuerys = subQuerys;
    }

    public GQuery(LogicalOperator logicalOperator, Criteria criteria) {
        this.logicalOperator = logicalOperator;
        this.criteria = criteria;
    }

    public GQuery(Criteria criteria) {
        this.logicalOperator = logicalOperator.SIMPLE;
        this.criteria = criteria;
    }

    public GQuery(LogicalOperator logicalOperator, List<GQuery> subQuerys) {
        this.logicalOperator = logicalOperator;
        this.subQuerys = subQuerys;
    }

    @Override
    public String toString() {
        if (null != logicalOperator) {
            switch (logicalOperator) {
                case SIMPLE:
                    return "(" + criteria.toString() + ")";
                case NOT:
                    return "(!" + criteria.toString() + ")";
                case AND:
                case OR:
                    if (subQuerys == null || subQuerys.isEmpty()) {
                        return "1 = 1";
                    }
                    String r = "(" + subQuerys.get(0);
                    for (int i = 1; i < subQuerys.size(); i++) {
                        r += " "+logicalOperator.toString() + " " + subQuerys.get(i).toString();
                    }
                    r += ")";
                    return r;
                default:
                    break;
            }
        }
        return "(" + criteria.toString() + ")";
    }
}
