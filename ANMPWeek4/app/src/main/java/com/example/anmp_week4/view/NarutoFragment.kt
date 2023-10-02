package com.example.anmp_week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.anmp_week4.R
import com.example.anmp_week4.viewmodel.ListViewModel
import com.example.anmp_week4.viewmodel.NarutosViewModel

class NarutoFragment : Fragment() {
private lateinit var viewModel: NarutosViewModel
private val narutoListAdapter = NarutoListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_naruto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NarutosViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.rvNaruto)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = narutoListAdapter



        observeViewModel()
    }
    private fun observeViewModel() {
        viewModel.narutoLD.observe(viewLifecycleOwner, Observer {
            narutoListAdapter.updateNarutoList(it)
        })
        val recView = view?.findViewById<RecyclerView>(R.id.rvNaruto)
        recView?.visibility = View.VISIBLE
    }


}