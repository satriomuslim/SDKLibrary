package com.example.sdklibrary.zebra

import android.util.Log
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader

class Battery(private val handlerRFID: Connect) {

    private var reader: RFIDReader? = null

    fun connectReader() {
        reader = handlerRFID.reader
        if (reader == null) {
            Log.e("Battery", "Reader not connected.")
        }
    }

    fun getBatteryHealth(): String {
        return try {
            if (reader != null && reader!!.isConnected) {
                val batteryStats = reader!!.Config.batteryStats
                batteryStats.health.toString()
            } else {
                Log.e("Battery", "Reader is null or not connected.")
                "Unknown"
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            "Error"
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            "Error"
        }
    }

    fun getBatteryPercentage(): Int {
        return try {
            if (reader != null && reader!!.isConnected) {
                val batteryStats = reader!!.Config.batteryStats
                batteryStats.percentage
            } else {
                Log.e("Battery", "Reader is null or not connected.")
                0
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            0
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            0
        }
    }

    fun getBatteryStatusText(): String {
        return try {
            if (reader != null && reader!!.isConnected) {
                val batteryStats = reader!!.Config.batteryStats
                when (batteryStats.chargeStatus) {
                    1 -> "Charging"
                    0 -> "Discharging"
                    else -> "Unknown"
                }
            } else {
                Log.e("Battery", "Reader is null or not connected.")
                "Unknown"
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            "Error"
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            "Error"
        }
    }

}
