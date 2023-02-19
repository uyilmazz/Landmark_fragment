package com.example.task1_landmarkbook_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task1_landmarkbook_fragment.databinding.FragmentLandmarkDetailBinding
import com.example.task1_landmarkbook_fragment.databinding.FragmentLandmarkListBinding

class LandmarkDetailFragment : Fragment() {

    private var _binding : FragmentLandmarkDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandmarkDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val landmark = LandmarkDetailFragmentArgs.fromBundle(it).landmark
            binding.imageView.setImageResource(landmark.image)
            binding.nameTextView.text = landmark.name
            binding.countryTextView.text = landmark.country
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
