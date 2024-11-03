package com.example.sdklibrary.zebra

import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader

class Battery {

    private var reader: RFIDReader? = null

    fun getStatus() {
        try {
            val batteryStats = reader!!.Config.batteryStats
            val batteryHealth = batteryStats.health
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }


    fun getHealth() {
        try {
            val batteryStats = reader!!.Config.batteryStats
            val batteryPercentage = batteryStats.percentage
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun getLevel() {
        try {
            val batteryStats = reader!!.Config.batteryStats

            val batteryStatusText = when (batteryStats.chargeStatus) {
                1 -> "Charging"
                0 -> "Discharging"
                else -> "Unknown"
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

}
