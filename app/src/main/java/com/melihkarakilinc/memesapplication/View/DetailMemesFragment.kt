package com.melihkarakilinc.memesapplication.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.melihkarakilinc.memesapplication.Meme
import com.melihkarakilinc.memesapplication.R
import com.melihkarakilinc.memesapplication.Util.Util
import com.melihkarakilinc.memesapplication.databinding.FragmentDetailMemesBinding

class DetailMemesFragment : Fragment() {

    private val args: DetailMemesFragmentArgs by navArgs()
    private lateinit var meme: Meme
    private lateinit var binding: FragmentDetailMemesBinding
    private var util = Util()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_memes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        meme = args.meme
        Log.e("MEME", meme.toString())
        util.imageLoader(meme.url, binding.imageView)
    }
}