package com.example.asus_cp.mingli.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by asus-cp on 2016-05-07.
 */
public class FileCopy {
    private Context context;
    public FileCopy(){

    }

    public FileCopy(Context context){
        this.context=context;
    }
    /**
     * 在sd卡上新建一个文件夹,名字叫做mingLi
     */
    public File newFolder(){
        String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"mingLi";
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    /**
     * 从asset文件夹里面移动文件到mingli文件夹里面
     */
    public void moveFileFromAssetsToMingLi(){
        AssetManager manager=context.getAssets();
        String mingLiPath=newFolder().getAbsolutePath();
        InputStream in=null;
        FileOutputStream out=null;
        try {
            String[] files=manager.list("");//获取到asset文件夹下的所有文件名称
            for(String file:files){
                in=manager.open(file);
                String targetPath=mingLiPath+File.separator+file;//目标文件的路径
                out=new FileOutputStream(targetPath);
                byte[] buf=new byte[1024];
                int len=0;
                while((len=in.read(buf))!=-1){
                    out.write(buf,0,len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
