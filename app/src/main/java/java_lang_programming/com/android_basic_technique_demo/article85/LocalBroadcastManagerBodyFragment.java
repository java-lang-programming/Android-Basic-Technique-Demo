package java_lang_programming.com.android_basic_technique_demo.article85;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalBroadcastManagerBodyFragment extends Fragment {

    public static final int REQUEST_CODE_DIALOG = 100;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LocalBroadcastManagerFragment.
     */
    public static LocalBroadcastManagerBodyFragment newInstance() {
        return new LocalBroadcastManagerBodyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_local_broadcast_manager_body, container, false);
        Button btnOpenDialog = view.findViewById(R.id.btn_open_dialog);
        btnOpenDialog.setOnClickListener(v -> showBottomSheetDialog());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * show BottomSheetDialog
     */
    public void showBottomSheetDialog() {
        LocalBroadcastManagerBottomSheetDialogFragment bottomSheetDialog = LocalBroadcastManagerBottomSheetDialogFragment.newInstance();
        bottomSheetDialog.setTargetFragment(this, REQUEST_CODE_DIALOG);
        bottomSheetDialog.show(getFragmentManager(), "dialog");

//        KtLocalBroadcastManagerBottomSheetDialogFragment bottomSheetDialog = KtLocalBroadcastManagerBottomSheetDialogFragment.Companion.newInstance();
//        bottomSheetDialog.setTargetFragment(this, REQUEST_CODE_DIALOG);
//        bottomSheetDialog.show(getFragmentManager(), "dialog");
    }
}
