package com.example.pokesphere

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.example.pokesphere.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding ? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        //return inflater.inflate(R.layout.fragment_tab2_notice, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateButton.setOnClickListener {

            val nombreUser = binding.userInput.text.toString()

            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
            sharedPreferences.edit().putString("username", nombreUser).apply()

            val bundle = Bundle().apply { putString("Nombre", nombreUser) }
            findNavController().navigate(R.id.action_loginFragment_to_noticeFragment, bundle)
        }

        binding.themeToggleButton.setOnClickListener {
            // Obtener el modo actual
            val currentMode = AppCompatDelegate.getDefaultNightMode()

            if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
                // Cambiar a modo claro
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                // Cambiar a modo oscuro
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


    }