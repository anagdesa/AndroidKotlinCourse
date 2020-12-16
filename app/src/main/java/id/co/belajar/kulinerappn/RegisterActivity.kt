package id.co.belajar.kulinerappn

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etemail
import kotlinx.android.synthetic.main.activity_register.etpassword

class RegisterActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        var strRole = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //untuk mengubah judul di slide bar
        supportActionBar?.title = "Silahkan Registrasi"
        //untuk memberi icon back to home
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //button listener punya bapake
        /*
        val listRole = arrayOf("Jadi", "Pergi", "Pulang")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listRole
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        srole.adapter = adapter
        */

        //perintah dropdown
        val strspinner = arrayOf("Guru", "Dosen", "Mahasiswa")
        srole.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strspinner)

        srole.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                strRole = p0?.getItemAtPosition(p2).toString()
            }

        }

        //default jenis kelamin
        rgJenisK.check(rlaki2.id)

        //button
        btregister.setOnClickListener {
            val strNama = etnamal.text
            val strEmail = etemail.text
            val strPsswrd = etpassword.text

            //variable untuk radio group button
            val intRadioGroup: Int = rgJenisK!!.checkedRadioButtonId
            val rbJenisK: RadioButton = findViewById(intRadioGroup)
            val strJenisK = rbJenisK.text

            //menggabungkan variable string
            val strTampil = "$strNama, $strEmail, $strPsswrd, $strJenisK, $strRole"

            //condition tampilan
            when {

                etnamal.length() == 0 && etemail.length().equals(0) && etpassword.length()==0 -> Toast.makeText(this@RegisterActivity, "belum diisi", Toast.LENGTH_SHORT).show()
                etnamal.length() == 0 -> etnamal.setError("masukkan nama")
                etemail.length() == 0 -> etemail.setError("masukkan email")
                etpassword.length()== 0 -> etpassword.setError("masukkan password")
            else -> Toast.makeText(this@RegisterActivity, strTampil, Toast.LENGTH_SHORT).show()
            }

            /* //if condition
            if (etnamal.length()==0){
                etnamal.setError("masukkan nama")
                }
            else if ( etemail.length()==0){
                etemail.setError("masukkan email")
                }
            else if (etpassword.length()==0){
                etpassword.setError("masukkan password")}
            else{
            //menampilkan
                Toast.makeText(this@RegisterActivity, strTampil, Toast.LENGTH_SHORT).show()}*/
        }

        //spinner
        //srole.adapter = ArrayAdapter<String>(this,android)
    }
    //untuk aktivasi tombok back to home
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}