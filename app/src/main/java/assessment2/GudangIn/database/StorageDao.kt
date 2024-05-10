package assessment2.GudangIn.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import assessment2.GudangIn.model.Storage
import kotlinx.coroutines.flow.Flow

@Dao
interface StorageDao {
    @Insert
    suspend fun insert(storage: Storage)

    @Update
    suspend fun update(storage: Storage)

    @Query("SELECT * FROM storage ORDER BY rak,kodeBarang DESC")
    fun getStorage(): Flow<List<Storage>>

    @Query("SELECT * FROM storage WHERE id = :id")
    suspend fun getStorageById(id: Long):Storage?

    @Query("DELETE FROM storage WHERE id = :id")
    suspend fun deleteById(id:Long)

}