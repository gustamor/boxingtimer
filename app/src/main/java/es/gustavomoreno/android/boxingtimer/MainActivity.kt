package es.gustavomoreno.android.boxingtimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import es.gustavomoreno.android.boxingtimer.navigation.Route
import es.gustavomoreno.android.boxingtimer.ui.theme.BoxingTimerTheme
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.ClockDownTimerScreen
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.ConfigureDurationScreen
import es.gustavomoreno.android.boxingtimer.ui.theme.screen.SelectPredefinedDurationsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxingTimerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) {
                    val navigationController: NavHostController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Route.SelectPredefinedDurationsScreen.route
                    ){
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
}
