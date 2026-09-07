package com.example.androidarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.androidarchitecture.data.local.AppDatabase
import com.example.androidarchitecture.data.remote.RetrofitInstance
import com.example.androidarchitecture.data.repository.PersonLocalDataSource
import com.example.androidarchitecture.data.repository.PersonRemoteDataSource
import com.example.androidarchitecture.data.repository.PersonRepositoryIml
import com.example.androidarchitecture.domain.usecase.GetPersonData
import com.example.androidarchitecture.ui.navigation.NavGraph
import com.example.androidarchitecture.ui.theme.AndroidArchitectureTheme
import com.example.androidarchitecture.ui.viewModel.PersonViewModel
import com.example.androidarchitecture.ui.viewModel.PersonViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var personViewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val database = AppDatabase.getDatabase(applicationContext) // use application
//        val userDao = database.personDao()
//        val localDataSource = PersonLocalDataSource(userDao)
//        val apiService = RetrofitInstance.api
//        val remoteDataSource = PersonRemoteDataSource(apiService)
//        val personRepository = PersonRepositoryIml(localDataSource, remoteDataSource)
//        val personData = GetPersonData(personRepository)
//        val personViewModel = PersonViewModel(personData)
//        this.personViewModel = personViewModel

//        val factory = PersonViewModelFactory(personData)


//        personViewModel.insertPerson()
//        Log.e("check_data", personViewModel.insertPerson().toString())

        setContent {
            val personViewModel: PersonViewModel = hiltViewModel()
            personViewModel.getPersons()
            AndroidArchitectureTheme {
                val navHostController = rememberNavController()
                NavGraph(navHostController = navHostController, personViewModel = personViewModel)
//                PersonData(viewModel)
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Polash",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}
