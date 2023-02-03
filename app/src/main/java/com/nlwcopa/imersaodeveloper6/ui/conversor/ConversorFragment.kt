package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.databinding.FragmentConversorBinding
import com.nlwcopa.imersaodeveloper6.ui.main.MainFragment

class ConversorFragment : Fragment () {

    private var _binding: FragmentConversorBinding? = null
    //private lateinit var conversorViewModel: ConversorViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ConversorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewModel
        val conversorViewModel =
            ViewModelProvider(this).get(ConversorViewModel::class.java)

        //Inserir Fragment na View
        _binding = FragmentConversorBinding.inflate(inflater, container, false)
        val root : View = binding.root

        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.conversorViewModel  = conversorViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}