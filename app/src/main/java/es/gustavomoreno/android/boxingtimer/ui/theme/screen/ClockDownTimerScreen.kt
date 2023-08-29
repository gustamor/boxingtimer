package es.gustavomoreno.android.boxingtimer.ui.theme.screen

import android.inputmethodservice.Keyboard.Row
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Preview
@Composable
fun ClockDownTimerScreen(model: DurationsViewModel = hiltViewModel()) {
    Column(
        Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .testTag("MainColumnClockDownTimerScreen"),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .background(MaterialTheme.colors.surface)
                .testTag("MainRowClockDownTimerScreen"),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = "ROUND 01",
                fontSize = 32.sp,
                color = (MaterialTheme.colors.onBackground),
                modifier = Modifier.testTag("MainTitleClockDownTimerScreen")
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .height(132.dp)
                .testTag("ClockRowClockDownTimerScreen"),
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                Modifier
                    .weight(0.95f)
                    .height(132.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "07",
                    fontSize = 112.sp,
                    modifier = Modifier.testTag("MinutesClockDownTimerScreen"),
                )
            }
            Row(
                Modifier
                    .weight(0.40f)
                    .height(132.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = ":",
                    fontSize = 106.sp,
                    modifier = Modifier.testTag("SeparatorClockDownTimerScreen")
                )
            }
            Row(
                Modifier
                    .weight(0.95f)
                    .height(132.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "00",
                    fontSize = 112.sp,
                    modifier = Modifier.testTag("SecondsClockDownTimerScreen")
                )
            }
        }
        RoundedButton("Stop", model)

    }

}

