package com.example.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "author")
public class Author {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;
    @DynamoDBAttribute
    private String firstName;
    @DynamoDBAttribute
    private String lastName;
}
