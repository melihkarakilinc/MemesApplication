package com.melihkarakilinc.memesapplication.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.melihkarakilinc.memesapplication.Adapter.ItemAdapter
import com.melihkarakilinc.memesapplication.Meme
import com.melihkarakilinc.memesapplication.R
import com.melihkarakilinc.memesapplication.Util.ItemClickListener
import com.melihkarakilinc.memesapplication.ViewModel.MainViewModel
import com.melihkarakilinc.memesapplication.databinding.FragmentAllMemesBinding
import kotlinx.coroutines.flow.collectLatest

class AllMemesFragment : Fragment(),ItemClickListener {
    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: FragmentAllMemesBinding
    private val adapter=ItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_memes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.clickListener=this
        binding.rv.adapter = adapter
        binding.rv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.getMemes().collectLatest {
                Log.e("ALL_ITEM", it.toString())
                adapter.submitData(it)
            }
        }
    }

    override fun OnItemSelect(meme: Meme) {
        val direction = AllMemesFragmentDirections
            .actionAllMemesFragmentToDetailMemesFragment(meme)
        findNavController().navigate(direction)
    }

}