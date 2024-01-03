package com.example.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavHostController) {

    val sharedPreferences = LocalContext.current.getSharedPreferences("UserProfile", Context.MODE_PRIVATE)

    val firstName = sharedPreferences.getString("FirstName", "")
    val lastName = sharedPreferences.getString("LastName", "")
    val emailAddress = sharedPreferences.getString("EmailAddress", "")

    Column (
        Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
            Modifier
                .fillMaxWidth()
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(text = "Profile Information :-", Modifier.fillMaxWidth(),textAlign = TextAlign.Center, fontSize = 28.sp)
        Spacer(modifier = Modifier.height(28.dp))
        Text(text = "First Name : $firstName", Modifier.fillMaxWidth(),textAlign = TextAlign.Center, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "Last Name : $lastName", Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "Email Address : $emailAddress", Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(18.dp))
        Button(onClick = { sharedPreferences.edit().clear().apply() }, modifier = Modifier.align(CenterHorizontally), colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}