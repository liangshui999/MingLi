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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        context=getContext();
        View v=View.inflate(getContext(), R.layout.ming_fragment_layout,null);
//        Button date= (Button) v.findViewById(R.id.btn_date_piker);
//        Button time= (Button) v.findViewById(R.id.btn_time_piker);
        paiBaZi= (Button) v.findViewById(R.id.btn_pai_bazi);
        nianZhu= (TextView) v.findViewById(R.id.text_nianzhu);
        yueZhu= (TextView) v.findViewById(R.id.text_yuezhu);
        riZhu= (TextView) v.findViewById(R.id.text_rizhu);
        shiZhu= (TextView) v.findViewById(R.id.text_shizhu);
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
                nianZhu.setText(convertBaZhiDirection(caculateGanZhi.getYearGanZhi(year, month, day, hour, minute)));
                yueZhu.setText(convertBaZhiDirection(caculateGanZhi.getMonthGanZhi(year, month, day, hour, minute)));
                riZhu.setText(convertBaZhiDirection(caculateGanZhi.getRiGanZhi(year, month, day, hour)));
                shiZhu.setText(convertBaZhiDirection(caculateGanZhi.getHourGanZhi(year, month, day, hour)));
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


}
