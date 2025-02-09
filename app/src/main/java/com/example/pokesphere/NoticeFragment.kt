package com.example.pokesphere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokesphere.databinding.FragmentNoticeBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator

class NoticeFragment : Fragment() {
    private var _binding : FragmentNoticeBinding? = null
    private val binding get() = _binding!!
    private var nombreUsuario: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoticeBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_notice, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nombreUsuario = arguments?.getString("Nombre")

        binding.vpNotice.adapter = NoticeAdapter(this, nombreUsuario)
        TabLayoutMediator(binding.TabNotice,binding.vpNotice){
                tab, position ->
            when(position){
                1 -> {
                    tab.text = "Creditos"
                    tab.setIcon(R.drawable.ic_menu)

                }
                0 -> {
                    tab.text = "Menú"
                    tab.setIcon(R.drawable.ic_home)
                    val badge : BadgeDrawable = tab.orCreateBadge
                    badge.backgroundColor =
                        ContextCompat.getColor(
                            requireContext().applicationContext,R.color.red)
                    badge.number=117
                    badge.maxCharacterCount = 3
                    badge.badgeGravity = BadgeDrawable.TOP_START
                }
            }
        }.attach()
    }
}


class NoticeAdapter(fragment: Fragment, private val nombreUser: String?) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment =
            if (position == 0)
                Tab2NoticeFragment().apply {
                    arguments = Bundle().apply {
                        putString("Nombre", nombreUser)  // Cambié de "nombre" a "Nombre"
                    }
                }
            else
                Tab1NoticeFragment()
        return fragment
    }
}