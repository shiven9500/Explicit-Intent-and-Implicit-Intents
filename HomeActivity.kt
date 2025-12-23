package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.core.net.toUri
import androidx.compose.foundation.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import android.provider.Settings

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username") ?: "No User"


        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(username)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(username: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Actions", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Username: $username")
        Text(text = "User Type: Student")

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Actions")

        Spacer(modifier = Modifier.height(100.dp))
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(350.dp))
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = "https://play.google.com".toUri()
            }
            context.startActivity(intent)
        }) {
            Text("Open Play Store")
        }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = "https://WhatsApp.com".toUri()
            }
            context.startActivity(intent)
        }) {
            Text("Open WhatsApp")
        }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "mailto:test@example.com".toUri()
            }
            context.startActivity(intent)
        }) {
            Text("Send an Email")
        }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "smsto:9876543210".toUri()
            }
            context.startActivity(intent)
        }) {
            Text("Send an SMS")
        }
        Button(onClick = {
            val intent = Intent(Settings.ACTION_SETTINGS)
            context.startActivity(intent)
        }) {
            Text("Open Device Settings")
        }
    }
}
