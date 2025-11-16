package com.wordgame.view;

import com.wordgame.service.GameService;
import com.wordgame.service.UserService;

import java.util.Scanner;

public class LoginView {
    private GameService gameService;

    public LoginView(GameService gameService) {
        this.gameService = gameService;
    }
    /*
        负责人：组员x
        功能：登录界面
        逻辑：展示登录提示→接收账号密码→调用login验证→成功进主菜单/失败重新输入
        参数：void
        返回值：void
    */
    public static void loginView() {
        Scanner sc = new Scanner(System.in);
        // 在此处完成代码：包含"忘记密码"入口（跳转forgetPwdView）、"注册"入口（跳转registerView）
        while (true) {
            System.out.println("==================== 单词闯关游戏 ====================");
            System.out.println("1-登录  2-注册  3-忘记密码  0-退出程序");
            System.out.print("请选择操作：");
            int choice = sc.nextInt();
            sc.nextLine(); // 吸收换行符

            switch (choice) {
                case 1: // 登录
                    System.out.print("请输入账号：");
                    String account = sc.nextLine();
                    System.out.print("请输入密码：");
                    String password = sc.nextLine();

                    int loginResult = UserService.userLogin(account, password);
                    if (loginResult == 1) {
                        System.out.println("登录成功！欢迎回来～");
                        // 登录成功后加载用户题库（实际需在userLogin中实现）
                        // 退出登录界面，进入主循环
                        return;
                    } else {
                        System.out.println("账号或密码错误，请重新尝试！");
                    }
                    break;
                case 2: // 注册
                    registerView();
                    break;
                case 3: // 忘记密码
                    forgetPwdView();
                    break;
                case 0: // 退出程序
                    System.out.println("感谢关注，再见！");
                    System.exit(0); // 直接终止程序
                    break;
                default:
                    System.out.println("输入无效，请重新选择！");
                    break;
            }
        }

    }


    /*
      负责人：组员x
      功能：注册界面
      逻辑：展示注册提示→依次接收账号、密码、确认密码、密保→调用register处理
      参数：void
      返回值：void
  */
    public static void registerView() {
        // 在此处完成代码：密码不一致则重新录入
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("请输入账号：");
            String regAccount = sc.nextLine();
            System.out.print("请输入密码：");
            String regPwd = sc.nextLine();
            System.out.print("请确认密码：");
            String confirmPwd = sc.nextLine();
            System.out.print("请设置密保问题（如：你的生日？）：");
            String securityQ = sc.nextLine();
            System.out.print("请设置密保答案：");
            String securityA = sc.nextLine();
            int regResult = UserService.userRegister(regAccount, regPwd, confirmPwd, securityQ, securityA);
            if (regResult == 1) {
                System.out.println("注册成功！可直接登录～");
                break;
            } else {
                System.out.println("密码不一致，注册失败！");
            }
        }

    }

    /*
      负责人：组员x
      功能：忘记密码界面
      逻辑：展示提示→接收账号、密保→调用forgetPassword→成功显示密码/失败重新输入
      参数：void
      返回值：void
  */
    public static void forgetPwdView() {
        // 在此处完成代码
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入账号：");
            String fpAccount = sc.nextLine();
            System.out.print("请输入密保问题：");
            String fpQ = sc.nextLine();
            System.out.print("请输入密保答案：");
            String fpA = sc.nextLine();
            String password = UserService.forgetPassword(fpAccount, fpQ, fpA);
            if (password != null) {
                System.out.println("验证成功！你的密码是：" + password);
                break;
            } else {
                System.out.println("账号或密保信息错误，请重新尝试！");
            }
        }
    }

}


