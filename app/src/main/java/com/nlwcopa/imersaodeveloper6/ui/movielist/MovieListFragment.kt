package com.nlwcopa.imersaodeveloper6.ui.movielist

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nlwcopa.imersaodeveloper6.database.AppDatabase
import com.nlwcopa.imersaodeveloper6.database.Movies
import com.nlwcopa.imersaodeveloper6.database.dao.MovieDao
import com.nlwcopa.imersaodeveloper6.databinding.FragmentMovielistBinding
import com.nlwcopa.imersaodeveloper6.repository.DatabaseDatasource
import com.nlwcopa.imersaodeveloper6.repository.MoviesRepository
import com.nlwcopa.imersaodeveloper6.ui.movies.MovieViewModel
import com.nlwcopa.imersaodeveloper6.ui.movies.MovieViewModelFactory


class MovieListFragment : Fragment() {
    private var _binding: FragmentMovielistBinding? = null
    private val binding get() = _binding!!

    private lateinit var  movieListViewModel: MovieListViewModel
    private lateinit var movieListViewModelFactory: MovieListViewModelFactory
    private lateinit var movieRepository : MoviesRepository
    private lateinit var movieDAO : MovieDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //val  movielistadapter = MovieListAdapter(

      /*
       Preenchimento direto
       val  movielistadapter = MovieListAdapter(
           listOf(
               Movies(0,"Filme 1","Capa 1","Diretor 1","2001"),
               Movies(0,"Filme 2","Capa 2","Diretor 2","2002"),
               Movies(0,"Filme 3","Capa 3","Diretor 3","2003"),
               Movies(0,"Filme 4","Capa 4","Diretor 4","2004")
          )
        )*/

        val application = requireNotNull(this.activity).application
        val movieDAO = AppDatabase.getInstance(application).movieDao
        val repository = DatabaseDatasource(movieDAO)

        //ViewModelFactory
        val movieListViewModelFactory = MovieListViewModelFactory(repository,application)

        //ViewModel
        val movieListViewModel =
            ViewModelProvider(this,movieListViewModelFactory).get(MovieListViewModel::class.java)

        this.movieListViewModel = movieListViewModel

        //Inserir Fragment na View
        _binding = FragmentMovielistBinding.inflate(inflater, container, false)

        val root: View = binding.root

        //binding.nome da variable no xml =
        // nome da val do viewModelProvider
        binding.movieListViewModel = movieListViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //Carregar o reciclerview com os dados do banco
         this.movieListViewModel.allMoviesEvent.observe(viewLifecycleOwner) {
            val  movielistadapter = MovieListAdapter(it)

            with(binding.recyclerviewmovie){
                setHasFixedSize(false)
                adapter = movielistadapter
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("MovieListFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MovieListFragment", "onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MovieListFragment", "onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MovieListFragment", "onStart called")
    }


    override fun onResume() {
        super.onResume()
        Log.i("MovieListFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MovieListFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MovieListFragment", "onStop called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("MovieListFragment", "onDetach called")
    }

}