package com.wordgame.model;


// 角色类：闯关模式角色信息
public class Role {
    private String name;        // 角色名称
    private int hp;             // 生命值（初始3，升级可提升）
    private int gold;           // 金币（用于商店购买）
    private int exp;            // 经验值（用于升级）
    private int level;          // 等级（1-3级，核心上限）
    private String skill;       // 角色技能

    public Role() {
    }
    public Role(String name, int hp, int gold, int exp, int level, String skill) {
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.exp = exp;
        this.level = level;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
