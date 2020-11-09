package com.yhy.mongodb.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * mongodb中collection对应的实体类
 */

@Document(collection = "demo_collection")
@Data
public class DemoEntity {

    @Id
    private String id;

    private String name;

    private String password;

}
