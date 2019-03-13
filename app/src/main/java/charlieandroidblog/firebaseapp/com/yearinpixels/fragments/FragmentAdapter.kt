package charlieandroidblog.firebaseapp.com.yearinpixels.fragments

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class FragmentAdapter internal constructor(fm: FragmentManager) : FragmentStatePagerAdapter(fm){

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }


    /**
     * If you want to only show icons, return null from this method.
     * @param position
     * @return
     */
    override fun getPageTitle(position: Int): CharSequence? {
        //return mFragmentTitleList[position]
        return null
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

}