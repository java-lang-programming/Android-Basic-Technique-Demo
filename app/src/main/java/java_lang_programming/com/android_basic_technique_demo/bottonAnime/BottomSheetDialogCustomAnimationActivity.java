/*
 * Copyright (C) 2017 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/ja/articles/80
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package java_lang_programming.com.android_basic_technique_demo.bottonAnime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * Screen for BottomSheetDialogCustomAnimationActivity
 */
public class BottomSheetDialogCustomAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog_custom_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> showBottomSheetDialog());
    }

    private void showBottomSheetDialog() {
        CustomBottomSheetDialogFragment customBottomSheetDialogFragment = CustomBottomSheetDialogFragment.newInstance();
        customBottomSheetDialogFragment.show(getSupportFragmentManager(), "dialog");
//        CustomBottomSheetDialogFragmentKotlin customBottomSheetDialogFragmentKotlin = CustomBottomSheetDialogFragmentKotlin.instantiate();
//        customBottomSheetDialogFragmentKotlin.show(getSupportFragmentManager(), "dialog");
    }
}
