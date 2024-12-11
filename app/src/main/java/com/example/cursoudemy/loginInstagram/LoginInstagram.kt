@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cursoudemy.loginInstagram

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursoudemy.R

@Preview
@Composable
fun LoginInstagram() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        HeaderLogin(Modifier.align(Alignment.TopEnd))
        BodyLogin(Modifier.align(Alignment.Center))
        FooterLogin(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun HeaderLogin(modifier: Modifier) {
    val context = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Filled.Close,
        contentDescription = "Close",
        tint = Color.Black,
        modifier = modifier
            .size(30.dp)
            .clickable {
                context.finish()
            }
    )
}


@Composable
fun BodyLogin(modifier: Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isLogin by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        ImageLogo(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailInput(
            Modifier.align(Alignment.CenterHorizontally),
            email = email,
            onValueChange = {
                email = it
                isLogin = enablelogin(email, password)
            })
        Spacer(modifier = Modifier.size(4.dp))
        PasswordInput(
            Modifier.align(Alignment.CenterHorizontally),
            password = password,
            onValueChange = {
                password = it
                isLogin = enablelogin(email, password)
            })
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(modifier = Modifier.align(Alignment.End))

        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLogin = isLogin, onLogin = { isLogin = true })
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.size(32.dp))
        LoginSocial(modifier = Modifier.align(Alignment.CenterHorizontally))


    }
}

@Composable
fun FooterLogin(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFF9F9F9)),
        )
        Spacer(modifier = Modifier.size(16.dp))

        SingUp()

        Spacer(modifier = Modifier.size(24.dp))


    }
}

@Composable
fun SingUp() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Don't have an account?",
            color = Color(0xFF8E8E8E),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = "Sign up.",
            color = Color(0xFF4EA8E9),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        modifier = modifier.size(120.dp),
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Instagram",
    )
}

@Composable
fun EmailInput(modifier: Modifier, email: String, onValueChange: (String) -> Unit) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text("Email")
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        readOnly = false,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color(0xFFF9F9F9),
            focusedContainerColor = Color(0xFFF9F9F9),
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            cursorColor = Color.Black,
        ),

        value = email,
        onValueChange = { onValueChange(it) },
        label = { Text("Email") }
    )
}

fun enablelogin(email: String, password: String): Boolean {

    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6

}


@Composable
fun PasswordInput(modifier: Modifier, password: String, onValueChange: (String) -> Unit) {
    var showPassword by rememberSaveable { mutableStateOf(false) }
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = password,
        placeholder = {
            Text("Password")
        },
        maxLines = 1,
        singleLine = true,

        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color(0xFFF9F9F9),
            focusedContainerColor = Color(0xFFF9F9F9),
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            cursorColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        trailingIcon = {
            val image = if(showPassword){
                Icons.Filled.FavoriteBorder
            }else{
                Icons.Filled.Favorite
            }

            IconButton(
                onClick = { showPassword = !showPassword }
            ) {
                Icon(imageVector = image, contentDescription = "Password")
            }

        },
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        onValueChange = { onValueChange(it) },
        label = { Text("Password") }
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    TextButton(
        onClick = { /*TODO*/ },
        modifier = modifier
    ) {
        Text(
            text = "Forgot password?",
            color = Color(0xFF4EA8E9),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}

@Composable
fun LoginButton(isLogin: Boolean, onLogin: () -> Unit) {
    Button(
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp),
        onClick = { onLogin() },
        enabled = isLogin,

        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            contentColor = Color.White,
            disabledContainerColor = Color(0xFFB2DFFC),
            disabledContentColor = Color(0xFF8E8E8E)

        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "Log in", fontWeight = FontWeight.Bold, color = Color.White)
    }

}

@Composable
fun LoginDivider(modifier: Modifier) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color(0xFFF9F9F9)),
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            color = Color(0xFF8E8E8E),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        HorizontalDivider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color(0xFFF9F9F9)),
        )
    }
}

@Composable
fun LoginSocial(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Facebook",
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Log in with Facebook",
            color = Color(0xFF3B5998),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}
