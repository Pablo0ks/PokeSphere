package com.example.pokesphere

import FavoriteFragment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pokesphere.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment() {

    private var _binding: FragmentPrincipalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el NavController para el NavHostFragment anidado
        val navHostFragment = childFragmentManager.findFragmentById(R.id.titulo) as? NavHostFragment
        if (navHostFragment != null) {
            // Proceed with navigation operations
        } else {
            // Handle the case where the fragment is not a NavHostFragment
            Log.e("Fragment Error", "Fragment is not a NavHostFragment")
        }
        val navController = navHostFragment?.navController

        // Configurar el BottomNavigationView con el NavController
        if (navController != null) {
            binding.barramenu.setupWithNavController(navController)
        }
        // Configurar el BottomNavigationView

        binding.barramenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_favorite -> {
                    replaceFragment(FavoriteFragment())
                    true
                }
                R.id.nav_setting -> {
                    replaceFragment(SettingFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.titulo, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
