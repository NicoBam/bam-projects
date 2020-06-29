package fr.haan.bamprojects.ui.projectlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import fr.haan.bamprojects.databinding.ProjectListFragmentBinding

class ProjectListFragment : Fragment() {


    private val viewModel: ProjectListViewModel by viewModels()

    private var _binding: ProjectListFragmentBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProjectListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ProjectListAdapter(requireContext())

        binding.listView.adapter = adapter
        binding.listView.layoutManager = LinearLayoutManager(requireContext())

        viewModel._projects.observe(viewLifecycleOwner, Observer { projects ->
            // Update the cached copy of the words in the adapter.
            projects?.let { adapter.setProjects(it) }
        })
    }
}