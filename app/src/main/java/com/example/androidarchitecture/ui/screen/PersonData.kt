package com.example.androidarchitecture.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.ui.viewModel.PersonViewModel

@Composable
fun PersonData(
    viewModel: PersonViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPersons()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        when {
//            uiState.isLoading -> {
//
//                CircularProgressIndicator(
//                    modifier = Modifier.align(Alignment.Center)
//                )
//            }

//            uiState.error != null -> {
//
//                Text(
//                    text = uiState.error ?: "Something went wrong",
//                    modifier = Modifier.align(Alignment.Center)
//                )
//            }

            else -> {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
//                    items(
//                        items = uiState.persons,
//                        key = { person -> person.id }
//                    ) { person ->
//
//                        PersonItem(person)
//                    }
                }
            }
        }
    }
}


@Composable
fun PersonItem(
    person: PersonEntity
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = person.name,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = "@${person.username}"
        )

        Text(
            text = person.email
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}