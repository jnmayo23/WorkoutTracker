package edu.quinnipiac.workouttracker

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [IntervalWorkout::class] , version = 1)
abstract class IntervalWorkoutDatabase : RoomDatabase() {

    abstract fun getIntervalWorkoutDao() : IntervalWorkoutDao

    companion object{
        private const val DB_NAME = "Interval-Workout-Database.db"

        @Volatile
        private var instance : IntervalWorkoutDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Application?) = instance ?: synchronized(LOCK){
//            instance ?: buildDatabase(context!!).also{
//                instance = it
//            }
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            IntervalWorkoutDatabase::class.java,
//            DB_NAME
//        ).fallbackToDestructiveMigration().build()

        fun getDatabase(context: Context) : IntervalWorkoutDatabase{
            return instance ?: synchronized( this){
                var instance = Room.databaseBuilder(
                    context.applicationContext.applicationContext,
                    IntervalWorkoutDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                instance= instance
                return instance
            }
        }
    }

    private val roomCallback: Callback = object : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // this method is called when database is created
            // and below line is to populate our data.
            PopulateDbAsyncTask(instance).execute()
        }
    }

    // we are creating an async task class to perform task in background.
    private class PopulateDbAsyncTask internal constructor(instance: IntervalWorkoutDatabase?) :
        AsyncTask<Void?, Void?, Void?>() {
        init {
            val intervalWorkoutDao: IntervalWorkoutDao? = instance?.getIntervalWorkoutDao()
        }

//        protected fun doInBackground(vararg voids: Void): Void? {
//            return null
//        }

        override fun doInBackground(vararg p0: Void?): Void? {
            return null
        }
    }
}