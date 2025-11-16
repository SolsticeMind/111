package com.wordgame.view;

import com.wordgame.service.GameService;

import java.util.Scanner;

public class MenuView {

    /*
      负责人：组员x
      功能：主菜单界面
      逻辑：展示模式选项→接收输入→跳转对应界面/执行操作
      参数：void
      返回值：void
  */
    public static void menuView() {
        // 在此处完成代码：展示"1-经典 2-快速 3-复习 5-闯关 6-选择词库 0-退出 存档"选项
        System.out.println("\n==================== 主菜单 ====================");
        System.out.println("1-经典模式（逐题输入中文，积累熟练度）");
        System.out.println("2-快速模式（仅判断是否认识，高效刷题）");
        System.out.println("3-复习模式（从熟练题库出题，巩固记忆）");
        System.out.println("5-闯关模式（角色养成+计时挑战，解锁道具）");
        System.out.println("6-选择词库（切换不同陌生题库）");
        System.out.println("7-手动存档（保存当前进度）");
        System.out.println("0-退出程序（自动存档）");
        System.out.print("请选择功能：");
    }

    /*
        负责人：组员x
        功能：词库选择界面
        逻辑：展示所有词库→接收索引→更新currentBankIndex
        参数：void
        返回值：void
    */
    public static void selectBankView() {
        // 在此处完成代码

        System.out.println("\n================= 词库选择 =================");
        System.out.println("1.词库1");
        System.out.println("2.词库2");
        System.out.print("请选择词库：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();                    //接收用户输入的值
        while(choice != 1 && choice != 2){                       //判断输入的值是否有效
            System.out.println("选择无效,请重新选择(1或2)");
            choice = scanner.nextInt();}
        if(choice==1){
            GameService gameService = new GameService();   //返回索引的值给currentBankIndex,值为0
            gameService.setCurrentBankIndex(0);
            System.out.println("词库选择成功,当前为词库1");}
        if(choice==2){
            GameService gameService = new GameService();   //返回索引的值给currentBankIndex,值为1
            gameService.setCurrentBankIndex(1);
            System.out.println("词库选择成功,当前为词库2");}
    }

}

