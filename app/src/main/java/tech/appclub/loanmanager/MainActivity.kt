package tech.appclub.loanmanager

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import tech.appclub.loanmanager.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "LM"
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Setting toolbar
        setSupportActionBar(this.binding.toolbar)

        // Getting Navigation Host & Controller
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController

        // Setting App Bar Configuration
        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.home_destination, R.id.history_destination))

        // Setting BottomNavMenu
        this.binding.bottomNavigationView.setupWithNavController(navController)

        // Setting up Action Bar
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }


}
