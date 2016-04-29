package com.example.asus_cp.mingli.Service;

import android.app.IntentService;
import android.content.Intent;

import com.example.asus_cp.mingli.db.DBCreateHelper;
import com.example.asus_cp.mingli.db.DBOperateHelper;
import com.example.asus_cp.mingli.model.QiongTong;
import com.example.asus_cp.mingli.model.SanMing;

/**
 * Created by asus-cp on 2016-04-29.
 */
public class InsertDataService extends IntentService {
    private DBOperateHelper helper;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public InsertDataService(String name) {
        super(name);
    }

    /**
     * 子类必然会调用父类的构造方法，如果父类没有空参数的构造方法
     * 则子类必须指定要调用父类的哪个构造方法，否则会报错
     */
    public InsertDataService(){
        super("110");
        helper=new DBOperateHelper(DBCreateHelper.getDBCreateHelper());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        QiongTong qiongTong=new QiongTong();
        SanMing sanMing=new SanMing();
        qiongTong.setRiGan("甲");
        qiongTong.setYueFen("寅");
        qiongTong.setDuanYu("果断是一条好命");
        helper.insertQiongTong(qiongTong);
        qiongTong.setRiGan("甲");
        qiongTong.setYueFen("卯");
        qiongTong.setDuanYu("烂命一条");
        helper.insertQiongTong(qiongTong);

        sanMing.setRiGan("乙");
        sanMing.setShiChen("庚");
        sanMing.setDuanYu("乙的命格不靠谱");
        helper.insertSanMing(sanMing);

        sanMing.setRiGan("乙");
        sanMing.setShiChen("辛");
        sanMing.setDuanYu("乙的辛很菜");
        helper.insertSanMing(sanMing);
    }
}
