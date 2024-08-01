package org.d3if0080.pgrcharremake

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanzz.pgrcharwiki.CharData
import com.wanzz.pgrcharwiki.CharModel
import org.d3if0080.pgrcharremake.ui.theme.PGRCharRemakeTheme

@Composable
fun DetailChar(model: CharModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = model.banner),
                contentDescription = "banner",
                modifier = Modifier.size(400.dp)
            )
            Image(
                painter = painterResource(id = model.imgRole),
                contentDescription = "role",
                modifier = Modifier
                    .align(
                        Alignment.TopStart
                    )
                    .size(80.dp)
            )
            Image(
                painter = painterResource(id = model.imgFaction),
                contentDescription = "role",
                modifier = Modifier
                    .align(
                        Alignment.TopEnd
                    )
                    .size(80.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = model.name, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, bottom = 4.dp)) {
            Text(text = stringResource(R.string.txt_class), modifier = Modifier.padding(end = 40.dp), fontSize = 18.sp)
            Text(text = model.role, fontSize = 18.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, bottom = 4.dp)) {
            Text(text = stringResource(R.string.faction), fontSize = 18.sp, modifier = Modifier.padding(end = 22.dp))
            Text(text = model.faction, fontSize = 18.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, bottom = 4.dp)) {
            Text(text = stringResource(R.string.weapon), fontSize = 18.sp, modifier = Modifier.padding(end = 16.dp))
            Text(text = model.weapon, fontSize = 18.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, bottom = 4.dp)) {
            Text(text = stringResource(R.string.element), fontSize = 18.sp, modifier = Modifier.padding(end = 16.dp))
            Text(text = model.element, fontSize = 18.sp)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 14.dp, end = 10.dp)) {
            Text(text = stringResource(R.string.information), fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
            Text(text = model.info)
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark")
@Composable
fun DetailCharPreview() {
    PGRCharRemakeTheme {
        Surface {
            val list: ArrayList<CharModel> = arrayListOf()
            list.addAll(CharData.listData)
            DetailChar(model = list[0])
        }
    }
}