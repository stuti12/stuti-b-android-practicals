package com.example.myapplication.RecycleViewPractical.BottomNavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ExpandRecycleMovieAdapter(movieList: List<Movie>) :
    RecyclerView.Adapter<ExpandRecycleMovieAdapter.MovieVH>() {

    var movieList: List<Movie>

    init {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.expand_recycle_movie_row, parent, false)
        return MovieVH(view)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie: Movie = movieList[position]
        holder.titleTextView.setText(movie.title)
        holder.yearTextView.setText(movie.year)
        holder.ratingTextView.setText(movie.rating)
        holder.plotTextView.setText(movie.plot)
        val isExpanded: Boolean = movieList[position].expanded
        holder.expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var expandableLayout: ConstraintLayout = itemView.findViewById(R.id.expandableLayout)
        var titleTextView: TextView = itemView.findViewById(R.id.title_movie)
        var yearTextView: TextView = itemView.findViewById(R.id.release_date)
        var ratingTextView: TextView = itemView.findViewById(R.id.movie_rating)
        var plotTextView: TextView = itemView.findViewById(R.id.movie_plot)

        init {
            titleTextView.setOnClickListener {
                val movie: Movie = movieList[adapterPosition]
                movie.expanded = !movie.expanded
                notifyItemChanged(adapterPosition)
            }
        }
    }


}