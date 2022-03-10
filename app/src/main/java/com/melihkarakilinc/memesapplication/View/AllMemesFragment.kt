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
import com.melihkarakilinc.memesapplication.Adapter.ItemAdapter
import com.melihkarakilinc.memesapplication.R
import com.melihkarakilinc.memesapplication.ViewModel.MainViewModel
import com.melihkarakilinc.memesapplication.databinding.FragmentAllMemesBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AllMemesFragment : Fragment() {
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
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMemes().collect {
                Log.e("ALL_ITEM",it.toString())
                binding.rv.adapter = adapter
                adapter.submitData(it)
            }
        }
    }

}