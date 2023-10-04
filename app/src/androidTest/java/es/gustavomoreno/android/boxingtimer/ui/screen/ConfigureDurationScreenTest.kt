package es.gustavomoreno.android.boxingtimer.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations.ConfigureDurationScreen
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations.DurationsViewModel
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations.OutLinedTextField
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations.RoundedButton
import org.junit.Rule
import org.junit.Test

/**
 * Configure duration screen test
 *
 * @constructor Create empty Configure duration screen test
 */
class ConfigureDurationScreenTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    /**
     * When_configure duration screen_check if exists_main column
     *
     */
    @Test
    fun when_ConfigureDurationScreen_checkIfExists_MainColumn() {
        composeTestRule.setContent {
            ConfigureDurationScreen()
        }
        composeTestRule.onNodeWithTag("MainColumnConfigureDurationScreen").assertExists()
    }

    /**
     * When_configure duration screen_check if exists_round button
     *
     */
    @Test
    fun when_ConfigureDurationScreen_CheckIfExists_RoundButton() {
        composeTestRule.setContent {
            ConfigureDurationScreen()
        }
        composeTestRule.onNodeWithTag("RoundButtonConfigureDurationScreen").assertExists()
    }

    /**
     * When_configure duration screen_check if exits_text round button
     *
     */
    @Test
    fun when_ConfigureDurationScreen_CheckIfExits_TextRoundButton() {
        composeTestRule.setContent {
            val model: DurationsViewModel = hiltViewModel()
            RoundedButton(" ") { model.onStarted() }
        }
        composeTestRule.onNodeWithText(" ", ignoreCase = false).assertExists()
    }

    /**
     * When_configure duration screen_check if exists_round_duration_icon
     *
     */
    @Test
    fun when_ConfigureDurationScreen_CheckIfExists_Round_Duration_Icon() {
        composeTestRule.setContent {
            val model: DurationsViewModel = hiltViewModel()
            OutLinedTextField(
                "outlinedtext",
                "hilttext",
                Icons.Filled.DateRange,
                model::onRoundDurationChangeValue
            )
        }
        composeTestRule.onNodeWithContentDescription("RoundTimer Duration").assertExists()
    }

    /**
     * When_configure duration screen_check if exists_outlined text field
     *
     */
    @Test
    fun when_ConfigureDurationScreen_CheckIfExists_OutlinedTextField() {
        composeTestRule.setContent {
            val model: DurationsViewModel = hiltViewModel()
            OutLinedTextField(
                "outlinedtext",
                "hilttext",
                Icons.Filled.DateRange,
                model::onRoundDurationChangeValue
            )
        }
        composeTestRule.onNodeWithTag("OutlinedTextFieldConfigureDurationScreen").assertExists()
    }
}