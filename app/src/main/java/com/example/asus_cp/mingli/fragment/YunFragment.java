package com.example.asus_cp.mingli.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.asus_cp.mingli.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus-cp on 2016-04-21.
 */
public class YunFragment extends Fragment {
    private List<Map<String,String>> geJus;
    private SimpleAdapter simpleAdapter;
    public static final String GRID_ITEM_CONTENT="content";
    private String tag="YunFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        for(Map<String,String>map:geJus){
            Log.d(tag, map.get(GRID_ITEM_CONTENT));
        }
        simpleAdapter=new SimpleAdapter(getActivity(),geJus,R.layout.ming_ren_ming_li_layout,
                new String[]{GRID_ITEM_CONTENT},new int[]{R.id.text_ge_ju}
        );
        View v=inflater.inflate(R.layout.yun_fragment_layout,null);
        GridView gridView= (GridView) v.findViewById(R.id.grid_view_ge_ju);
        gridView.setAdapter(simpleAdapter);
        return v;
    }

    private void init() {
        geJus=new ArrayList<Map<String,String>>();
        Map<String,String> zhengGuan=new HashMap<String,String>();
        zhengGuan.put(GRID_ITEM_CONTENT,"正官格");
        geJus.add(zhengGuan);

        Map<String,String> qiSha=new HashMap<String,String>();
        qiSha.put(GRID_ITEM_CONTENT, "七杀格");
        geJus.add(qiSha);

        Map<String,String> zhengCai=new HashMap<String,String>();
        zhengCai.put(GRID_ITEM_CONTENT,"正财格");
        geJus.add(zhengCai);

        Map<String,String> piancCai=new HashMap<String,String>();
        piancCai.put(GRID_ITEM_CONTENT,"偏财格");
        geJus.add(piancCai);

        Map<String,String> zhengYin=new HashMap<String,String>();
        zhengYin.put(GRID_ITEM_CONTENT,"正印格");
        geJus.add(zhengYin);

        Map<String,String> pianYin=new HashMap<String,String>();
        pianYin.put(GRID_ITEM_CONTENT,"偏印格");
        geJus.add(pianYin);

        Map<String,String> shangGuan=new HashMap<String,String>();
        shangGuan.put(GRID_ITEM_CONTENT,"伤官格");
        geJus.add(shangGuan);

        Map<String,String> shiShen=new HashMap<String,String>();
        shiShen.put(GRID_ITEM_CONTENT,"食神格");
        geJus.add(shiShen);

        Map<String,String> jianLu=new HashMap<String,String>();
        jianLu.put(GRID_ITEM_CONTENT,"建禄格");
        geJus.add(jianLu);

        Map<String,String> yangRen=new HashMap<String,String>();
        yangRen.put(GRID_ITEM_CONTENT,"阳刃格");
        geJus.add(yangRen);

        Map<String,String> congGe=new HashMap<String,String>();
        congGe.put(GRID_ITEM_CONTENT,"从格");
        geJus.add(congGe);

        Map<String,String> zhuanWang=new HashMap<String,String>();
        zhuanWang.put(GRID_ITEM_CONTENT, "专旺格");
        geJus.add(zhuanWang);





    }
}
