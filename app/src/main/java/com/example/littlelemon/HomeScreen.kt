package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { }, actions = {
                Image(painter = painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier.clickable(onClick = {navController.navigate(Destinations.Profile.route)}).padding(20.dp, 10.dp).clip(
                    RoundedCornerShape(50)).size(42.dp))
            })
        }
    ) { contentpadding ->
        Box (
            Modifier
                .fillMaxSize()
                .padding(contentpadding)){



            Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .align(Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}