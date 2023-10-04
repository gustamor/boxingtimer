package es.gustavomoreno.android.boxingtimer

import android.app.AlarmManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import es.gustavomoreno.android.boxingtimer.Permissions.Companion.SCHEDULE_EXACT_ALARM_PERMISSION_REQUEST_CODE
import es.gustavomoreno.android.boxingtimer.navigation.Route
import es.gustavomoreno.android.boxingtimer.ui.theme.BoxingTimerTheme
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.CountDown.ClockDownTimerScreen
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.Durations.ConfigureDurationScreen
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.PredefinedDurations.SelectPredefinedDurationsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var permision = Permissions(this)

    @RequiresApi(VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!permision.requestExactAlarmPermission()) {
            permision.verifyBackgroundPermissions()
        }

        setContent {
            BoxingTimerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) {
                    val navigationController: NavHostController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Route.ConfigureDurationScreen.route
                    ) {
                        composable(Route.ConfigureDurationScreen.route) {
                            ConfigureDurationScreen()
                        }
                        composable(Route.ClockDownTimerScreen.route) {
                            ClockDownTimerScreen()
                        }
                        composable(Route.SelectPredefinedDurationsScreen.route) {
                            SelectPredefinedDurationsScreen()
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(VERSION_CODES.S)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == SCHEDULE_EXACT_ALARM_PERMISSION_REQUEST_CODE) {
            if (grantResults.none { it != PackageManager.PERMISSION_GRANTED }) {
                permision.verifyBackgroundPermissions()
            }
        }
    }
}
