package java_lang_programming.com.android_basic_technique_demo.article86.kotlin

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.content.LocalBroadcastManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java_lang_programming.com.android_basic_technique_demo.R
import java_lang_programming.com.android_basic_technique_demo.article86.Constants

/**
 * Created by msuzuki on 2017/07/01.
 */
class KtLocalBroadcastManagerBottomSheetDialogFragment : BottomSheetDialogFragment(), LifecycleRegistryOwner {

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @return A new instance of fragment LocalBroadcastManagerBottomSheetDialogFragment.
         */
        @JvmStatic fun newInstance(): KtLocalBroadcastManagerBottomSheetDialogFragment {
            return KtLocalBroadcastManagerBottomSheetDialogFragment()
        }
    }

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_local_broadcast_manager_bottom_sheet_dialog, container, false)
        val btnSend = view.findViewById<Button>(R.id.btn_send)
        btnSend.setOnClickListener { v -> onClickBtnSend() }
        return view
    }

    private fun onClickBtnSend() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            val intent = Intent(Constants.ACTION_NAME)
            intent.putExtra(Constants.EXTRA_NAME, "Hello LocalBroadcastManager")
            intent.putExtra(Constants.EXTRA_BG_COLOR, R.color.colorBg)
            LocalBroadcastManager.getInstance(activity.applicationContext).sendBroadcast(intent)
            dismiss()
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}
