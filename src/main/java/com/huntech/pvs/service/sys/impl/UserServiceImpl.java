package com.huntech.pvs.service.sys.impl;

import com.huntech.pvs.core.generic.GenericDao;
import com.huntech.pvs.core.generic.GenericServiceImpl;
import com.huntech.pvs.dao.sys.UserMapper;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.dto.sys.UserExample;
import com.huntech.pvs.service.sys.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类
 *
 * @author
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public int insert(User model) {
        return userMapper.insertSelective(model);
    }

    @Override
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<User, Long> getDao() {
        return userMapper;
    }

    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        //example.createCriteria().andUsernameEqualTo(username);
        example.createCriteria().andLoginNameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        if(null!=list && list.size()>0){
            return list.get(0);
        }
        return null;
    }





    @Override
    public List<User> getSidByName2(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(userName);
        criteria.andEnabledEqualTo("1");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int editUserMessage(User userInform) {
        return  userMapper.updateByPrimaryKey(userInform);
    }

    @Override
    public Integer addOrgByDis(User user) {
        userMapper.insertSelective(user);
        Long ddd = user.getSid();
        return Integer.valueOf(String.valueOf(ddd));
    }

    @Override
    public void updateByDis(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andSidEqualTo(user.getSid());
        int c = 0;
        c = userMapper.countByExample(userExample);
        if(0 == c){
            userMapper.insertSelective(user);
        }else {
            userMapper.updateByExampleSelective(user,userExample);
        }
    }


}
