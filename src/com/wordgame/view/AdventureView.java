package com.wordgame.view;

import com.wordgame.service.GameService;

public class AdventureView {
    private GameService gameService;

    public AdventureView(GameService gameService) {
        this.gameService = gameService;
    }

    /*
        负责人：组员x
        功能：闯关模式子菜单
        逻辑：展示"1-开始游戏 2-作弊选项 3-成就"→跳转对应界面
        参数：void
        返回值：void
    */
    public static void adventureMenuView() {
        // 在此处完成代码
    }

    /*
       负责人：组员x
       功能：角色选择界面
       逻辑：展示可选角色→接收选择→调用selectRole→跳转任务/商店/闯关
       参数：void
       返回值：void
   */
    public static void roleSelectView() {
        // 在此处完成代码：隐藏角色未解锁时显示"???"
    }

    /*
       负责人：组员x
       功能：商店界面
       逻辑：展示道具列表+当前资源→接收选择→调用buyAndUseItem→返回游戏/退出
       参数：void
       返回值：void
   */
    public static void shopView() {
        // 在此处完成代码
    }

    /*
       负责人：组员x
       功能：作弊界面
       逻辑：展示作弊选项→接收选择→调用activateCheat→返回子菜单
       参数：void
       返回值：void
   */
    public static void cheatView() {
        // 在此处完成代码
    }

    /*
        负责人：组员x
        功能：闯关/无尽模式游戏界面
        逻辑：整合角色状态→循环出题（含计时器）→处理商店入口→调用updateAdventureStatus
        参数：void
        返回值：void
    */
    public static void adventureGameView() {
        // 在此处完成代码：包含10秒倒计时、商店入口、生命值/金币显示
    }

}
