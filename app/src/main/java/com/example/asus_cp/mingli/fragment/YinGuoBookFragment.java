package com.example.asus_cp.mingli.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus_cp.mingli.R;
import com.example.asus_cp.mingli.util.FileCopy;

import java.io.File;

/**
 * Created by asus-cp on 2016-04-21.
 */
public class YinGuoBookFragment extends Fragment implements View.OnClickListener{
    private FileCopy fileCopy;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fileCopy=new FileCopy(getContext());
        new Thread(new Runnable() {
            @Override
            public void run() {
                fileCopy.moveFileFromAssetsToMingLi();
            }
        }).start();

        View v=inflater.inflate(R.layout.book_fragment_layout_new,null);
        ImageView imgBaiYeJing= (ImageView) v.findViewById(R.id.img_bai_ye_jing);
        imgBaiYeJing.setOnClickListener(this);
        return v;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_bai_ye_jing:
                String path=fileCopy.newFolder()+ File.separator+ "bayejing.doc";
                File file=new File(path);
                Uri uri=Uri.fromFile(file);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setDataAndType(uri, "application/msword");
                startActivity(intent);
                break;
        }
    }
}
