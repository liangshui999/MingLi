package com.example.asus_cp.mingli.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus-cp on 2016-04-24.
 */
public class CaculateGanZhi {

    private String tag="CaculateGanZhi";

    //天干的数组
    private String[] tianGan=new String[]{"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};

    //地支的数组
    private String[] diZhi=new String[]{"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};

    //六十花甲的数组
    private String[] huaJia;

    //生成24节气的一个对象
    private SolarTerm solarTerm;

    //记录天干五行属性的集合
    private Map<String,String> tianGanWuXing;

    //记录地支五行属性的集合
    private Map<String,String>diZhiWuXing;

    //记录天干的阴阳属性的集合
    private Map<String,String>tianGanYinYang;

    //记录地支阴阳属性的集合
    private Map<String,String>diZhiYiYang;

    //记录地支藏干的集合
    private Map<String,List<String>>diZhiCangGan;

    public CaculateGanZhi(){
        solarTerm=new SolarTerm();
        createHuaJia();
        init();
    }
    /**
     * 初始化的方法
     */
    public void init(){
        tianGanWuXing=new HashMap<String,String>();
        tianGanWuXing.put("甲","木");
        tianGanWuXing.put("乙","木");
        tianGanWuXing.put("丙","火");
        tianGanWuXing.put("丁","火");
        tianGanWuXing.put("戊","土");
        tianGanWuXing.put("己","土");
        tianGanWuXing.put("庚","金");
        tianGanWuXing.put("辛","金");
        tianGanWuXing.put("壬","水");
        tianGanWuXing.put("癸","水");

        diZhiWuXing=new HashMap<String,String>();
        diZhiWuXing.put("子","水");
        diZhiWuXing.put("丑","土");
        diZhiWuXing.put("寅","木");
        diZhiWuXing.put("卯","木");
        diZhiWuXing.put("辰","土");
        diZhiWuXing.put("巳","火");
        diZhiWuXing.put("午","火");
        diZhiWuXing.put("未","土");
        diZhiWuXing.put("申","金");
        diZhiWuXing.put("酉","金");
        diZhiWuXing.put("戌","土");
        diZhiWuXing.put("亥","水");

        tianGanYinYang=new HashMap<String,String>();
        tianGanYinYang.put("甲","阳");
        tianGanYinYang.put("乙","阴");
        tianGanYinYang.put("丙","阳");
        tianGanYinYang.put("丁","阴");
        tianGanYinYang.put("戊","阳");
        tianGanYinYang.put("己","阴");
        tianGanYinYang.put("庚","阳");
        tianGanYinYang.put("辛","阴");
        tianGanYinYang.put("壬","阳");
        tianGanYinYang.put("癸","阴");

        diZhiYiYang=new HashMap<String,String>();
        diZhiYiYang.put("子","阳");
        diZhiYiYang.put("丑","阴");
        diZhiYiYang.put("寅","阳");
        diZhiYiYang.put("卯","阴");
        diZhiYiYang.put("辰","阳");
        diZhiYiYang.put("巳","阴");
        diZhiYiYang.put("午","阳");
        diZhiYiYang.put("未","阴");
        diZhiYiYang.put("申","阳");
        diZhiYiYang.put("酉","阴");
        diZhiYiYang.put("戌","阳");
        diZhiYiYang.put("亥","阴");
    }

    /**
     * 生成六十花甲的方法
     *
     */
    public void createHuaJia(){
        huaJia=new String[60];
        int i=0;
        int j=0;
        for(int m=0;m<60;m++){
            if(i>=10){
                i=i-10;
            }
            if(j>=12){
                j=j-12;
            }
            huaJia[m]=tianGan[i++]+diZhi[j++];
        }
    }

    /**
     * 把年转换成天干地支,比如把1990年转换成庚午
     *
     */
    public String getYearGanZhi(String year1, String month, String day, String hour, String minute){
        String year=solarTerm.getNongLiYear(year1, month, day, hour, minute);//根据用户输入的年份，返回对应的农历年份
        int y=Integer.parseInt(year);
        int index=y-1924;
        while(index>=60){
            index=index-60;
        }
        return huaJia[index];
    }

    /**
     *
     * 根据天干地支返回天干的值,比如甲午返回的是甲
     */
    public String getTianGanFromGanZhi(String ganZhi){
        if(ganZhi!=null&& !ganZhi.isEmpty()){
            return String.valueOf(ganZhi.charAt(0));
        }
        return null;
    }

    /**
     *
     * 根据天干地支返回地支的值,比如甲午返回的是午
     */
    public String getDiZhiFromGanZhi(String ganZhi){
        if(ganZhi!=null&& !ganZhi.isEmpty()){
            return String.valueOf(ganZhi.charAt(1));
        }
        return null;
    }



    /**
     * 根据年月日时分秒,，求取月的干支
     */
    public String getMonthGanZhi(String year,String month,String day,
                                 String hour,String minute){
        String zhuanHuanHouMonth=solarTerm.getNongLiMonth(year, month, day, hour, minute);
        String yearToGanZhi= getYearGanZhi(year, month, day, hour, minute);//必须根据真实月份求年干支，而不是转换后的月份
        String yearTianGan= getTianGanFromGanZhi(yearToGanZhi);
        int m=0;
        if(zhuanHuanHouMonth!=null && !zhuanHuanHouMonth.isEmpty()){
            m=Integer.parseInt(zhuanHuanHouMonth);
        }
        int dif=m-1;
        int oneMonthIndex=0;
        if(yearTianGan.equals("甲")||yearTianGan.equals("己")){
            oneMonthIndex=getIndex(huaJia,"丙寅");
            return huaJia[oneMonthIndex+dif];
        }else if(yearTianGan.equals("乙")||yearTianGan.equals("庚")){
            oneMonthIndex=getIndex(huaJia,"戊寅");
            return huaJia[oneMonthIndex+dif];
        }
        else if(yearTianGan.equals("丙")||yearTianGan.equals("辛")){
            oneMonthIndex=getIndex(huaJia,"庚寅");
            return huaJia[oneMonthIndex+dif];
        }
        else if(yearTianGan.equals("丁")||yearTianGan.equals("壬")){
            oneMonthIndex=getIndex(huaJia,"壬寅");
            return huaJia[oneMonthIndex+dif];
        }
        else if(yearTianGan.equals("戊")||yearTianGan.equals("癸")){
            oneMonthIndex=getIndex(huaJia,"甲寅");
            return huaJia[oneMonthIndex+dif];
        }
        return null;
    }

    /**
     * 求某个元素在数组里面的索引
     */
    public int getIndex(String[] s,String str){
        for(int i=0;i<s.length;i++){
            if(s[i].equals(str)){
               return i;
            }
        }
        return -1;
    }

    /**
     * 计算世纪数
     */
    public int caculateShiJiShu(String year1){
        int year=Integer.parseInt(year1);
        return year/100+1;
    }
    /**
     * 计算年份后两位
     */
    public int cacalateLastTwo(String year1){
        int year=Integer.parseInt(year1);
        int first=year/1000;
        int second=(year-first*1000)/100;
        int lastTwo=year-first*1000-second*100;
        return lastTwo;
    }

    /**
     * 计算日干的算法
     */
    public String getRiGan(String year1,String month1,String day1,String hour1){
        if(Integer.parseInt(hour1)>=23){    //大于23就算第二天了
            day1=Integer.parseInt(day1)+1+"";
        }
        int year=Integer.parseInt(year1);
        int month=Integer.parseInt(month1);
        int day=Integer.parseInt(day1);
        if(month<=2){
            month=month+12;
            year=year-1;
        }
        int c=caculateShiJiShu(year+"")-1;
        int y=cacalateLastTwo(year+"");
        int result=(4*c+c/4+5*y+y/4+3*(month+1)/5+day-3)%10;
        if(result==0){
            result=10;
        }
        return tianGan[result-1];

        //G = 4C + [C / 4] + 5y + [y / 4] + [3 * (M + 1) / 5] + d - 3
    }


    /**
     * 计算日支的算法
     */
    public String getRiZhi(String year1, String month1, String day1,String hour1){
        if(Integer.parseInt(hour1)>=23){
            day1=Integer.parseInt(day1)+1+"";
        }
        int year=Integer.parseInt(year1);
        int month=Integer.parseInt(month1);
        int day=Integer.parseInt(day1);
        if(month<=2){
            month=month+12;
            year=year-1;
        }
        int c=caculateShiJiShu(year+"")-1;
        int y=cacalateLastTwo(year+"");
        int i=0;
        if(month%2==0){
            i=6;
        }
        int result=(8*c+c/4+5*y+y/4+3*(month+1)/5+day+7+i)%12;
        if(result==0){
            result=12;
        }
                ;
        return diZhi[result-1];
        //Z = 8C + [C / 4] + 5y + [y / 4] + [3 * (M + 1) / 5] + d + 7 + i
    }

    /**
     * 计算日干支
     */
    public String getRiGanZhi(String year, String month, String day,String hour){
        return getRiGan(year,month,day,hour)+getRiZhi(year, month, day,hour);
    }



    /**
     * 计算时干支
     */
    public String getHourGanZhi(String year1, String month1, String day1, String hour1){
        int hour=Integer.parseInt(hour1);
        //大于23算第二天
        if(hour>=23){
            int day=Integer.parseInt(day1);
            day=day+1;
            hour=0;
            getHourGanZhi(year1, month1, day + "", hour + "");
        }
        int dif=0;
        if(hour%2==0){
            dif=hour/2;
        }else {
            dif=hour/2+1;
        }

        String riGan = getRiGan(year1, month1, day1,hour1);
        int firstIndex=0;
        if(riGan.equals("甲")||riGan.equals("己")){
            firstIndex=getIndex(huaJia,"甲子");
            return huaJia[firstIndex+dif];
        }else if(riGan.equals("乙")||riGan.equals("庚")){
            firstIndex=getIndex(huaJia,"丙子");
            return huaJia[firstIndex+dif];
        }
        else if(riGan.equals("丙")||riGan.equals("辛")){
            firstIndex=getIndex(huaJia,"戊子");
            return huaJia[firstIndex+dif];
        }
        else if(riGan.equals("丁")||riGan.equals("壬")){
            firstIndex=getIndex(huaJia,"庚子");
            return huaJia[firstIndex+dif];
        }
        else if(riGan.equals("戊")||riGan.equals("癸")){
            firstIndex=getIndex(huaJia,"壬子");
            return huaJia[firstIndex+dif];
        }
        return null;
    }

    /**
     * 返回给定的2个干支之间的关系,比如甲和丙的关系是木生火，则返回“印”，
     * 另外甲和丙都是阳的，所以应该返回偏印
     * 用s1和s2进行比较，返回s1是s2的什么
     *
     */
    public String getRelationBetwwnGanZhi(String s1,String s2){
        return null;
    }



}
