package etec.crud.service
import etec.crud.model.Instrumento
import org.springframework.stereotype.Service

@Service
class InstrumentoServicio {

  private val instrumentos = mutableListOf<Instrumento>()

 fun listarTodos(): List<Instrumento> {
        return instrumentos
    } 

    fun buscarPorId(id: Long): Instrumento? {
        // Retorna el instrumento o null si no lo encuentra
        return instrumentos.find { it.id == id }
    }

fun guardar(instrumento: Instrumento): Instrumento {
        instrumentos.add(instrumento)
        return instrumento
    }

 fun actualizar(id: Long, instrumentoActualizado: Instrumento): Instrumento? {
        val indice = instrumentos.indexOfFirst { it.id == id }
        if (indice != -1) {
            // Reemplazamos en la lista el instrumento viejo por el nuevo
            instrumentos[indice] = instrumentoActualizado
            return instrumentoActualizado
        }
        return null // Retorna null si el ID no existía
    }

