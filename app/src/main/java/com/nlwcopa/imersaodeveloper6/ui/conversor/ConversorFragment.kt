package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

        binding.BtnMoeda1.setOnClickListener{
            Log.i("INFO", "Valor Convertido")
//            findNavController().navigate(R.id.action_conversorFragment_to_moedasFragment)
               findNavController()
                .navigate(ConversorFragmentDirections
                    .actionConversorFragmentToMoedasFragment(11,16))
         }
        // Using directions to navigate to the GameWonFragment
        //view.findNavController()
           // .navigate(


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