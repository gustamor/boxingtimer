package es.gustavomoreno.android.boxingtimer.ui.theme.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.gustavomoreno.android.boxingtimer.R

@Preview
@Composable
fun SelectPredefinedDurationsScreen() {
    val paddingModifier = Modifier.padding(10.dp)

    Column(
        Modifier
            .fillMaxSize()
            .background(color =  MaterialTheme.colors.surface)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.onBackground),
            modifier = paddingModifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                val image: Painter = painterResource(id = R.drawable.clock)
                Image(painter = image, contentDescription = "clockIcon", modifier = Modifier.height(100.dp).width(100.dp))
                Column() {
                    Text(text = "Rounds: 12", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "Duration of round: 3:00",fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "RestTimer time: 1:00", fontSize = 16.sp, modifier =  Modifier.padding(top = 8.dp, start= 16.dp))
                }
            }
        }
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.onBackground),
            modifier = paddingModifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                val image: Painter = painterResource(id = R.drawable.clock)
                Image(painter = image, contentDescription = "clockIcon", modifier = Modifier.height(100.dp).width(100.dp))

                Column() {
                    Text(text = "Rounds: 12", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "Duration of round: 3:00",fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "RestTimer time: 1:00", fontSize = 16.sp, modifier =  Modifier.padding(top = 8.dp, start= 16.dp))
                }
            }

        }
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.onBackground),
            modifier = paddingModifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                val image: Painter = painterResource(id = R.drawable.clock)
                Image(painter = image, contentDescription = "clockIcon", modifier = Modifier.height(100.dp).width(100.dp))

                Column() {
                    Text(text = "Rounds: 12", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "Duration of round: 3:00",fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "RestTimer time: 1:00", fontSize = 16.sp, modifier =  Modifier.padding(top = 8.dp, start= 16.dp))
                }
            }
        }
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.onBackground),
            modifier = paddingModifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                val image: Painter = painterResource(id = R.drawable.clock)
                Image(painter = image, contentDescription = "clockIcon", modifier = Modifier.height(100.dp).width(100.dp))
                Column() {
                    Text(text = "Rounds: 12", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "Duration of round: 3:00",fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "RestTimer time: 1:00", fontSize = 16.sp, modifier =  Modifier.padding(top = 8.dp, start= 16.dp))
                }
            }

        }
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.onBackground),
            modifier = paddingModifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                val image: Painter = painterResource(id = R.drawable.clock)
                Image(painter = image, contentDescription = "clockIcon", modifier = Modifier.height(100.dp).width(100.dp))

                Column() {
                    Text(text = "Rounds: 12", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "Duration of round: 3:00",fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "RestTimer time: 1:00", fontSize = 16.sp, modifier =  Modifier.padding(top = 8.dp, start= 16.dp))
                }
            }

        }
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(3.dp, MaterialTheme.colors.onBackground),
            modifier = paddingModifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row() {
                val image: Painter = painterResource(id = R.drawable.clock)
                Image(painter = image, contentDescription = "clockIcon", modifier = Modifier.height(100.dp).width(100.dp))

                Column() {
                    Text(text = "Rounds: 12", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "Duration of round: 3:00",fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp, start= 16.dp))
                    Text(text = "RestTimer time: 1:00", fontSize = 16.sp, modifier =  Modifier.padding(top = 8.dp, start= 16.dp))
                }
            }

        }

    }

}