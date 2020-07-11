package com.sun_asterisk.foodies.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.screen.tab_layout.TabFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabFragment(TabFragment())
    }

    private fun setupTabFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}

