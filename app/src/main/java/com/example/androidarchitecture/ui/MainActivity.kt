package com.example.androidarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.ui.theme.AndroidArchitectureTheme
import com.example.androidarchitecture.ui.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initVariable()
        initFunctionality()


//        enableEdgeToEdge()
//        setContent {
//            AndroidArchitectureTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Polash",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
    private fun initFunctionality(){

    }
    private fun initVariable() {
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[UserViewModel::class.java]
        viewModel.users.observe(this) { users ->
            users.forEach{

                Log.d("TAG", it.name+" - "+it.email)
            }
        }
        viewModel.fetchData()
        viewModel.createPost()

//        viewModel.getUsers.observe(this){data->
//            data.forEach{
//                Log.d("Data", it.name)
//            }
//        }
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