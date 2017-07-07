package java_lang_programming.com.android_basic_technique_demo.article86;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * BottomSheetDialogFragment for LocalBroadcastManager
 */
public class LocalBroadcastManagerBottomSheetDialogFragment extends BottomSheetDialogFragment implements LifecycleRegistryOwner {

    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LocalBroadcastManagerBottomSheetDialogFragment.
     */
    public static LocalBroadcastManagerBottomSheetDialogFragment newInstance() {
        return new LocalBroadcastManagerBottomSheetDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_local_broadcast_manager_bottom_sheet_dialog, container, false);
        Button btnSend = view.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(v -> onClickBtnSend());
        return view;
    }

    private void onClickBtnSend() {
        Log.d("LocalBroadcastFragment ", "BroadcastReceiver : " + getLifecycle().getCurrentState());
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            Intent intent = new Intent(Constants.ACTION_NAME);
            intent.putExtra(Constants.EXTRA_NAME, "Hello LocalBroadcastManager");
            intent.putExtra(Constants.EXTRA_BG_COLOR, R.color.colorBg);
            LocalBroadcastManager.getInstance(getActivity().getApplicationContext()).sendBroadcast(intent);
            dismiss();
        }
    }
}
