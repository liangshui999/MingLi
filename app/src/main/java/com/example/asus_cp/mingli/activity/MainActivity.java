package com.example.asus_cp.mingli.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.fragment.MingFragment;
import com.example.asus_cp.mingli.fragment.MingRenMingLiFragment;
import com.example.asus_cp.mingli.fragment.YinGuoBookFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private LinearLayout llMing;
    private LinearLayout llMingRenMingLi;//名人命例
    private LinearLayout llBook;
//    private LinearLayout llRecord;
    private ViewPager viewPagerMain;
    private ImageButton shareButton;//分享按钮
    private ImageButton helpButton;//帮助按钮
    private AlertDialog helpDialog;//帮助的对话框



    //tag,调试用
    private String tag="MainActivity";

    //装fragment的集合
    private List<Fragment> fragments;

    //fragment对应的数值
    public static final int MING=0;
    public static final int YUN=1;
    public static final int BOOK=2;
    public static final int RECORD=3;

    //帮助的intent传递时的键,打开helpactivity时传递值时用
    public static final String HELP_INTENT_KEY ="key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main_layout);
        init();
    }

    /**
     * 初始化的方法
     */
    public void init() {
        llMing= (LinearLayout) findViewById(R.id.ll_ming);
        llMingRenMingLi = (LinearLayout) findViewById(R.id.ll_yun);
        llBook= (LinearLayout) findViewById(R.id.ll_book);
//        llRecord= (LinearLayout) findViewById(R.id.ll_record);
        viewPagerMain= (ViewPager) findViewById(R.id.view_pager_main);
        shareButton= (ImageButton) findViewById(R.id.img_btn_share);
        helpButton= (ImageButton) findViewById(R.id.img_btn_help);
        shareButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);


        llMing.setBackgroundResource(R.color.blue);
        MingFragment mingFragment=new MingFragment();
        MingRenMingLiFragment mingRenMingLiFragment=new MingRenMingLiFragment();
        YinGuoBookFragment bookFragment=new YinGuoBookFragment();
//        RecordFragment recordFragment=new RecordFragment();
        fragments=new ArrayList<Fragment>();
        fragments.add(mingFragment);
        fragments.add(mingRenMingLiFragment);
        fragments.add(bookFragment);
//        fragments.add(recordFragment);
        FragmentPagerAdapter adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPagerMain.setAdapter(adapter);
        viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(tag, "onPageScrolled" + "position=" + position + "..." + "positionOffset" + positionOffset + "..." +
                        "positionOffsetPixels" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(tag, "onPageSelected" + "position=" + position);
                resetBackGround();
                switch (position) {
                    case MING:
                        llMing.setBackgroundResource(R.color.blue);
                        break;
                    case YUN:
                        llMingRenMingLi.setBackgroundResource(R.color.blue);
                        break;
                    case BOOK:
                        llBook.setBackgroundResource(R.color.blue);
                        break;
                    case RECORD:
//                        llRecord.setBackgroundResource(R.color.blue);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(tag, "onPageScrollStateChanged" + "state=" + state);
            }
        });
        llMing.setOnClickListener(this);
        llMingRenMingLi.setOnClickListener(this);
        llBook.setOnClickListener(this);
