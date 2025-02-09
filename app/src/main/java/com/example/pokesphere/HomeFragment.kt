package com.example.pokesphere

import PokemonViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokesphere.adapter.PokemonAdapter
import com.example.pokesphere.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PokemonAdapter

    private val PokemonViewModel: PokemonViewModel by activityViewModels()

        val listaPokemon = listOf(
            Pokemon(
                "Pikachu",
                "Primera Generación",
                "Segunda etapa",
                "Eléctrico",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png"),

            Pokemon(
                "Charizard",
                "Primera Generación",
                "Tercera etapa",
                "Fuego/Volador",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png"),

            Pokemon(
                "Bulbasaur",
                "Primera Generación",
                "Primera etapa",
                "Planta/Veneno",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"),

            Pokemon(
                "Squirtle",
                "Primera Generación",
                "Primera etapa",
                "Agua",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png"),

            Pokemon(
                "Lucario",
                "Cuarta Generación",
                "Tercera etapa",
                "Lucha/Acero",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/448.png"),

            Pokemon(
                "Gengar",
                "Primera Generación",
                "Tercera etapa",
                "Fantasma/Veneno",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png"),

            Pokemon(
                "Gyarados",
                "Primera Generación",
                "Segunda etapa",
                "Agua/Volador",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/130.png"),

            Pokemon(
                "Eevee",
                "Primera Generación",
                "Primera etapa",
                "Normal",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/133.png"),

            Pokemon(
                "Tyranitar",
                "Segunda Generación",
                "Tercera etapa",
                "Roca/Siniestro",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/248.png"),

            Pokemon(
                "Rayquaza",
                "Tercera Generación",
                "Legendario",
                "Dragón/Volador",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/384.png"),
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = PokemonAdapter(listaPokemon, onClickListener = { pokemon ->
            val bundle = Bundle().apply {
                putString("nombre", pokemon.nombre)
                putString("generacion", pokemon.generacion)
                putString("etapaevo", pokemon.etapaevo)
                putString("tipo", pokemon.tipo)
                putString("imagen", pokemon.imagen)
            }
            requireActivity().findNavController(R.id.titulo).navigate(R.id.action_homeFragment2_to_detailPokemonFragment, bundle)
        }, onFavoriteClick = { pokemon ->
                PokemonViewModel.agregarFavorito(pokemon) // Agrega a favoritos
            }
        )

        binding.pokemon2.layoutManager = LinearLayoutManager(context)
        binding.pokemon2.adapter = adapter
    }
}



