package assessment2.GudangIn.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import assessment2.GudangIn.database.StorageDao
import assessment2.GudangIn.ui.screen.DetailViewModel
import assessment2.GudangIn.ui.screen.MainViewModel

class ViewModelFactory(
    private  val  dao: StorageDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}