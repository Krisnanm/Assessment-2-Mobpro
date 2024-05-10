package assessment2.GudangIn.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage")
data class Storage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val namaBarang: String,
    val kodeBarang: String,
    val rak: String
)