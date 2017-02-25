/**
 * Copyright (C) 2017 Programming Java Android Development Project
 * Programming Java is
 *
 * http://java-lang-programming.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java_lang_programming.com.android_basic_technique_demo.article76;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * Main Screen
 */
public class CallBackFromFragmentToFragmentActivity extends AppCompatActivity implements ImageFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back_from_fragment_to_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.container, ImageFragment.newInstance());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the chang
        ft.commit();
    }
}
