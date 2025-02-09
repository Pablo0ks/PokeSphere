import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokesphere.R
import com.example.pokesphere.adapter.PokemonAdapter
import com.example.pokesphere.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var adapter: PokemonAdapter

    // ViewModel compartido con HomeFragment
    private val personajeViewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        setupRecyclerView()
        observarFavoritos()
        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = PokemonAdapter(
            emptyList(), // Se llenará con LiveData
            onClickListener = { pokemon ->
                // Navegar a DetailFavoriteFragment con los datos del Pokémon seleccionado
                val bundle = Bundle().apply {
                    putString("nombre", pokemon.nombre)
                    putString("generacion", pokemon.generacion)
                    putString("etapaevo", pokemon.etapaevo)
                    putString("tipo", pokemon.tipo)
                    putString("imagen", pokemon.imagen)
                }
                requireActivity().findNavController(R.id.titulo)
                    .navigate(R.id.action_principalFragment_to_detailFavoriteFragment2, bundle)
            },
            onFavoriteClick = { pokemon ->
                personajeViewModel.quitarFavorito(pokemon) // Quita de favoritos
            }
        )

        binding.recyclerpokemon2.layoutManager = LinearLayoutManager(context)
        binding.recyclerpokemon2.adapter = adapter
    }

    private fun observarFavoritos() {
        personajeViewModel.favoritos.observe(viewLifecycleOwner) { lista ->
            adapter.actualizarLista(lista) // Actualiza la lista en tiempo real
        }
    }
}
