package com.example.androidarchitecture.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidarchitecture.data.model.Person
import com.example.androidarchitecture.ui.MainActivity
import com.example.androidarchitecture.ui.viewModel.UserViewModel

@Composable
fun PersonData(viewModel: UserViewModel){
    val state by viewModel.personsData.observeAsState(emptyList())
    Text(text = "Person Data")
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(state) { person ->
            PersonDetail(person)
        }
    }
}

@Composable
fun PersonDetail(person: Person){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
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