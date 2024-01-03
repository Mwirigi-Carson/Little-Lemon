package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(navController: NavHostController) {

    val sharedPreferences = LocalContext.current.getSharedPreferences("UserData", Context.MODE_PRIVATE)

    val context = LocalContext.current
    
    var firstName by remember {
        mutableStateOf("")
    }

    val lastName by remember {
        mutableStateOf("")
    }

    val emailAddress by remember {
        mutableStateOf("")
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
            Modifier
                .fillMaxWidth()
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        
        Text(text = "Let's get to know you", color = Color.White, modifier = Modifier
            .background(Color(0xFF495E57))
            .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 28.sp)


        Column (Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){
            OutlinedTextField(value = firstName, onValueChange = {
                firstName = it
            }, modifier = Modifier.fillMaxWidth(), label = { Text(text = "First Name")})

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(value = lastName, onValueChange = {
                firstName = it
            },  modifier = Modifier.fillMaxWidth(), label = { Text(text = "Last Name")})

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(value = emailAddress, onValueChange = {
                firstName = it
            },  modifier = Modifier.fillMaxWidth(), label = { Text(text = "Email Address")})
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        Button(onClick = {
            if (firstName.isBlank() && lastName.isBlank() && emailAddress.isBlank()){
                Toast.makeText(context, "Registration unsuccessful. Please enter all data.", Toast.LENGTH_SHORT).show()
            }

            else {
                val editor = sharedPreferences.edit()
                editor.putString("FirstName", firstName)
                editor.putString("LastName", lastName)
                editor.putString("EmailAddress", emailAddress)

                editor. apply()
                Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
            }

            navController.navigate(Destinations.Home.route){
                popUpTo(Destinations.OnBoarding.route){
                    inclusive = true
                }
            }
        },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14))) {

            Text(text = "Register", fontSize = 24.sp)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(navController = rememberNavController())
}