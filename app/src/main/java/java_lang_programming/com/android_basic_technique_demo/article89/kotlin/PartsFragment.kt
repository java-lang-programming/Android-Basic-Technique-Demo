package java_lang_programming.com.android_basic_technique_demo.article89.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java_lang_programming.com.android_basic_technique_demo.R

/**
 * PartsFragment is sub Fragment for MainFragment
 */
class PartsFragment : Fragment() {

    companion object {
        const val NAME = "PartsFragment"
        const val ARG_COLOR_INT = "ColorInt"

        @JvmStatic fun newInstance(colorInt: Int): PartsFragment {
            val fragment = PartsFragment()
            val args = Bundle()
            args.putInt(ARG_COLOR_INT, colorInt)
            fragment.arguments = args
            return fragment
        }
    }

    private var colorInt: Int = Color.RED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            colorInt = arguments.getInt(ARG_COLOR_INT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_parts, container, false)
        view.setBackgroundColor(colorInt)
        return view
    }
}
