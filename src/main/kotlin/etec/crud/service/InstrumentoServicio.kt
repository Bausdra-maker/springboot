package etec.crud.service

import etec.crud.model.Instrumento
import org.springframework.stereotype.Service

@Service
class InstrumentoServicio {
    private val instrumentos = mutableListOf<Instrumento>()

    fun guardar(instrumento: Instrumento): Instrumento {
        this.instrumentos.add(instrumento)
        return instrumento
    }

    fun listarTodos(): List<Instrumento> {
        return this.instrumentos.toList()
    }

    fun buscarPorId(id: Int): Instrumento? {
        return this.instrumentos.find { it.id == id  }
    }

    fun actualizar(id: Int, instrumento: Instrumento): Instrumento? {
        val instrumentoAActualizar = this.instrumentos.find { it.id == id }
        instrumentoAActualizar?.nombre = instrumento.nombre
        instrumentoAActualizar?.descripcion = instrumento.descripcion
        return instrumentoAActualizar
    }

    fun eliminar(id: Int) : Boolean {
        return this.instrumentos.removeIf { it.id == id }

    }
}