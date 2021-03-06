package io.gumga.core.gquery;

import java.io.Serializable;

public class Criteria implements Serializable{

    private String field;
    private ComparisonOperator comparisonOperator;
    private String value;
    private String[] values;
    private String fieldFunction;
    private String valueFunction;

    private void init() {
        comparisonOperator = ComparisonOperator.EQUAL;
        fieldFunction = "%s";
        valueFunction = "%s";
    }

    public Criteria() {
        init();
    }

    public Criteria(String field, ComparisonOperator comparisonOperator, String value) {
        init();
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

    public String getFieldFunction() {
        return fieldFunction;
    }

    public void setFieldFunction(String fieldFunction) {
        this.fieldFunction = fieldFunction;
    }

    public String getValueFunction() {
        return valueFunction;
    }

    public void setValueFunction(String valueFunction) {
        this.valueFunction = valueFunction;
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
        return String.format(fieldFunction, field) + comparisonOperator.hql + String.format(valueFunction, '\'' + value + '\'');
    }

}
