package com.nlwcopa.imersaodeveloper6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragment
import com.nlwcopa.imersaodeveloper6.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ConversorFragment.newInstance())
                .commitNow()
        }
    }
}