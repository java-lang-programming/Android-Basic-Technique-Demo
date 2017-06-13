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

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * Screen for BottomSheetDialog
 */
public class CustomBottomSheetDialogFragment extends AppCompatDialogFragment {

    public static final String TAG = "CustomDialogFragment";

    public static CustomBottomSheetDialogFragment newInstance() {
        return new CustomBottomSheetDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(TAG, "onCreateDialog");
        return new BottomSheetDialog(getContext(), R.style.CustomBottomSheet_Dialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_bottom_sheet_dialog, container, false);
    }
}