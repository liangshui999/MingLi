package com.example.asus_cp.mingli.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.Service.InsertDataService;
import com.example.asus_cp.mingli.db.DBConstant;
import com.example.asus_cp.mingli.db.DBCreateHelper;
import com.example.asus_cp.mingli.db.DBOperateHelper;
import com.example.asus_cp.mingli.util.CaculateGanZhi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.NumericWheelAdapter;

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
    private DBOperateHelper helper;
    public static final String SHARE_NAME="havingDate";
    public static final String SHARE_KEY="dataKey";

    public static final String KONG="";

//    public static final int OFFSET=0;//控制时间区域的高度，有几行，如果等于2则上面有2行，下面有2行，总共是4行

    private CaculateGanZhi caculateGanZhi;//工具类的对象

    private String year=1980+"";//用户选择的年数据
    private String month=0+"";//用户选择的月数据
    private String day=1+"";//用户选择的日数据
    private String hour=0+"";//用户选择的时数据
    private String minute=0+"";//用户选择的分钟数据

    private ImageButton paiBaZi;//排八字的button
    private TextView nianZhu;
    private TextView yueZhu;
    private TextView riZhu;
    private TextView shiZhu;
    private TextView riYuan;

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

    private TextView textFirstDaYunDate;//第一次起大运的准确时间
    private TextView textFirstDaYunNian;//第一次起大运的年份
    private TextView textFirstDaYunGanZhi;//第一次起大运的干支

    private TextView textSecondDaYunNian;//第二次起大运的年份
    private TextView textSecondDaYunGanZhi;//第二次起大运的干支

    private TextView textThirdDaYunNian;//第三次起大运的年份
    private TextView textThirdDaYunGanZhi;//第三次起大运的干支

    private TextView textFourDaYunNian;//第四次起大运的年份
    private TextView textFourDaYunGanZhi;//第四次起大运的干支

    private TextView textFiveDaYunNian;//第五次起大运的年份
    private TextView textFiveDaYunGanZhi;//第五次起大运的干支

    private TextView textSixDaYunNian;//第六次起大运的年份
    private TextView textSixDaYunGanZhi;//第六次起大运的干支

    private TextView textSevenDaYunNian;//第七次起大运的年份
    private TextView textSevenDaYunGanZhi;//第七次起大运的干支

    private TextView textEightDaYunNian;//第八次起大运的年份
    private TextView textEightDaYunGanZhi;//第八次起大运的干支

    private ImageButton imageButtonBornTime;//选择出生时间的点击按钮
    private TextView textViewBornTime;//显示出生时间的textview


    private TextView textDiTianShui;//滴天髓解释的内容
