package fr.haan.bamprojects.ui.projectlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import fr.haan.bamprojects.R
import fr.haan.bamprojects.data.model.Project

class ProjectListAdapter internal constructor(
    context: Context,
    private val onFavoriteClicked:(Project) -> Unit
) : RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var projects = emptyList<Project>() // Cached copy of words

    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView: TextView = itemView.findViewById(R.id.text_title)
        val descriptionView: TextView = itemView.findViewById(R.id.text_description)
        val favIcon: AppCompatImageView = itemView.findViewById(R.id.button_fav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val itemView = inflater.inflate(R.layout.project_list_item, parent, false)
        return ProjectViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val current = projects[position]
        holder.nameView.text = current.name
        holder.descriptionView.text = current.description
        if(current.isFavorite) {
            holder.favIcon.setImageResource(R.drawable.ic_baseline_star_24)
        }else {
            holder.favIcon.setImageResource(R.drawable.ic_baseline_star_border_24)
        }

        holder.favIcon.setOnClickListener {
            onFavoriteClicked(current)
        }
    }

    internal fun setProjects(projects: List<Project>) {
        this.projects = projects
        notifyDataSetChanged()
    }

    override fun getItemCount() = projects.size
}