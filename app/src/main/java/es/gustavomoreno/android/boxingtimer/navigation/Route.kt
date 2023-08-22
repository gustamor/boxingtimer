package es.gustavomoreno.android.boxingtimer.navigation

sealed class Route(val route: String) {
    object ClockDownTimerScreen : Route("clockDownTimerScreen")
    object ConfigureDurationScreen : Route("configureDurationScreen")
    object SelectPredefinedDurationsScreen : Route("selectPredefinedDurationsScreen")
}