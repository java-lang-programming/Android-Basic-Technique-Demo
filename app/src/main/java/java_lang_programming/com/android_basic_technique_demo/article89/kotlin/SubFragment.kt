package java_lang_programming.com.android_basic_technique_demo.article89.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java_lang_programming.com.android_basic_technique_demo.R
import java.util.*

/**
 * SubFragment is sub Fragment for MainFragment
 */
class SubFragment : Fragment() {

    companion object {
        const val NAME = "SubFragment"

        @JvmStatic fun newInstance(): SubFragment {
            return SubFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_sub, container, false)
        val btnAddFrag: Button = view.findViewById(R.id.btn_add_frag)
        btnAddFrag.setOnClickListener { onClickBtnAddFrag() }
        return view
    }

    private fun onClickBtnAddFrag() {
        val random = Random()
        val colorInt = when (random.nextInt(3)) {
            0 -> Color.RED
            1 -> Color.BLACK
            2 -> Color.BLUE
            else -> Color.BLUE
        }

        val partsFragment = PartsFragment.newInstance(colorInt)
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.add(R.id.add_parts_frag, partsFragment, PartsFragment.NAME)
        // バックスタックに追加
        transaction.addToBackStack(PartsFragment.NAME)
        transaction.commitAllowingStateLoss()
    }
}
