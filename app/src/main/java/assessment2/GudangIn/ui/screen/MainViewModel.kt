package assessment2.GudangIn.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import assessment2.GudangIn.database.StorageDao
import assessment2.GudangIn.model.Storage
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: StorageDao) : ViewModel() {

    val data : StateFlow<List<Storage>> = dao.getStorage().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}