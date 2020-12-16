package id.co.belajar.kulinerappn

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //untuk judul Bar
        supportActionBar?.title = "List Menu Top"
        //untuk menampilkan icon back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //tombol menuju activity_entry
        faAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, EntryActivity::class.java)
            startActivity(intent)
        }

    }
    //aktivasi icon back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}