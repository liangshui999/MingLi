package kankan.wheel.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wheeldemo.R;

import java.util.Calendar;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import kankan.wheel.widget.adapters.NumericWheelAdapter;

public class DateActivity extends Activity {
    private String tag="DateActivity";
    private String months[]= new String[] {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_layout);

        Calendar calendar = Calendar.getInstance();

        final WheelView month = (WheelView) findViewById(R.id.month);
        final WheelView year = (WheelView) findViewById(R.id.year);
        final WheelView day = (WheelView) findViewById(R.id.day);

        //在监听器里面检测到当前选中的项，而不是在adapter里面进行操作
        OnWheelChangedListener listener = new OnWheelChangedListener() {
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                updateDays(year, month, day);
                Log.d(tag, "currentValue=" + newValue);
            }
        };

        // month
        int curMonth = calendar.get(Calendar.MONTH);
        month.setViewAdapter(new DateArrayAdapter(this, months, curMonth));
        month.setCurrentItem(curMonth);
        month.addChangingListener(listener);
        month.setCyclic(true);//设置循环显示
    
        // year
        int curYear = calendar.get(Calendar.YEAR);
        year.setViewAdapter(new DateNumericAdapter(this, curYear, curYear + 10, 0));
        year.setCurrentItem(curYear);
        year.addChangingListener(listener);
        year.setCyclic(true);//设置循环显示
        
        //day
        updateDays(year, month, day);
        day.setCurrentItem(calendar.get(Calendar.DAY_OF_MONTH) - 1);
        day.setCyclic(true);//设置循环显示
    }
    
    /**
     * Updates day wheel. Sets max days according to selected month and year
     * 控制月份的最大值和最小值，有的月份根本没有31天，不让他有31天显示出来
     */
    void updateDays(WheelView year, WheelView month, WheelView day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + year.getCurrentItem());
        calendar.set(Calendar.MONTH, month.getCurrentItem());
        
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        day.setViewAdapter(new DateNumericAdapter(this, 1, maxDays, calendar.get(Calendar.DAY_OF_MONTH) - 1));
        int curDay = Math.min(maxDays, day.getCurrentItem() + 1);
        day.setCurrentItem(curDay - 1, true);
    }
    
    /**
     * Adapter for numeric wheels. Highlights the current value.
     * 年和日用的是这个适配器
     * 如果是纯数字的话可以使用这种适配器，不用弄数组了，直接使用最大值最小值，他就能自动帮你生成中间的值
     */
    private class DateNumericAdapter extends NumericWheelAdapter {
        // Index of current item
        int currentItem;
        // Index of item to be highlighted
        int currentValue;
        
        /**
         * Constructor
         * @param minValue 传入的数字的最小值
         * @param maxValue 传入的数字的最大值
         * @param current 初始时需要跳到的项
         */
        public DateNumericAdapter(Context context, int minValue, int maxValue, int current) {
            super(context, minValue, maxValue);
            this.currentValue = current;
            //Log.d(tag,"currentValue="+currentValue);
            setTextSize(16);
        }
        
        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            if (currentItem == currentValue) {
                view.setTextColor(0xFF0000F0);
            }
            view.setTypeface(Typeface.SANS_SERIF);
        }
        
        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            currentItem = index;
            //Log.d(tag,"currentItem="+currentItem);
            return super.getItem(index, cachedView, parent);
        }
    }
    
    /**
     * Adapter for string based wheel. Highlights the current value.
     * 月用的是这个适配器
     * 如果是非纯数字，就必须使用这种适配器，往里面传入数组
     */
    private class DateArrayAdapter extends ArrayWheelAdapter<String> {
        // Index of current item
        int currentItem;
        // Index of item to be highlighted
        int currentValue;
        
        /**
         * Constructor
         */
        public DateArrayAdapter(Context context, String[] items, int current) {
            super(context, items);
            this.currentValue = current;

            setTextSize(16);
        }
        
        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            if (currentItem == currentValue) {
                view.setTextColor(0xFF0000F0);
            }
            view.setTypeface(Typeface.SANS_SERIF);
        }
        
        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            currentItem = index;
//            Log.d(tag,"currentItem="+months[currentItem-1]);
            return super.getItem(index, cachedView, parent);
        }
    }
}
