package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import org.w3c.dom.NameList

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by remember {
                mutableStateOf("")
            }
            var names by remember {
                mutableStateOf(listOf<String>())
            }
            JetPackComposeTheme {
              Column(
                  modifier = Modifier
                      .fillMaxSize()
                      .padding(16.dp),
              ){
                  Row (
                      modifier = Modifier.fillMaxWidth()
                  ){
                      OutlinedTextField(
                          value = name,
                          onValueChange = { text ->
                              name = text
                          },
                          modifier = Modifier.weight(1f),

                          )
                      Spacer(modifier = Modifier.width(16.dp))

                      Button(onClick = {
                          if (name.isNotBlank()){
                              names = names+ name
                              name=""
                          }

                      }) {

                          Text(text = "Add")
                      }
                  }
                 NameList(names = names) //Reusable Code
              }
            }
        }
    }

}

@Composable
fun NameList(
    names : List<String>,
    modifier: Modifier = Modifier
) {
    
    LazyColumn(modifier ){
        items(names){
                currentName ->
            Text(
                text = currentName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp,)
            )
            Divider()
        }
    }
    
}
