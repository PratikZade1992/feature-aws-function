package com.awslamda.demo.config;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import java.util.function.Supplier;


public class DynamoMapper {

    public static Supplier<DynamoDBMapper> dynamoDBMapperSupplier =
            () -> {
        return new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build());
    };
}
