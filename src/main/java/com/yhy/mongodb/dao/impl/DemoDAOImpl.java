package com.yhy.mongodb.dao.impl;

import com.yhy.mongodb.dao.DemoDAO;
import com.yhy.mongodb.entity.DemoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;


@Component
@Slf4j
public class DemoDAOImpl implements DemoDAO {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public boolean addDemo(DemoEntity demoEntity) {
        try {
            mongoTemplate.save(demoEntity);
        } catch (Exception e) {
            log.error("mongodb插入失败", e);
        }

        return true;
    }

    @Override
    public boolean deleteDemo(String id) {
        try {
            Query query = new Query(Criteria.where("id").is(id));
            mongoTemplate.remove(query, DemoEntity.class);
        } catch (Exception e) {
            log.error("mongodb删除失败", e);
        }
        return true;
    }

    @Override
    public List<DemoEntity> getDemoList() {
        List<DemoEntity> demoEntityList = mongoTemplate.findAll(DemoEntity.class);
        return demoEntityList;
    }

    @Override
    public boolean updateDemo(DemoEntity demoEntity) {
        Query query = new Query(Criteria.where("id").is(demoEntity.getId()));
        Update update = new Update();
        if (!StringUtils.isEmpty(demoEntity.getName())) {
            update.set("name", demoEntity.getName());
        }
        if (!StringUtils.isEmpty(demoEntity.getPassword())) {
            update.set("password", demoEntity.getPassword());
        }
        try {
            mongoTemplate.updateFirst(query, update, DemoEntity.class);
        } catch (Exception e) {
            log.error("mongodb更新失败", e);
        }
        return true;
    }

    @Override
    public DemoEntity findDemoById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        DemoEntity demoEntity = mongoTemplate.findOne(query, DemoEntity.class);
        return demoEntity;
    }

    @Override
    public DemoEntity findDemoByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        DemoEntity demoEntity = mongoTemplate.findOne(query, DemoEntity.class);
        return demoEntity;
    }
}
