package com.example.asus_cp.mingli.util;

/**
 * Created by asus-cp on 2016-04-24.
 */
public class CaculateGanZhi {

    //天干的数组
    private String[] tianGan=new String[]{"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};

    //地支的数组
    private String[] diZhi=new String[]{"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};

    //六十花甲的数组
    private String[] huaJia;

    //生成24节气的一个对象
    private SolarTerm solarTerm;

    public CaculateGanZhi(){
        solarTerm=new SolarTerm();
        createHuaJia();
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
    public String convertYearToGanZhi(String year1, String month, String day, String hour, String minute){
        String year=solarTerm.getYear(year1,month,day,hour,minute);
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
    public String getYearTianGanFromGanZhi(String ganZhi){
        if(ganZhi!=null&& !ganZhi.isEmpty()){
            return String.valueOf(ganZhi.charAt(0));
        }
        return null;
    }

    /**
     *
     * 根据天干地支返回地支的值,比如甲午返回的是午
     */
    public String getYearDiZhiFromGanZhi(String ganZhi){
        if(ganZhi!=null&& !ganZhi.isEmpty()){
            return String.valueOf(ganZhi.charAt(1));
        }
        return null;
    }

    /**
     *
     * 把月份转换成干支，比如甲午年的1月转换成干支就是丙寅月
     * @param year 年份，如1990年
     * @param month 月份，如1月
     */
    public String convertMonthToGanZhi(String year,String month,String day,String hour,String minute){
        String m=solarTerm.getNongLiMonth(year, month, day, hour, minute);
//        if(Integer.parseInt(m)>500){
//            //要重新计算年份
//            return getMonthGanZhi(year,Integer.parseInt(m)-500+"");
//        }
        return getMonthGanZhi(year,m,day,hour,minute);
    }

    /**
     * 根据年和月，求取月的干支
     */
    public String getMonthGanZhi(String year, String month,String day,String hour,String minute){
        String yearTianGan=getYearTianGanFromGanZhi(convertYearToGanZhi(year,month,day,hour,minute));
        int m=Integer.parseInt(month);
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
    public String getRiGan(String year1,String month1,String day1){
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
     * 计算支的算法
     */
    public String getRiZhi(String year1, String month1, String day1){
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
    public String getRiGanZhi(String year, String month, String day){
        return getRiGan(year,month,day)+getRiZhi(year, month, day);
    }

    /**
     * 计算时支
     */
    public String getHourZhi(String hour1){
        int hour=Integer.parseInt(hour1);
        //大于23是明天的子时，日干支需重新进行计算
        if(hour>23){
            return "第二天";
        }else if(hour>=0&&hour<1){
            return "子";
        }else if(hour>=1 && hour<3){
            return "丑";
        }
        else if(hour>=3 && hour<5){
            return "寅";
        }
        else if(hour>=5 && hour<7){
            return "卯";
        }
        else if(hour>=7 && hour<9){
            return "辰";
        }
        else if(hour>=9 && hour<11){
            return "巳";
        }
        else if(hour>=11 && hour<=13){
            return "午";
        }
        else if(hour>13 && hour<15){
            return "未";
        }
        else if(hour>15 && hour<17){
            return "申";
        }
        else if(hour>17 && hour<19){
            return "酉";
        }
        else if(hour>19 && hour<21){
            return "戌";
        }
        else if(hour>21 && hour<23){
            return "亥";
        }
        return null;
    }

    /**
     * 计算时干支
     */
    public String getHourGanZhi(String year1, String month1, String day1, String hour1){
        int hour=Integer.parseInt(hour1);
        //大于23算第二天
        if(hour>23){
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

        String riGan = getRiGan(year1, month1, day1);
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


}
