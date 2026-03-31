package com.example.androidarchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidarchitecture.ui.screen.PersonData
import com.example.androidarchitecture.ui.screen.PersonDetail
import com.example.androidarchitecture.ui.viewModel.UserViewModel

@Composable
fun NavGraph(navHostController: NavHostController, viewModel: UserViewModel) {
    NavHost(navController = navHostController, startDestination = Routes.Home.route){
        composable(Routes.Home.route){
            PersonData(navHostController, viewModel)
        }
        composable(Routes.PersonDetails.route){
            val personId = it.arguments?.getString("personId")?.toInt() ?: return@composable

//            val personId = it.arguments?.getInt("personId")
            val person = viewModel.getPersonById(personId!!)
            PersonDetail(person)
        }

    }
}