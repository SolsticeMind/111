package com.wordgame.utils;

import com.wordgame.model.GameStats;
import com.wordgame.service.GameService;

public class FileUtil {

    /*
        负责人：组员x
        功能：数据持久化（存档/读档，核心）
        参数：
            type: 操作类型（1-存档 2-读档）
            gameService: 游戏服务实例
        返回值：
            0: 操作失败
            1: 操作成功
    */
    //这个不会的话可暂时不实现
    public static int saveOrLoadData(int type, GameService gameService) {
        // 在此处完成代码：用IO流存储/读取用户信息、题库、游戏进度
        return 0;
    }

    /*
       负责人：组员x
       功能：计算游戏正确率
       参数：GameStats gameStats - 游戏统计数据
       返回值：double - 保留两位小数的正确率（0除0返回0）
   */
    public static double calculateAccuracy(GameStats gameStats) {
        // 在此处完成代码
        if (gameStats.getTotalCount() == 0) {
            return 0.0;
        }

        double accuracy = (double) gameStats.getCorrectCount() / gameStats.getTotalCount() * 100;
        // 保留两位小数
        return Math.round(accuracy * 100) / 100.0;
    }
}
