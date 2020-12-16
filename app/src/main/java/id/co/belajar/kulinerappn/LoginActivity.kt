package id.co.belajar.kulinerappn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hidden action bar
        supportActionBar?.hide()
        //hidden status bar
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_login)

        tvregister.paint?.isUnderlineText = true

        tvregister.setOnClickListener {
            var intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        btlogin.setOnClickListener {
            var new = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(new)
        }
    }
}