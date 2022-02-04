package com.pawan.sage.viewmodeltest

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pawan.sage.viewmodeltest.viewmodel.ListViewFragmentViewModel

class ListViewFragment : Fragment() {

    companion object {
        fun newInstance() = ListViewFragment()
    }

    private lateinit var viewModel: ListViewFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}