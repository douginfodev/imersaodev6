package com.nlwcopa.imersaodeveloper6.ui.splashscreen

import androidx.fragment.app.Fragment
import com.nlwcopa.imersaodeveloper6.ui.main.MainFragment
import com.nlwcopa.imersaodeveloper6.ui.main.MainViewModel

class SplashScreenFragment : Fragment() {

    companion object {
        fun newInstance() = SplashScreenFragment()
    }

    private lateinit var viewModel: SplashScreenViewModel
}