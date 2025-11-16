package com.wordgame.service;
import com.wordgame.main.Main;
import com.wordgame.model.Word;
import com.wordgame.service.WordService;

import java.util.Random;

public class WordService {
    private static Random r = new Random();
    private static GameService gameService = Main.gameService;
    //创建一个Word的对象来获取中英文
    Word word = new Word();

    //创建四个词库分别存储陌生单词库的单词和熟练词库的单词
    private static String[] unFamiliarChineseWords = gameService.getUnFamiliarChineseWords();
    private static String[] unFamiliarEnglishWords = gameService.getUnFamiliarEnglishWords();
    private static String[] familiarChineseWords = gameService.getProficientChineseWords();
    private static String[] familiarEnglishWords = gameService.getProficientEnglishWords();

    //创建熟练度数组
    private static int[] wordProficiency=new int[unFamiliarEnglishWords.length];
    //创建两个布尔数组来标记随机的单词是否出现过,判断数组的每一个索引和词库的单词是一一对应的
    //利用static标识符保证这些变量只被初始化一次(防止每次创建WordService的对象的时候都会将数据初始化)
    private  static boolean[] unFamiliarUsed=new boolean[unFamiliarChineseWords.length];//每一个索引的布尔值对应词库的单词是否出现过
    private  static boolean[] familiarUsed=new boolean[familiarChineseWords.length];//机制和上面的同理
    private  static int familiarUsedCount=0;//统计熟悉词库使用的次数,这里主要是为了判断单词是否全部用完
    private  static int unFamiliarUsedCount=0;//统计不熟悉词库使用的次数,和上面同理

    //创建一个熟练词库的索引
    // 主要用于后续能够将陌生词库的单词添加到熟练词库且保证索引不会因为在方法中定义而每次归0
    private static int i = 0;

