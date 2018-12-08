package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.kotlin.samples.kotlinapp.fragments.*
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.toolbar.*

class NavigationDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        setSupportActionBar(toolbar)

        navigationView.setNavigationItemSelectedListener {

            //Checking if the item is in checked state or not, if not make it in checked state
            it.isChecked = !it.isChecked

            //Closing drawer on item click
            drawerLayout.closeDrawers()

            //Check to see which item was being clicked and perform appropriate action
            when(it.itemId){
                R.id.menuAndroid -> changeFragment(0)

                R.id.menuAndroidBug -> changeFragment(1)

                R.id.menuAndroidHelp -> changeFragment(2)
            }

            return@setNavigationItemSelectedListener true
        }

        //calling sync state is necessay or else your hamburger icon wont show up

        val actionBarDrawerToggle:ActionBarDrawerToggle= object :ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer
        ){
            override fun onDrawerClosed(drawerView: View) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView)
            }
        }

        drawerLayout.setDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun changeFragment(position:Int){
         var fragment:Fragment?=null

        when(position){
            0 -> fragment= AndroidFragment.newInstance("","")
            1 -> fragment= BugFragment.newInstance("","")
            2 -> fragment= HelpFragment.newInstance("","")
        }

        fragment?.let {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame,fragment)
                commit()
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
