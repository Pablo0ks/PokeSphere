package com.example.pokesphere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokesphere.databinding.FragmentTab2NoticeBinding

class Tab2NoticeFragment : Fragment() {

    private var _binding: FragmentTab2NoticeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        _binding = FragmentTab2NoticeBinding.inflate(inflater, container, false)
        // Configurar el botón de salir
        binding.btnSalir.setOnClickListener {
            // Navegar al LoginFragment cuando el usuario presione el botón
            findNavController().navigate(R.id.action_tab2NoticeFragment_to_loginFragment)
        }
        binding.btnMenu.setOnClickListener {
            // Navegar al LoginFragment cuando el usuario presione el botón
            findNavController().navigate(R.id.action_noticeFragment_to_principalFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombreUser = arguments?.getString("Nombre")
        binding.tvTab2.text="Bienvenido, ${nombreUser ?:""}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}