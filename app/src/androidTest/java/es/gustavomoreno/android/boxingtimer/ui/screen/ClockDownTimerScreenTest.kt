package es.gustavomoreno.android.boxingtimer.ui.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.ClockDownTimerScreen
import org.junit.Rule
import org.junit.Test

/**
 * Clock down timer screen test
 *
 * @constructor Create empty Clock down timer screen test
 */
class ClockDownTimerScreenTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    /**
     * When_clock down timer screen_check if_exists_main column
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_MainColumn() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
       composeTestRule.onNodeWithTag("MainColumnClockDownTimerScreen").assertExists()
    }

    /**
     * When_clock down timer screen_check if_exists_main row
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_MainRow() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
        composeTestRule.onNodeWithTag("MainRowClockDownTimerScreen").assertExists()
    }

    /**
     * When_clock down timer screen_check if_exists_main title
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_MainTitle() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
        composeTestRule.onNodeWithTag("MainTitleClockDownTimerScreen").assertExists()
    }

    /**
     * When_clock down timer screen_check if_exists_clock row
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_ClockRow() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
        composeTestRule.onNodeWithTag("ClockRowClockDownTimerScreen").assertExists()
    }

    /**
     * When_clock down timer screen_check if_exists_minutes clock
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_MinutesClock() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
        composeTestRule.onNodeWithTag("MinutesClockDownTimerScreen").assertExists()
    }

    /**
     * When_clock down timer screen_check if_exists_separator clock
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_SeparatorClock() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
        composeTestRule.onNodeWithTag("SeparatorClockDownTimerScreen").assertExists()
    }

    /**
     * When_clock down timer screen_check if_exists_seconds clock
     *
     */
    @Test
    fun when_ClockDownTimerScreen_checkIf_Exists_SecondsClock() {
        composeTestRule.setContent {
            ClockDownTimerScreen()
        }
        composeTestRule.onNodeWithTag("SecondsClockDownTimerScreen").assertExists()
    }
}