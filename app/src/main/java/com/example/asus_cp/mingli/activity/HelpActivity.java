package com.example.asus_cp.mingli.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asus_cp.mingli.R;

import java.util.HashMap;
import java.util.Map;

/**
 * 展示帮助内容的activity，
 * Created by asus-cp on 2016-05-08.
 */
public class HelpActivity extends Activity {
    private Map<String,String>help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity_layout);
        init();
        String helpKey=getIntent().getStringExtra(MainActivity.HELP_INTENT_KEY);
        String helpContent=help.get(helpKey);
        TextView helpText= (TextView) findViewById(R.id.text_help);
        helpText.setText(helpContent);
    }

    private void init() {
        help=new HashMap<String,String>();
        help.put("排八字帮助","点击日历图标选择好出生日期，然后选择性别，最后点击八卦按钮即可开始排八字了");
        help.put("分享帮助","请先滑动到想分享的部分，软件会自动进行截图，然后点击分享按钮（在帮助按钮的左侧），" +
                "然后在弹出的对话框里选择分享的途径即可");
        help.put("术语解释","命理有云：一命二运三风水四积德五读书，所谓算命就是根据人出生的年月日时对应的天干地支" +
                "来测算命格的好坏，年月日时是由八个天干和地支组成的，所以算命也称为算八字。其中日元（也就是日柱的天干）代表的是自己。" +
                "根据测算理论的不同，又分为用神派和格局派。用神派看八字时，讲究日主的阴阳平衡，既不能太过，也不能不及。而格局派通过月令（" +
                "月柱的地支）和日主的关系将八字分成很多格局，基本格局大概是10个左右，格局派看八字时更加注重八字的格局是否成立，是否有对格局" +
                "的破坏等等。");
        help.put("命运形成","点击百业经的封面上的任何一点，在弹出的对话框里选择一种打开方式即可");
        help.put("关于软件","本软件完全免费，主要是帮助命理爱好者快速推出八字");
    }
}
