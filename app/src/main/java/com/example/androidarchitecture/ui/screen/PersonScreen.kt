package com.example.androidarchitecture.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidarchitecture.data.model.Person
import com.example.androidarchitecture.ui.navigation.Routes
import com.example.androidarchitecture.ui.viewModel.PersonViewModel
import com.example.androidarchitecture.ui.viewModel.UserViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonData(navHostController: NavHostController, viewModel: PersonViewModel){
//    val state by viewModel.personsData.observeAsState(emptyList())//it will be used when we use UserViewModel
    val state by viewModel.personsData.collectAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Person Info") },
            )
        }
    ) { innerPadding ->
        Text(text = "Person Data")
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(state) { person ->
                PersonHeader(person, navHostController)
            }
        }
    }
}


@Composable
fun PersonHeader(person: Person, navHostController: NavHostController){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp)),
            onClick = {
                Log.d("Person", person.name)
                navHostController.navigate(Routes.PersonDetails.createRoute(person.id))
            }
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ){
                Text(text = "Name: "+person.name, color = Color.Black)
                Text(text = "Email: "+person.email, color = Color.Black)
                Log.d("Person", person.name)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetail( personId: Int, personViewModel: PersonViewModel){
    val person by personViewModel.getPersonById(personId).collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Person Detail") },
            )
        }
    ) {innerPadding->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Log.d("detail", person?.name.toString())
                Text(text = "Name: "+ person?.name, color = Color.Black)
                Text(text = "Username: "+ person?.username, color = Color.Black)
                Text(text = "Email: "+ person?.email, color = Color.Black)
                Text(text = "Address: "+ person?.address.toString(), color = Color.Black)
            }
        }

    }
}