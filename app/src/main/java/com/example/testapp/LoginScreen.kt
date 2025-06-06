package com.example.testapp

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(activity: ComponentActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Login Image",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .aspectRatio(2 / 2f)
                .padding(bottom = 16.dp)
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
        )


        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 2.dp, start = 20.dp)
        )

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }


        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Enter your email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor =Color.Yellow,
                unfocusedBorderColor = Color.LightGray
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 25.dp, bottom = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            singleLine = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image =
                    if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ), colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Yellow,
                unfocusedBorderColor = Color.LightGray
            ),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp, top = 10.dp)
        )


        Text(
            text = "Forget Password?",
            style = TextStyle(color = Yellow),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(top = 25.dp, bottom = 10.dp)

        )
        Button(
          onClick = {
              val intent = Intent(activity, MainActivity::class.java)
              activity.startActivity(intent)
              activity.finish()
          },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Yellow
                    )
        ) {
            Text(text = "Login" ,
                style = TextStyle(color = Color.DarkGray),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
 Row {
     Text(
         text = "Don't have account?",
         style = TextStyle(color = Color.Gray),
         fontSize = 16.sp,
         fontWeight = FontWeight.Normal,
         modifier = Modifier.padding(start = 30.dp,top = 20.dp, bottom = 10.dp)

     )
     Text(
         text = " Create new Account",
         style = TextStyle(color = Yellow),
         fontSize = 16.sp,
         fontWeight = FontWeight.Normal,
         modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)

     )
 }
    }

    }



