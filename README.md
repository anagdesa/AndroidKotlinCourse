# AndroidKotlinCourse to Networks

Step 1 
build.gredle https://github.com/anagdesa/AndroidKotlinCourse/blob/AndroidKotlinCourse/app/build.gradle


konfiguration for Network database
refrensi from mr. pedy https://pastebin.com/2GgJbAPb

New > kotlin > file
judul file : NetworkTools.kt

    Disesuikan dengan package yang dada pada kodisi app --> package id.co.belajar.kulinerappn

    import android.os.StrictMode
    import org.json.JSONArray
    import java.io.BufferedReader
    import java.io.InputStreamReader
    import java.net.HttpURLConnection
    import java.net.URL

    fun getJSON(url: String): String {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        val c: HttpURLConnection?
        StrictMode.setThreadPolicy(policy)

        val response: String?
        val u = URL(url)

        c = u.openConnection() as HttpURLConnection
        c.setRequestProperty("Content-length", "0")
        c.requestMethod = "GET"
        c.useCaches = false
        c.allowUserInteraction = false
        //c.setConnectTimeout(timeout);
        //c.setReadTimeout(timeout);
        c.connect()

        val br = BufferedReader(InputStreamReader(c.inputStream))
        val sb = StringBuilder()
        var line = br.readLine()

        while (line != null) {
            sb.append(line + "\n")
            line = br.readLine()
        }

        br.close()
        response = sb.toString()

        return response
    }

    fun jsonArrayToList(jsonArray: JSONArray): ArrayList<LinkedHashMap<String, String>> {
        val table = ArrayList<LinkedHashMap<String, String>>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val key = jsonObject.keys()
            val row = LinkedHashMap<String, String>()
            while (key.hasNext()) {
                val k = key.next().toString()
                row.put(k, jsonObject.getString(k))
            }
            table.add(row)
        }

        return table
    }


Tampilan

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/textViewNama"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <TextView
        android:id="@+id/textViewKeterangan"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <TextView
        android:id="@+id/textViewKontributor"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <TextView
        android:id="@+id/textViewLat"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />

    <TextView
        android:id="@+id/textViewLon"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="TextView" />
</LinearLayout>
