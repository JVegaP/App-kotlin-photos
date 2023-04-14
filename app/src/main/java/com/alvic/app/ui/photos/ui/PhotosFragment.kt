package com.alvic.app.ui.photos.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.alvic.app.R
import com.alvic.app.databinding.FragmentPhotosBinding
import com.alvic.app.ui.photos.adapters.PhotosAdapter
import com.alvic.app.ui.photos.utils.GridSpacingItemDecoration
import com.alvic.app.ui.photos.utils.hidden
import com.alvic.app.ui.photos.utils.show
import com.alvic.photos.core.utils.isConnected
import com.alvic.app.ui.photos.viewModel.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : Fragment() {

    private lateinit var binding: FragmentPhotosBinding
    private val photosViewModel: PhotosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        setupUI()
        setupData()
    }

    private fun setupData() {
        photosViewModel.getPhotos(isConnect = isConnected(requireContext()))
    }

    private fun setupUI() {
        binding.rvListPhotos.layoutManager = GridLayoutManager(requireContext(), 2 )
    }
    
    private fun initObserver() {
        binding.loading.show()
        photosViewModel.photos.observe(viewLifecycleOwner) {
            binding.loading.hidden()
            binding.rvListPhotos.apply {
                layoutManager = GridLayoutManager(requireContext(), 2 )
                adapter = PhotosAdapter( photos = it.toMutableList(), fragment = this@PhotosFragment )
            }
            val spacing = resources.getDimensionPixelSize(R.dimen.margin_10_dp)
            binding.rvListPhotos.addItemDecoration(GridSpacingItemDecoration(2, spacing,false,0))
        }
    }

}