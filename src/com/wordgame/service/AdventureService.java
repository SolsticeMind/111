package com.wordgame.service;
import com.wordgame.model.Role;

public class AdventureService {
    /*
       负责人：组员x
       功能：角色选择与初始化（闯关模式用）
       参数：
           roleIndex: 角色索引（1-ddg 2-阿伟 3-大超 4-隐藏角色）
       返回值：
           Role: 选中的角色对象（未解锁返回null）
   */
    public Role selectRole(int roleIndex) {
        // 在此处完成代码：结合作弊状态判断是否解锁隐藏角色
        return null;
    }

    /*
        负责人：组员x
        功能：商店道具购买与使用
        参数：
            itemIndex: 道具索引
            role: 当前角色
        返回值：
            0: 购买失败（金币不足）
            1: 购买并使用成功
    */
    public int buyAndUseItem(int itemIndex, Role role) {
        // 在此处完成代码：扣减金币、执行道具效果（如恢复HP）
        return 0;
    }

    /*
       负责人：组员x
       功能：闯关/无尽模式状态更新
       参数：
           isCorrect: 答题是否正确
           role: 当前角色
       返回值：
           0: 生命值耗尽（游戏结束）
           1: 正常继续
   */
    public int updateAdventureStatus(boolean isCorrect, Role role) {
        // 在此处完成代码：正确+金币/经验，错误-生命值；20关后错误扣2血
        return 0;
    }

    /*
       负责人：组员x
       功能：作弊功能激活
       参数：
           cheatType: 作弊类型（1-无限金币 2-解锁隐藏角色 3-角色满级）
           gameService: 游戏服务实例
       返回值：void
   */
    public void activateCheat(int cheatType, GameService gameService) {
        // 在此处完成代码：修改对应状态变量（如cheatStatus、角色属性、金币）
    }

    /*
        负责人：组员x
        功能：计时器倒计时（闯关模式用）
        参数：void
        返回值：
            true: 倒计时结束（自动跳过，扣1血）
            false: 未结束
    */
    public boolean timerCountdown() {
        // 在此处完成代码：10秒倒计时判断
        return false;
    }
}
