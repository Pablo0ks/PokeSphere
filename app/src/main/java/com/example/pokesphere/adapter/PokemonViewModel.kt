import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokesphere.Pokemon

class PokemonViewModel : ViewModel() {
    private val _favoritos = MutableLiveData<MutableList<Pokemon>>(mutableListOf())
    val favoritos: LiveData<MutableList<Pokemon>> get() = _favoritos

    fun agregarFavorito(pokemon: Pokemon) {
        if (!_favoritos.value!!.contains(pokemon)) {
            _favoritos.value = (_favoritos.value!! + pokemon).toMutableList() // Notifica el cambio
        }
    }

    fun quitarFavorito(pokemon: Pokemon) {
        _favoritos.value = (_favoritos.value!!.filter { it != pokemon }).toMutableList() // Notifica el cambio
    }
}
