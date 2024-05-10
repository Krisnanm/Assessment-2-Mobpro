package assessment2.GudangIn.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import assessment2.GudangIn.database.StorageDao
import assessment2.GudangIn.model.Storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel (private val dao: StorageDao): ViewModel() {

    fun insert(namaBarang:String, kodeBarang:String, rak: String){
        val storage = Storage (
            namaBarang = namaBarang,
            kodeBarang = kodeBarang,
            rak = rak
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(storage)
        }
    }

    suspend fun getStorage(id:Long): Storage?{
        return dao.getStorageById(id)
    }

    fun  update(id: Long, namaBarang:String, kodeBarang:String, rak: String){
        val storage = Storage(
            id = id,
            namaBarang = namaBarang,
            kodeBarang = kodeBarang,
            rak = rak
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(storage)
        }

    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteById(id)
        }
    }

}