//    private TextView textQiongTong;//穷通宝鉴解释的内容
    private TextView textSanMing;//三命通会解释的内容


    /**
     * 向数据库中插入数据,开启服务，让服务去插入数据
     */
    public void insertData(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        int m=sharedPreferences.getInt(SHARE_KEY,-1);
        if(m==-1){
            Intent intent=new Intent(context, InsertDataService.class);
            context.startService(intent);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
        context=getContext();
        insertData();
        v=View.inflate(getContext(), R.layout.ming_fragment_layout, null);
        initView();
        return v;

    }

    /**
     * 初始化数据的方法
     */
    public void initData(){
        years=new ArrayList<String>();
        months=new ArrayList<String>();
        days=new ArrayList<String>();
        hours=new ArrayList<String>();
        minutes=new ArrayList<String>();
        fuZhi(years,200,firstYear);
        fuZhi(months,12,firstExcepteYear);
        fuZhi(days, 31, firstExcepteYear);
        fuZhi(hours,24,firstHourAndMinute);
        fuZhi(minutes, 60, firstHourAndMinute);
        caculateGanZhi=new CaculateGanZhi();
        helper=new DBOperateHelper(DBCreateHelper.getDBCreateHelper());
    }

    /**
     * 初始化view的方法
     */
    public void initView(){
//      Button date= (Button) v.findViewById(R.id.btn_date_piker);
//      Button time= (Button) v.findViewById(R.id.btn_time_piker);
        paiBaZi= (ImageButton) v.findViewById(R.id.btn_pai_bazi);
        nianZhu= (TextView) v.findViewById(R.id.text_nianzhu);
        yueZhu= (TextView) v.findViewById(R.id.text_yuezhu);
        riZhu= (TextView) v.findViewById(R.id.text_rizhu);
        shiZhu= (TextView) v.findViewById(R.id.text_shizhu);
        riYuan= (TextView) v.findViewById(R.id.text_ri_yuan);

        textNianShiShen= (TextView) v.findViewById(R.id.text_nian_shi_shen);
        textYueShiShen= (TextView) v.findViewById(R.id.text_yue_shi_shen);
        textShiShiShen= (TextView) v.findViewById(R.id.text_shi_shi_shen);

        textNianCangGan= (TextView) v.findViewById(R.id.text_nian_cang_gan);
        textYueCangGan= (TextView) v.findViewById(R.id.text_yue_cang_gan);
        textRiCangGan= (TextView) v.findViewById(R.id.text_ri_cang_gan);
        textShiCangGan= (TextView) v.findViewById(R.id.text_shi_cang_gan);

        radioGroup= (RadioGroup) v.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new MyCheckedChangeLister());

        textFirstDaYunDate= (TextView) v.findViewById(R.id.text_first_da_yun_date);
        textFirstDaYunNian= (TextView) v.findViewById(R.id.text_first_da_yun_nian);
        textFirstDaYunGanZhi= (TextView) v.findViewById(R.id.text_first_da_yun_gan_zhi);

        textSecondDaYunNian= (TextView) v.findViewById(R.id.text_second_da_yun_nian);
        textSecondDaYunGanZhi= (TextView) v.findViewById(R.id.text_second_da_yun_gan_zhi);

        textThirdDaYunNian= (TextView) v.findViewById(R.id.text_third_da_yun_nian);
        textThirdDaYunGanZhi= (TextView) v.findViewById(R.id.text_third_da_yun_gan_zhi);

        textFourDaYunNian= (TextView) v.findViewById(R.id.text_four_da_yun_nian);
        textFourDaYunGanZhi= (TextView) v.findViewById(R.id.text_four_da_yun_gan_zhi);

        textFiveDaYunNian= (TextView) v.findViewById(R.id.text_five_da_yun_nian);
        textFiveDaYunGanZhi= (TextView) v.findViewById(R.id.text_five_da_yun_gan_zhi);

        textSixDaYunNian= (TextView) v.findViewById(R.id.text_six_da_yun_nian);
        textSixDaYunGanZhi= (TextView) v.findViewById(R.id.text_six_da_yun_gan_zhi);

        textSevenDaYunNian= (TextView) v.findViewById(R.id.text_seven_da_yun_nian);
        textSevenDaYunGanZhi= (TextView) v.findViewById(R.id.text_seven_da_yun_gan_zhi);

        textEightDaYunNian= (TextView) v.findViewById(R.id.text_eight_da_yun_nian);
        textEightDaYunGanZhi= (TextView) v.findViewById(R.id.text_eight_da_yun_gan_zhi);

        imageButtonBornTime= (ImageButton) v.findViewById(R.id.img_btn_born_time);
        textViewBornTime= (TextView) v.findViewById(R.id.text_born_time);

        textDiTianShui= (TextView) v.findViewById(R.id.text_di_tian_shui);
//        textQiongTong= (TextView) v.findViewById(R.id.text_qiong_tong);
        textSanMing= (TextView) v.findViewById(R.id.text_san_ming);
        imageButtonBornTime.setOnClickListener(this);



      /*  WheelView wheelViewYear= (WheelView) v.findViewById(R.id.whe_year);
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
        });*/
//        date.setOnClickListener(this);
//        time.setOnClickListener(this);
        paiBaZi.setOnClickListener(this);
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
            case R.id.btn_pai_bazi: //点击了排八字的按钮
                Animation rolate= AnimationUtils.loadAnimation(context,R.anim.ba_zi_button_anim);
                rolate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        resetView();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {     //动画结束时将结果显示出来
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

                        //让日元显示出来
                        riYuan.setVisibility(View.VISIBLE);

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

                        //设置大运
                        if(radioButton==null){
                            Toast.makeText(context, "请选择性别,有性别才能排出大运哦", Toast.LENGTH_LONG).show();
                        }else{
                            List<String> daYuns= caculateGanZhi.getDaYun(year,month,day,hour,minute,radioButton.
                                    getText().toString());
                            textFirstDaYunDate.setText(daYuns.get(0));
                            textFirstDaYunNian.setText(daYuns.get(1));
                            textFirstDaYunGanZhi.setText(daYuns.get(2));

                            textSecondDaYunNian.setText(daYuns.get(3));
                            textSecondDaYunGanZhi.setText(daYuns.get(4));

                            textThirdDaYunNian.setText(daYuns.get(5));
                            textThirdDaYunGanZhi.setText(daYuns.get(6));

                            textFourDaYunNian.setText(daYuns.get(7));
                            textFourDaYunGanZhi.setText(daYuns.get(8));

                            textFiveDaYunNian.setText(daYuns.get(9));
                            textFiveDaYunGanZhi.setText(daYuns.get(10));

                            textSixDaYunNian.setText(daYuns.get(11));
                            textSixDaYunGanZhi.setText(daYuns.get(12));

                            textSevenDaYunNian.setText(daYuns.get(13));
                            textSevenDaYunGanZhi.setText(daYuns.get(14));

                            textEightDaYunNian.setText(daYuns.get(15));
                            textEightDaYunGanZhi.setText(daYuns.get(16));
                        }

                        //显示断命的结果
                        String diTianShui=helper.queryDiTianShui(DBConstant.DiTianShui.SELECT_DUAN_YU,new String[]{riGan});
                        String qiongTong=helper.queryQiongTongDuanYu(DBConstant.QiongTong.SELECT_DUAN_YU,
                                new String[]{riGan, yueZhi});
                        String sanMing=helper.querySanMingDuanYu(DBConstant.SanMing.SELECT_DUAN_YU,
                                new String[]{riGanZhi, shiZhi});
                        textDiTianShui.setText(diTianShui);
//                        textQiongTong.setText(qiongTong);
                        textSanMing.setText(sanMing);

                        //查询完毕之后关闭数据库
                        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
                        int m=sharedPreferences.getInt(SHARE_KEY,-1);
                        if(m!=-1){  //所有的数据都插入完毕之后m的数据会是1
                            helper.closeDB();
                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                paiBaZi.startAnimation(rolate);

                break;
            case R.id.img_btn_born_time://点击了选择出生时间的button，弹出一个对话框
                year=1980+"";//用户选择的年数据
                month=1+"";//用户选择的月数据
                day=1+"";//用户选择的日数据
                hour=0+"";//用户选择的时数据
                minute=0+"";//用户选择的分钟数据
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                LayoutInflater inflater=LayoutInflater.from(context);
                View view=inflater.inflate(R.layout.date_picker_dialog_layout, null);
                WheelView wheelViewYear= (WheelView) view.findViewById(R.id.whe_year);
                WheelView wheelViewMonth= (WheelView) view.findViewById(R.id.whe_month);
                WheelView wheelViewDay= (WheelView) view.findViewById(R.id.whe_day);
                WheelView wheelViewHour= (WheelView) view.findViewById(R.id.whe_hour);
                WheelView wheelViewMinute= (WheelView) view.findViewById(R.id.whe_minute);

                OnWheelChangedListener listener=new OnWheelChangedListener() {
                    @Override
                    public void onChanged(WheelView wheel, int oldValue, int newValue) {
                        switch (wheel.getId()){
                            case R.id.whe_year:
                                year=1920+newValue+"";
                                break;
                            case R.id.whe_month:
                                month=1+newValue+"";
                                break;
                            case R.id.whe_day:
                                day=1+newValue+"";
                                break;
                            case R.id.whe_hour:
                                hour=newValue+"";
                                break;
                            case R.id.whe_minute:
                                minute=newValue+"";
                                break;
                        }
                    }
                };

                wheelViewYear.setViewAdapter(new MyWheelAdapter(context, 1920, 2100));
                wheelViewYear.setCurrentItem(60);
                wheelViewYear.setCyclic(true);
                wheelViewYear.addChangingListener(listener);

                wheelViewMonth.setViewAdapter(new MyWheelAdapter(context, 1, 12));
                wheelViewMonth.setCurrentItem(0);
                wheelViewMonth.setCyclic(true);
                wheelViewMonth.addChangingListener(listener);



                wheelViewDay.setViewAdapter(new MyWheelAdapter(context,1,31));
                wheelViewDay.setCurrentItem(0);
                wheelViewDay.setCyclic(true);
                wheelViewDay.addChangingListener(listener);

                wheelViewHour.setViewAdapter(new MyWheelAdapter(context,0,24));
                wheelViewHour.setCurrentItem(0);
                wheelViewHour.setCyclic(true);
                wheelViewHour.addChangingListener(listener);

                wheelViewMinute.setViewAdapter(new MyWheelAdapter(context,0,60));
                wheelViewMinute.setCurrentItem(0);
                wheelViewMinute.setCyclic(true);
                wheelViewMinute.addChangingListener(listener);


                builder.setView(view);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Calendar calendar1=Calendar.getInstance();
                        calendar1.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day),
                                Integer.parseInt(hour), Integer.parseInt(minute),00);
                        String pattern="yyyy-MM-dd HH:mm:ss";
                        String bornDate=caculateGanZhi.getStringFromCalendar(calendar1,pattern);
                        textViewBornTime.setText(bornDate);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
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
     * 将八字，大运设置为初始状态
     */
    public void resetView(){
        riYuan.setVisibility(View.GONE);
        //给八字的四柱赋值
        nianZhu.setText(KONG);
        yueZhu.setText(KONG);
        riZhu.setText(KONG);
        shiZhu.setText(KONG);

        //给天干十神赋值
        textNianShiShen.setText(KONG);
        textYueShiShen.setText(KONG);
        textShiShiShen.setText(KONG);

        //给地支藏干赋值
        textNianCangGan.setText(KONG);
        textYueCangGan.setText(KONG);
        textRiCangGan.setText(KONG);
        textShiCangGan.setText(KONG);

        textFirstDaYunDate.setText(KONG);
        textFirstDaYunNian.setText(KONG);
        textFirstDaYunGanZhi.setText(KONG);

        textSecondDaYunNian.setText(KONG);
        textSecondDaYunGanZhi.setText(KONG);

        textThirdDaYunNian.setText(KONG);
        textThirdDaYunGanZhi.setText(KONG);

        textFourDaYunNian.setText(KONG);
        textFourDaYunGanZhi.setText(KONG);

        textFiveDaYunNian.setText(KONG);
        textFiveDaYunGanZhi.setText(KONG);

        textSixDaYunNian.setText(KONG);
        textSixDaYunGanZhi.setText(KONG);

        textSevenDaYunNian.setText(KONG);
        textSevenDaYunGanZhi.setText(KONG);

        textEightDaYunNian.setText(KONG);
        textEightDaYunGanZhi.setText(KONG);

        textDiTianShui.setText(KONG);
        textSanMing.setText(KONG);
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

    /**
     * wheelview的适配器，继承自numerricwheelapter，不需要往里面传入数组，只需要传最大值，最小值即可
     */
    public class MyWheelAdapter extends NumericWheelAdapter{

        /**
         * Constructor
         * @param minValue 传入的数字的最小值
         * @param maxValue 传入的数字的最大值
         *
         */
        public MyWheelAdapter(Context context, int minValue, int maxValue) {
            super(context, minValue, maxValue);
            setTextSize(24);
        }

        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            view.setTypeface(Typeface.MONOSPACE);
        }

    }


}
