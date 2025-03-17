package com.mahmoud.ecowind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .blur(20.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.ecowindmainlogo),
                        contentDescription = "App Logo",
                        modifier = Modifier.height(30.dp))
//                    Spacer(modifier = Modifier.width(10.dp))
//                    Text(
//                        text = "EcoWind",
//                        fontSize = 32.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color(0xFF467864)
//                    )
                }

                Row {
                    IconButton(onClick = { navController.navigate("connection") }) {
                        Icon(painter = painterResource(id = R.drawable.wifi), contentDescription = "WiFi", Modifier
                            .height(20.dp)
                            .width(20.dp), tint = Color.White)
                    }
                    IconButton(onClick = { /* Open settings */ }) {
                        Icon(painter = painterResource(id = R.drawable.setting), contentDescription = "Settings", Modifier
                            .height(20.dp)
                            .width(20.dp), tint = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Semi-circle Slider Simulation
            Box(contentAlignment = Alignment.Center) {
//                CircularProgressIndicator(
//                    progress = { sliderValue / 100f },
//                    modifier = Modifier.size(200.dp),
//                    color = Color(0xFF467864),
//                    strokeWidth = 8.dp,
//                )

                CircularSlider(thumbColor = Color.White, progressColor = Color(0xFF467864),  modifier = Modifier.size(360.dp), stroke = 30f, progress = sliderValue)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${sliderValue.toInt()}%",
                        fontSize = 70.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.White,
                    )

//                    Spacer(modifier = Modifier.height(20.dp))

                    // Toggle Button
//                    Switch(
//                        checked = isToggleOn,
//                        onCheckedChange = { isToggleOn = it },
//                        colors = SwitchColors(
//                            checkedThumbColor = Color.White,
//                            checkedTrackColor = Color(0xFF467864),
//                            checkedBorderColor = Color.White,
//                            checkedIconColor = Color(0xFF467864),
//                            uncheckedThumbColor = Color.Gray,
//                            uncheckedTrackColor = Color.White,
//                            uncheckedBorderColor = Color(0xFF467864),
//                            uncheckedIconColor = Color(0xFF467864),
//                            disabledCheckedThumbColor = Color(0xFF467864),
//                            disabledCheckedTrackColor = Color(0xFF467864),
//                            disabledCheckedBorderColor = Color(0xFF467864),
//                            disabledCheckedIconColor = Color(0xFF467864),
//                            disabledUncheckedThumbColor = Color(0xFF467864),
//                            disabledUncheckedTrackColor = Color(0xFF467864),
//                            disabledUncheckedBorderColor = Color(0xFF467864),
//                            disabledUncheckedIconColor = Color(0xFF467864)
//                        )
//                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Spacer(modifier = Modifier.height(16.dp))

            // Plus and Minus Buttons
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Button(onClick = { if (sliderValue > 0) sliderValue -= 10 }) {
//                    Text("-")
//                }
//                Spacer(modifier = Modifier.width(16.dp))
//                Button(onClick = { if (sliderValue < 100) sliderValue += 10 }) {
//                    Text("+")
//                }
//            }

            Spacer(modifier = Modifier.weight(1f))

            // Water Control
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                TextViewWithImage(text = "Humidity", value = "40%", R.drawable.humidity)
                Spacer(modifier = Modifier.height(20.dp))
                TextViewWithImage(text = "Temperature", value = "24℃", R.drawable.thermometer)
                Spacer(modifier = Modifier.height(20.dp))
                TextViewWithImage(text = "Soil Moisture", value = "70%", R.drawable.moisturizing)
            }

            Spacer(modifier = Modifier.height(100.dp))

        }
    }
}

@Composable
fun TextViewWithImage(text: String, value: String, drawableID: Int) {
    Button(
        onClick = {}, colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.DarkGray
        ), contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = drawableID), contentDescription = "WiFi", Modifier
                    .height(26.dp)
                    .width(26.dp), tint = Color.White
            )

            Spacer(modifier = Modifier.width(20.dp))
            Text(text, color = Color.White, fontSize = 16.sp)

            Spacer(modifier = Modifier.weight(1f))
            Text(value, color = Color.White, fontSize = 16.sp)


        }
    }
}
