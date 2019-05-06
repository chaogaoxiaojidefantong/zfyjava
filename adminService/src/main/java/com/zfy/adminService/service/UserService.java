package com.zfy.adminService.service;

import com.zfy.adminService.dao.UserMapper;
import com.zfy.common.pojo.User;
import com.zfy.common.util.EmailUtil;
import com.zfy.common.util.JsonUtil;
import com.zfy.common.vo.BiliResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    JsonUtil<User>jsonUtil=new JsonUtil<User>();

    Jedis jedis=new Jedis();

    /**
     * 登录
     * @param user
     * @return
     */
    public BiliResult login(User user){
        if(user.getUserPwd()!=null){
            String md5Pwd=DigestUtils.md5Hex(user.getUserPwd());
            user.setUserPwd(md5Pwd);
        }
    User user1=userMapper.selectOne(user);
    if(user1==null){
        return BiliResult.build(201,"密码不存在");
    }
    Map map=handleToken(user1);
    return BiliResult.oK(map);
}

    public Map handleToken(User user) {
        String token=user.getUserEmail()+ UUID.randomUUID();//token的保留形式为用户邮箱+随机数
        String JsonUser2=jsonUtil.writeObjToJsonString(user);//转为JSON格式，存储到redis服务器里
        jedis.set(token,JsonUser2);
        jedis.expire(token,60*60*24);
        Map map=new HashMap();
        map.put("user",user);
        map.put("token",token);
        return map;
    }

    /**
     * 发送验证码
     * @param user
     * @return
     */
    public BiliResult sendVerifyCode(User user){
       String userEmail= user.getUserEmail();
        EmailUtil emailUtil=new EmailUtil();
        String verifyCode=emailUtil.emailCheck(userEmail);
        user.setVerifyCode(verifyCode);
       Integer i1= userMapper.updateUser(user);
       if(i1==0){
           return BiliResult.build(201,"验证码发送失败");
       }
       return BiliResult.oK();
}

    /**
     * 判断此邮箱是否已被注册
     * @return
     */
    public  BiliResult registVerify(User user){
    User user1=userMapper.selectOne(user);
    if(user1==null){
        return BiliResult.oK("此邮箱还没有被注册");
    }
    return BiliResult.build(201,"此邮箱已被注册");
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public  BiliResult addOne(User user){
        String md5Pwd=DigestUtils.md5Hex(user.getUserPwd());
        user.setUserPwd(md5Pwd);
        user.setUserMember(false);
        Integer i1=userMapper.insert(user);
        if(i1==0){
            return BiliResult.build(201,"注册失败");
        }
        return BiliResult.oK();
    }

    /**
     * token登录
     * @param token
     * @return
     */
    public BiliResult tokenLogin(String token){
    String userJson=jedis.get(token);
    User user=jsonUtil.writeJsonStringToObj(userJson,User.class);
    return BiliResult.oK(user);
    }

    /**
     * 退出登录的操作
     * @param token
     * @return
     */
    public BiliResult logout(String token){
    jedis.del(token);
    return BiliResult.oK();
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public BiliResult updateUser(User user){
        String md5Pwd=DigestUtils.md5Hex(user.getUserPwd());
        user.setUserPwd(md5Pwd);
        Integer i1=userMapper.updateUser(user);
        if(i1==0){
            return BiliResult.build(201,"修改失败");
        }
        User user1=userMapper.selectOne(user);
        Map map=handleToken(user1);
        return BiliResult.oK(map);
    }

}
