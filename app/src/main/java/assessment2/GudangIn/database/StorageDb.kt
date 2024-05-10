package assessment2.GudangIn.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import assessment2.GudangIn.model.Storage

@Database(entities = [Storage::class], version = 1, exportSchema = false)
abstract class StorageDb: RoomDatabase() {

    abstract val dao:StorageDao

    companion object{
        @Volatile
        private var INSTANCE: StorageDb? = null

        fun getInstance(context: Context):StorageDb{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StorageDb::class.java,
                        "storage.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}