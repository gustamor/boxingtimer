package es.gustavomoreno.android.boxingtimer.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Preview
@Composable
fun ConfigureDurationScreen(model: DurationsViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(top = 148.dp)
            .testTag("MainColumnConfigureDurationScreen")

    ) {
        OutLinedTextField(
            "3",
            "Minutes per round",
            Icons.Filled.DateRange,
            model::onRoundDurationChangeValue
        )
        OutLinedTextField(
            "12",
            "Número de rounds",
            Icons.Filled.DateRange,
            model::onRoundsChangeValue
        )
        OutLinedTextField(
            "1",
            "Rest interval minutes",
            Icons.Filled.DateRange,
            model::onRestIntervalDurationChangeValue
        )
        Row(
            Modifier
                .fillMaxSize()
                .padding(top = 64.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            RoundedButton("Start", model)
        }
    }
}

@Composable
fun RoundedButton(text: String, model: DurationsViewModel) {
    Button(modifier = Modifier
        .width(200.dp)
        .height(50.dp)
        .padding(horizontal = 16.dp)
        .testTag("RoundButtonConfigureDurationScreen"),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colors.background,
            backgroundColor = MaterialTheme.colors.secondary,
        ),
        onClick = {
            // model.roundDuration
            //  model.rounds
            model.restIntervalDuration
        }
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 6.dp)
                .testTag("TextRoundButtonConfigureDurationScreen")

        )
    }
}

@Composable
fun OutLinedTextField(
    text: String,
    hiltText: String,
    icon: ImageVector,
    onValueChangeFunction: (Int) -> Unit
) {
    var textValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(text))
    }
    OutlinedTextField(
        shape = RoundedCornerShape(10.dp),
        leadingIcon = { Icon(icon, "Round Duration") },
        value = textValue,
        singleLine = true,
        onValueChange = {
            if (it.text.isEmpty()) {
                textValue = it
                onValueChangeFunction(0)
            } else if (it.text.length <= 2) {
                textValue = it
                onValueChangeFunction(it.text.toInt())
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.secondary,
            leadingIconColor = Color(0xFFFFC300),
            disabledLeadingIconColor = Color(0xFFFFC300),
            textColor = Color(0xFFFFC300),
            disabledTextColor = Color(0xFFFFC300),
        ),
        label = {
            Text(
                hiltText,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                fontSize = 21.sp,
                color = Color(0xFFFFC300)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color(0xFF000814))
            .padding(vertical = 8.dp)
            .testTag("OutlinedTextFieldConfigureDurationScreen")
    )
}
