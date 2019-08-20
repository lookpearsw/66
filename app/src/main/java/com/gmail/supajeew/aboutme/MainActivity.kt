package com.gmail.supajeew.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.gmail.supajeew.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Supajee Werasatean")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            binding.doneButton.setOnClickListener {
                addNickname(it)
            }
            binding.nicknameText.setOnClickListener {
                updateNickname(it)
            }
        }
        binding.myName = myName
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE

            invalidateAll()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
//        val editText = binding.nicknameEdit
//        val nicknameTextView = binding.nicknameText
//
//        editText.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE
//
//        val doneButton = binding.doneButton
//        doneButton.visibility = View.GONE


//        hide keyboard

    }

    private fun updateNickname(view: View) {
        val editText = binding.nicknameEdit
        val nicknameTextView = binding.nicknameText
        editText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE


        val doneButton = binding.doneButton
        doneButton.visibility = View.VISIBLE


        // Set the focus to the edit text.
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
