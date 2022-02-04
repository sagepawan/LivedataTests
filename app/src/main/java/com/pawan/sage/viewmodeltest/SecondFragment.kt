package com.pawan.sage.viewmodeltest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pawan.sage.viewmodeltest.databinding.FragmentSecondBinding
import com.pawan.sage.viewmodeltest.viewmodel.SecondFragmentViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var secondFragViewModel: SecondFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        secondFragViewModel = ViewModelProvider(requireActivity()).get(SecondFragmentViewModel::class.java)

        secondFragViewModel.seconds.observe(requireActivity(), Observer{
            binding.textviewSecond.text = "Current countdown is ${it.toString()}"
        })

        secondFragViewModel.finished.observe(requireActivity(), Observer { finished ->
            if(finished) {
                Toast.makeText(requireContext(), "Count down finished!", Toast.LENGTH_LONG).show()
            }
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTimerStart.setOnClickListener {
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            secondFragViewModel.startTimer()
        }

        binding.buttonTimerStop.setOnClickListener{
            secondFragViewModel.stopTimer()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}