import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.gifttracker.Frag1
import com.example.gifttracker.Frag2
import com.example.gifttracker.Frag3

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs  
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return Frag1()
            }
            1 -> {
                return Frag2()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return Frag3()
            }
            else -> return null
        }
    }

    // this counts total number of tabs  
    override fun getCount(): Int {
        return totalTabs
    }
}  