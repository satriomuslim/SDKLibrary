package com.example.sdklibrary.zebra

import android.util.Log
import com.zebra.rfid.api3.BEEPER_VOLUME
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException

class Beeper (private val handlerRFID: Connect) {

    private var reader: RFIDReader? = null

    fun connectReader() {
        reader = handlerRFID.reader
        if (reader == null) {
            Log.e("Beeper", "Reader not connected.")
        } else {
            Log.e("Beeper", "Reader not connect.")
        }
    }

    fun enabledBeep() {
        try {
            if (reader != null && reader!!.isConnected) {
                reader!!.Config.beeperVolume = BEEPER_VOLUME.HIGH_BEEP
            } else {
                Log.e("Beeper", "Reader is null or not connected.")
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun disabledBeep() {
        try {
            if (reader != null && reader!!.isConnected) {
                reader!!.Config.beeperVolume = BEEPER_VOLUME.QUIET_BEEP
            } else {
                Log.e("Beeper", "Reader is null or not connected.")
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun setLevelBeep(level: BEEPER_VOLUME) {
        try {
            if (reader != null && reader!!.isConnected) {
                reader!!.Config.beeperVolume = level
            } else {
                Log.e("Beeper", "Reader is null or not connected.")
            }
        }catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

}