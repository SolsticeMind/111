package com.wordgame.service;

import com.wordgame.main.Main;
import com.wordgame.model.User;

import java.util.*;

// 用户相关服务
public class UserService {
    private static List<User> userList = new ArrayList<>();

    /*
      负责人：组员x
      功能：用户注册处理
      参数：
          account: 注册账号
          password: 密码
          confirmPwd: 确认密码
          securityQ: 密保问题
          securityA: 密保答案
      返回值：
          0: 注册失败（密码不一致）
          1: 注册成功（存储用户信息）
  */
    public static int userRegister(String account, String password, String confirmPwd, String securityQ, String securityA) {
        // 在此处完成代码
        // 检查密码是否一致
        if (!password.equals(confirmPwd)) {
            return 0;
        }

        // 检查账号是否已存在
        for (User user : userList) {
            if (user.getAccount().equals(account)) {
                // 账号已存在
                return 0;
            }
        }

        // 创建新用户并添加到列表
        User newUser = new User(account, password, securityQ, securityA);
        userList.add(newUser);
        return 1;

    }

    /*
      负责人：组员x
      功能：用户登录验证
      参数：
          account: 登录账号
          password: 登录密码
      返回值：
          0: 登录失败（账号或密码错误）
          1: 登录成功（赋值currentUser，加载用户题库数据）
  */
    public static int userLogin(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
                // 登录成功，设置当前用户
                Main.gameService.setCurrentUser(user);
                return 1;
            }
        }
        // 登录失败
        return 0;
    }

    /*
        负责人：组员x
        功能：忘记密码验证
        参数：
            account: 账号
            securityQ: 密保问题
            securityA: 密保答案
        返回值：
            null: 验证失败
            String: 验证成功，返回用户密码
    */
    public static String forgetPassword(String account, String securityQ, String securityA) {
        for (User user : userList) {
            if (user.getAccount().equals(account) &&
                    user.getSecurityQ().equals(securityQ) &&
                    user.getSecurityA().equals(securityA)) {
                return user.getPassword();
            }
        }
        return null;
    }
}
