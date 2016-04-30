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
