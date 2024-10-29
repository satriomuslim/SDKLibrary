package com.example.sdklibrary.zebra

import com.zebra.rfid.api3.BEEPER_VOLUME
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException

class Beeper {

    private var reader: RFIDReader? = null

    fun enabledBeep() {
        try {
            reader!!.Config.beeperVolume = BEEPER_VOLUME.HIGH_BEEP
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun disabledBeep() {
        try {
            reader!!.Config.beeperVolume = BEEPER_VOLUME.QUIET_BEEP
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun setLevelBeep(level: BEEPER_VOLUME) {
        try {
            reader!!.Config.beeperVolume = level
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }


    }

}