package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.ui.main.MainFragment

class ConversorFragment : Fragment () {

    companion object {
        fun newInstance() = ConversorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_conversor, container, false)
    }
}