package com.sun_asterisk.foodies.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sun_asterisk.foodies.R
import kotlinx.android.synthetic.main.fragment_grocery.*

class GroceryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grocery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonExit.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                remove(this@GroceryFragment)
                commit()
            }
        }
        buttonSearch.setOnClickListener {
            Toast.makeText(this.context,editTextSearch.text.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}
