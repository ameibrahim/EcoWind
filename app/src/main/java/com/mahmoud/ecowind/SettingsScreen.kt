package com.mahmoud.ecowind

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.ColorFilter
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController){

    var darkMode by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(true) }

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
            }

            Row(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "Settings",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF467864)
                )
            }

            Spacer(Modifier.height(20.dp))

            // Dark Mode Toggle
            SettingToggleItem(
                title = "Dark Mode",
                iconId = R.drawable.light,
                checked = darkMode,
                onCheckedChange = { darkMode = it }
            )

            CustomDivider()

            // Notifications Toggle
            SettingToggleItem(
                title = "Enable Notifications",
                iconId = R.drawable.notification,
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it }
            )

            CustomDivider()

            SettingClickableItem(
                title = "Units",
                iconId = R.drawable.celcius,
                onClick = { /* Open Help page */ }
            )

            CustomDivider()

            // Help & Support
            SettingClickableItem(
                title = "App Tutorial",
                iconId = R.drawable.tutorial,
                onClick = { /* Open Help page */ }
            )



        }

    }

}

@Composable
fun SettingToggleItem(
    title: String,
    iconId: Int,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(iconId), contentDescription = "WiFi", Modifier
            .height(20.dp)
            .width(20.dp), tint = Color.White)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, modifier = Modifier.weight(1f), color = Color.White)


        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchColors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFF467864),
                checkedBorderColor = Color.White,
                checkedIconColor = Color(0xFF467864),
                uncheckedThumbColor = Color.Gray,
                uncheckedTrackColor = Color.White,
                uncheckedBorderColor = Color(0xFF467864),
                uncheckedIconColor = Color(0xFF467864),
                disabledCheckedThumbColor = Color(0xFF467864),
                disabledCheckedTrackColor = Color(0xFF467864),
                disabledCheckedBorderColor = Color(0xFF467864),
                disabledCheckedIconColor = Color(0xFF467864),
                disabledUncheckedThumbColor = Color(0xFF467864),
                disabledUncheckedTrackColor = Color(0xFF467864),
                disabledUncheckedBorderColor = Color(0xFF467864),
                disabledUncheckedIconColor = Color(0xFF467864)
            )
        )
    }
}

@Composable
fun SettingClickableItem(
    title: String,
    iconId: Int,
    onClick: () -> Unit,
    iconTint: Color = Color.White,
    textColor: Color = Color.White
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(iconId), contentDescription = "WiFi", Modifier
            .height(20.dp)
            .width(20.dp), tint = Color.White)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, color = textColor, modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next", tint = Color.White, modifier = Modifier.size(18.dp))
        Spacer(Modifier.width(2.dp))
    }
}

@Composable
fun CustomDivider(){
    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = Color.White.copy(alpha = 0.3f))
}