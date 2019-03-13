package charlieandroidblog.firebaseapp.com.yearinpixels

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import charlieandroidblog.firebaseapp.com.yearinpixels.fragments.FragmentCalendar
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Button
import charlieandroidblog.firebaseapp.com.yearinpixels.fragments.FragmentAdapter
import charlieandroidblog.firebaseapp.com.yearinpixels.fragments.FragmentNotas


class MainActivity : AppCompatActivity() {

    var fragmentAdapter: FragmentAdapter? = null
    var pager: ViewPager? = null

    var alBotones:ArrayList<Button> ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentAdapter = FragmentAdapter(supportFragmentManager)

        val fragmentCalendar = FragmentCalendar()
        fragmentCalendar.setContext(this)
        val fragmentNotas = FragmentNotas()
        fragmentNotas.setContext(this)


        fragmentAdapter?.addFragment(fragmentCalendar, "")
        fragmentAdapter?.addFragment(fragmentNotas, "")


        pager = findViewById(R.id.viewpager)
        pager?.adapter = fragmentAdapter

        pager?.setCurrentItem(0)


        val btn1 : Button = findViewById(R.id.button1)
        val btn2 : Button = findViewById(R.id.button2)

        btn1.setOnClickListener(View.OnClickListener { pager?.setCurrentItem(0)})
        btn2.setOnClickListener(View.OnClickListener { pager?.setCurrentItem(1)})

    }

    private fun loadFragmentCalendar() {
        var fragmentCalendar = FragmentCalendar();
        fragmentCalendar.setContext(this)

        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()

        transaction.replace(R.id.fl_container,fragmentCalendar)
        transaction.commit()
    }


}
