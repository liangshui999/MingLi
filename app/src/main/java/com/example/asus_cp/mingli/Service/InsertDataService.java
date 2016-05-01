package com.example.asus_cp.mingli.Service;

import android.app.IntentService;
import android.content.Intent;

import com.example.asus_cp.mingli.db.DBCreateHelper;
import com.example.asus_cp.mingli.db.DBOperateHelper;
import com.example.asus_cp.mingli.model.DiTianShui;
import com.example.asus_cp.mingli.model.QiongTong;
import com.example.asus_cp.mingli.model.SanMing;
import com.example.asus_cp.mingli.util.CaculateGanZhi;

/**
 * Created by asus-cp on 2016-04-29.
 */
public class InsertDataService extends IntentService {
    private DBOperateHelper helper;

    public static final String JIA_ZI="甲子";

    public static final String JIA_YIN="甲寅";

    public static final String JIA_CHEN="甲辰";

    public static final String JIA_WU="甲午";

    public static final String JIA_SHEN="甲申";

    public static final String JIA_XU="甲戌";

    public static final String YI_CHOU="乙丑";

    public static final String YI_MAO="乙卯";

    public static final String YI_SI="乙巳";

    public static final String YI_WEI="乙未";

    public static final String YI_YOU="乙酉";

    public static final String YI_HAI="乙亥";

    public static final String BING_ZI="丙子";

    public static final String BING_YIN="丙寅";

    public static final String BING_CHEN="丙辰";

    public static final String BING_WU="丙午";

    public static final String BING_SHEN="丙申";

    public static final String BING_XU="丙戌";

    public static final String DING_CHOU="丁丑";

    public static final String DING_MAO="丁卯";

    public static final String DING_SI="丁巳";

    public static final String DING_WEI="丁未";

    public static final String DING_YOU="丁酉";

    public static final String DING_HAI="丁亥";

    public static final String WU_ZI="戊子";

    public static final String WU_YIN="戊寅";

    public static final String WU_CHEN="戊辰";

    public static final String WU_WU="戊午";

    public static final String WU_SHEN="戊申";

    public static final String WU_XU="戊戌";

    public static final String JI_CHOU="己丑";

    public static final String JI_MAO="己卯";

    public static final String JI_SI="己巳";

    public static final String JI_WEI="己未";

    public static final String JI_YOU="己酉";

    public static final String JI_HAI="己亥";
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
        DiTianShui diTianShui=new DiTianShui();
        QiongTong qiongTong=new QiongTong();
        SanMing sanMing=new SanMing();

