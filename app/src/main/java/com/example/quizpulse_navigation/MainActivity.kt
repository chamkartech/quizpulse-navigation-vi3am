package com.example.quizpulse_navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.quizpulse_navigation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NavController from NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(binding.toolbar)

        // Define top-level destinations (no Up Button shown)
        appBarConfig = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.homeFragment,
                R.id.rulesFragment,
                R.id.aboutFragment
            ),
            drawerLayout = binding.drawerLayout
        )

        // Wire ActionBar ↔ NavController
        // Auto-updates title, shows/hides Up Button, opens Drawer
        setupActionBarWithNavController(navController, appBarConfig)

        // Wire Navigation Drawer ↔ NavController
        // Menu item id MUST match fragment id in nav_graph.xml
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    // Called when user presses the Up Button (←)
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig)
                || super.onSupportNavigateUp()
    }

    // Inflate overflow menu from res/menu/options_menu.xml
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // item.onNavDestinationSelected() → navigates if item id
    // matches a fragment id in nav_graph.xml
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }
}