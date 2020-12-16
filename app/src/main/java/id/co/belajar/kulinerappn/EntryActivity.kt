package id.co.belajar.kulinerappn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
        //untuk judul Bar
        supportActionBar?.title = "Entry Kuliner Top"
        //untuk menampilkan icon back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    //aktivasi icon back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}