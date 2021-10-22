package com.df.service;

import com.df.mapper.RoleMapper;
import com.df.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/1/6 23:52
 **/

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;


    public int deleteByPrimaryKey(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }


    public int insert(Role record) {
        return roleMapper.insert(record);
    }


    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }


    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    public Integer count() {
        return roleMapper.count();
    }


    /**
     * Add role int.
     *
     * @param name 用户名
     * @return 0 成功  1 失败
     */
    public int addRole(String name) {
        return this.insertSelective(new Role(null, name, LocalDateTime.now(), "", 0, null, null));
    }

}
