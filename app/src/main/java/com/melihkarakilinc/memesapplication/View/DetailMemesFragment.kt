package com.melihkarakilinc.memesapplication.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.melihkarakilinc.memesapplication.R
import com.melihkarakilinc.memesapplication.databinding.FragmentDetailMemesBinding

class DetailMemesFragment : Fragment() {
    lateinit var binding: FragmentDetailMemesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detail_memes,container,false)
        return binding.root
    }
}