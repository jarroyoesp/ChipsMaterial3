@file:OptIn(ExperimentalMaterial3Api::class)

package com.jarroyo.chipsmaterial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jarroyo.chipsmaterial3.ui.theme.ChipsMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChipsMaterial3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        FilterChip("This a normal text and you see the trailingIcon")
                        FilterChip("This a very long text to show that the trailingIcon is hidden if you have a long text")
                    }
                }
            }
        }
    }
}


@Composable
fun FilterChip(text: String) {
    FilterChip(
        selected = false,
        onClick = { },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ui_ic_cancel),
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
                    .clickable(
                        onClick = {},
                        role = Role.Button,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false, radius = 16.dp),
                    ),
            )
        },
        label = {
            Text(text = text)
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChipsMaterial3Theme() {
        FilterChip("Android")
    }
}