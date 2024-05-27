package com.steliosf.konsist.samples.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steliosf.konsist.samples.R
import com.steliosf.konsist.samples.presentation.ui.theme.KonsistSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    KonsistSamplesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(stringResource(id = R.string.main_content_1))
                    Spacer(Modifier.size(32.dp))
                    Text(stringResource(id = R.string.main_content_2))
                    Spacer(Modifier.size(32.dp))
                    Text(stringResource(id = R.string.main_content_3))
                    Spacer(Modifier.size(32.dp))
                    Text(stringResource(id = R.string.main_content_4))
                }
            }
        }
    }
}
