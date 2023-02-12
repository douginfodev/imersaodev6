package com.nlwcopa.imersaodeveloper6.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.databinding.FragmentMainBinding
import com.nlwcopa.imersaodeveloper6.databinding.FragmentSplashScreenBinding
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragmentDirections
import com.nlwcopa.imersaodeveloper6.ui.splashscreen.SplashScreenFragment
import com.nlwcopa.imersaodeveloper6.ui.splashscreen.SplashScreenViewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Inserir Fragment na View
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnEntrar.setOnClickListener{
//            findNavController().navigate(R.id.action_mainFragment_to_conversorFragment)
            findNavController()
                .navigate(
                    MainFragmentDirections
                        .actionMainFragmentToConversorFragment(11,15)
                )

        }

        val root : View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}