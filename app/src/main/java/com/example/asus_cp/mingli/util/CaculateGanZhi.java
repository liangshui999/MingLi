package com.example.asus_cp.mingli.util;

import java.util.ArrayList;
import java.util.Calendar;
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

    public static final String YIN="阴";
    public static final String YANG="阳";
    public static final String JIN="金";
    public static final String MU="木";
    public static final String SHUI="水";
    public static final String HUO="火";
    public static final String TU="土";

    public static final String ZHENG_YIN="正印";
    public static final String PIAN_YIN="偏印";
    public static final String SHI_SHEN="食神";
    public static final String SHANG_GUAN="伤官";
    public static final String BI_JIAN="比肩";
    public static final String JIE_CAI="劫财";
    public static final String ZHENG_CAI="正财";
    public static final String PIAN_CAI="偏财";
    public static final String ZHENG_GUAN="正官";
    public static final String QI_SHA="七杀";


    public static final String JIA="甲";
    public static final String YI="乙";
    public static final String BING="丙";
    public static final String DING="丁";
    public static final String WU_TIAN_GAN="戊";
    public static final String JI="己";
    public static final String GENG="庚";
    public static final String XIN="辛";
    public static final String REN="壬";
    public static final String GUI="癸";

    public static final String ZI="子";
    public static final String CHOU="丑";
    public static final String YIN_DI_ZHI="寅";
    public static final String MAO="卯";
    public static final String CHEN="辰";
    public static final String SI="巳";
    public static final String WU_DI_ZHI="午";
    public static final String WEI="未";
    public static final String SHEN="申";
    public static final String YOU="酉";
    public static final String XU="戌";
    public static final String HAI="亥";

    public static final String MAN="男";
    public static final String WOMEN="女";

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
        tianGanWuXing.put(JIA,MU);
        tianGanWuXing.put(YI,MU);
        tianGanWuXing.put(BING,HUO);
        tianGanWuXing.put(DING,HUO);
        tianGanWuXing.put(WU_TIAN_GAN,TU);
        tianGanWuXing.put(JI,TU);
        tianGanWuXing.put(GENG,JIN);
        tianGanWuXing.put(XIN,JIN);
        tianGanWuXing.put(REN,SHUI);
        tianGanWuXing.put(GUI,SHUI);

        diZhiWuXing=new HashMap<String,String>();
        diZhiWuXing.put(ZI,SHUI);
        diZhiWuXing.put(CHOU,TU);
        diZhiWuXing.put(YIN_DI_ZHI,MU);
        diZhiWuXing.put(MAO,MU);
        diZhiWuXing.put(CHEN,TU);
        diZhiWuXing.put(SI, HUO);
        diZhiWuXing.put(WU_DI_ZHI,HUO);
        diZhiWuXing.put(WEI,TU);
        diZhiWuXing.put(SHEN,JIN);
        diZhiWuXing.put(YOU, JIN);
        diZhiWuXing.put(XU,TU);
        diZhiWuXing.put(HAI,SHUI);

        tianGanYinYang=new HashMap<String,String>();
        tianGanYinYang.put(JIA, YANG);
        tianGanYinYang.put(YI,YIN);
        tianGanYinYang.put(BING,YANG);
        tianGanYinYang.put(DING,YIN);
        tianGanYinYang.put(WU_TIAN_GAN, YANG);
        tianGanYinYang.put(JI, YIN);
        tianGanYinYang.put(GENG,YANG);
        tianGanYinYang.put(XIN,YIN);
        tianGanYinYang.put(REN, YANG);
        tianGanYinYang.put(GUI, YIN);

        diZhiYiYang=new HashMap<String,String>();
        diZhiYiYang.put(ZI,YANG);
        diZhiYiYang.put(CHOU, YIN);
        diZhiYiYang.put(YIN_DI_ZHI, YANG);
        diZhiYiYang.put(MAO, YIN);
        diZhiYiYang.put(CHEN,YANG);
        diZhiYiYang.put(SI, YIN);
        diZhiYiYang.put(WU_DI_ZHI, YANG);
        diZhiYiYang.put(WEI, YIN);
        diZhiYiYang.put(SHEN,YANG);
        diZhiYiYang.put(YOU, YIN);
        diZhiYiYang.put(XU, YANG);
        diZhiYiYang.put(HAI, YIN);

        diZhiCangGan=new HashMap<String,List<String>>();
        List<String> ziCangGan=new ArrayList<String>();
        ziCangGan.add(GUI);
        diZhiCangGan.put(ZI, ziCangGan);

        List<String> chouCangGan=new ArrayList<String>();
        chouCangGan.add(JI);
        chouCangGan.add(GUI);
        chouCangGan.add(XIN);
        diZhiCangGan.put(CHOU, chouCangGan);

        List<String> yinCangGan=new ArrayList<String>();
        yinCangGan.add(JIA);
        yinCangGan.add(BING);
        yinCangGan.add(WU_TIAN_GAN);
        diZhiCangGan.put(YIN_DI_ZHI, yinCangGan);

        List<String> maoCangGan=new ArrayList<String>();
        maoCangGan.add(YI);
        diZhiCangGan.put(MAO, maoCangGan);

        List<String> chenCangGan=new ArrayList<String>();
        chenCangGan.add(WU_TIAN_GAN);
        chenCangGan.add(YI);
        chenCangGan.add(GUI);
        diZhiCangGan.put(CHEN, chenCangGan);

        List<String> siCangGan=new ArrayList<String>();
        siCangGan.add(GENG);
        siCangGan.add(BING);
        siCangGan.add(WU_TIAN_GAN);
        diZhiCangGan.put(SI, siCangGan);

        List<String> wuCangGan=new ArrayList<String>();
        wuCangGan.add(DING);
        wuCangGan.add(JI);
        diZhiCangGan.put(WU_DI_ZHI, wuCangGan);

        List<String> weiCangGan=new ArrayList<String>();
        weiCangGan.add(JI);
        weiCangGan.add(DING);
        weiCangGan.add(YI);
        diZhiCangGan.put(WEI, weiCangGan);

        List<String> shenCangGan=new ArrayList<String>();
        shenCangGan.add(GENG);
        shenCangGan.add(REN);
        shenCangGan.add(WU_TIAN_GAN);
        diZhiCangGan.put(SHEN, shenCangGan);

        List<String> youCangGan=new ArrayList<String>();
        youCangGan.add(XIN);
        diZhiCangGan.put(YOU, youCangGan);

        List<String> xuCangGan=new ArrayList<String>();
        xuCangGan.add(WU_TIAN_GAN);
        xuCangGan.add(XIN);
        xuCangGan.add(DING);
        diZhiCangGan.put(XU, xuCangGan);

        List<String> haiCangGan=new ArrayList<String>();
        haiCangGan.add(REN);
        haiCangGan.add(JIA);
        diZhiCangGan.put(HAI, haiCangGan);



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

        String riGan = getRiGan(year1, month1, day1, hour1);
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
     * 用s1和s2进行比较，返回s1是s2的什么,s2是被比较的
     *
     */
    public String getRelationBetwwnGanZhi(String s1,String s2){
        String s1WuXing=tianGanWuXing.get(s1);
        String s2WuXing=tianGanWuXing.get(s2);
        String s1YinYang=tianGanYinYang.get(s1);
        String s2YinYang=tianGanYinYang.get(s2);
        switch (s2WuXing){
            case JIN:
                if(s1WuXing.equals(JIN)){       //金是金的比劫
                    if(s1YinYang.equals(s2YinYang)){
                        return BI_JIAN;
                    }else{
                        return JIE_CAI;
                    }
                }else if(s1WuXing.equals(MU)){  //木是金的财
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_CAI;
                    }else{
                        return  ZHENG_CAI;
                    }
                }else if(s1WuXing.equals(SHUI)){    //水是金的子孙
                    if(s1YinYang.equals(s2YinYang)){
                        return SHI_SHEN;
                    }else{
                        return SHANG_GUAN;
                    }
                }else if(s1WuXing.equals(HUO)){     //火是金的官杀
                    if(s1YinYang.equals(s2YinYang)){
                        return QI_SHA;
                    }else{
                        return ZHENG_GUAN;
                    }
                }else if(s1WuXing.equals(TU)){      //土是金的父母
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_YIN;
                    }else{
                        return ZHENG_YIN;
                    }
                }


            case MU:
                if(s1WuXing.equals(JIN)){       //金是木的官杀
                    if(s1YinYang.equals(s2YinYang)){
                        return QI_SHA;
                    }else{
                        return ZHENG_GUAN;
                    }
                }else if(s1WuXing.equals(MU)){  //木是木的比劫
                    if(s1YinYang.equals(s2YinYang)){
                        return BI_JIAN;
                    }else{
                        return  JIE_CAI;
                    }
                }else if(s1WuXing.equals(SHUI)){    //水是木的父母
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_YIN;
                    }else{
                        return ZHENG_YIN;
                    }
                }else if(s1WuXing.equals(HUO)){     //火是木的子孙
                    if(s1YinYang.equals(s2YinYang)){
                        return SHI_SHEN;
                    }else{
                        return SHANG_GUAN;
                    }
                }else if(s1WuXing.equals(TU)){      //土是木的财
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_CAI;
                    }else{
                        return ZHENG_CAI;
                    }
                }



            case SHUI:
                if(s1WuXing.equals(JIN)){       //金是水的父母
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_YIN;
                    }else{
                        return ZHENG_YIN;
                    }
                }else if(s1WuXing.equals(MU)){  //木是水的子孙
                    if(s1YinYang.equals(s2YinYang)){
                        return SHI_SHEN;
                    }else{
                        return  SHANG_GUAN;
                    }
                }else if(s1WuXing.equals(SHUI)){    //水是水的比劫
                    if(s1YinYang.equals(s2YinYang)){
                        return BI_JIAN;
                    }else{
                        return JIE_CAI;
                    }
                }else if(s1WuXing.equals(HUO)){     //火是水的财
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_CAI;
                    }else{
                        return ZHENG_CAI;
                    }
                }else if(s1WuXing.equals(TU)){      //土是水的官杀
                    if(s1YinYang.equals(s2YinYang)){
                        return QI_SHA;
                    }else{
                        return ZHENG_GUAN;
                    }
                }


            case HUO:
                if(s1WuXing.equals(JIN)){       //金是火的财
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_CAI;
                    }else{
                        return ZHENG_CAI;
                    }
                }else if(s1WuXing.equals(MU)){  //木是火的父母
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_YIN;
                    }else{
                        return  ZHENG_YIN;
                    }
                }else if(s1WuXing.equals(SHUI)){    //水是火的官杀
                    if(s1YinYang.equals(s2YinYang)){
                        return QI_SHA;
                    }else{
                        return ZHENG_GUAN;
                    }
                }else if(s1WuXing.equals(HUO)){     //火是火的比劫
                    if(s1YinYang.equals(s2YinYang)){
                        return BI_JIAN;
                    }else{
                        return JIE_CAI;
                    }
                }else if(s1WuXing.equals(TU)){      //土是火的子孙
                    if(s1YinYang.equals(s2YinYang)){
                        return SHI_SHEN;
                    }else{
                        return SHANG_GUAN;
                    }
                }


            case TU:
                if(s1WuXing.equals(JIN)){       //金是土的子孙
                    if(s1YinYang.equals(s2YinYang)){
                        return SHI_SHEN;
                    }else{
                        return SHANG_GUAN;
                    }
                }else if(s1WuXing.equals(MU)){  //木是土的官杀
                    if(s1YinYang.equals(s2YinYang)){
                        return   QI_SHA;
                    }else{
                        return  ZHENG_GUAN;
                    }
                }else if(s1WuXing.equals(SHUI)){    //水是土的财
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_CAI;
                    }else{
                        return ZHENG_CAI;
                    }
                }else if(s1WuXing.equals(HUO)){     //火是土的父母
                    if(s1YinYang.equals(s2YinYang)){
                        return PIAN_YIN;
                    }else{
                        return ZHENG_YIN;
                    }
                }else if(s1WuXing.equals(TU)){      //土是土的比劫
                    if(s1YinYang.equals(s2YinYang)){
                        return BI_JIAN;
                    }else{
                        return JIE_CAI;
                    }
                }
        }
        return null;
    }

    /**
     * 求取支的藏干
     */
    public List<String> getDiZhiCangGan(String str){
        return diZhiCangGan.get(str);
    }

    /**
     * 排大运，返回一个大运的集合
     * @param sex 性别,因为男女的大运排法正好是相反的
     * @return 几岁，什么大运
     */
    public Map<String,String> getDaYun(String year,String month,String day,String hour,String minute,String sex){
       Map<String,String>daYunMap=new HashMap<String,String>();

        String nianGanZhi=getYearGanZhi(year, month, day, hour, minute);
        String nianGan=getTianGanFromGanZhi(nianGanZhi);
        String nianGanYinYang=tianGanYinYang.get(nianGan);

        String nongLiNian=solarTerm.getNongLiYear(year, month, day, hour, minute);//获取农历年
        String nongLiYue=solarTerm.getNongLiMonth(year, month, day, hour, minute);//获取农历月

        Map<Integer,String> nongliNianJieQi=solarTerm.generateNoLiYear(nongLiNian);//获取该农历年的完整的节气时间

        String space=" ";
        String second="00";
        String stanMonth=solarTerm.getStandardTime(Integer.parseInt(month));
        String stanDay=solarTerm.getStandardTime(Integer.parseInt(day));
        String stanHour=solarTerm.getStandardTime(Integer.parseInt(hour));
        String stanMinute=solarTerm.getStandardTime(Integer.parseInt(minute));

        String bornDateString=year+"-"+stanMonth+"-"+stanDay+space+stanHour+":"+stanMinute+":"+second;
        String pattern="yyyy-MM-dd HH:mm:ss";

        Calendar bornDateCalendar=solarTerm.convertStringToCalendar(bornDateString,pattern);//出生时间的calendar对象


        switch (sex){
            case MAN:
                if(nianGan.equals(YANG)){   //顺行
                    String nextBornYueJieQiString=nongliNianJieQi.get(Integer.parseInt(nongLiYue) + 1);
                    Calendar nextBornJieQiCalendar=solarTerm.convertStringToCalendar(nextBornYueJieQiString, pattern);
                    Calendar daYunCalendar=getQiDaYun(bornDateCalendar,nextBornJieQiCalendar);//交运的时间
                    int daYunNian=daYunCalendar.YEAR;
                    String daYunGanZhi=getYearGanZhi(daYunCalendar.YEAR+"",daYunCalendar.MONTH+1+"",
                            daYunCalendar.DAY_OF_MONTH+"",daYunCalendar.HOUR_OF_DAY+"",daYunCalendar.MINUTE+""
                    );
                    daYunMap.clear();
                    for(int i=0;i<8;i++){
                        int index=getIndex(huaJia,daYunGanZhi);
                        daYunMap.put(daYunNian+10*i+"",huaJia[index]);
                        index=index+1;
                        if(index==60){
                            index=0;
                        }
                    }


                }else{      //逆行

                }
                break;
            case WOMEN:
                if(nianGan.equals(YIN)){   //顺行

                }else{      //逆行

                }
                break;
        }
        return null;
    }

    /**
     *计算起大运的准确时间
     */
    public Calendar getQiDaYun(Calendar calendar1,Calendar calendar2){
        Calendar calendar=Calendar.getInstance();
        long time=calendar1.getTimeInMillis()+Math.abs(calendar1.getTimeInMillis() - calendar2.getTimeInMillis())*120;
        calendar.setTimeInMillis(time);
        return calendar;
    }




}
