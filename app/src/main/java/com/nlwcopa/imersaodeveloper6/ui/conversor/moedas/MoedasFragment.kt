package com.nlwcopa.imersaodeveloper6.ui.conversor.moedas

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.databinding.FragmentConversorBinding
import com.nlwcopa.imersaodeveloper6.databinding.FragmentMoedasBinding
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragment
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragmentArgs
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragmentDirections
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorViewModel
import com.nlwcopa.imersaodeveloper6.ui.main.MainViewModel

class MoedasFragment : Fragment() {
    /*  private lateinit var viewModel: MoedasViewModel
         override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View {
          return inflater.inflate(R.layout.fragment_moedas, container, false)
      }
       companion object {
        fun newInstance() = MoedasFragment()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }*/
    private var _binding: FragmentMoedasBinding? = null
    private val binding get() = _binding!!
    private lateinit var moedasViewModel: MoedasViewModel
    private lateinit var args: MoedasFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//             Toast.makeText(
//            context,
//            "Tipo Moeda 1: ${args.tipomoeda1}, Tipo Moeda 2: ${args.tipomoeda2}",
//            Toast.LENGTH_LONG
//        ).show()

        //ViewModel
        this.moedasViewModel =
            ViewModelProvider(this).get(MoedasViewModel::class.java)

        //Inserir Fragment na View
        _binding = FragmentMoedasBinding.inflate(inflater, container, false)

        binding.imageButton.setOnClickListener {

            if (onVerifyMoedas(
                    moedasViewModel.moedaAtualSelected, moedasViewModel.moedaConverterSelected-3
                )
            ) {
                onMessage()
            } else {
                onNavigate()
            }
        }

        val root: View = binding.root
        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.moedasViewModel = this.moedasViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onNavigate() {
        findNavController()
            .navigate(
                MoedasFragmentDirections
                    .actionMoedasFragmentToConversorFragment(
                        moedasViewModel.moedaAtualSelected,
                        moedasViewModel.moedaConverterSelected
                    )
            )
    }

    fun onGetArguments() {
        this.args = MoedasFragmentArgs.fromBundle(requireArguments())
    }

    fun onVerifyMoedas(moeda1: Int, moeda2: Int): Boolean {
        var verify = false

        if (moeda1 == moeda2)
            verify = true

        return verify
    }

    fun onMessage() {
        Toast.makeText(
            context,
            " INFO: sELECIONE MOEDAS DIFERENTES",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("MoedasFragment", "onAttach called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MoedasFragment", "onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MoedasFragment", "onViewCreated called")
    }

    //onShow
    override fun onStart() {
        super.onStart()
        onGetArguments()
        this.moedasViewModel.onStartFragment(args.tipomoeda1, args.tipomoeda2)
    }

    //onFocus
    override fun onResume() {
        super.onResume()
        Log.i("MoedasFragment", "onResume called")
    }

    //onInvisible
    override fun onPause() {
        super.onPause()
        Log.i("MoedasFragment", "onPause called")
    }

    //sair do focus
    override fun onStop() {
        super.onStop()
        Log.i("MoedasFragment", "onStop called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("MoedasFragment", "onDetach called")
    }

}