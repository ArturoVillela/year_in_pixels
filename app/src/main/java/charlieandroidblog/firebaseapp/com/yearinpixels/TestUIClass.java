package charlieandroidblog.firebaseapp.com.yearinpixels;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestUIClass {


    public void addUIElements(Context context, LinearLayout fl){

        String [] res = context.getResources().getStringArray(R.array.s_month);


        for (String mes : res ){
            TextView tv = new TextView(context);

            tv.setLayoutParams(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1.0f));

            tv.setText(mes);
            fl.addView(tv);
        }

    }
}
