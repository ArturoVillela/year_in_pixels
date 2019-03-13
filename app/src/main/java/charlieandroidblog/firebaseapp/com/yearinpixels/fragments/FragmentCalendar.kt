package charlieandroidblog.firebaseapp.com.yearinpixels.fragments

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import charlieandroidblog.firebaseapp.com.yearinpixels.R

class FragmentCalendar : Fragment() {

    lateinit var questionTextView: TextView
    lateinit var activity: Context

    fun setContext(containerActivity: Context) {
        this.activity = containerActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.calendar_layout, container, false)
        generateUICalendar(view)
        return view
    }

    fun generateUICalendar(view: View) {

        //first linearLayout should be for months
        var llContainerVertical = view.findViewById<LinearLayout>(R.id.ll_container_calendar);


        var llevaNumero = true
        for (i in 0..12) {
            if (i > 0) llevaNumero = false

            var linearLayout: LinearLayout = generateRowCalendar(getTitleMonth(i), 31, llevaNumero);
            llContainerVertical.addView(linearLayout)

        }
    }

    private fun getTitleMonth(i: Int): String {

        var arrayMonths = context?.resources?.getStringArray(R.array.s_month)
        var title = arrayMonths!![i]

        return title;
    }

    private fun generateRowCalendar(title: String, length: Int, bLLevaTexto: Boolean): LinearLayout {
        var llContainer: LinearLayout = LinearLayout(context);
        llContainer.orientation = LinearLayout.VERTICAL;

        val paramVerticalLayout = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
        )
        llContainer.layoutParams = paramVerticalLayout

        val paramHorizontalLayout = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1.0f
        )

        for (i in 0..length) {
            var fl = FrameLayout(context)
            fl.background = getActivity()?.getDrawable(R.drawable.selector_day)
            fl.layoutParams = paramHorizontalLayout


            var tvDay: TextView = TextView(activity)
            if (i == 0) {
                tvDay.setText(title)
            } else if (bLLevaTexto) {
                tvDay.setText("$i")
            }
            val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
            params.gravity = Gravity.CENTER;
            tvDay.layoutParams = params

            fl.addView(tvDay)
            llContainer.addView(fl)

        }
        return llContainer

    }


    fun generateLLMonths(): LinearLayout {
        var ll: LinearLayout = LinearLayout(context);
        ll.orientation = LinearLayout.HORIZONTAL;

        var res: Resources = activity.resources
        var meses = res.getStringArray(R.array.s_month)


        val param = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f
        )

        for (mes in meses) {
            var tvMes: TextView = TextView(activity)
            tvMes.setText(mes)
            tvMes.layoutParams = param
            ll.addView(tvMes)
        }


        return ll;
    }
}

















