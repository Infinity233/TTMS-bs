package com.Infinity.service;

import com.Infinity.dao.ManagerMapper;
import com.Infinity.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    public List<Manager> selectAll() {

        return managerMapper.selectAll();
    }

    public List<Manager> serachManager(String username) {

        List<Manager> list = managerMapper.selectByUsernameMohu(username);
        return list;
    }

    public int insert(Manager manager) {

        return managerMapper.insert(manager);
    }

    public int update(Manager manager) {

        return managerMapper.updateByPrimaryKeySelective(manager);
    }

    public int delete(String[] list) {

        return managerMapper.deleteByIds(list);
    }


    public boolean isExist(String username) {

        Boolean exist = true;

        if(managerMapper.selectByUsername(username)==0) {
            exist = false;
        }

        return exist;
    }
}
