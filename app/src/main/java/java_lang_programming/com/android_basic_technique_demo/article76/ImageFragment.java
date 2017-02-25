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
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java_lang_programming.com.android_basic_technique_demo.R;


/**
 * Image Screen
 */
public class ImageFragment extends Fragment {
    public static final int REQUEST_CODE_IMAGE_FILTER_DIALOG = 100;

    private ImageView imageView;

    private OnFragmentInteractionListener mListener;

    public static ImageFragment newInstance() {
        ImageFragment fragment = new ImageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setOnClickListener(image -> {
            openDialog();
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Open ImageFilterDialogFragment
     */
    private void openDialog() {
        ImageFilterDialogFragment imageFilterDialogFragment = ImageFilterDialogFragment.newInstance();
        imageFilterDialogFragment.setTargetFragment(this, ImageFragment.REQUEST_CODE_IMAGE_FILTER_DIALOG);
        imageFilterDialogFragment.show(getFragmentManager(), "dialog");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_IMAGE_FILTER_DIALOG:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                }
                String[] imageFiltersName = getResources().getStringArray(R.array.image_filters_name);
                Toast.makeText(getActivity().getApplicationContext(),
                        "requestCode : " + requestCode + ", resultCode : " + resultCode + " " +
                                getString(R.string.image_filter_selected_msg, imageFiltersName[data.getIntExtra(ImageFilterDialogFragment.SELECTED_FILTER_NAME, 0)]),
                        Toast.LENGTH_LONG).show();
                break;
        }
    }

    public interface OnFragmentInteractionListener {
    }
}
