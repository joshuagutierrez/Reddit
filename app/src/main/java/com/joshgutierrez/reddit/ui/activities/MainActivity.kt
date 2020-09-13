package com.joshgutierrez.reddit.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joshgutierrez.reddit.R
import Request
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.joshgutierrez.reddit.data.Children
import com.joshgutierrez.reddit.ui.adapters.ThreadListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        threadList.layoutManager = LinearLayoutManager(this)


        doAsync {
            val result = Request().run()
            uiThread {
                threadList.adapter = ThreadListAdapter(result, { child: Children -> threadItemClicked(child) })
            }
        }
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT).show()
    }

    //new click handler function
    fun threadItemClicked(repo: Children){
        val builder = AlertDialog.Builder(this)

        builder.setMessage(repo.data.selftext)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))

        builder.show()
    }


}