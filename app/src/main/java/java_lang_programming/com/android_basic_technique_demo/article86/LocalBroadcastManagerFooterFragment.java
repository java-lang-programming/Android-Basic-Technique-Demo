package java_lang_programming.com.android_basic_technique_demo.article86;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * ChildFragment for broadcast
 */
public class LocalBroadcastManagerFooterFragment extends Fragment implements LifecycleRegistryOwner {

    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    private TextView msg;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LocalBroadcastManagerChildFragment.
     */
    public static LocalBroadcastManagerFooterFragment newInstance() {
        return new LocalBroadcastManagerFooterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_local_broadcast_manager_footer, container, false);
        msg = view.findViewById(R.id.msg);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FooterFragment ", "onResume");
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).registerReceiver(
                messageReceiver, new IntentFilter(Constants.ACTION_NAME));
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("FooterFragment ", "onPause");
        LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).unregisterReceiver(messageReceiver);
        super.onPause();
    }

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "custom-event-name" is broadcasted.
    private BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("FooterFragment ", "BroadcastReceiver : " + getLifecycle().getCurrentState());
            // Get extra data included in the Intent
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                if (intent.getAction().equals(Constants.ACTION_NAME)) {
                    String message = intent.getStringExtra(Constants.EXTRA_NAME);
                    int bgcolor = intent.getIntExtra(Constants.EXTRA_BG_COLOR, 0);
                    msg.setText(message);
                    getView().setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), bgcolor));
                }
            }
        }
    };
}
