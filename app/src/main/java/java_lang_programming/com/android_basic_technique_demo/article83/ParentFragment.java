/*
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

package java_lang_programming.com.android_basic_technique_demo.article83;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java_lang_programming.com.android_basic_technique_demo.R;

/**
 * Parent Screen
 */
public class ParentFragment extends Fragment {

    private OnParentFragmentListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_parent, container, false);
        final Button btnClick1 = (Button) view.findViewById(R.id.btn_click_1);
        btnClick1.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onClickClick1();
            }
        });

        final Button btnClick2 = (Button) view.findViewById(R.id.btn_click_2);
        btnClick2.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onClickClick2();
            }
        });

        final Button btnShowBottomSheet = (Button) view.findViewById(R.id.btn_show_bottom_sheet);
        btnShowBottomSheet.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onShowBottomSheet();
            }
        });

        final Button btnCloseBottomSheet = (Button) view.findViewById(R.id.btn_close_bottom_sheet);
        btnCloseBottomSheet.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onCloseBottomSheet();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnParentFragmentListener) {
            mListener = (OnParentFragmentListener) context;
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
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    protected interface OnParentFragmentListener {

        void onClickClick1();

        void onClickClick2();

        void onShowBottomSheet();

        void onCloseBottomSheet();
    }
}
