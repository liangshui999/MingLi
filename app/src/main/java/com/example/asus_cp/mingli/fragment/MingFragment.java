package com.example.asus_cp.mingli.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.custumview.WheelView;
import com.example.asus_cp.mingli.util.CaculateGanZhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus-cp on 2016-04-21.
 */
public class MingFragment extends Fragment implements View.OnClickListener {
    private String tag="MingFragment";
    private Context context;
    private List<String> years;
    private List<String> months;
    private List<String> days;
    private List<String> hours;
    private List<String> minutes;
    private int firstYear=1950;//年的初始值
    private int firstExcepteYear=1;//除了年以外的，其他的初始值
    private int firstHourAndMinute=0;//小时和分钟的初始值


    public static final int OFFSET=0;//控制时间区域的高度，有几行，如果等于2则上面有2行，下面有2行，总共是4行

    private CaculateGanZhi caculateGanZhi;//工具类的对象

    private String year=1950+"";//用户选择的年数据
    private String month=1+"";//用户选择的月数据
    private String day=1+"";//用户选择的日数据
    private String hour=0+"";//用户选择的时数据
    private String minute=0+"";//用户选择的分钟数据

    private Button paiBaZi;
    private TextView nianZhu;
    private TextView yueZhu;
    private TextView riZhu;
    private TextView shiZhu;

    private TextView textNianShiShen;//年的十神
    private TextView textYueShiShen;//月的十神
    private TextView textShiShiShen;//时的十神

    private TextView textNianCangGan;//年的藏干
    private TextView textYueCangGan;//年的藏干
    private TextView textRiCangGan;//年的藏干
    private TextView textShiCangGan;//年的藏干

    private RadioGroup radioGroup;
    private RadioButton radioButton;//选中的radiobutton

    private View v;//碎片的布局view



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        context=getContext();
        v=View.inflate(getContext(), R.layout.ming_fragment_layout, null);
//        Button date= (Button) v.findViewById(R.id.btn_date_piker);
//        Button time= (Button) v.findViewById(R.id.btn_time_piker);
        paiBaZi= (Button) v.findViewById(R.id.btn_pai_bazi);
        nianZhu= (TextView) v.findViewById(R.id.text_nianzhu);
        yueZhu= (TextView) v.findViewById(R.id.text_yuezhu);
        riZhu= (TextView) v.findViewById(R.id.text_rizhu);
        shiZhu= (TextView) v.findViewById(R.id.text_shizhu);

        textNianShiShen= (TextView) v.findViewById(R.id.text_nian_shi_shen);
        textYueShiShen= (TextView) v.findViewById(R.id.text_yue_shi_shen);
        textShiShiShen= (TextView) v.findViewById(R.id.text_shi_shi_shen);

        textNianCangGan= (TextView) v.findViewById(R.id.text_nian_cang_gan);
        textYueCangGan= (TextView) v.findViewById(R.id.text_yue_cang_gan);
        textRiCangGan= (TextView) v.findViewById(R.id.text_ri_cang_gan);
        textShiCangGan= (TextView) v.findViewById(R.id.text_shi_cang_gan);

