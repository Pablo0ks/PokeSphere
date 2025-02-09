package com.example.pokesphere.adapter

import PokemonViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokesphere.Pokemon
import com.example.pokesphere.R
import com.example.pokesphere.databinding.FragmentPokemon2Binding

class PokemonAdapter(
    private var listaPokemon: List<Pokemon>,
    private val onClickListener: (Pokemon) -> Unit,
    private val onFavoriteClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = FragmentPokemon2Binding.bind(view)

        fun bind(pokemon: Pokemon) {
            binding.tvNombre.text = pokemon.nombre
            binding.tvTipo.text = pokemon.tipo
            Glide.with(binding.ivPokemon.context).load(pokemon.imagen).into(binding.ivPokemon)

            binding.root.setOnClickListener { onClickListener(pokemon) }
            binding.btnFavorito.setOnClickListener { onFavoriteClick(pokemon) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_pokemon2, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(listaPokemon[position])
    }

    override fun getItemCount(): Int = listaPokemon.size

    fun actualizarLista(nuevaLista: List<Pokemon>) {
        listaPokemon = nuevaLista
        notifyDataSetChanged()
    }
}

