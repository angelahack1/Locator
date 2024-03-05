package com.aixkare.locator.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aixkare.locator.databinding.FragmentConfigurationBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentConfigurationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentConfigurationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textSlideshow
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}