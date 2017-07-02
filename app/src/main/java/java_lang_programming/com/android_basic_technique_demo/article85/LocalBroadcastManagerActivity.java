package java_lang_programming.com.android_basic_technique_demo.article85;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * Activity for LocalBroadcastManager
 */
public class LocalBroadcastManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast_manager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.container, LocalBroadcastManagerBodyFragment.newInstance());
        ft.replace(R.id.footer_container, LocalBroadcastManagerFooterFragment.newInstance());
        // ft.replace(R.id.footer_container, KtLocalBroadcastManagerFooterFragment.Companion.newInstance());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the chang
        ft.commit();
    }

}
