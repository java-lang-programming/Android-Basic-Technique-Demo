package java_lang_programming.com.android_basic_technique_demo.article86.kotlin

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java_lang_programming.com.android_basic_technique_demo.R
import java_lang_programming.com.android_basic_technique_demo.article86.Constants
import java_lang_programming.com.android_basic_technique_demo.article86.LocalBroadcastManagerFooterFragment

/**
 * Created by msuzuki on 2017/07/01.
 */
class KtLocalBroadcastManagerFooterFragment : Fragment(), LifecycleRegistryOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    private lateinit var msg: TextView

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment LocalBroadcastManagerChildFragment.
         */
        @JvmStatic fun newInstance(): LocalBroadcastManagerFooterFragment {
            return LocalBroadcastManagerFooterFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_local_broadcast_manager_footer, container, false)
        msg = view.findViewById<TextView>(R.id.msg) as TextView
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d("FooterFragment ", "onResume")
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        LocalBroadcastManager.getInstance(activity.applicationContext).registerReceiver(
                messageReceiver, IntentFilter(Constants.ACTION_NAME))
        super.onResume()
    }

    override fun onPause() {
        Log.d("FooterFragment ", "onPause")
        LocalBroadcastManager.getInstance(activity.applicationContext).unregisterReceiver(messageReceiver)
        super.onPause()
    }

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "custom-event-name" is broadcasted.
    private val messageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            Log.d("FooterFragment ", "BroadcastReceiver : " + lifecycle.currentState)
            // Get extra data included in the Intent
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                intent?.let { intent ->
                    if (intent.action != Constants.ACTION_NAME) {
                        return
                    }

                    val message = intent.getStringExtra(Constants.EXTRA_NAME)
                    msg.text = message
                    val bgColor = intent.getIntExtra(Constants.EXTRA_BG_COLOR, 0)
                    getView()?.setBackgroundColor(ContextCompat.getColor(activity.applicationContext, bgColor))
                }
            }
        }
    }
}