package com.mahmoud.ecowind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    var sliderValue by remember { mutableStateOf(40f) }
    var isToggleOn by remember { mutableStateOf(false) }
    var isWaterOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "EcoWind",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                IconButton(onClick = { /* WiFi settings */ }) {
                    Icon(painter = painterResource(id = R.drawable.wifi), contentDescription = "WiFi")
                }
                IconButton(onClick = { /* Open settings */ }) {
                    Icon(painter = painterResource(id = R.drawable.setting), contentDescription = "Settings")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Semi-circle Slider Simulation
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { sliderValue / 100f },
                modifier = Modifier.size(200.dp),
                color = Color(0xFF467864),
                strokeWidth = 8.dp,
            )
            Text(text = "${sliderValue.toInt()} km/h", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Toggle Button
        Switch(
            checked = isToggleOn,
            onCheckedChange = { isToggleOn = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Plus and Minus Buttons
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { if (sliderValue > 0) sliderValue -= 10 }) {
                Text("-")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { if (sliderValue < 100) sliderValue += 10 }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Water Control
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Water", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Switch(
                checked = isWaterOn,
                onCheckedChange = { isWaterOn = it }
            )
        }
    }
}
