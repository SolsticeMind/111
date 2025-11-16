package com.wordgame.model;

// 游戏统计数据
public class GameStats {
    // 总答题数
    private int totalCount;
    // 正确答题数
    private int correctCount;
    // 正确率（保留两位小数）
    private double accuracy;
    // 当前关卡（闯关/无尽模式用）
    private int currentLevel;

    public GameStats() {
    }

    public GameStats(int totalCount, int correctCount, double accuracy, int currentLevel) {
        this.totalCount = totalCount;
        this.correctCount = correctCount;
        this.accuracy = accuracy;
        this.currentLevel = currentLevel;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
