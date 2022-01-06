package com.example.pleasureinvegas.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationView: BottomNavigationView
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: NavController.OnDestinationChangedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setupNavigationDrawer()
        setupBottomNavigationDrawer()

    }



    private fun setupBottomNavigationDrawer() {
        bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun setupNavigationDrawer() {
        drawerLayout = binding.drawerLayout
        navigation_view.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}