package com.nlwcopa.imersaodeveloper6.ui.conversor

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorViewModel
import com.nlwcopa.imersaodeveloper6.databinding.FragmentConversorBinding
import com.nlwcopa.imersaodeveloper6.ui.conversor.moedas.MoedasFragmentArgs
import com.nlwcopa.imersaodeveloper6.ui.main.MainFragment

class ConversorFragment : Fragment() {

    private var _binding: FragmentConversorBinding? = null
    private val binding get() = _binding!!
    private var argsMoedaAtual = 0
    private var argsMoedaConverter = 0
    private var valorConverter = "0.0"
    private lateinit var  convViewModel: ConversorViewModel
    private lateinit var args: ConversorFragmentArgs

//    companion object {
//        fun newInstance() = ConversorFragment()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewModel
        val conversorViewModel =
            ViewModelProvider(this).get(ConversorViewModel::class.java)

        this.convViewModel = conversorViewModel

        //Inserir Fragment na View
        _binding = FragmentConversorBinding.inflate(inflater, container, false)

        // onClick Moeda Atual
        binding.BtnMoeda1.setOnClickListener {
            onNavigate()
        }

        // onClick Moeda Converter
        binding.btnmoeda2.setOnClickListener {
            onNavigate()
        }

        binding.btnconverter.setOnClickListener {
            this.valorConverter = binding.edtTxtl.text.toString()
            onConvertMoeda(this.valorConverter.toFloat())
        }


        val root: View = binding.root

        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.conversorViewModel = conversorViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onGetArguments(){
        Log.i("INFO", "CONVERSOR GETTERS ARGUMENTOS")
        this.args = ConversorFragmentArgs.fromBundle(requireArguments())
        this.argsMoedaAtual = args.moedaatual
        this.argsMoedaConverter = args.moedaconverter
        Log.i("INFO", this.argsMoedaAtual.toString()+this.argsMoedaConverter)
    }

    fun onSetMoedas(){
        Log.i("INFO", "CONVERSOR SETAR MOEDAS")
        this.convViewModel.checkArgsMoedas(this.argsMoedaAtual, this.argsMoedaConverter)
    }

    fun onNavigate() {
        findNavController()
            .navigate(
                ConversorFragmentDirections
                    .actionConversorFragmentToMoedasFragment(argsMoedaAtual, argsMoedaConverter)
            )
    }

    fun onConvertMoeda(value : Float){
        Log.i("INFO", "CONVERSOR SETAR MOEDAS")
        this.convViewModel.onConvert(value)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("ConversorFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ConversorFragment", "onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("ConversorFragment", "onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("ConversorFragment", "onStart called")
        onGetArguments()
        onSetMoedas()
    }

//    fun onChangeMoedas(vwModel: ConversorViewModel){
//        vwModel.
//    }



    override fun onResume() {
        super.onResume()
        Log.i("ConversorFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("ConversorFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("ConversorFragment", "onStop called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ConversorFragment", "onDetach called")
    }



}