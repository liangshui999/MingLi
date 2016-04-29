package com.example.asus_cp.mingli.db;

/**
 * Created by asus-cp on 2016-04-29.
 */
public interface DBConstant {
    public static final String DB_NAME="mingLiDatabase";//数据库的名称
    public static final int DB_VERSION=1;//数据库的版本
    public static final String KONG_GE=" ";

    //三命通会的表
    public interface SanMing{
        public static final String TABLE_NAME="sanMing";
        public static final String RI_GAN="riGan";
        public static final String SHI_CHEN ="shiChen";
        public static final String DUAN_YU="duanYu";

        public static final String CREATE_TABLE="create table if not exists"+KONG_GE+TABLE_NAME+"(" +
                "id integer primary key autoincrement ," +
                RI_GAN+KONG_GE+"text not null," +
                SHI_CHEN +KONG_GE+"text not null," +
                DUAN_YU+KONG_GE+"text not null"+
                ")";

        public static final String SELECT_DUAN_YU="select"+KONG_GE+DUAN_YU+KONG_GE+"from"+KONG_GE+TABLE_NAME+KONG_GE
                +"where" +KONG_GE+RI_GAN+"=? and"+KONG_GE+ SHI_CHEN +"=?";

    }

    //穷通宝鉴的表
    public interface QiongTong{
        public static final String TABLE_NAME="qiongTong";
        public static final String RI_GAN="riGan";
        public static final String YUE_FEN ="yueFen";
        public static final String DUAN_YU="duanYu";

        public static final String CREATE_TABLE="create table if not exists"+KONG_GE+TABLE_NAME+"(" +
                "id integer primary key autoincrement ," +
                RI_GAN+KONG_GE+"text not null," +
                YUE_FEN +KONG_GE+"text not null," +
                DUAN_YU+KONG_GE+"text not null"+
                ")";

        public static final String SELECT_DUAN_YU="select"+KONG_GE+DUAN_YU+KONG_GE+"from"+KONG_GE+TABLE_NAME+KONG_GE+"where" +
                KONG_GE+RI_GAN+"=? and"+KONG_GE+ YUE_FEN +"=?";
    }
}
