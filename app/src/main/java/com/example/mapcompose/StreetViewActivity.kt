package com.example.mapcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class StreetViewActivity : ComponentActivity() {

    private val TAG  = StreetViewActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}

@Composable
fun StreetViewSwitch(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit){
    Row(Modifier.padding(4.dp)) {
        Text(title)
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}