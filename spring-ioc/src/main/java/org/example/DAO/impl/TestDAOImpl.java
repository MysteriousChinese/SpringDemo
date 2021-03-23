package org.example.DAO.impl;

import org.example.DAO.Interface.ITestDAO;
import org.example.service.Interface.ITestService;
import org.springframework.stereotype.Repository;

@Repository //TestDAOImpl实例注册到ioc容器 ,数据访问层用@Repository
public class TestDAOImpl implements ITestDAO {

    @Override
    public void Query() {
        System.out.println("d1查询成功");
    }
}
