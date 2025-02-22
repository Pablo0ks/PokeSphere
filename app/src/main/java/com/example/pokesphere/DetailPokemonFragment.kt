import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pokesphere.databinding.FragmentDetailPokemonBinding

class DetailPokemonFragment : Fragment() {

    private lateinit var binding: FragmentDetailPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailPokemonBinding.inflate(inflater, container, false)

        val nombre = arguments?.getString("nombre")
        val generacion = arguments?.getString("generacion")
        val etapaevo = arguments?.getString("etapaevo")
        val tipo = arguments?.getString("tipo")
        val imagen = arguments?.getString("imagen")

        binding.tvNombre.text = nombre
        binding.tvGeneracion.text = generacion
        binding.tvEtapaEvo.text = etapaevo
        binding.tvTipo.text = tipo

        Glide.with(this)
            .load(imagen)
            .into(binding.ivPokemon)

        return binding.root
    }
}