        //插入滴天髓的数据
        diTianShui.setRiGan(CaculateGanZhi.JIA);
        diTianShui.setDuanYu("甲木参天，脱胎要火，春不容金，秋不容土，火炽乘龙，水宕骑虎，地润天和，植立千古。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.YI);
        diTianShui.setDuanYu("乙木虽柔，刲羊解牛，怀丁抱丙，跨凤乘猴，虚湿之地，骑马亦忧，藤罗系甲，可春可秋。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.BING);
        diTianShui.setDuanYu("丙火猛烈，欺霜侮雪。能煅庚金，逢辛反怯。土众成慈。水猖显节，虎马犬乡，甲来成灭。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.DING);
        diTianShui.setDuanYu("丁火柔中，内性昭融，抱乙而孝，合壬而忠，旺而不烈，衰而不穷，如有嫡母，可秋可冬。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.WU_TIAN_GAN);
        diTianShui.setDuanYu("戊土固重，既中且正，静翕动辟，万物司命，水润物生，火燥物病，若在艮坤，怕冲宜静。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.JI);
        diTianShui.setDuanYu("己土卑湿，中正蓄藏，不愁木盛，不畏水狂，火少火晦，金多金光，若要物旺，宜助宜帮。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.GENG);
        diTianShui.setDuanYu("庚金带煞，刚健为最，得水而清，得火而锐，土润则生，土干则脆，能赢甲兄，输于乙妹。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.XIN);
        diTianShui.setDuanYu("辛金软弱，温润而清，畏土之叠，乐水之盈，能扶社稷，能救生灵，热则喜母，寒则喜丁。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.REN);
        diTianShui.setDuanYu("壬水通河，能泄金气，则中之德，周流不滞，通根透癸，冲天奔地，化则有情，从则相济。");
        helper.insertDiTianShui(diTianShui);

        diTianShui.setRiGan(CaculateGanZhi.GUI);
        diTianShui.setDuanYu("癸水至弱，达于天津，得龙而运，功化斯神，不愁火土，不论庚辛，合戊见火，化象斯真。");
        helper.insertDiTianShui(diTianShui);

        //插入三命通会的数据
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("甲子日甲子时，子遥巳格，年月无庚辛申酉，丑绊午冲，离祖自立，贵。" +
                "若年月俱寅，逢申酉运，大富后退财。子亥卯未年月，行西运，贵。" +
                "甲辰月亦贵。酉月，只以正官格论，大贵。巳午戌月，平常。午月，甲死子冲，尤不吉。" +
                "乙卯、乙巳月，主法死。以上具以日时为主，而以人命年月附之，其官御不同者，此前代命也。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("甲寅日甲子时，拱丑中辛，贵。年月无庚辛申酉丑未，" +
                "大贵。再甲寅月，孤克，惟憎道可。亥子年月，四品贵。" +
                "午月，行东北方运，亦贵。如酉丑巳等月，明有官煞，柱但有印，俱贵。" +
                "卯未，身太旺，未免刑伤。乙巳月，受刑。丁亥月，旺中恶死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("甲辰日甲子时，若水位年月，水泛木浮，主移根换叶；" +
                "申月，煞星会印，俱贵。子月，行水木运，亦贵。酉月正官，大贵。" +
                "寅午戌月，俱吉。乙卯月，刑折。癸巳月，水火中死。癸亥月，凶死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("甲午日甲子时，时日并冲，忧伤妻子，月通木气者显贵。纯子午年月，或亥未酉月，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("甲申日甲子时，甲胎逢印印化煞，贵。鸳鸯重迭，子嗣难为。" +
                "若行东南方运，文武职居间。亥卯未辰丑申等月，俱贵。乙卯月夭。丁巳月，死不全尸。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("甲戌日甲子时，拱亥天门，会同帝阙，甲长生地也，不可以隔角论。" +
                "年月通申巳酉丑金气，大贵。戊寅年月，主聋哑，或狼虎伤害，见壬则吉。" +
                "乙卯月，刑死，乙亥月，遭盗死。以上六日年月喜忌，当通融活看。");
        helper.insertSanMing(sanMing);





        //丑时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("甲日乙丑时，辛金为官，己土为财，丑中暗己，被明乙劫夺，乙丑金神，若年日时合成火局，" +
                "得制伏，主德性纯和而贵；无火凶狠；如合水局凶恶损家。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("甲寅日乙丑时，春贫，秋贵，冬富，夏火制金神，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("甲辰日乙丑时，主富厚有财，通火气年月，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("甲午日乙丑时，金神入火局，身弱贫夭。寅戌会火，是一木迭逢火位，不吉。" +
                "若单寅单戌，或申酉亥月，四五品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("甲申日乙丑时，带疾平常。子月生，南方运，贵。秋生化煞，天干透印绶，尤贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("甲戌日乙丑时，田连阡陌，贯朽粟陈，但未免先刑。寅年月，父子俱显。子月，西方运，金紫。");
        helper.insertSanMing(sanMing);


        //寅时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("甲子日丙寅时，日禄居时，青云得路，年月无庚辛金，贵；通木火气极贵。" +
                "午月行东北方运，五六品贵。申月，归禄逢煞，主大权贵；水局平常。若年月与日时同，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("甲寅日丙寅时，年月无巳酉辛丑字，是归禄格，位至一二品。" +
                "纯木火带土，富贵双全，六卿之职。丙子及亥未，卯月，四五品贵；行西南方运，最吉。" +
                "亦有酉、丑月贵者，看干透及年何如。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("甲辰日丙寅时，龙虎拱门，又龙吟虎啸，主贵，或一生近贵，财源或得或失，名利既济未济。" +
                "未、寅年月，官至六卿；戌月风宪；酉月三品；子、亥、丑月四五品，行西方运，大贵；卯、巳年月平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("甲午日丙寅时，身居绝地，主平。若通水月，木得滋养，吉；火月寿夭，天干比助无妨。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("甲申日丙寅时，时日并冲，忧伤妻子。若年月日同，大贵；巳、亥二三品；" +
                "辰、子年月，会水以煞化印，吉；未月财库，亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("甲戌日丙寅时，年月有土则富；有金反复。如有金，须生亥子印月方贵，余月则否。");
        helper.insertSanMing(sanMing);


        //卯时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("甲子日丁卯时，克剥悭吝，作事进退，不免刑伤妻子，或死他乡。" +
                "生辰戌丑未月，贵。卯月凶，柱有官煞制亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("甲寅日丁卯时，年月木火相停，通明之象，贵。" +
                "月令坐丑、未贵。乙亥月，文章冠世，官至三品，干支金水全，官印双显贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("甲辰日丁卯时，财帛满目，生计盈余，妻贤子孝，高命论之。春生太旺无制，贫贱残疾。丑、酉月贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("甲午日丁卯时，身坐绝地，凶刑。若生秋冬，寿夭。春夏富贵。甲午月，大贵，运宜东北方。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("甲申日丁卯时，主武职，风宪权贵。酉月，火木运，中贵。寅、午年月大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("甲戌日丁卯时，逢亥月，有才学，贵显。羊刃最坏，造化须有制合方吉；" +
                "身弱无凶，若年月纯煞，甲木秋生，主夭折。");
        helper.insertSanMing(sanMing);


        //辰时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("甲子日戊辰时，主移根换叶，改姓易宗，妻贤子孝，作高命论。未月，行北方运，贵。酉月，北方运，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("甲寅日戊辰时，龙吟虎啸格，贵。纯辰，中贵。纯寅康寿。亥卯未三合，财旺身强，大贵。酉丑申年月亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("甲辰日戊辰时，刑冲发财，妻重子晚，双亲有克。酉月三四品贵。丑月亦贵。地支纯辰，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("甲午日戊辰时，财多成败，早岁灰心。亥子丑卯午未年月大贵。酉月亦贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("甲申日戊辰时，主孤，僧道清高。丑月富贵。寅月尤贵。甲戌日戊辰时，大富，年月扶合亦贵。" +
                "寅亥年月，三四品贵。但时日并冲克，早年身孤，中年发福。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("甲日戊辰时，天财坐库，时上偏财，遇龙守库，主为商贾发财，田园广盛。" +
                "八月带禄，财官俱有，富贵双全。忌比肩、羊刃夺财。");
        helper.insertSanMing(sanMing);


        //巳时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("甲子日己巳时，先贫后富，祖业轻微，妻勤子拗。生寅未巳丑年月，虽贵防疾。申子辰戌，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("甲寅日己巳时，时日相刑，忧伤妻子。生火年月，有明断之才，掌兵权之职。戊子年月，承袭祖荫，主富。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("甲辰日己巳时，丰姿敦厚，一生平安，财帛有成。巳酉丑年月，行火金运，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("甲午月己巳时，金神入火乡，大贵。酉月，行火木运，武职有权。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("甲申日己巳时，敦厚聪明，善于决断，身孤清贵，不免破刑。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("甲戌日己巳时，财神贵格，名利两全。子戌年月，五品以上贵。");
        helper.insertSanMing(sanMing);


        //午时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("甲子日庚午时，时日相冲，忧伤妻子，平常。若子午年月及寅戌月生，行西北方运，金紫风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("甲寅日庚午时，春月有寿。夏月伤官伤尽，财源进退。申有权，酉反复。冬月伤妻子。子未年月煞助印生，四品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("甲辰日庚午时，田园乐赏。寅月，行金运，风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("甲午日庚午时，破祖业发财，禄因财不得善终。寅午戌年月，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("甲申日庚午时，子辰年月会印。亥卯年月身旺，俱贵。寅戌会伤制煞，甲得寄托，亦贵，运喜金水。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("甲戌日庚午时，生辰戌月，敦厚，不贵则富。丑月行火土运，金紫风宪，寅月清贵。");
        helper.insertSanMing(sanMing);


        //未时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("甲子日辛未时，辰戌丑未及己酉月，土金地方，文贵显达。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("甲寅日辛未时，寅申月贵。纯酉丑年月，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("甲辰日辛未时，辰戌丑未月富。巳酉丑子年月贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("甲午日辛未时，春吉，夏凶，秋身弱难任官禄，冬贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("甲申日辛未时，春吉，夏辛苦，秋显达，冬根基别立贵。子丑月大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("甲戌日辛未时，先刑后贵。寅卯酉丑年月贵，子申年月，位至贵显。");
        helper.insertSanMing(sanMing);


        //申时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("甲子日壬申时，申子辰亥月，水泛木漂，移根换叶，玉堂金马之贵。水土运，凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("甲寅日壬申时，旺中有失。辰戌丑未月勾陈得位；寅、午、戌月，偏官有制；秋月，行东南运，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("甲辰日壬申时，寅辰年月，文章显贵。透丙戊尤美。甲午日壬申时，申子辰月，改姓更宗，敦厚之命。午月贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("甲日壬申时，甲木绝在申，申土壬水长生，庚金建禄，明袅暗鬼，甲旺化鬼为官，犹不免凶暴。" +
                "若生秋庚旺，生冬壬旺，柱无丙戊制伏，漂流之象。若巳午月，大吉。强横透庚，作煞论，运行北方，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("甲申日壬申时，寅月，身煞两停；卯月，以刃合煞，俱贵。子辰年月，以煞化印；" +
                "巳午火月，七煞有制，俱吉。最怕煞旺身弱，大凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("甲戌日壬申时，辰戌丑未月，衣锦有成；亥月学堂；寅月建禄；俱贵。午酉月寿促，不然贫贱。");
        helper.insertSanMing(sanMing);


        //酉时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("甲子日癸酉时，春生木旺；酉月官纯，贵。若混之以煞，或煞多，柱中全无火气，凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("甲寅日癸酉时，春生寿，夏反复。秋性不定，多凶。冬平常。丑未月贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("甲辰日癸酉时，子戌年月，有财有官，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("甲午日癸酉时，主孤。生寅午戌月，行东北方郎官。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("甲申日癸酉时，平常。通火气月，行南运，富贵。申酉年月，多夭。" +
                "有水化金毒，只作官印论，不作金神亦吉，但主退早。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("甲戌日癸酉时，子戌年月，文章显贵。子午月，不贵即富。");
        helper.insertSanMing(sanMing);


        //戌时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("甲子日甲戌时，春寿，夏暴，秋贵，冬，移根换叶，柱见纯亥夹角，虽贵终凶。辰戌丑未，杂气财官，亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("甲寅日甲戌时，比肩争禄，木气遭焚，四十后渐不如前。甲丙申子年月，大贵。纯戌风宪，午月，行水火运，七八品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("甲辰日甲戌时，财源稳厚，多凶。春月金火运，官至六品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("甲午日甲戌时，春生，贵人扶持。夏，背禄逐马。冬，印缓，吉。纯寅年月，近侍贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("甲申日甲戌时，夹酉官贵，但身孤，发亦不久。春生，木土运，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("甲戌日甲戌时，背禄逐马，平常。秋生，官煞有气，贵。辰戌丑未月，吉。" +
                "卯月凶。若丙寅、甲午年月，三甲食二丙，丙夏得时，居寅长生，甲就食见禄，主富贵。");
        helper.insertSanMing(sanMing);


        //亥时
        sanMing.setRiGanZhi(JIA_ZI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("甲子日乙亥时，成趋干格，贵。如生申月，煞旺合刃，权贵。酉月正官，柱稍得土助，大贵。" +
                "辰巳丑未戌月俱吉。年月纯卯，刃旺则凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_YIN);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("甲寅日乙亥时，辰戌丑未月，富。申酉月，贵，冬，平常。若寅亥月，高贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_CHEN);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("甲辰日乙亥时，酉月正官，最贵。辰戌丑未及寅亥年月，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_WU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("甲午日乙亥时，卯月羊刃，刑骨肉，身弱不得善终。春生，贵为宰辅。申子戌午年月，行水火运，官至六卿。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_SHEN);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("甲申日乙亥时，亥月，学问有成，贵为风宪。申酉月，先贫后富。子月，行水火运，金紫。" +
                "辰戌丑未，杂气财官；寅月建禄，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(JIA_XU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("甲戌日乙亥时，春冬生，富，土厚地方显贵。夏，劳力不聚财。秋平常。");
        helper.insertSanMing(sanMing);



        //六乙日的数据
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("乙丑日丙子时，身弱平常，无午穿冲，贤德温厚。申酉年月，风宪。寅子，贵显。" +
                "忌丙寅、己未、甲戌、己丑等月，主凶刑恶死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("乙卯日丙子时，高。辰戌丑未亥年月，不见官星，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("乙巳日丙子时，吉。若巳午年月，寿促，不然，身孤劳碌，纯土，财旺生官，行西运；" +
                "子辰，行水火运，俱二三品贵。申月正官，酉月偏官，卯月建禄，俱吉。忌甲寅月，刑夭。乙酉月下贱。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("乙未日丙子时，平。若子亥年月，大贵，岁运同。" +
                "忌巳未月，刑伤，丙申月，身不完死；己丑月，破祖恶死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("乙酉日丙子时，贵，身孤，反复起倒，月通水气，不见辛午亦贵。" +
                "忌戊寅月，大凶；丁巳月，破祖贫；己酉月，金刃死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("乙亥日丙子时，化青赤，主福。生庚辰年月，富贵。" +
                "纯亥，成败。丑月，行南运郎官。巳午西运，极贫。忌壬辰月，刑；乙酉月，破祖高贵，中恶死。");
        helper.insertSanMing(sanMing);


        //六乙日丑时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("乙丑日丁丑时，秋生有权；主带疾；夏吉，冬平；春旺，贵寿。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("乙卯日丁丑时，亥月，身旺见辛偏官，柱有丁制，风宪武职。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("乙巳日丁丑时生，亥卯未寅月，贵。通金气月有倚托者，福重。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("乙未日丁丑时，辰戌丑未月，富。春寿长，秋名利，夏贫下，冬平常，申年月，武职三品");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("乙酉日丁丑时，若通木气有倚托者，显贵。申丑年月亦好，寅亥尤佳。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("乙亥日丁丑时，亥月，性急有操持，妻贤子孝，官至六七品。午月长生，年月透官印，大贵。");
        helper.insertSanMing(sanMing);


        //六乙日寅时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("乙丑日戊寅时高，生子年戌月者，富贵。辰戌，行木火运，威权。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("乙卯日戊寅时，刑中发福。秋生贵。酉年遇辰戌丑未月，富。卯月建禄，午月印生，透官印，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("乙巳日戊寅时，孤克平常。若年月申庚，正官；丑辛，七煞，俱贵。辰月，北方运，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("乙未日戊寅时，春生有寿。秋贵显。夏平常，冬反复。辰戌且未，俱吉。岁运同。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("乙酉日戊寅时，春生富，夏平、秋贵、寿促，冬吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("乙亥日戊寅时，春吉，夏劳力，秋冬贵。子丑年月，贵至三品，有起有落，寿永。");
        helper.insertSanMing(sanMing);


        //六乙日卯时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("乙丑日己卯时高，中年大福。春生，身太旺，孤。夏贫。" +
                "秋有疾。冬温厚。柱不见辛金，吉。若辰戌丑未月，金紫贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("乙卯日己卯时高，春生旺，为僧道，富足。夏平常，不见辛金，吉。" +
                "秋带疾。冬温厚。卯丑年月，显达高寿。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("乙巳日己卯时，春孤贫，夏平，秋带疾，冬贵。午辰年月、地支一路相连，尤吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("乙未日己卯时，年月不见庚辛金，贵。秋生，看地厚薄，如生壬戌年月，三四品贵。" +
                "乙酉日己卯时秀，初年破祖，中主发财，未年孤刑。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("乙日己卯时，禄入庙堂，乙木逢卯建禄，为人秀丽，通木火者贵。见庚辛为伤禄破命，患目疾。" +
                "若生巳酉丑月，平常衣禄。辰戌丑未，吉。申月亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("乙亥日己卯时，生寅巳月，不见庚辛，日禄归时格，显达清贵。纯卯年月，高僧羽士。戌，特达聪明，有财禄。");
        helper.insertSanMing(sanMing);


        //六乙日辰时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("乙丑日庚辰时，破祖克父，身弱忌疾，通月气者，贵。子申年月，天干透甲戊，合三奇，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("乙卯日庚辰时，富贵。通火土年月，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("乙巳日庚辰时，作事成败，僧道富贵带疾。常人刑克妻子。申子辰卯巳年月，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("乙未日庚辰时，亥卯身，身旺；巳申，官旺，天干透煞印，皆贵。" +
                "丑酉纯煞，柱有火制，亦吉。戌丑年月，四库全，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("乙酉日庚辰时，亥子年月，干透戊癸，贵。寅巳午月，官煞有制，吉。纯酉化金，主厚福。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("乙亥日庚辰时，不贵则富。若年月癸戊一化，申卯两旺，巳丑酉会金，行木土运，位至金紫。");
        helper.insertSanMing(sanMing);


        //六乙日巳时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("乙丑日辛巳时，先杂后纯，生寅午丙丁年月，偏官有制，作高命看。" +
                "巳申酉丑月，官煞重迭，多带疾从煞，亦吉。惟身强主兵权，有名誉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("乙卯日辛巳时，春生，身强煞浅，大贵。夏平常。秋，官煞旺；冬，印绶旺，俱吉。秋不如冬。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("乙巳日辛巳时，克妻，妻子俱晚。若巳酉丑月，木柔金重，主带疾。不然寿促。" +
                "甲巳子巳年月，入偏官格，西运，风宪。春月身旺，更吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("乙未日辛巳时，午月干强，武职，有名誉。亥子印绶，吉。" +
                "乙酉日辛巳时，若未月生，身坐制伏则吉。秋偏官，贵。酉月，行南方运，贫，不然残疾。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("乙日辛巳时，暗金交争，是非日有，若通身旺月，有倚托，化鬼为官，行身旺运，贵。" +
                "通木气月，行金旺运，大贵。通金气月，行身旺运，亦贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("乙亥日辛巳时，生巳午月，偏官有制。春干强，位居风宪。秋煞重，主残疾。");
        helper.insertSanMing(sanMing);


        //六乙日午时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("乙丑日壬午时，春夏多富贵。秋冬官印，或纯煞透干，尤吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("乙卯日壬午时高，丑月，入杂气财官；申酉月，身煞两停，俱主显贵。纯午酉年月，三四品；辰戌，平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("乙巳日壬午时吉，春夏富贵。秋冬平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("乙未日壬午时，寅卯身旺，亥子印旺，丑月财官印三奇，俱主贵显。" +
                "申月正官，尤吉，若庚午、丁亥年月，食神同窠，就食见禄，富贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("乙酉日壬午时，春吉。秋夏平常。柱纯乙酉，透庚合化，或见印助，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("乙亥日壬午时，春身旺，夏福厚，秋反复，冬吉庆。");
        helper.insertSanMing(sanMing);


        //六乙日未时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("乙丑日癸未时，凶刑孤独，年月通土气，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("乙卯日癸未时，改祖离亲，就妻为家。午未年月，贵。春尤贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("乙巳日癸未时，不贵则富，先难后易。纯午、三品贵。辰戌丑月，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("乙未日癸未时，春，身旺刑伤。秋，官煞旺，科名有分。冬安稳。夏平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("乙酉日癸未时，身坐煞，春，身旺，吉。夏，身弱煞衰，贫。秋，煞旺，身能从化，贵。" +
                "冬平。辰戌丑未月，透庚辛，行金运，贵。一到刃运，退官罢职。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("乙亥日癸未时，春木旺，刑伤妻子。申月官旺，贵。" +
                "酉煞旺，年月有火则吉。午未戌年月，一二品贵。冬生稳厚。");
        helper.insertSanMing(sanMing);


        //六乙日申时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("乙丑日甲申时高，纯子辰年月，行东南运，大贵。巳酉丑，贵；中防凶。" +
                "午未纯，吉。亥卯亦吉。余月平平。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("乙卯日甲申时，化贵。月通水气无伤破者，贵，不然，富。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("乙巳日甲申时，身强官旺。春，聪明显达，官至四品。夏，身心劳碌。秋冬眼疾。午年月，行财运，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("乙未日甲申时，生未酉亥月，聪俊特达，官至二三品。丙丁寅午卯酉年月，伤食制煞，权贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("乙酉日甲申时，官煞混杂，若柱丁火制煞留官则吉。亥卯未酉年月，武职极品；不久；行东南方运，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("乙亥日甲申时，时落空亡，主少子。秋生，官居六卿。亥卯年未月，俱吉。");
        helper.insertSanMing(sanMing);


        //六乙日酉时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("乙丑日乙酉时高，生巳酉丑月，合金局，更行西运，大贵。寅午戌月，贫下。" +
                "亥卯未月，吉。纯子年月，行南运，一二品贵。寅月火金，七品贵。申月水木，金紫贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("乙卯日乙酉时，月通金局者贵。未寅年月，官至一二品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("乙巳日乙酉时，春吉。夏，伤官有制，好。秋，木弱金重，夭，不然有疾。冬，福厚亦夭。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("乙未日乙酉时，拱贵格，无刑破者贵，有申填实则非。亥卯月，行西运，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("乙酉日乙酉时，旺处自刑，年月火土重，主灾。若通月气，透出印食，行火木运，大贵。" +
                "地支纯酉，化成金象，但带印绶，贵不可言。最怕岁运遇官。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("乙亥日乙酉时，春生，仁寿格，贵。寅月，行金火运，大贵。");
        helper.insertSanMing(sanMing);


        //六乙日戌时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("乙丑日丙戌时，春身旺，吉。夏，伤官太重。秋，劳力辛苦。" +
                "冬亥子，印绶带伤官，极贵。戌月，木火运，七品贵。纯戌年月，天干透庚丙者，大贵。" +
                "寅午合火者夭。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("乙卯日丙戌时，寅卯月，运西运，六七品贵。子月印绶；丑月杂气，刑出财官，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("乙巳日丙戌时，吉。丑戌未年月，风宪六卿。亥月，行东运，翰院清贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("乙未日丙戌时，旺处凶。卯午未戌年月，贵显。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("乙酉日丙戌时，春身旺，冬印旺，大贵。夏巳午，秋酉戌，俱贵。" +
                "亦看天干如何？丁未、甲辰，生计辛苦；一生遇贵。丑月刑。戌吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("乙亥日丙戌时，血疾。亥子卯未寅月，遇贵发福；天干透伤官生财，尤吉。" +
                "枯木相逢局，逢春叶更生；晚年方得地，花发再重荣。");
        helper.insertSanMing(sanMing);


        //六乙日亥时
        sanMing.setRiGanZhi(YI_CHOU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("乙丑日丁亥时秀，生壬子申未卯月，干透财印者，才德兼全，职在风宪。" +
                "年月干支纯金，身衰煞旺，主凶死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_MAO);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("乙卯日丁亥时，巳酉丑月偏官，申月正官，俱贵。亥月，东南运，风宪。未月，三合木局，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_SI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("乙日丁亥时，死处逢生，乙木死，亥却气壬水为生气印绶，乙用丁为食，亥中丁坐无气，喜甲木生，助丁食为福。" +
                "如遇金局，行水运者，防目疾。四柱见财，或行财运、贪财坏印，主破财。戊为财为妻，庚为官为子，亥上庚绝土病，" +
                "妻衰子少。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_WEI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("乙未日丁亥时贵，子亥年月，公侯。春生，行西运，郎官。酉孤，贵。" +
                "年月木火，主发高科。水土金与日干合化有用者，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_YOU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("乙酉日丁亥时，月通金局，行水运，大贵。通木气，发达。土气，称意。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(YI_HAI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("乙亥日丁亥时，有财自刑，寅卯身旺，天干透财者富；辰丑，行金火运，贵。" +
                "亥子申，官印双清，更辅以财。大贵。");
        helper.insertSanMing(sanMing);




        //六丙日十二时辰
        //六丙日子时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丙子日戊子时，寅巳卯未月，木能生火，大贵。冬月，丙火无气，贫夭。" +
                "戌月，行火土运，五六品贵。忌丁巳月，夭；己酉月，破家失土，身贱。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丙寅日戊子时，生卯丑月，清贵。寅戌，平常。夏月身旺，柱有水金方吉。" +
                "子月正官，大贵。忌癸巳月，刑；癸亥月，恶死；己酉月，大败。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丙辰日戊子时，丙辰为日德格，喜见官星。若生戌月，身旺最宜，武贵。寅月，行金水运，中贵。" +
                "申月三合，合煞有印， 贵。忌己巳月，凶死；己亥月，自刑死；癸丑月，破祖恶死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丙午日戊子时，丙午为日刃格，要官煞制合。生辰戌丑未月，大富。亥卯未寅年月，大贵，申巳，" +
                "文贵三品，武贵不永。纯子，为子午双包贵格。忌丁巳月，恶死；丁亥月，自刑恶死；辛丑月，孤独。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丙申日戊子时，巳午年月，行东北运，风宪，子月，行木火运，三品。" +
                "丑七品，酉亥，虽遇贵反贱。忌癸巳月，中年刑。乙酉月，破败。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丙戌日戊子时，春生，印绶最吉。夏，身太旺，平常。秋，财旺身衰，有寄托则贵。" +
                "纯酉年月，文进之贵。忌己亥月，死不全尸；癸丑月，贫夭。");
        helper.insertSanMing(sanMing);

        //六丙日丑时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丙子日己丑时，寅亥申辰年月，天干透财印食者贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丙寅日己丑时，平常，生乙酉月，正财格，有乙庚健旺者贵。巳丑年月，干透官印者贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丙辰日己丑时，申亥年月，化水则吉；不化寿促，戌月冲库，无人不发。寅午身旺，成火上格，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丙午日己丑时，春月，行火金运，官至极品。夏平，秋富，冬贵，难为妻子，" +
                "午酉年月，五六品，此月禄生财之验。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丙申日巳丑时，血疾。申月，文学儒官成。卯贵。子辰会官，寅卯会印，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丙戌日己丑时高，武刑后发旺。生亥卯月，火金运，大贵。辰未四库全，火土成局，大富。");
        helper.insertSanMing(sanMing);


        //六丙日寅时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丙子日庚寅时，生子月，近贵。癸酉月，行水木运，高贵；火木运，五品以上贵。未申、癸午年月，身居武职，大贵，寿浅。丙寅日庚寅时，" +
                "贵不久。生酉申年月，世裔冷职。子丑寅未，贵显。纯寅尤吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丙日庚寅时，生气学堂，丙寅上长生，文章秀气；丙以庚辛为财，寅上庚绝丙旺。" +
                "若通月气金局者财旺，富贵双全，喜西方运；不通局者财薄。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丙辰日庚寅时，生寅午戌未年月，妻贤子孝，富贵双全。申子，行北运，大贵。酉丑，富。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丙午日庚寅时，年月无壬癸子未巳字，飞天禄马，贵。巳酉丑申，主文学，不贵即富。" +
                "未月，伤官。辰月，先贫后富。亥月，行西运，贵显。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丙申日庚寅时，亥卯未、申子辰二局，官印两旺，大贵。巳丑财局，吉。寅午戌火局，平。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丙戌日庚寅时，生亥子月，贵显。申酉年月，行北方运；寅午戌，行官鬼运，俱大贵。" +
                "若运临死绝，即入黄泉无疑。");
        helper.insertSanMing(sanMing);


        //六丙日卯时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丙子日辛卯时，子卯相刑，伤妻害子。年月同，主魁名，近侍之贵。寅、午、丑、戌、天干地支俱合者大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丙寅日辛卯时，无祖自立，有肢体疾。寅卯未子月，贵。余月平，岁运同。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丙辰日辛卯时，生寅戌月，天月二德，高。巳月，行北方运，贵。酉丑亦贵。亥卯未，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丙午日辛卯时，年月中得癸水官星去刃则吉。子月，伤克妻子，寅酉，性格刚强，不受击触，三四品贵。" +
                "午戌，行东南运；卯月，行西北运，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丙申日辛卯时滞，主聪明好酒色，身旺不化者贵。春吉。冬，行北运，富贵双全。" +
                "巳丑年月，行东运，二品，午未三品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丙戌日辛卯时，伤妻害子，身旺不化者贵。春，聪明好酒色。冬，行西运，富贵。夏风宪。");
        helper.insertSanMing(sanMing);


        //六丙日辰时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丙子日壬辰时，辰戌丑未月，偏官有制，吉。亥卯年月，富贵。寅午，行子运；" +
                "子，行寅午运，俱贵。不然僧道。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丙寅日壬辰时，身煞两旺，寅卯辰丑未年月，大贵。巳午戌年月亦贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丙辰日壬辰时，身孤有财，主恶死。春生，行北运；夏，东运，俱贵。秋，南运，官至三品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丙午日壬辰时贵，身旺煞浅，若辰戌丑未月，偏官有制，贵；无制，平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丙申日壬辰时，旺中灾。春平，夏福，秋富，冬寿促。若申子辰木局，干透印比助，大贵，" +
                "食制煞亦贵。嫌煞透无制，财党煞强，夭死非命。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丙戌日壬辰时，凶。卯未年月，运行火土，官至三品，妻贤子孝。辰戌丑月，平稳。寅午子巳年月，风宪。");
        helper.insertSanMing(sanMing);


        //六丙日巳时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丙子日癸巳时，丙禄在已，癸禄在巳，互换禄马，岁月无壬已寅亥冲破，近侍风宪，位至公侯。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丙寅日癸巳时，春月，干支无水，文进绣衣，荣妻荫子。卯戌申酉年月，二三品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丙辰日癸巳时，不利祖宗。酉戌寅丑年月，魁罡格，通身旺，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丙午日癸巳时，丑辰月，杂气财官，贵显。寅月，丙长生；已月，丙建禄，天干透财印者大贵，宜戒酒。" +
                "子，官旺；酉，财旺，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丙申日癸巳时，身坐偏官、偏财，不贵即富。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丙戌日癸巳时，卯戌丑未月，贵，不永。寅亥年月，风宪，嫌冲刑，宜戒酒。");
        helper.insertSanMing(sanMing);


        //六丙日午时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丙子日甲午时，春生吉；夏无依，秋财旺，冬官贵，少子晚成，火土运发达。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丙寅日甲午时，生辰戌丑未月，上伏火气，造化得中贵。午月，火太旺，凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丙辰日甲午时，寅卯印助，申酉印旺，巳午身旺，亥子官旺，俱吉。然以火土为重，无则福薄。未戌辰丑见，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丙午日甲午时，寅午戌月，作倒冲论，二三品贵。子月，南运，八九品贵。" +
                "寅月，南运，金紫贵。午月，东方运，近侍贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丙申日甲午时，不见火土气者福薄。行金水运，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丙戌日甲午时，春生吉，夏孤克，秋吉，子少。寅午戌月，富贵超群。神仙宰相。");
        helper.insertSanMing(sanMing);


        //六丙日未时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丙子日乙未时，春，印绶稳厚。夏平稳，秋反复，冬贵，岁运同。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丙寅日乙未时，生卯未月，印绶格，智慧丰厚，难为妻子。寅巳子辰年月，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丙辰日乙未时，春吉，夏平稳，秋劳碌，冬贵显。巳午月，行西北运，六七品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丙午日乙未时，不贵则富。午戌年月，职居风宪。申子辰，官星制刃；亥印未，印绶化刃，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丙申日乙未时，不通火气，不见财星，作好命论。年月子辰会官；亥卯会印，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丙戌日乙未时，申子辰年月，近侍贵。寅卯巳年月，大贵。");
        helper.insertSanMing(sanMing);


        //六丙日申时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丙子日丙申时，若通火气及寅卯月再行身旺运，吉。年月纯金，弃命就财，亦以吉论。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丙寅日丙申时，时日对冲，忧伤妻子，通火气月，行身旺运，吉，亥月，手艺。丙辰日丙申时，寅月，" +
                "行南运，贵。子，三合官局，天干透印，大贵。亥生透壬，多夭。戌未，平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丙日丙申时，财旺身衰，丙逢庚为财，壬为鬼，申庚旺壬生，丙火无气，财须比肩分夺。" +
                "若不通身旺月者贫下；有倚托救助，又通身旺月，运再同，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丙午日丙申时，主血火厄，后大发。若巳月生，庚辛透露，财星格，武贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丙申日丙申时高，好色。子辰年月，东运，贵；不然，残疾寿促。亥卯未，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丙戌日丙申时，柱无壬癸亥子酉字填实，作拱格论，贵。寅戌巳午，身旺无依，僧道。");
        helper.insertSanMing(sanMing);


        //六丙日酉时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丙子日丁酉时，春稳，夏贵，秋平，冬吉。未申酉亥年月，大贵。有丑会子，有辰会酉，俱以贵论。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丙寅日丁酉时，卯亥未年月，干透官煞者贵。余月有艺，平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丙辰日丁酉时，寅午戌巳年月，干透煞印者贵。申子会官，干透印比者贵。如年月火土，宜见财则吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丙午日丁酉时，生巳午戌月，僧道命好；酉月贵；亥子丑寅卯辰官印年月，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丙申日丁酉时，通水木气月，行水木运贵。已午，身旺。亥子，官旺。年月两全者，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丙戌日丁酉时，月通木气，行水运，贵；通金气，行火运，金马玉堂，才名冠世。露庚藏戊，贫夭。");
        helper.insertSanMing(sanMing);


        //六丙日戌时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丙子日戊戌时，寿永，名利不失。家亥卯未印及申酉戌已年胜，贵。" +
                "丙子日戊戌时，夏月，福寿双全。春，木克土，食神被枭。寅月，丙戊俱长生，最吉。" +
                "有申庚制甲，大贵。秋冬火衰贫下。巳申亥年月，风宪极品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丙寅日戊戌时，庙堂食神，丙以戊为食神寿星，戌上丙火入库，戊土专位，" +
                "若通火气月及东南运，福厚有寿；不通，平常。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丙辰日戊戌时，午月，丙火有气，土厚地方，五六品贵。亥月，金火运，风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丙午日戊戌时，羊刃食神健旺，名利骤发，亥未辰戌年月，西方运，风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丙申日戊戌时，亥月，东方运，贵。寅午身旺，干透财，吉。丑辰刑冲戌库，发于晚年。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丙戌日戊戌时贫，若通寅巳午戌火局，福寿双全，大贵。见财亦吉。时上食神局，" +
                "楼台店舍中；茶房饼酒肆，几度立家风。");
        helper.insertSanMing(sanMing);


        //六丙日亥时
        sanMing.setRiGanZhi(BING_ZI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丙子日己亥时，秋冬，平常。未月，行水木运，干透木火者，贵。子月，行东运，大贵。" +
                "申、亥、丑、戌年月，亦贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_YIN);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丙寅日己亥时，夏生，化鬼为官，妻贤子孝，不贵则富。寅卯辰巳申丑年月，或午戌会局，" +
                "天干更透丙戌字，主大权贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_CHEN);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丙辰日己亥时，日德格。寅月生，吉，辰月，为僧道主富，平人孤克。戌月冲辰，巳月冲亥，" +
                "丙旺库，俱吉。卯未会，行金水运，申子会，行木火运，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_WU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丙午日己亥时，武贵。寅巳午月生，妻重子晚，不贵即富。秋冬，名利进退，酉午戌，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_SHEN);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丙申日己亥时，春夏生，移根换叶，就妻改福。秋冬平常。酉月，行东南运，风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(BING_XU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丙戌日己亥时，寅卯巳午，木生火炎，妻伤子少，聪明富贵；酉亥子丑，平常，东运亦贵。");
        helper.insertSanMing(sanMing);





        //六丁日十二时辰
        //六丁日子时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁丑日庚子时平，通木火气，或行身旺运，贵。亦有亥子年月贵者，以丁火阴柔，" +
                "不怕水乡故也。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁卯庚子时贫，辰戌丑未，偏官有制，午月干强，春身旺，俱吉。秋冬平常。忌癸巳月，破祖凶；" +
                "己未月，刑伤；甲申月，刺面血光死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁巳日庚子时，春旺，夏强，俱贵。秋冬平常。四季月，制伏得中吉。子辰，行西运，四五品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁未日庚子时，辰戌丑未月，偏官有制。午月干强，贵。余月有制伏，吉；戊子，文章显秀。" +
                "忌戊申月，夭；丙戌月，刑；辛丑月，刑凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁酉日庚子时，辰戌丑未月，刚明特达，贵。辰巳年月，贵尊相府。忌甲寅月，破败恶死；" +
                "癸巳月，离乡恶死；乙酉月刑死。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁亥日庚子时，五十后大旺。辰戌丑未月，吉。寅午年月，贵。" +
                "忌庚寅月，恶死；庚申月，身不全死；辛酉月，破败。");
        helper.insertSanMing(sanMing);


        //六丁日丑时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丁丑日辛丑时，申酉月，财格，财旺生官，贵。午月，伤财身旺，主官禄。" +
                "纯子寅，武贵三品。水月，艰辛劳苦。辰月贵戚。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丁卯日辛丑时，辰巳未年月，富贵，妻子迟。寅卯印助，戌库身旺，刑。丑丁，得倚托，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丁巳日辛丑时，因阴人致贵。巳酉丑申年月，财旺生官，富贵。卯月平常，行此运亦贵。丑月，西南运，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丁未日辛丑时，时日并冲，忧伤妻子。酉月，通水气，吉。岁运同。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丁酉日辛丑时，寅卯巳午，身旺有托，主文名高贵，宠遇非常。申酉戌，财旺从之，最吉。亥子，官旺亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.CHOU);
        sanMing.setDuanYu("丁亥日辛丑时，春印绶，吉，秋生，有火气亦吉，夏太旺，凶。冬官煞旺，吉。未戌月，冲开丑库，富。");
        helper.insertSanMing(sanMing);


        //六丁日寅时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丁丑日壬寅时化贵。生冬月，官旺，贵。春，印绶，安稳，夏吉；秋平，行东运好。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丁卯日壬寅时，贵化吉。寅卯年月，行金水运，大贵。亥子月，行西运，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丁巳日壬寅时，丁死于寅，巳无生意，又被寅刑，有始无终，若行金水运，荣贵。" +
                "寅午年月，身旺；申子辰，官旺；亥卯未，印旺，俱可言贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丁未日壬寅时，恶死。春生印吉，夏，木火运，发福。秋富，冬贵。" +
                "酉戌年月，官至三品。亥卯寅戌，文贵，纯卯行金水运，金紫。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丁酉日壬寅时，亥未寅卯申子年月，聪明富贵，风宪极品。巳午，宰相。辰月，" +
                "行金水运；戌月，东方运，俱贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.YIN_DI_ZHI);
        sanMing.setDuanYu("丁亥日壬寅时，日贵格，配合壬寅，官印俱全，文章显达。子月，大贵，化气凶。");
        helper.insertSanMing(sanMing);


        //六丁日卯时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丁丑日癸卯时，辰戍丑来月，制伏得中。午月，干强，贵。申丑，风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丁卯日癸卯时，寅卯月生，印绶带煞，不为凶论，行官运，贵显。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丁巳日癸卯时，丑月生，北方运，土厚地方.吉，水秀之地，二三品贵。申酉， 用财亦吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丁未日癸卯时.偏官生印。春吉，夏平.秋富，冬铳。或云丁火不怕水，冬生亥 子煞重身柔，大贵。丑未行东运贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丁酉日癸卯时，日时俱坐贵，最吉。春夏身旺，化鬼为官，秋冬身衰，勤苦。" +
                "巳 戌月贵。纯午丑年月，干透庚己，清贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.MAO);
        sanMing.setDuanYu("丁亥日癸卯时，卯月印媛，近侍之贵，寅午京官五六品。");
        helper.insertSanMing(sanMing);


        //六丁日辰时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丁丑日甲辰时吉，亥子月，富贵。申月，东方运；午月，金水运，俱贵。纯寅，风宪极品。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丁卯日甲辰时，辰戌丑未月，孤克，运通发财。丑月，南方运，贵。卯月，金水运，近侍权贵，不利建白。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丁巳日甲辰时，凶刑孤克。春印吉。夏秋平常。冬官旺。纯戌，木火运，官居冷职。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丁未日甲辰时，丑亥卯未月，印绶，官贵。夏平。辰戌，贵厚。酉午，金水运，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丁酉日甲辰时平，年月不见戌字，日主荣贵格。春生，南运，贵；北运，大贵。" +
                "年午月支合局，人马化格，尤贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.CHEN);
        sanMing.setDuanYu("丁亥日甲辰时，日贵格，官禄得位，必当显达。申辰年月，大贵。午月，东北运；辰月，北方运，俱贵。");
        helper.insertSanMing(sanMing);


        //六丁日巳时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丁丑日乙巳时，春富，夏孤，秋吉，冬贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丁卯日乙巳时，春印，夏旺，秋财，冬官，看取用何如？俱可论吉。午未年月，文章贵显，行官禄运，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丁巳日乙巳时，再生巳月，倒冲，亥壬为官，无水填实破格者，主四五品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丁未日乙巳时，若人倒冲格，无冲破，贵。巳亥年月，三四品贵。酉丑合财局，富。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丁酉日乙巳时，破财倒食，若通金水年月，行金水运，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.SI);
        sanMing.setDuanYu("丁亥日乙巳时，时日并冲，忧伤妻子。巳酉丑申子辰，金水二局，财官得用，以富贵论。");
        helper.insertSanMing(sanMing);


        //六丁日午时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.ZI);
        sanMing.setDuanYu("丁丑日丙午时平，寅卯戌未年月，贵。酉丑，用财最吉。忌亥子官煞。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丁卯日丙午时，旺中有灾，卯字刑破白丁。巳月。西北运，贵；东南，极品有权。" +
                "寅亥，武职二品。若全子酉，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丁巳日丙午时，丁禄午，丙禄巳，互换禄格，柱无寅亥子字，文章显贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丁未日丙午时贵，破祖而成。年月忌壬癸字。甲申月，财官印三奇；辰月，官库；亥月，官印，俱大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丁酉日丙午时平，不利子孙。亥卯未年月，贵。巳酉丑，平。寅午戌，富。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.WU_DI_ZHI);
        sanMing.setDuanYu("丁亥日丙午时平，子月，金水运，郎官。未申酉丑年月，俱吉。");
        helper.insertSanMing(sanMing);


        //六丁日未时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丁丑日丁未时，丑未刑冲，不得善终。年月辰戌，四库全，贵当极品。申未，三品，法司淡薄清闲。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丁卯日丁未时，刑中发。寅卯月，印绶，发财敦厚。辰戌申午，俱吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丁巳日丁未时，拱禄格贵。年有子字，则午为阙门，得拱大贵。忌空亡填实。" +
                "年月见财官印，俱吉；财，富；官印，贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丁未日丁未时，八专太旺，早克父母妻子，衣禄平常，为僧道吉。柱通金水木并金水运，衣禄安稳，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丁酉日丁未时，日贵格。若亥卯未寅月生，衣禄敦厚，寅月，金水运，金紫风宪。丁亥日丁未时，卯月，三合印局，" +
                "贵而有寿，申，财官旺；亥，官旺，俱吉，夏生，丁火有气，儒官，但不免孤贫");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.WEI);
        sanMing.setDuanYu("丁日丁未时，火托木局，丁以甲为印绶，未为木库印绶之乡，若柱不见财星，不行财运，" +
                "月年通亥卯未局，有倚托者，安稳之福。");
        helper.insertSanMing(sanMing);


        //六丁日申时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丁丑日戊申时，秀贵。未申年月，贵；行东南运，大贵。巳月，西北运，六卿之职。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丁卯日戊申时，春，伤官用印；秋，伤官用财，俱吉。夏，比肩；冬，伤官见官，平常。四季月，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丁巳日戊申时，不贵即富，未免刑克。夏生，行西北运，贵，秋冬，劳苦。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丁未日戊申时；生巳午未戌，身旺贵显。若亥卯会未，子辰会申，俱以贵论。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丁酉日戊申时，寅午戌丑辰未月生，伤官伤尽为奇，又日贵格，主登科第，运行金水，腰金衣紫。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.SHEN);
        sanMing.setDuanYu("丁亥日戊申时，日时相害，忧伤妻子。通月气身旺者，贵显。年月戊戌、丁巳，火土太重者目疾。" +
                "丁日戊申时为正，天元气旺显文明；为官虽是甘淡薄，运吉终须家道成； ");
        helper.insertSanMing(sanMing);


        //六丁日酉时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丁丑日己酉时，辰巳午未申戍年月贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丁卯日己酉时，时日并冲，忧伤妻子，通火气吉。忌乙卯字。年月有亥未、巳丑，但一字两合，不以冲论。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丁巳日己酉时，巳酉丑年月，财旺生官，终身富贵。亥子亦吉。丁未日己酉时，通火气，贵。见卯乙癸字不贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丁日己酉时，丁火酉上长生，学堂、天乙贵人皆兼得之。丁用己为食，辛为财，" +
                "酉上明己暗辛生旺，文章秀丽，如见卯乙冲破者不贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丁酉日己酉时，刑害孤恶，通木火月，吉。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.YOU);
        sanMing.setDuanYu("丁亥日己酉时，蹇滞。如戊己丙丁年月，居近侍有权。卯甲乙寅，西北运，贵。");
        helper.insertSanMing(sanMing);


        //六丁日戌时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丁丑日庚戌时，时日相刑，忧伤妻子。若寅亥申酉年月，官至三品。午未子辰，行金木运亦贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丁卯日庚戌时，生亥未年月，三合会印，贵。子月，煞印，吉。年月建禄，僧道，主贵。柱无救助，" +
                "见癸旺，多患目疾，酉月无贵；纯酉戌年月，天干透己甲者贵，中带凶。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丁巳日庚戌时，辰巳月，金水运，风宪。癸子、壬亥，南方运，极品。" +
                "纯未，西北运，三四品；身旺不行财官运，平常，为僧道清高。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丁未日庚戌时，主刑。亥卯会印，申子辰会官，俱主文贵。午月，建禄，有子冲，凶。" +
                "若年月用土生财，主富；用财生官，富贵双全。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丁酉日庚戌时，日贵格，近贵，晓艺业，有机谋。酉戌，六害，骨肉无情，秋月，五六品贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.XU);
        sanMing.setDuanYu("丁亥日庚戌时，日贵格。巳酉丑年月，四五品贵。寅卯亥，火金运，位至六卿。");
        helper.insertSanMing(sanMing);


        //六丁日亥时
        sanMing.setRiGanZhi(DING_CHOU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丁丑日辛亥时，秋财旺，夏身旺，春印旺，贵显。冬，官煞太重，恐身弱不能胜任其福。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_MAO);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丁卯日辛亥时，时上财官印三奇，再得年月印助财生，皆主大贵。纯子，行木火运，官可六品，" +
                "巳酉丑月，辛财得局，方有倚旺，富贵双全。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_SI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丁巳日辛亥时，时日相冲，忧伤妻子。若通火气，秋生，行东运，贵。辛月得巳亥者，破祖显秀。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_WEI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丁未日辛亥时，亥卯未寅辰午年月，干透正印、正官者，聪明贵显；行西运，极品。巳丑月，风宪。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_YOU);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丁酉日辛亥时，贵人捧印，贵。子月，东方运，风宪。柱有巳丑会财，卯未会印，天干透财官印者，大贵。");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi(DING_HAI);
        sanMing.setShiChen(CaculateGanZhi.HAI);
        sanMing.setDuanYu("丁亥日辛亥时，日贵格，又三奇全，通月气身旺者贵。卯未三合印局，大贵。");
        helper.insertSanMing(sanMing);






























        qiongTong.setRiGan("甲");
        qiongTong.setYueFen("寅");
        qiongTong.setDuanYu("果断是一条好命");
        helper.insertQiongTong(qiongTong);
        qiongTong.setRiGan("甲");
        qiongTong.setYueFen("卯");
        qiongTong.setDuanYu("烂命一条");
        helper.insertQiongTong(qiongTong);

        sanMing.setRiGanZhi("乙");
        sanMing.setShiChen("庚");
        sanMing.setDuanYu("乙的命格不靠谱");
        helper.insertSanMing(sanMing);

        sanMing.setRiGanZhi("癸亥");
        sanMing.setShiChen("亥");
        sanMing.setDuanYu("最后一条数据");
        helper.insertSanMing(sanMing);
    }
}
