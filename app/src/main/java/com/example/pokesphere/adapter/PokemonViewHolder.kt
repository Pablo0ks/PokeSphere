package com.example.pokesphere.adapter


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokesphere.Pokemon
import com.example.pokesphere.databinding.FragmentPokemon2Binding


class PokemonViewHolder(private val binding: FragmentPokemon2Binding) : RecyclerView.ViewHolder(binding.root) {


    fun render(pokemon: Pokemon, onClickListener: (Pokemon) -> Unit, onFavoriteClick: (Pokemon) -> Unit) {
        binding.tvNombre.text = pokemon.nombre
        binding.tvGeneracion.text = pokemon.generacion
        binding.tvEtapaEvo.text = pokemon.etapaevo
        binding.tvTipo.text = pokemon.tipo


        Glide.with(binding.ivPokemon.context)
            .load(pokemon.imagen)
            .into(binding.ivPokemon)


        binding.root.setOnClickListener {
            onClickListener(pokemon)
        }


        binding.btnFavorito.setOnClickListener {
            onFavoriteClick(pokemon)
        }
    }
}
