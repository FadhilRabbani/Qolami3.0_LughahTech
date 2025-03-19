package com.test.qolami

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.test.qolami.view.HomeFragment
import com.test.qolami.view.account.PopUpAkunFragment
import com.test.qolami.view.home.PopUpFiturSedangDikembankanFragment
import com.test.qolami.view.home.PopUpFragment
import com.test.qolami.view.home.PopUpPelajaranFragment
import com.test.qolami.view.latihan.FragmentLatihan
import com.test.qolami.view.pelajaran.PelajaranFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView4) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomnav)
        //navcontroler,nacdestination,bundle
        navController.addOnDestinationChangedListener { navcontroler, destination, bundle ->
            when (destination.id) {
                R.id.homeFragment, R.id.pelajaranFragment, R.id.fragmentLatihan -> {
                    bottomNavView.visibility = View.VISIBLE
                }
                else -> {
                    bottomNavView.visibility = View.GONE
                }
            }

            updateBottomNavigationItem(destination.id)
        }
        navController.currentDestination
        NavigationUI.setupWithNavController(bottomNavView, navController)
        bottomNavView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home ->{
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.pelajaran ->{
                    navController.navigate(R.id.pelajaranFragment)
                    true
                }
                R.id.latihan -> {
                    val currentFragmentId = navController.currentBackStackEntry?.destination?.id
                    sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
                    var token = sharedPreferences.getString("token", "")
                    Log.i("token", "$token")
                    if (token!!.isNotEmpty()) {
                        navController.navigate(R.id.fragmentLatihan)
                        true
                    }else{
                        if(currentFragmentId!! == R.id.homeFragment) {
                            val popUpFragment = PopUpAkunFragment()
                            popUpFragment.show(getSupportFragmentManager(), "popupfragment")
                            false
                        }else if(currentFragmentId!! == R.id.pelajaranFragment){
                            val popUpFragment = PopUpPelajaranFragment()
                            popUpFragment.show(getSupportFragmentManager(), "popupfragment")
                            false
                        }
                    }
                }
                R.id.Quiz -> {
                    false
                    val popUpFiturFragment = PopUpFiturSedangDikembankanFragment()
                    popUpFiturFragment.show(getSupportFragmentManager(), "popupfitur")
                }
                else -> false
            }

            true // Mengembalikan true menandakan bahwa aksi telah ditangani
        }



    }
    fun updateBottomNavigationItem(destinationId: Int?) {
        destinationId ?: return // Jika destinationId null, kembalikan

        // Mengatur item bottom navigation berdasarkan destinationId
        when (destinationId) {
            R.id.homeFragment -> findViewById<BottomNavigationView>(R.id.bottomnav).menu.getItem(0).isChecked =
                true
            R.id.pelajaranFragment -> findViewById<BottomNavigationView>(R.id.bottomnav).menu.getItem(
                1
            ).isChecked = true
            R.id.fragmentLatihan -> findViewById<BottomNavigationView>(R.id.bottomnav).menu.getItem(
                2
            ).isChecked = true
        }
    }


}