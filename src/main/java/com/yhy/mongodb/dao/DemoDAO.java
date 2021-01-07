package com.yhy.mongodb.dao;

import com.yhy.mongodb.entity.DemoEntity;

import java.util.List;

public interface DemoDAO {
    boolean addDemo(DemoEntity demoEntity);

    boolean deleteDemo(String id);

    boolean updateDemo(DemoEntity demoEntity);

    DemoEntity findDemoById(String id);

    DemoEntity findDemoByName(String name);

    List<DemoEntity> getDemoList();

     void getMongoData();
}
