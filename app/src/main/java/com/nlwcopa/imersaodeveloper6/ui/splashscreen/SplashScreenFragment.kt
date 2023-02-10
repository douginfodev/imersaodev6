package com.nlwcopa.imersaodeveloper6.ui.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = SplashScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewModel
        val splashscreenViewModel =
            ViewModelProvider(this).get(SplashScreenViewModel::class.java)

        //Inserir Fragment na View
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        binding.btnEntrar.setOnClickListener{
           findNavController().navigate(R.id.action_splashScreenFragment_to_mainFragment)
        }

        val root : View = binding.root
        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.splashscreenViewModel  = splashscreenViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}