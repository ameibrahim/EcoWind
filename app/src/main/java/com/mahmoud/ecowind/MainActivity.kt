package com.mahmoud.ecowind

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            EcoWindTheme {
            AppNavigator()
//            }
        }
        checkStoragePermission()
    }

    private fun checkStoragePermission() {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        }
    }
}


@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") { LandingScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("connection") { ConnectionScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}

@Composable
fun LandingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .blur(20.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Image(
                painter = painterResource(id = R.drawable.ecowindlogo),
                contentDescription = "App Logo",
                modifier = Modifier.height(200.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Eco Wind",
                fontSize = 40.sp,
                fontWeight = FontWeight.Thin,
                color = Color.White,
                letterSpacing = 4.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Rüzgarın Gücüyle Akıllı Tarım, Suyu Koru, Depola, Geleceği Yaşat!",
                fontSize = 40.sp,
                fontWeight = FontWeight.Thin,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.navigate("dashboard") },
                colors = ButtonDefaults.buttonColors(Color(0xFF467864)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text(text = "Get Started", fontSize = 18.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(50.dp))

        }
    }
}