package com.nlwcopa.imersaodeveloper6.ui.movies

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nlwcopa.imersaodeveloper6.databinding.FragmentConversorBinding
import com.nlwcopa.imersaodeveloper6.databinding.FragmentMovieBinding
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragmentArgs
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorFragmentDirections
import com.nlwcopa.imersaodeveloper6.ui.conversor.ConversorViewModel

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var  movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //ViewModel
        val movieViewModel =
            ViewModelProvider(this).get(MovieViewModel::class.java)

        this.movieViewModel = movieViewModel

        //Inserir Fragment na View
        _binding = FragmentMovieBinding.inflate(inflater, container, false)

        // onClick Moeda Atual
       // binding.BtnMoeda1.setOnClickListener {
          //  onNavigate()
        //}

        // onClick Moeda Converter
        binding.imgBtnGravar.setOnClickListener {
            Log.i("INFO", "GRAVEI O FILME")
        }

       // binding.btnconverter.setOnClickListener {
        //    this.valorConverter = binding.edtTxtl.text.toString()
        //    onConvertMoeda(this.valorConverter.toFloat())
       // }


        val root: View = binding.root

        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.movieViewModel = movieViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onConvertMoeda(value : Float){
        Log.i("INFO", "CONVERSOR SETAR MOEDAS")
        //this.convViewModel.onConvert(value)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("MovieFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MovieFragment", "onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MovieFragment", "onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MovieFragment", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MovieFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MovieFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MovieFragment", "onStop called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("MovieFragment", "onDetach called")
    }
}