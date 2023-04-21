package com.example.mapcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mapcompose.ui.theme.MapComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                    ) {
                    val context = LocalContext.current
                    Column(
                        Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = getString(R.string.main_activity_title),
                            style = MaterialTheme.typography.h5
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(
                            onClick = {
                                context.startActivity(Intent(context, BasicMapActivity::class.java))
                             }) {
                            Text(getString(R.string.basic_map_activity))
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Button(
                            onClick = { context.startActivity(Intent(context,MapInColumnActivity::class.java))
                            }) {
                            Text(getString(R.string.map_in_column_activity))
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Button(
                            onClick = {
                                context.startActivity(Intent(context,MapClusteringActivity::class.java))
                            }) {
                            Text(getString(R.string.map_clustering_activity))
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Button(
                            onClick = {
                                context.startActivity(Intent(context, LocationTrackingActivity::class.java))
                            }) {
                            Text(getString(R.string.location_tracking_activity))
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Button(
                            onClick = {
                                context.startActivity(Intent(context,ScaleBarActivity::class.java))
                            }) {
                            Text(getString(R.string.scale_bar_activity))
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Button(
                            onClick = {
                                context.startActivity(Intent(context,StreetViewActivity::class.java))
                            }) {
                            Text(getString(R.string.street_view))
                        }
                    }

                }
            }
        }
    }
}

