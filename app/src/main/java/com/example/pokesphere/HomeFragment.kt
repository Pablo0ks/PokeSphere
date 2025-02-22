package com.example.pokesphere

import PokemonViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokesphere.adapter.PokemonAdapter
import com.example.pokesphere.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PokemonAdapter

    private val PokemonViewModel: PokemonViewModel by activityViewModels()

    fun getListaPokemon(context: HomeFragment): List<Pokemon> {
        return listOf(
            Pokemon(
                context.getString(R.string.pikachu),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.segunda_etapa),
                context.getString(R.string.electrico),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png"
            ),
            Pokemon(
                context.getString(R.string.charizard),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.tercera_etapa),
                context.getString(R.string.fuego_volador),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png"
            ),
            Pokemon(
                context.getString(R.string.bulbasaur),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.primera_etapa),
                context.getString(R.string.planta_veneno),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"
            ),
            Pokemon(
                context.getString(R.string.squirtle),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.primera_etapa),
                context.getString(R.string.agua),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png"
            ),
            Pokemon(
                context.getString(R.string.lucario),
                context.getString(R.string.cuarta_generacion),
                context.getString(R.string.tercera_etapa),
                context.getString(R.string.lucha_acero),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/448.png"
            ),
            Pokemon(
                context.getString(R.string.gengar),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.tercera_etapa),
                context.getString(R.string.fantasma_veneno),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png"
            ),
            Pokemon(
                context.getString(R.string.gyarados),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.segunda_etapa),
                context.getString(R.string.agua_volador),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/130.png"
            ),
            Pokemon(
                context.getString(R.string.eevee),
                context.getString(R.string.primera_generacion),
                context.getString(R.string.primera_etapa),
                context.getString(R.string.normal),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/133.png"
            ),
            Pokemon(
                context.getString(R.string.tyranitar),
                context.getString(R.string.segunda_generacion),
                context.getString(R.string.tercera_etapa),
                context.getString(R.string.roca_siniestro),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/248.png"
            ),
            Pokemon(
                context.getString(R.string.rayquaza),
                context.getString(R.string.tercera_generacion),
                context.getString(R.string.legendario),
                context.getString(R.string.dragon_volador),
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/384.png"
            )
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root

    }

    private fun setupRecyclerView() {
        adapter = PokemonAdapter(getListaPokemon(this), onClickListener = { pokemon ->
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



