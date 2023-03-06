package com.nlwcopa.imersaodeveloper6.ui.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nlwcopa.imersaodeveloper6.R
import com.nlwcopa.imersaodeveloper6.database.Movies

class MovieListAdapter(
    private val movies: List<Movies>
) : RecyclerView.Adapter<MovieListAdapter.MoveListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movies_item, parent, false
        )
        return MoveListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoveListViewHolder, position: Int) {
        holder.bindView(movies[position])
    }

    override fun getItemCount() = movies.size

    class MoveListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtViewNome: TextView = itemView.findViewById(R.id.txt_View_Titulo)
        private val txtViewCapa: TextView = itemView.findViewById(R.id.txtViewCapa)
        private val txtViewDiretor: TextView = itemView.findViewById(R.id.txtViewDiretor)
        private val txtViewAno: TextView = itemView.findViewById(R.id.txtViewAno)

        fun bindView(movie : Movies){
            txtViewNome.text = movie.nameMovie
            txtViewCapa.text = movie.refName
            txtViewDiretor.text = movie.directorName
            txtViewAno.text =  movie.yearMovie
        }
    }
}