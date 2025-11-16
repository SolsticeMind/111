package com.wordgame.service;
import com.wordgame.model.GameStats;
import com.wordgame.model.User;
import com.wordgame.model.Role;

public class GameService {
    // 当前登录用户
    private User currentUser;
    // 陌生题库（多个词库）
    private  String[] UnFamiliarChineseWords;
    private  String[] UnFamiliarEnglishWords;
    // 熟练题库
    private  String[] ProficientChineseWords;
    private  String[] ProficientEnglishWords;
    // 当前选择的词库索引
    private int currentBankIndex = 0;
    // 当前游戏模式（1-经典 2-快速 3-复习 5-闯关）
    private int currentMode;
    // 游戏统计数据
    private GameStats gameStats;
    // 商店道具列表
    private String[] shopItems;
    // 闯关模式计时器（10秒倒计时）
    private long timer;
    // 作弊状态标记（0-未激活 1-无限金币 2-解锁隐藏角色 3-满级角色）
    private int cheatStatus = 0;
    // 当前选择的角色（闯关模式用）
    private Role currentRole;

    public GameStats getGameStats() {
        return gameStats;
    }

    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }

    public String[] getShopItems() {
        return shopItems;
    }

    public void setShopItems(String[] shopItems) {
        this.shopItems = shopItems;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public int getCheatStatus() {
        return cheatStatus;
    }

    public void setCheatStatus(int cheatStatus) {
        this.cheatStatus = cheatStatus;
    }

    public Role getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(Role currentRole) {
        this.currentRole = currentRole;
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public  String[] getUnFamiliarChineseWords() {
        return UnFamiliarChineseWords;
    }

    public  String[] getUnFamiliarEnglishWords() {
        return UnFamiliarEnglishWords;
    }

    public String[] getProficientChineseWords() {
        return ProficientChineseWords;
    }
    public String[] getProficientEnglishWords() {
        return ProficientEnglishWords;
    }

    public int getCurrentBankIndex() {
        return currentBankIndex;
    }

    public void setCurrentBankIndex(int currentBankIndex) {
        this.currentBankIndex = currentBankIndex;
    }

    public int getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(int currentMode) {
        this.currentMode = currentMode;
    }


    /*
            负责人：组员x
            功能：初始化系统核心数据
            参数：void
            返回值：void
        */
    public void initSystem() {
        // 在此处完成代码：加载默认词库、初始化商店道具、默认角色数据
        currentUser = new User();
        // gameStats初始化
        gameStats = new GameStats();
        initializeWordBanks();
        initializeShopItems();
    }

    /*
        负责人：组员x
        功能：初始化词库数据
        参数：void
        返回值：void
    */
    private void initializeWordBanks() {
        // 在此处完成代码:
        // 初始化陌生词库
        UnFamiliarChineseWords = new String[]{
                "放弃", "能力", "在国外", "缺席", "绝对的",
                "吸收", "访问；进入", "准确的", "实现", "适应",
                "足够的", "调整", "承认", "采用", "前进；提前",
                "优势", "建议", "影响", "买得起；承担", "同意",
                "允许", "改变", "使惊讶", "分析", "宣布",
                "焦虑", "道歉", "出现", "申请；应用", "批准",
                "争论", "到达", "安排", "评估", "协助",
                "假设", "附着；重视", "吸引", "避免", "意识到",
                "平衡", "禁止", "承受；忍受", "打败；击打", "开始",
                "表现", "相信", "有益于", "背叛", "责备"

        };

        UnFamiliarEnglishWords = new String[]{
                "abandon", "ability", "abroad", "absence", "absolute",
                "absorb", "access", "accurate", "achieve", "adapt",
                "adequate", "adjust", "admit", "adopt", "advance",
                "advantage", "advise", "affect", "afford", "agree",
                "allow", "alter", "amaze", "analyze", "announce",
                "anxiety", "apologize", "appear", "apply", "approve",
                "argue", "arrive", "arrange", "assess", "assist",
                "assume", "attach", "attract", "avoid", "aware",
                "balance", "ban", "bear", "beat", "begin",
                "behave", "believe", "benefit", "betray", "blame"
        };

        // 初始化熟练词库（可以初始为空，通过游戏过程添加）
        ProficientChineseWords = new String[UnFamiliarChineseWords.length];
        ProficientEnglishWords = new String[UnFamiliarEnglishWords.length];

    }

    /*
       负责人：组员x
       功能：初始化商店道具
       参数：void
       返回值：void
   */
    private void initializeShopItems() {
        // 在此处完成代码
        shopItems = new String[]{
                "1-小型血瓶(50金币)：恢复1点生命值",
                "2-中型血瓶(100金币)：恢复2点生命值",
                "3-大型血瓶(200金币)：恢复3点生命值"
        };
    }


}


