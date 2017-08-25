package io.gumga.core.gquery;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public class Programa {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        GQuery q = om.readValue("{\"logicalOperator\":\"AND\",\"criteria\":null,\"subQuerys\":[{\"logicalOperator\":\"OR\",\"criteria\":null,\"subQuerys\":[{\"logicalOperator\":\"SIMPLE\",\"criteria\":{\"field\":\"name\",\"comparisonOperator\":\"STARTS_WITH\",\"value\":\"munif\",\"values\":null,\"fieldFunction\":\"%s\",\"valueFunction\":\"%s\"},\"subQuerys\":null},{\"logicalOperator\":\"SIMPLE\",\"criteria\":{\"field\":\"name\",\"comparisonOperator\":\"STARTS_WITH\",\"value\":\"vicente\",\"values\":null,\"fieldFunction\":\"%s\",\"valueFunction\":\"%s\"},\"subQuerys\":null},{\"logicalOperator\":\"SIMPLE\",\"criteria\":{\"field\":\"name\",\"comparisonOperator\":\"STARTS_WITH\",\"value\":\"duda\",\"values\":null,\"fieldFunction\":\"%s\",\"valueFunction\":\"%s\"},\"subQuerys\":null}]},{\"logicalOperator\":\"SIMPLE\",\"criteria\":{\"field\":\"name\",\"comparisonOperator\":\"CONTAINS\",\"value\":\"gebara\",\"values\":null},\"subQuerys\":null}]}", GQuery.class);

//        GQuery q = new GQuery(new Criteria("name", ComparisonOperator.STARTS_WITH, "munif"))
//                .or(new Criteria("name", ComparisonOperator.STARTS_WITH, "vicente"))
//                .or(new Criteria("name", ComparisonOperator.STARTS_WITH, "duda"))
//                .and(new Criteria("name", ComparisonOperator.CONTAINS, "gebara"));

        System.out.println(om.writeValueAsString(q));

        System.out.println("\n" + q);

        GQuery gQuery = new GQuery(new Criteria("oi", ComparisonOperator.STARTS_WITH, "1."));
        
        gQuery = gQuery.and(q);
        

        String hql = "FROM Pessoa p where " + gQuery;

        System.out.println("--->" + hql);

    }

}
