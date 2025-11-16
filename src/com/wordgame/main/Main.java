package com.wordgame.main;

import com.wordgame.model.GameStats;
import com.wordgame.model.Word;
import com.wordgame.service.GameService;
import com.wordgame.utils.FileUtil;
import com.wordgame.view.AdventureView;
import com.wordgame.view.GameView;
import com.wordgame.view.LoginView;
import com.wordgame.view.MenuView;
import java.util.Scanner;


public class Main {

    public static GameService gameService = new GameService();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 1. 初始化系统数据（题库、商店、默认角色）
        gameService.initSystem();
        // 2. 进入登录界面（含注册、忘记密码入口），登录成功才进入主循环
        LoginView.loginView();

        // 3. 主循环：登录成功后持续展示主菜单，直到用户选择退出
        while (gameService.getCurrentUser() != null) {
            // 展示主菜单（提供模式选择、词库选择、存档、退出选项）
            MenuView.menuView();
            // 接收用户主菜单输入（1-经典 2-快速 3-复习 5-闯关 6-选择词库 7-存档 0-退出）
            int menuChoice = sc.nextInt();
            sc.nextLine();

            // 根据选择执行对应流程
            switch (menuChoice) {
                // 经典模式
                case 1:
                    gameService.setCurrentMode(1);
                    // 启动经典模式核心游戏（出题→答题→判断）
                    GameView.gameCoreView();
                    // 游戏结束展示结算数据
                    GameView.resultView();
                    break;
                // 快速模式
                case 2:
                    gameService.setCurrentMode(2);
                    // 启动快速模式核心游戏（无需输入中文，仅判断是否认识）
                    GameView.gameCoreView();
                    break;
                // 复习模式
                case 3:
                    gameService.setCurrentMode(3);
                    // 启动复习模式核心游戏（从熟练题库出题）
                    GameView.gameCoreView();
                    // 展示结算数据
                    GameView.resultView();
                    break;
                // 闯关模式
                case 5:
                    gameService.setCurrentMode(5);
                    // 进入闯关子菜单（开始游戏/作弊/成就）
                    AdventureView.adventureMenuView();
                    int adventureChoice = sc.nextInt();
                    sc.nextLine();
                    // 选择开始闯关
                    if (adventureChoice == 1) {
                        // 选择角色（解锁状态由cheatStatus控制）
                        AdventureView.roleSelectView();
                        // 角色选择成功
                        if (gameService.getCurrentRole() != null) {
                            // 启动闯关游戏（含计时器、商店入口）
                            AdventureView.adventureGameView();
                            // 展示闯关结算（关卡数、金币、经验）
                            GameView.resultView();
                        }
                    } else if (adventureChoice == 2) {
                        // 进入作弊界面（激活对应作弊功能）
                        AdventureView.cheatView();
                    }
                    break;
                // 词库选择
                case 6:
                    // 选择陌生题库（更新currentBankIndex）
                    MenuView.selectBankView();
                    break;
                // 存档
                case 7:
                    // 调用存档功能
                    FileUtil.saveOrLoadData(1,gameService);
                    System.out.println("存档成功！");
                    break;
                // 退出程序
                case 0:
                    // 退出前自动存档
                    FileUtil.saveOrLoadData(1,gameService);
                    System.out.println("感谢游玩，再见！");
                    // 终止主循环
                    gameService.setCurrentUser(null);
                    break;
                default:
                    System.out.println("输入无效，请重新选择！");
                    break;
            }
        }
    }


}
