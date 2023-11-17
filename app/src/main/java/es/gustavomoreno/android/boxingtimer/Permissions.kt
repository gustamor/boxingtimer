
package es.gustavomoreno.android.boxingtimer

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import javax.inject.Inject

class Permissions @Inject constructor(private val context: Activity) {
    companion object {
        const val SCHEDULE_EXACT_ALARM_PERMISSION_REQUEST_CODE = 100
    }

    fun requestExactAlarmPermission(): Boolean {
        val scheduleExactAlarmPermission: Int =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ContextCompat.checkSelfPermission(
                    context,
                    android.Manifest.permission.SCHEDULE_EXACT_ALARM
                )
            } else {
                PackageManager.PERMISSION_GRANTED
            }
        return scheduleExactAlarmPermission == PackageManager.PERMISSION_GRANTED
    }

    fun verifyBackgroundPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.SCHEDULE_EXACT_ALARM
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
            }
            shouldShowRequestPermissionRationale(
                context,
                android.Manifest.permission.SCHEDULE_EXACT_ALARM
            ) -> {
                Log.d("GusMor", "aquí irá un argumento racional para el usuario.")
            }
            else -> {
                // You can directly ask for the permission.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    requestPermissions(
                        context, arrayOf(android.Manifest.permission.SCHEDULE_EXACT_ALARM),
                        SCHEDULE_EXACT_ALARM_PERMISSION_REQUEST_CODE
                    )
                }
            }
        }
    }
}
