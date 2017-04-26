package java_lang_programming.com.android_basic_technique_demo.article83;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java_lang_programming.com.android_basic_technique_demo.R;

public class OverlayFragmentActivity extends AppCompatActivity implements ParentFragment.OnParentFragmentListener, ChildFragment.OnChildFragmentListener {

    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RelativeLayout bottomSheet = (RelativeLayout) findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void onClickClick1() {
        Toast.makeText(this, getString(R.string.fragment_parent_btn_1), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickClick2() {
        Toast.makeText(this, getString(R.string.fragment_parent_btn_2), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onShowBottomSheet() {
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.child_fragment, ChildFragment.newInstance());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the chang
        ft.commit();

        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void onCloseBottomSheet() {
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    @Override
    public void onClickChildFragmentBtn1() {
        Toast.makeText(this, getString(R.string.fragment_child_btn_1), Toast.LENGTH_LONG).show();
    }
}
