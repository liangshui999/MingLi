package com.example.asus_cp.mingli.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.activity.MingRenListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus-cp on 2016-04-21.
 */
public class MingRenMingLiFragment extends Fragment {
    private List<Map<String,String>> geJus;
    private SimpleAdapter simpleAdapter;
    public static final String GRID_ITEM_CONTENT="content";
    public static final String GE_JU_KEY="geJuKey";
    private String tag="MingRenMingLiFragment";
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();

        View v=inflater.inflate(R.layout.yun_fragment_layout,null);
        GridView gridView= (GridView) v.findViewById(R.id.grid_view_ge_ju);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(context,"positon="+position,Toast.LENGTH_SHORT).show();
                String geJu=geJus.get(position).get(GRID_ITEM_CONTENT);
                Intent intent=new Intent(context, MingRenListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(GE_JU_KEY,geJu);
                startActivity(intent);

            }
        });
        return v;
    }

    private void init() {
        context=getActivity();
        geJus=new ArrayList<Map<String,String>>();
        Map<String,String> zhengGuan=new HashMap<String,String>();
        zhengGuan.put(GRID_ITEM_CONTENT,"正官格");
        geJus.add(zhengGuan);

        Map<String,String> qiSha=new HashMap<String,String>();
        qiSha.put(GRID_ITEM_CONTENT, "七杀格");
        geJus.add(qiSha);

        Map<String,String> zhengCai=new HashMap<String,String>();
        zhengCai.put(GRID_ITEM_CONTENT,"财格");
        geJus.add(zhengCai);

        Map<String,String> zhengYin=new HashMap<String,String>();
        zhengYin.put(GRID_ITEM_CONTENT,"印绶格");
        geJus.add(zhengYin);

        Map<String,String> shangGuan=new HashMap<String,String>();
        shangGuan.put(GRID_ITEM_CONTENT,"伤官格");
        geJus.add(shangGuan);

        Map<String,String> shiShen=new HashMap<String,String>();
        shiShen.put(GRID_ITEM_CONTENT,"食神格");
        geJus.add(shiShen);

//        Map<String,String> jianLu=new HashMap<String,String>();
//        jianLu.put(GRID_ITEM_CONTENT,"建禄格");
//        geJus.add(jianLu);

        Map<String,String> yangRen=new HashMap<String,String>();
        yangRen.put(GRID_ITEM_CONTENT,"羊刃格");
        geJus.add(yangRen);

        Map<String,String> congGe=new HashMap<String,String>();
        congGe.put(GRID_ITEM_CONTENT,"从格");
        geJus.add(congGe);

        Map<String,String> zhuanWang=new HashMap<String,String>();
        zhuanWang.put(GRID_ITEM_CONTENT, "专旺格");
        geJus.add(zhuanWang);

        for(Map<String,String>map:geJus){
            Log.d(tag, map.get(GRID_ITEM_CONTENT));
        }
        simpleAdapter=new SimpleAdapter(getActivity(),geJus,R.layout.ge_ju_item,
                new String[]{GRID_ITEM_CONTENT},new int[]{R.id.text_ge_ju}
        );



    }
}
