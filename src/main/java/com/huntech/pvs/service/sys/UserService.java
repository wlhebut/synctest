package com.huntech.pvs.service.sys;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import com.huntech.pvs.core.generic.GenericService;
import com.huntech.pvs.dto.sys.User;
import com.huntech.pvs.dto.sys.UserExample;
import com.huntech.pvs.view.sys.UserView;
import com.huntech.pvs.view.sys.UserViewExample;


import java.util.List;

/**
 * 用户 业务 接口
 * 
 * @author
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService extends GenericService<User, Long> {

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);

    List<User> getSidByName2(String userName);

    int editUserMessage(User userInform);

    Integer addOrgByDis(User user);

    void updateByDis(User user);
}
