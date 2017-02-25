/**
 * Copyright (C) 2017 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/
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

package java_lang_programming.com.android_basic_technique_demo.article76;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import java_lang_programming.com.android_basic_technique_demo.R;


/**
 * Dialog Screen
 */
public class ImageFilterDialogFragment extends DialogFragment {
    public static final String SELECTED_FILTER_NAME = "filter";
    private Fragment fragment;

    /**
     * コンストラクタ
     *
     * @return A new instance of fragment ImageFilterDialogFragment.
     */
    public static ImageFilterDialogFragment newInstance() {
        ImageFilterDialogFragment fragment = new ImageFilterDialogFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        fragment = getTargetFragment();
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.image_filter_dialog_fragment_title)
                .setItems(R.array.image_filters_name, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        Intent intent = new Intent();
                        intent.putExtra(ImageFilterDialogFragment.SELECTED_FILTER_NAME, which);
                        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                    }
                })
                .create();
    }
}
// https://developer.android.com/guide/topics/ui/dialogs.html?hl=ja