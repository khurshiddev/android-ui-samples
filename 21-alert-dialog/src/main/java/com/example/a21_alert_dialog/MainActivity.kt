package com.example.a21_alert_dialog


import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface.OnMultiChoiceClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a21_alert_dialog.databinding.ActivityMainBinding
import com.example.a21_alert_dialog.databinding.CustomDialogViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val checkedList = BooleanArray(3) // bu shu checked listni o'zida save qiladi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogBtn.setOnClickListener {
            val dialogViewBinding = CustomDialogViewBinding.inflate(layoutInflater, null, false)
            val dialog = AlertDialog.Builder(this)
                .setView(dialogViewBinding.root)
                .create()
            dialogViewBinding.signBtn.setOnClickListener {

                Log.d(
                    "dialog",
                    ":${dialogViewBinding.userNameEt.text} ${dialogViewBinding.userEmailEt.text} "
                )
                dialog.dismiss() // button press dismiss
            }

            dialog.show()
        }
    }
}