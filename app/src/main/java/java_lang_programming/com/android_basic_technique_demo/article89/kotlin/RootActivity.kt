package java_lang_programming.com.android_basic_technique_demo.article89.kotlin

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java_lang_programming.com.android_basic_technique_demo.R

/**
 * RootActivity
 */
class RootActivity : AppCompatActivity(), MainFragment.Listener {

    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        display = findViewById(R.id.display)

        val btnCheckCount: Button = findViewById(R.id.btn_check_count)
        btnCheckCount.setOnClickListener {
            setDisplay()
        }

        val btnPopBackStack: Button = findViewById(R.id.btn_pop_back_stack)
        btnPopBackStack.setOnClickListener {
            popBackStack()
        }

        val btnPopBackStackInclusive: Button = findViewById(R.id.btn_pop_back_stack_inclusive)
        btnPopBackStackInclusive.setOnClickListener {
            popBackStackInclusive()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frag, MainFragment.newInstance(), MainFragment.NAME)
        // バックスタックに追加
        transaction.addToBackStack(MainFragment.NAME)
        transaction.commitAllowingStateLoss()
    }

//    override fun onBackPressed() {
//        val result = supportFragmentManager.popBackStackImmediate()
//        //val isStateSaved = fragmentManager.isStateSaved
//        Log.d("RootActivity : ", result.toString())
//        //Log.d("RootActivity : ", isStateSaved?.toString())
//        super.onBackPressed()
//    }

    private fun setDisplay() {
        display.text = supportFragmentManager.backStackEntryCount.toString()
    }

    private fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    private fun popBackStackInclusive() {
        //supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.popBackStack(SubFragment.NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}
