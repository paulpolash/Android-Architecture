package com.example.androidarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.ui.screen.PersonData
import com.example.androidarchitecture.ui.theme.AndroidArchitectureTheme
import com.example.androidarchitecture.ui.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[UserViewModel::class.java]
        initVariable()
//        initFunctionality()


//        enableEdgeToEdge()
        setContent {
            AndroidArchitectureTheme {
                PersonData(viewModel)
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
