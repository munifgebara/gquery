package io.gumga.core.gquery;

public class Criteria {

    private String field;
    private ComparisonOperator comparisonOperator;
    private String value;
    private String[] values;

    public Criteria() {
        comparisonOperator = ComparisonOperator.EQUAL;
    }

    public Criteria(String field, ComparisonOperator comparisonOperator, String value) {
        this.field = field;
        this.comparisonOperator = comparisonOperator;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public ComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        String value = this.value;
        if (ComparisonOperator.STARTS_WITH.equals(this.comparisonOperator)) {
            value = value + "%";
        } else if (ComparisonOperator.ENDS_WITH.equals(this.comparisonOperator)) {
            value = "%" + value;
        } else if (ComparisonOperator.CONTAINS.equals(this.comparisonOperator)) {
            value = "%" + value + "%";
        }
        return field + comparisonOperator.hql + '\'' + value + '\'';
    }

}
