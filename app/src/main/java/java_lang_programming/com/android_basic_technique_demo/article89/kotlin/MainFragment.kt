package java_lang_programming.com.android_basic_technique_demo.article89.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import java_lang_programming.com.android_basic_technique_demo.R

/**
 * MainFragment is main Fragment for RootActivity
 */
class MainFragment : Fragment() {

    companion object {
        const val NAME = "MainFragment"
        const val REQUEST_CODE_MAIN_FRAGMENT_CALLBACK = 1

        @JvmStatic fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private var mListener: Listener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        val btnAddFrag: Button = view.findViewById(R.id.btn_add_frag)
        btnAddFrag.setOnClickListener { onClickBtnAddFrag() }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Listener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    private fun onClickBtnAddFrag() {
        val subFragment = SubFragment.newInstance()
        subFragment.setTargetFragment(this, REQUEST_CODE_MAIN_FRAGMENT_CALLBACK)

        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.add(R.id.add_frag, subFragment, SubFragment.NAME)
        // バックスタックに追加
        transaction.addToBackStack(SubFragment.NAME)
        transaction.commitAllowingStateLoss()
    }

    interface Listener
}
