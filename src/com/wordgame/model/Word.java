package com.wordgame.model;
// 单词类：存储单词核心信息
public class Word {
    // 英文单词
    private String english;
    // 中文释义
    private String chinese;
    // 熟练度（0-5，经典模式用）
    private int proficiency;
    private int familiarIndex;
    private int unFamiliarIndex;

    public int getFamiliarIndex() {
        return familiarIndex;
    }

    public void setFamiliarIndex(int familiarIndex) {
        this.familiarIndex = familiarIndex;
    }

    public int getUnFamiliarIndex() {
        return unFamiliarIndex;
    }

    public void setUnFamiliarIndex(int unFamiliarIndex) {
        this.unFamiliarIndex = unFamiliarIndex;
    }

    public Word() {
    }

    public Word(String english, String chinese, int proficiency) {
        this.english = english;
        this.chinese = chinese;
        this.proficiency = proficiency;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
}
