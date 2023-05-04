package edu.quinnipiac.workouttracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.apache.commons.csv.CSVFormat
import java.io.BufferedReader
import org.apache.commons.csv.CSVParser
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView.setupWithNavController(navController)

        //readCSVFile()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    private fun readCSVFile(){
       val bufferedReader = BufferedReader(assets.open("intervals.csv").reader())
        val csvParser = CSVParser.parse(bufferedReader, CSVFormat.DEFAULT)


        csvParser.forEach{
            it?.let{
                val interval = IntervalList(
                    name = it.get(0),
                    sets = it.get(1),
                    highIntensity = it.get(2),
                    lowIntensity = it.get(3),
                    coolDown = it.get(4)
                )
                List.add(interval)

            }


        }

    }

}