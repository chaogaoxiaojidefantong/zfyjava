package com.zfy.adminService.service;

import com.zfy.adminService.dao.UserMapper;
import com.zfy.common.pojo.User;
import com.zfy.common.vo.BiliResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return
     */
    public BiliResult login(User user){
    String md5Pwd=DigestUtils.md5Hex(user.getUserPwd());
    user.setUserPwd(md5Pwd);
    User user1=userMapper.selectOne(user);
    if(user1==null){
        return BiliResult.build(201,"密码不存在");
    }
    return BiliResult.oK(user1);
}

}
