package com.nlwcopa.imersaodeveloper6.ui.conversor.moedas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.databinding.FragmentConversorBinding
import com.nlwcopa.imersaodeveloper6.databinding.FragmentMoedasBinding
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragment
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorViewModel
import com.nlwcopa.imersaodeveloper6.ui.main.MainViewModel

class MoedasFragment : Fragment() {
  /*  private lateinit var viewModel: MoedasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_moedas, container, false)
    }*/

    private var _binding: FragmentMoedasBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MoedasFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewModel
        val moedasViewModel =
            ViewModelProvider(this).get(MoedasViewModel::class.java)

        //Inserir Fragment na View
        _binding = FragmentMoedasBinding.inflate(inflater, container, false)
        val root : View = binding.root

        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.moedasViewModel  = moedasViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}