import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pokesphere.databinding.FragmentDetailFavoriteBinding

class DetailFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentDetailFavoriteBinding
    private val comentarios = mutableListOf<String>()
    private var comentarioCount = 1
    private val puntuaciones = mutableListOf<Float>()  // Lista para guardar las puntuaciones

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailFavoriteBinding.inflate(inflater, container, false)

        val nombre = arguments?.getString("nombre")
        val generacion = arguments?.getString("generacion")
        val etapaevo = arguments?.getString("etapaevo")
        val tipo = arguments?.getString("tipo")
        val imagen = arguments?.getString("imagen")

        binding.tvNombreFav.text = nombre
        binding.tvGeneracionFav.text = generacion
        binding.tvEtapaEvoFav.text = etapaevo
        binding.tvTipoFav.text = tipo

        Glide.with(this)
            .load(imagen)
            .into(binding.ivPokemonFav)

        binding.btnGuardarComentario.setOnClickListener {
            val comentario = binding.etComentario.text.toString()

            if (comentario.isNotEmpty()) {
                comentarios.add("Comentario $comentarioCount: $comentario")
                comentarioCount++

                // Guardar la puntuación seleccionada
                val puntuacion = binding.ratingBar.rating
                puntuaciones.add(puntuacion)

                // Mostrar los comentarios y puntuaciones en el TextView
                val comentariosConPuntuaciones = comentarios.zip(puntuaciones) { comentario, puntuacion ->
                    "$comentario\nPuntuación: $puntuacion estrellas"
                }.joinToString("\n\n")

                binding.tvComentarios.text = comentariosConPuntuaciones

                // Limpiar el EditText y RatingBar
                binding.etComentario.text.clear()
                binding.ratingBar.rating = 0f

                // Mostrar un Toast de confirmación
                Toast.makeText(requireContext(), "Comentario y Puntuación guardados", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Por favor, escribe un comentario", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}
