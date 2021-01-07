package com.yhy.mongodb;

import com.yhy.mongodb.dao.DemoDAO;
import com.yhy.mongodb.entity.DemoEntity;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MongodbApplicationTests {
    @Autowired
    DemoDAO demoDAO;

    @Test
    void addDemoTest() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("曼达洛人");
        demoEntity.setPassword("this is the way");
        demoDAO.addDemo(demoEntity);
    }

    @Test
    void deleteDemoTest() {

        demoDAO.deleteDemo("5fa8e46a75aaf520abda177b");
    }

    @Test
    void getDemoListTest() {
        List<DemoEntity> demoEntityList;
        demoEntityList = demoDAO.getDemoList();
        for (DemoEntity de : demoEntityList) {
            System.out.println(de);
        }
    }

    @Test
    void findDemoTest() {

        DemoEntity demoEntity = demoDAO.findDemoById("5fa8e43ecaed083961756814");

        System.out.println();

        DemoEntity demoEntity2 = demoDAO.findDemoByName("mongodb第三条数据");
        System.out.println(demoEntity2);

    }

    @Test
    void updateDemoTest() {

        DemoEntity demoEntity=new DemoEntity();
        demoEntity.setId("5fa8e43ecaed083961756814");
        demoEntity.setPassword("good people");
        demoDAO.updateDemo(demoEntity);
    }
}
