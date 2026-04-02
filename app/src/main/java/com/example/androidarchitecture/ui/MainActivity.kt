package com.example.androidarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.androidarchitecture.data.local.AppDatabase
import com.example.androidarchitecture.data.repository.UserRepository
import com.example.androidarchitecture.ui.navigation.NavGraph
import com.example.androidarchitecture.ui.screen.PersonData
import com.example.androidarchitecture.ui.theme.AndroidArchitectureTheme
import com.example.androidarchitecture.ui.viewModel.PersonViewModel
import com.example.androidarchitecture.ui.viewModel.PersonViewModelFactory
import com.example.androidarchitecture.ui.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: UserViewModel
    private lateinit var personViewModel: PersonViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[UserViewModel::class.java]
//        val factory = PersonViewModelFactory(userRepository = viewModel.userRepository)
//        val personViewModel = ViewModelProvider(this, factory)
//            .get(PersonViewModel::class.java)
        val database = AppDatabase.getDatabase(applicationContext) // use application
        val userDao = database.userDao()
        val repository = UserRepository(userDao)
        val factory = PersonViewModelFactory(repository)
        val personViewModel = ViewModelProvider(this, factory)
            .get(PersonViewModel::class.java)
        this.personViewModel = personViewModel
        initVariable()
//        initFunctionality()


//        enableEdgeToEdge()
        setContent {
            AndroidArchitectureTheme {
                val navHostController = rememberNavController()
                NavGraph(navHostController = navHostController, viewModel = viewModel, personViewModel = personViewModel)
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
    private fun initFunctionality(){

    }
    private fun initVariable() {
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[UserViewModel::class.java]
//        viewModel.users.observe(this) { users ->
//            users.forEach{
//                Log.d("TAG", it.name+" - "+it.email)
//            }
//        }
//        viewModel.fetchData()
//        viewModel.createPost()

//        viewModel.getUsers.observe(this){data->
//            data.forEach{
//                Log.d("Data", it.name)
//                PersonData(person = it)
//            }
//        }
        viewModel.insertAndFetchData()
    }
}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AndroidArchitectureTheme {
//        Greeting("Android")
//    }
//}
