package org.d3if0080.pgrcharremake

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.wanzz.pgrcharwiki.CharData
import com.wanzz.pgrcharwiki.CharModel
import org.d3if0080.pgrcharremake.ui.theme.PGRCharRemakeTheme

@Composable
fun ListItem(model: CharModel, navController: NavController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clickable { navController.navigate("detail/${model.id}") }) {
        Image(
            painter = painterResource(id = model.profile),
            contentDescription = "profile",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(start = 10.dp, top = 5.dp)) {
            Text(text = model.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = model.role)
        }
    }
}

@Composable
fun Greeting() {
    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }
}


@Preview
@Composable
fun HitungButtonPrev() {
    PGRCharRemakeTheme {
        Greeting()
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    PGRCharRemakeTheme {
        val navController = rememberNavController()
        var list: ArrayList<CharModel> = arrayListOf()
        list.addAll(CharData.listData)
        ListItem(model = list[0], navController)
    }
}