        radioGroup= (RadioGroup) v.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new MyCheckedChangeLister());

        WheelView wheelViewYear= (WheelView) v.findViewById(R.id.whe_year);
        WheelView wheelViewMonth= (WheelView) v.findViewById(R.id.whe_month);
        WheelView wheelViewDay= (WheelView) v.findViewById(R.id.whe_day);
        WheelView wheelViewHour= (WheelView) v.findViewById(R.id.whe_hour);
        WheelView wheelViewMinute= (WheelView) v.findViewById(R.id.whe_minute);

        wheelViewYear.setOffset(OFFSET);
        wheelViewYear.setItems(years);
        wheelViewYear.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                year=item.trim();//免得有空格之类的，到时候解析不出来
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewMonth.setOffset(OFFSET);
        wheelViewMonth.setItems(months);
        wheelViewMonth.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                month=item.trim();//免得有空格之类的，到时候解析不出来
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewDay.setOffset(OFFSET);
        wheelViewDay.setItems(days);
        wheelViewDay.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                day=item.trim();//免得有空格之类的，到时候解析不出来
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewHour.setOffset(OFFSET);
        wheelViewHour.setItems(hours);
        wheelViewHour.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                hour=item.trim();//免得有空格之类的，到时候解析不出来
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewMinute.setOffset(OFFSET);
        wheelViewMinute.setItems(minutes);
        wheelViewMinute.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                minute=item.trim();//免得有空格之类的，到时候解析不出来
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });
//        date.setOnClickListener(this);
//        time.setOnClickListener(this);
        paiBaZi.setOnClickListener(this);
        return v;

    }

    /**
     * 初始化的方法
     */
    public void init(){
        years=new ArrayList<String>();
        months=new ArrayList<String>();
        days=new ArrayList<String>();
        hours=new ArrayList<String>();
        minutes=new ArrayList<String>();
        fuZhi(years,200,firstYear);
        fuZhi(months,12,firstExcepteYear);
        fuZhi(days,31,firstExcepteYear);
        fuZhi(hours,24,firstHourAndMinute);
        fuZhi(minutes, 60, firstHourAndMinute);
        caculateGanZhi=new CaculateGanZhi();

    }

    /**
     * 给年月日时分秒赋值的通用方法
     * @param max 需要赋值的最大范围
     * @param first 初始值
     */
    public void fuZhi(List<String> list,int max,int first){
        for(int i=0;i<max;i++){
            list.add(""+first++);
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pai_bazi:
                //求取年月日时的干支
                String nianGanZhi=caculateGanZhi.getYearGanZhi(year, month, day, hour, minute);
                String yueGanZhi=caculateGanZhi.getMonthGanZhi(year, month, day, hour, minute);
                String riGanZhi=caculateGanZhi.getRiGanZhi(year, month, day, hour);
                String shiGanZhi=caculateGanZhi.getHourGanZhi(year, month, day, hour);

                //求取年月日时的干和支
                String nianGan=caculateGanZhi.getTianGanFromGanZhi(nianGanZhi);
                String nianZhi=caculateGanZhi.getDiZhiFromGanZhi(nianGanZhi);
                String yueGan=caculateGanZhi.getTianGanFromGanZhi(yueGanZhi);
                String yueZhi=caculateGanZhi.getDiZhiFromGanZhi(yueGanZhi);
                String riGan=caculateGanZhi.getTianGanFromGanZhi(riGanZhi);
                String riZhi=caculateGanZhi.getDiZhiFromGanZhi(riGanZhi);
                String shiGan=caculateGanZhi.getTianGanFromGanZhi(shiGanZhi);
                String shiZhi=caculateGanZhi.getDiZhiFromGanZhi(shiGanZhi);

                //求年干，月干，时干的十神
                String nianGanShiShen=caculateGanZhi.getRelationBetwwnGanZhi(nianGan, riGan);
                String yueGanShiShen=caculateGanZhi.getRelationBetwwnGanZhi(yueGan,riGan);
                String shiGanShiShen=caculateGanZhi.getRelationBetwwnGanZhi(shiGan,riGan);

                //求年支藏干，月支藏干，日支藏干，时支藏干
                List<String> nianZhiCangGan=caculateGanZhi.getDiZhiCangGan(nianZhi);
                List<String> yueZhiCangGan=caculateGanZhi.getDiZhiCangGan(yueZhi);
                List<String> riZhiCangGan=caculateGanZhi.getDiZhiCangGan(riZhi);
                List<String> shiZhiCangGan=caculateGanZhi.getDiZhiCangGan(shiZhi);

                //给八字的四柱赋值
                nianZhu.setText(convertBaZhiDirection(nianGanZhi));
                yueZhu.setText(convertBaZhiDirection(yueGanZhi));
                riZhu.setText(convertBaZhiDirection(riGanZhi));
                shiZhu.setText(convertBaZhiDirection(shiGanZhi));

                //给天干十神赋值
                textNianShiShen.setText(nianGanShiShen);
                textYueShiShen.setText(yueGanShiShen);
                textShiShiShen.setText(shiGanShiShen);

                //给地支藏干赋值
                textNianCangGan.setText(getCangGanFromList(nianZhiCangGan));
                textYueCangGan.setText(getCangGanFromList(yueZhiCangGan));
                textRiCangGan.setText(getCangGanFromList(riZhiCangGan));
                textShiCangGan.setText(getCangGanFromList(shiZhiCangGan));

                break;
//            case R.id.btn_date_piker:
//                Calendar c = Calendar.getInstance();
//                int year = c.get(Calendar.YEAR);
//                int month = c.get(Calendar.MONTH);
//                int day = c.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog datePickerDialog=new DatePickerDialog(context,this,year,month,day);
//                datePickerDialog.show();
//                break;
//            case R.id.btn_time_piker:
//                Calendar c1 = Calendar.getInstance();
//                int hour = c1.get(Calendar.HOUR_OF_DAY);
//                int minute = c1.get(Calendar.MINUTE);
//                TimePickerDialog timePickerDialog=new TimePickerDialog(context,this,hour,minute,true);
//                timePickerDialog.show();
//                break;
        }
    }

    /**
     * 将横向的八字转换成竖向的八字
     */
    public String convertBaZhiDirection(String str){
        String tianGan=caculateGanZhi.getTianGanFromGanZhi(str);
        String diZhi=caculateGanZhi.getDiZhiFromGanZhi(str);
        String ganZhi=tianGan+"\n"+diZhi;
        return ganZhi;
    }

    /**
     * 将藏干数据从集合中取出，添加到stringbuilder里面去
     */
    public String getCangGanFromList(List<String>lists){
        StringBuilder sb=new StringBuilder();
        for(String s:lists){
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * raidogroup点击的切换事件
     */
    class MyCheckedChangeLister implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            radioButton= (RadioButton) v.findViewById(checkedId);
        }
    }


}
