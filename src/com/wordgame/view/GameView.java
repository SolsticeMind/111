package com.wordgame.view;

import com.wordgame.main.Main;
import com.wordgame.model.GameStats;
import com.wordgame.model.Word;
import com.wordgame.service.GameService;
import com.wordgame.service.WordService;
import com.wordgame.utils.FileUtil;

public class GameView {
    /*
       负责人：组员x
       功能：游戏核心界面（适配经典/快速/复习模式）
       逻辑：初始化统计数据→循环出题→接收用户操作→调用judgeAnswer→更新界面
       参数：void
       返回值：void
   */
    public static void gameCoreView() {
        // 在此处完成代码：根据currentMode处理不同逻辑（如快速模式无需输入中文）
        GameStats gameStats = Main.gameService.getGameStats();

        // 重置统计数据（每次游戏开始时重置）
        gameStats.setTotalCount(0);
        gameStats.setCorrectCount(0);
        gameStats.setAccuracy(0.0);
        System.out.println("\n=========== 游戏开始 =============");
        System.out.println("输入'q'退出游戏");
        while (true) {
            // 获取下一个单词
            Word word = WordService.getNextWord();
            if (word == null) {
                System.out.println("题库已空，游戏结束！");
                break;
            }
            // 显示单词
            System.out.println("\n单词：" + word.getEnglish());
            // 根据模式处理不同逻辑
            int mode = Main.gameService.getCurrentMode();
            String userAnswer = "";
            int isKnown = 0;

            // 快速模式
            if (mode == 2) {
                System.out.print("是否认识这个单词？(1-认识 2-不认识)：");
                // 读取用户输入
                String choice = Main.sc.nextLine().trim();
                if (choice.equalsIgnoreCase("q")) {
                    break; // 退出游戏循环
                }
                switch (choice) {
                    case "1":
                        System.out.println("已跳转至下一个单词~");
                        continue; // 直接进入下一次循环（获取下一个单词）
                    case "2":
                        System.out.println("单词释义：" + word.getChinese());
                        // 展示后自动跳至下一个单词
                        continue; // 进入下一次循环
                    default:
                        // 其他输入：提示无效，重新等待输入（不跳单词）
                        System.out.println("无效输入，请重新选择！");
                        // 不使用continue，让循环停留在当前单词，重新提示输入
                }
                // 经典/复习模式
            } else {
                System.out.print("请输入中文释义：");
                userAnswer = Main.sc.nextLine();
                isKnown = 1;
            }
            // 检查是否退出
            if (userAnswer.equalsIgnoreCase("q")) {
                break;
            }

            if (mode != 2){
                // 判断答案
                int result = WordService.judgeAnswer(word, userAnswer, isKnown);
                // 增加总答题数（无论正确与否）
                gameStats.setTotalCount(gameStats.getTotalCount() + 1);
                if (result == 1) {
                    System.out.println("正确！");
                    // 增加正确答题数
                    gameStats.setCorrectCount(gameStats.getCorrectCount() + 1);
                } else {
                    System.out.println("错误！正确答案是：" + word.getChinese());
                }
            }
        }
        // 计算正确率
        gameStats.setAccuracy(FileUtil.calculateAccuracy(gameStats));
    }

    /*
       负责人：组员x
       功能：结算界面
       逻辑：展示游戏结束→显示统计数据→给出鼓励语→返回主菜单
       参数：void
       返回值：void
   */
    public static void resultView() {
        // 在此处完成代码：闯关模式额外显示关卡数
        GameStats stats = Main.gameService.getGameStats();
        System.out.println("\n===== 游戏结束 =====");
        System.out.println("总答题数：" + stats.getTotalCount());
        System.out.println("正确数：" + stats.getCorrectCount());
        System.out.println("正确率：" + stats.getAccuracy() + "%");

        // 闯关模式额外显示关卡数
        if (Main.gameService.getCurrentMode() == 5 && Main.gameService.getCurrentRole() != null) {
            System.out.println("当前关卡：" + stats.getCurrentLevel());
            System.out.println("获得金币：" + Main.gameService.getCurrentRole().getGold());
            System.out.println("当前等级：" + Main.gameService.getCurrentRole().getLevel());
        }

        // 鼓励语
        if (stats.getAccuracy() >= 90) {
            System.out.println("太棒了，继续保持！");
        } else if (stats.getAccuracy() >= 60) {
            System.out.println("不错哦，继续努力！");
        } else {
            System.out.println("加油，多练习一定会有进步！");
        }
        System.out.println("按回车键返回主菜单...");
        Main.sc.nextLine();
    }


}
