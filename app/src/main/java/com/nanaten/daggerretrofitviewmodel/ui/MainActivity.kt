package com.nanaten.daggerretrofitviewmodel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nanaten.daggerretrofitviewmodel.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MainFragmentを表示
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()

    }
}
