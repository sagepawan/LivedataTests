package com.pawan.sage.viewmodeltest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pawan.sage.viewmodeltest.databinding.FragmentFirstBinding
import com.pawan.sage.viewmodeltest.viewmodel.FirstFragmentViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel:FirstFragmentViewModel

    lateinit var count: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(FirstFragmentViewModel::class.java)

        count = viewModel.number.toString()

        binding.textviewFirst.text = "Current count is ${count}!"

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            viewModel.addNumber()
            count = viewModel.number.toString()
            binding.textviewFirst.text = "Current count is ${count}!"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}