//        llRecord.setOnClickListener(this);
    }

    /**
     * 将页面标签的background设置成初始状态
     */
    public void resetBackGround(){
        llMing.setBackgroundResource(R.color.gray);
        llMingRenMingLi.setBackgroundResource(R.color.gray);
        llBook.setBackgroundResource(R.color.gray);
//        llRecord.setBackgroundResource(R.color.gray);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ll_ming:
                Log.d(tag,"点击了命");
                resetBackGround();
                llMing.setBackgroundResource(R.color.blue);
                viewPagerMain.setCurrentItem(MING);
                break;
            case R.id.ll_yun:
                Log.d(tag,"点击了运");
                resetBackGround();
                llMingRenMingLi.setBackgroundResource(R.color.blue);
                viewPagerMain.setCurrentItem(YUN);
                break;
            case R.id.ll_book:
                Log.d(tag,"点击了书籍");
                resetBackGround();
                llBook.setBackgroundResource(R.color.blue);
                viewPagerMain.setCurrentItem(BOOK);
                break;
//            case R.id.ll_record:
//                Log.d(tag,"点击了记录");
//                resetBackGround();
//                llRecord.setBackgroundResource(R.color.blue);
//                viewPagerMain.setCurrentItem(RECORD);
//                break;
            case R.id.img_btn_share:    //分享按钮的点击事件
                File file=getCurrentImage();
                Uri uri=Uri.fromFile(file);
                Log.d(tag, uri.toString());
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, uri);//注意这里的键值不是自己乱写的
                intent.setType("image/*");
                startActivity(Intent.createChooser(intent, "分享到"));
                break;
            case R.id.img_btn_help:     //帮助按钮的点击事件
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("帮助");
                LayoutInflater inflater=LayoutInflater.from(this);
                View helpView=inflater.inflate(R.layout.help_dialog_layout, null);
                TextView textShare= (TextView) helpView.findViewById(R.id.text_share_help);
                TextView textShuYu= (TextView) helpView.findViewById(R.id.text_shu_yu_jie_si);
                TextView textAbout= (TextView) helpView.findViewById(R.id.text_about_soft);
                TextView textpaiBaZi= (TextView) helpView.findViewById(R.id.text_pai_ba_zi_help);
                TextView textMingYunXingCheng= (TextView) helpView.findViewById(R.id.text_ming_yun_xing_cheng_help);
                textShare.setOnClickListener(this);
                textShuYu.setOnClickListener(this);
                textAbout.setOnClickListener(this);
                textpaiBaZi.setOnClickListener(this);
                textMingYunXingCheng.setOnClickListener(this);
                builder.setView(helpView);
                helpDialog=builder.show();
                helpDialog.show();
                break;
            case R.id.text_share_help:
               // Toast.makeText(this,"分享帮助",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(this,HelpActivity.class);
                intent1.putExtra(HELP_INTENT_KEY,"分享帮助");
                startActivity(intent1);
                helpDialog.dismiss();
                break;
            case R.id.text_shu_yu_jie_si:
                //Toast.makeText(this,"属于解释",Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(this,HelpActivity.class);
                intent2.putExtra(HELP_INTENT_KEY,"术语解释");
                startActivity(intent2);
                helpDialog.dismiss();
                break;
            case R.id.text_about_soft:
                //Toast.makeText(this,"关于软件",Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(this,HelpActivity.class);
                intent3.putExtra(HELP_INTENT_KEY,"关于软件");
                startActivity(intent3);
                helpDialog.dismiss();
                break;
            case R.id.text_pai_ba_zi_help:
                //Toast.makeText(this,"排八字的帮助",Toast.LENGTH_SHORT).show();
                Intent intent4=new Intent(this,HelpActivity.class);
                intent4.putExtra(HELP_INTENT_KEY,"排八字帮助");
                startActivity(intent4);
                helpDialog.dismiss();
                break;
            case R.id.text_ming_yun_xing_cheng_help:
                //Toast.makeText(this,"命运形成的帮助",Toast.LENGTH_SHORT).show();
                Intent intent5=new Intent(this,HelpActivity.class);
                intent5.putExtra(HELP_INTENT_KEY,"命运形成");
                startActivity(intent5);
                helpDialog.dismiss();
                break;
        }
    }


    /**
     * 获取当前屏幕的截图
     */
    public File getCurrentImage(){
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        int w = point.x;
        int h = point.y;
        Bitmap bmp = Bitmap.createBitmap( w, h, Bitmap.Config.ARGB_8888 );
        View decorview = this.getWindow().getDecorView();
        decorview.setDrawingCacheEnabled(true);
//        decorview.buildDrawingCache();
        bmp = decorview.getDrawingCache();

        OutputStream out=null;
        File file=new File(Environment.getExternalStorageDirectory(),"1.jpg");//这里需要申请权限的
        if(file.exists()){  //如果存在就删除
            boolean m=file.delete();
            Log.d(tag, "删除成功"+m);
        }
        if(!file.exists()){ //如果不存在就创造出来
            try {
                boolean n=file.createNewFile();
                Log.d(tag, "创建成功"+n);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out=new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG,100,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            decorview.destroyDrawingCache();//释放资源,这儿一定要释放资源，不然每次创建的bitmap都是一样的
        }
    return file;

    }
}
