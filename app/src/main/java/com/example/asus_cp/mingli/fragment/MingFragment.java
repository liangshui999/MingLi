package com.example.asus_cp.mingli.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.custumview.WheelView;

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


    public static final int OFFSET=0;//控制时间区域的高度，有几行，如果等于2则上面有2行，下面有2行，总共是4行

    //天干的数组
    private String[] tianGan=new String[]{"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};

    //地支的数组
    private String[] diZhi=new String[]{"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};

    //六十花甲的数组
    private String[] huaJia;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        context=getContext();
        View v=View.inflate(getContext(), R.layout.ming_fragment_layout,null);
//        Button date= (Button) v.findViewById(R.id.btn_date_piker);
//        Button time= (Button) v.findViewById(R.id.btn_time_piker);
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
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewMonth.setOffset(OFFSET);
        wheelViewMonth.setItems(months);
        wheelViewMonth.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewDay.setOffset(OFFSET);
        wheelViewDay.setItems(days);
        wheelViewDay.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewHour.setOffset(OFFSET);
        wheelViewHour.setItems(hours);
        wheelViewHour.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        wheelViewMinute.setOffset(OFFSET);
        wheelViewMinute.setItems(minutes);
        wheelViewMinute.setOnWheelViewListener(new WheelView.OnWheelViewListener(){
            @Override
            public void onSelected(int selectedIndex, String item) {
                super.onSelected(selectedIndex, item);
                Log.d(tag, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });
//        date.setOnClickListener(this);
//        time.setOnClickListener(this);
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
        fuZhi(hours,24,firstExcepteYear);
        fuZhi(minutes,60,firstExcepteYear);
        createHuaJia();
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

    /**
     * 生成六十花甲的方法
     *
     */
    public void createHuaJia(){
        huaJia=new String[60];
        for(int i=0;i<60;i++){
            if(i<10){
                huaJia[i]=tianGan[i]+diZhi[i];
            }else if(i>=10&&i<12){
                huaJia[i]=tianGan[i-10]+diZhi[i];
            }

        }
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
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
//        }
    }


}
