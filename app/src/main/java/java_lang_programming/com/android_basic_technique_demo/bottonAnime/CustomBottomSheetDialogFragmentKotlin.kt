package java_lang_programming.com.android_basic_technique_demo.bottonAnime

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java_lang_programming.com.android_basic_technique_demo.R

/*
 * Created by msuzuki on 2017/06/13.
 */
class CustomBottomSheetDialogFragmentKotlin : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(context, R.style.CustomBottomSheet_Dialog)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_custom_bottom_sheet_dialog, container, false)
    }

    companion object {

        fun newInstance(): CustomBottomSheetDialogFragment {
            return CustomBottomSheetDialogFragment()
        }

    }
}