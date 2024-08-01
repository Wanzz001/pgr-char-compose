package org.d3if0080.pgrcharremake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wanzz.pgrcharwiki.CharData
import com.wanzz.pgrcharwiki.CharModel
import org.d3if0080.pgrcharremake.ui.theme.PGRCharRemakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PGRCharRemakeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var list: ArrayList<CharModel> = arrayListOf()
                    list.addAll(CharData.listData)
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "list") {
                        composable("list") {
                            Greeting(list = list, navController)
                        }
                        composable("detail/{itemId}") { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getString("itemId")?.toInt()
                            if (itemId != null) {
                                DetailChar(list[itemId])
                            } else {
                                Text("Error: Item ID not provided")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(list: List<CharModel>, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(list) { charModel ->
            ListItem(model = charModel, navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PGRCharRemakeTheme {
        val navController = rememberNavController()
        var list: ArrayList<CharModel> = arrayListOf()
        list.addAll(CharData.listData)
        Greeting(list = list, navController)
    }
}