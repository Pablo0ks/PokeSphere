package com.example.pokesphere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.pokesphere.databinding.FragmentTab1NoticeBinding


class Tab1NoticeFragment : Fragment() {

    private var _binding : FragmentTab1NoticeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        _binding = FragmentTab1NoticeBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_tab2_notice, container, false)
        return binding.root

    }


}