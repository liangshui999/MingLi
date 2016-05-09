package com.example.asus_cp.mingli.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.fragment.MingRenMingLiFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus-cp on 2016-05-06.
 * 展示每个格局的名人列表
 */
public class MingRenListActivity extends ListActivity {
    private Map<String,List<Map<String,Object>>> geJuPersons;
    public static final String NAME="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        ListView listView=getListView();
        final Intent intent=getIntent();
        String geJuString=intent.getStringExtra(MingRenMingLiFragment.GE_JU_KEY);
        final List<Map<String,Object>> geJu=geJuPersons.get(geJuString);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,geJu, R.layout.ming_ren_name_list_item,
                new String[]{NAME},new int[]{R.id.text_ming_ren_name});
        setListAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name= (String) geJu.get(position).get(NAME);
                Intent intent1=new Intent(MingRenListActivity.this,MingRenMIngLiContentActivity.class);
                intent1.putExtra(NAME,name);
                startActivity(intent1);
            }
        });
    }

    private void init() {
        geJuPersons=new HashMap<String,List<Map<String,Object>>>();
        List<Map<String,Object>> zhengGuanGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item1=new HashMap<String,Object>();
        item1.put(NAME,"欧阳修");
        Map<String,Object> item2=new HashMap<String,Object>();
        item2.put(NAME,"胡汉民");
        zhengGuanGe.add(item1);
        zhengGuanGe.add(item2);
        geJuPersons.put("正官格",zhengGuanGe);


        List<Map<String,Object>> qiShaGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item3=new HashMap<String,Object>();
        item3.put(NAME,"毛泽东");
        Map<String,Object> item4=new HashMap<String,Object>();
        item4.put(NAME,"谭延闿");
        qiShaGe.add(item3);
        qiShaGe.add(item4);
        geJuPersons.put("七杀格",qiShaGe);


        List<Map<String,Object>> yinShouGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item5=new HashMap<String,Object>();
        item5.put(NAME,"齐白石");
        Map<String,Object> item6=new HashMap<String,Object>();
        item6.put(NAME,"洪秀全");
        yinShouGe.add(item5);
        yinShouGe.add(item6);
        geJuPersons.put("印绶格",yinShouGe);


        List<Map<String,Object>> caiGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item7=new HashMap<String,Object>();
        item7.put(NAME,"张作相");
        Map<String,Object> item8=new HashMap<String,Object>();
        item8.put(NAME,"张元忭");
        caiGe.add(item7);
        caiGe.add(item8);
        geJuPersons.put("财格",caiGe);

        List<Map<String,Object>> shiShenGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item9=new HashMap<String,Object>();
        item9.put(NAME, "隆庆皇帝");
        shiShenGe.add(item9);
        geJuPersons.put("食神格",shiShenGe);


        List<Map<String,Object>> shangGuanGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item10=new HashMap<String,Object>();
        item10.put(NAME,"纪晓岚");
        Map<String,Object> item11=new HashMap<String,Object>();
        item11.put(NAME,"黄庭坚");
        Map<String,Object> item12=new HashMap<String,Object>();
        item12.put(NAME,"刘秀");
        shangGuanGe.add(item10);
        shangGuanGe.add(item11);
        shangGuanGe.add(item12);
        geJuPersons.put("伤官格",shangGuanGe);


        List<Map<String,Object>> yangRenGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item13=new HashMap<String,Object>();
        item13.put(NAME, "和珅");
        yangRenGe.add(item13);
        geJuPersons.put("羊刃格",yangRenGe);


        List<Map<String,Object>> zhuanWangGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item14=new HashMap<String,Object>();
        item14.put(NAME,"王守仁");
        Map<String,Object> item15=new HashMap<String,Object>();
        item15.put(NAME,"李鸿章");
        zhuanWangGe.add(item14);
        zhuanWangGe.add(item15);
        geJuPersons.put("专旺格",zhuanWangGe);


        List<Map<String,Object>> congGe=new ArrayList<Map<String,Object>>();
        Map<String,Object> item16=new HashMap<String,Object>();
        item16.put(NAME, "邓小平");
        congGe.add(item16);
        geJuPersons.put("从格",congGe);




    }

}
