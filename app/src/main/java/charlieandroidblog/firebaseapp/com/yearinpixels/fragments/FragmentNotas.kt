package charlieandroidblog.firebaseapp.com.yearinpixels.fragments

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import charlieandroidblog.firebaseapp.com.yearinpixels.R

class FragmentNotas : Fragment() {

    lateinit var questionTextView: TextView
    lateinit var activity: Context

    fun setContext(containerActivity: Context) {
        this.activity = containerActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.notas_layout, container, false)

        return view
    }


}

















