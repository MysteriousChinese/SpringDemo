package org.example.DAO.impl;

import org.example.DAO.Interface.ITestDAO;
import org.springframework.stereotype.Repository;

@Repository("d2")
public class TestDAOImpl12  implements ITestDAO {
    @Override
    public void Query() {
        System.out.println("d2查询成功");
    }
}
