package com.udeldev.contactapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udeldev.contactapp.domain.model.Friend
import com.udeldev.contactapp.presentation.home.components.CardFriend
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
) {

    val name = state.enteredName

    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 30.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = name,
                        onValueChange = { text ->
                            onEvent(HomeEvent.EnteredName(text))
                        },
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(onClick = {
                        onEvent(HomeEvent.AddFriend(Friend(name = state.enteredName)))
                    }) {
                        Text(text = "Add")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.friend) { friend ->
                        CardFriend(
                            name = friend.name,
                            onDeleteClick = {
                                onEvent(HomeEvent.DeleteFriend(friend))
                            }
                        )
                        Divider()
                    }

                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(
            friend = listOf(
                Friend(1, "Udel"),
                Friend(2, "Udel"),
                Friend(3, "Udel"),
                Friend(4, "Udel"),
                Friend(5, "Udel"),
                Friend(6, "Udel"),
                Friend(7, "Udel"),
            ),
        ),
        onEvent = {},
    )
}