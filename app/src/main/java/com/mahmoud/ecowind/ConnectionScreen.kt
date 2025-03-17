package com.mahmoud.ecowind

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConnectionScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .blur(20.dp),
            contentScale = ContentScale.Crop
        )

        Column(Modifier.padding(horizontal = 30.dp)) {
            Spacer(modifier = Modifier.height(50.dp))

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

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Connection",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF467864)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            ConnectionCircle()
            Spacer(modifier = Modifier.weight(1f))

            TextViewWithImage("ConnectionType", "Bluetooth", R.drawable.bluetooth)

            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

@Composable
fun ConnectionCircle(){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        // Draw concentric circles
        Canvas(modifier = Modifier.size(160.dp)) {
            val radiusStep = size.minDimension / 3  // Defines spacing for circles

            for (i in 1..3) {
                drawCircle(
                    color = Color(0xFF467864).copy(alpha = 0.5f),  // Transparent outer circles
                    radius = radiusStep * i,
                    style = Fill,
                )

                drawCircle(
                    color = Color.White.copy(alpha = 0.8f),  // Transparent outer circles
                    radius = radiusStep * i,
                    style = Stroke(width = 4f),
                )
            }
        }

        // Center circle with "ON"
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "ON",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}