    /*
       负责人：组员x
       功能：获取当前模式的下一个单词
       参数：void
       返回值：Word: 待答题的单词（根据模式从对应题库抽取）
   */
    public static Word getNextWord() {
        // 在此处完成代码：经典/快速模式从陌生题库，复习模式从熟练题库，闯关模式从陌生题库
        //获取当前模式是啥
        int currentMode = gameService.getCurrentMode();

        //利用Switch来根据不同的模式选择对应的单词库

        switch (currentMode) {
            case 1:
                return getUnFamiliarWord();

            case 2:
                return getUnFamiliarWord();

            case 3:
                return getFamiliarWord();

            case 5:
                return getUnFamiliarWord();

            default:
                return new Word("null","错误输入",0);
        }
    }
    //实现从陌生词库获得一个随机但是不重复的单词
    private static Word getUnFamiliarWord() {
        //设置一个随机索引
        int randomIndex;
        //如果陌生词库的单词都出现过，那么则重置标记情况
        if (unFamiliarUsedCount >= unFamiliarEnglishWords.length) {

            reSetUnFamiliarUsed(unFamiliarUsed);
        }

        //考虑这样一种逻辑，如果随机出来的索引被用过了，那么就继续随机，这里就用do while
        do {
            randomIndex = r.nextInt(unFamiliarChineseWords.length);

        } while (unFamiliarUsed[randomIndex]);//这里把随机到的索引给到判断数组，判断索引是否已经使用过
        Word word = new Word(unFamiliarEnglishWords[randomIndex],unFamiliarChineseWords[randomIndex],wordProficiency[randomIndex]);

        unFamiliarUsedCount++;//单词库使用次数+1
        unFamiliarUsed[randomIndex]=true;//标记该索引的单词已经被引用过

        //设置该单词的索引位置
        word.setUnFamiliarIndex(randomIndex);
        return word;
    }
    //实现从熟练词库获得一个随机但是不重复的单词
    private static Word getFamiliarWord() {
        //设置一个随机索引
        int randomIndex;

        //判断熟练词库是否为空
        if (familiarEnglishWords == null || familiarEnglishWords.length == 0) {

            return new Word("empty", "词库为空", 0);

        }

        //如果熟练词库的单词都使用过，那么就重置标记情况
        if (familiarUsedCount >= familiarEnglishWords.length) {

            reSetFamiliarUsed(familiarUsed);

        }
        do{

            randomIndex=r.nextInt(familiarChineseWords.length);

        }while(familiarUsed[randomIndex]);

        Word word=new Word(familiarEnglishWords[randomIndex],familiarChineseWords[randomIndex],wordProficiency[randomIndex]);

        familiarUsedCount++;//熟练词库使用次数+1
        familiarUsed[randomIndex]=true;//标记该索引的单词已经被引用过

        //设置该单词的索引
        word.setFamiliarIndex(randomIndex);
        return word;
    }
    //重置熟练词库的使用情况
    private static void reSetFamiliarUsed(boolean[] familiarUsed) {

        if (familiarUsed != null) {
            for (int i = 0; i < familiarUsed.length; i++) {
                familiarUsed[i] = false;
            }
        }

        familiarUsedCount = 0;
    }
    //重置不熟练词库的使用情况
    private static void reSetUnFamiliarUsed(boolean[] unFamiliarUsed){
        if(unFamiliarUsed!=null){
            for(int i=0;i<unFamiliarUsed.length;i++){
                unFamiliarUsed[i]=false;
            }
        }
        unFamiliarUsedCount=0;
    }
    //初始化熟练度为0
    public static void reSetProficiency(int[] proficiency) {
        for (int i = 0; i < proficiency.length; i++) {
            proficiency[i] = 0;
        }
    }
    /*
      负责人：组员x
      功能：答题结果判断与数据更新
      参数：
          word: 当前答题单词
          userAnswer: 用户输入的中文释义（认识时需输入）
          isKnown: 是否认识（1-认识 2-不认识）
      返回值：
          0: 答错/不认识
          1: 答对
  */
    public static int judgeAnswer(Word word, String userAnswer, int isKnown) {
        // 在此处完成代码：更新熟练度、题库归属、答题统计
        //判断用户选择的模式
        int selectedMode = gameService.getCurrentMode();
        //先判断用户认不认识该单词
        //认识，判断用户选择的那个模式
        if (isKnown == 1) {
            //判断使用那个词库
            // //1-经典 2-快速 3-复习 5-闯关
            switch(selectedMode){
                //经典模式，从陌生词库里面寻找正确答案
                case 1:
                    //判断用户的回答是否正确
                    if(word.getChinese().equals(userAnswer)){
                        //判断该单词的熟练度是否在[0,5)之间
                        if(wordProficiency[word.getUnFamiliarIndex()]>=0 && wordProficiency[word.getUnFamiliarIndex()]<5) {
                            //在该范围内则增加熟练度
                            wordProficiency[word.getUnFamiliarIndex()]++;
                        }
                        //如果大于等于5那么直接将该单词移送到熟练词库
                        else if(wordProficiency[word.getUnFamiliarIndex()]>=5) {

                            familiarEnglishWords[i]=word.getEnglish();
                            familiarChineseWords[i]=word.getChinese();
                            //这里不需要考虑i是否会越界，因为上面两个数组的长度和陌生词库的长度相同
                            i++;//每次添加一个新的单词就自增
                        }
                        //忘记返回1
                        return 1;
                    }
                    //错误返回0
                    else{
                        return 0;
                    }
                case 2:
                    //快速模式，在陌生词库里面寻找对应的单词
                    //认识,直接将单词归纳到熟练词库
                    familiarEnglishWords[i] = word.getEnglish();
                    familiarChineseWords[i] = word.getChinese();
                    i++;//每次添加一个新的单词就自增
                    return 1;
                case 3:
                    //复习模式:只读取熟练词库的单词，不对熟练度做任何修改
                    if(word.getChinese().equals(userAnswer)){
                        //正确返回1
                        return 1;
                    }
                    //错误直接返回0
                    else{
                        return 0;
                    }
                case 5:
                    //闯关模式
                    //和经典模式相同
                    //判断用户的回答是否正确
                    if(word.getChinese().equals(userAnswer)){
                        //判断该单词的熟练度是否在[0,5)之间
                        if(wordProficiency[word.getUnFamiliarIndex()]>=0 && wordProficiency[word.getUnFamiliarIndex()]<5) {
                            //在该范围内则增加熟练度
                            wordProficiency[word.getUnFamiliarIndex()]++;
                        }

                        //如果大于等于5那么直接将该单词移送到熟练词库
                        else if(wordProficiency[word.getUnFamiliarIndex()]>=5) {

                            familiarEnglishWords[i]=word.getEnglish();
                            familiarChineseWords[i]=word.getChinese();
                            //这里不需要考虑i是否会越界，因为上面两个数组的长度和陌生词库的长度相同
                            i++;//每次添加一个新的单词就自增

                        }
                        //忘记返回1
                        return 1;
                    }
                    //错误返回0
                    else{return 0;}
            }
        }

        //不认识，直接返回0
        else if (isKnown == 2) {
            return 0;
        }
        return 0;
    }
}
