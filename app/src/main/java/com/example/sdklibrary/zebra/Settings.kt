package com.example.sdklibrary.zebra

import android.util.Log
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader

class Settings (private val handlerRFID: Connect) {

    private var reader: RFIDReader? = null

    fun connectReader() {
        reader = handlerRFID.reader
        if (reader == null) {
            Log.e("Beeper", "Reader not connected.")
        } else {
            Log.e("Beeper", "Reader not connect.")
        }
    }

    fun setAntenna(powerIndex : Int) : String {
        try {
            if (reader != null && reader!!.isConnected) {
                // get the configuration
                val antennaRfConfig = reader!!.Config.Antennas.getAntennaRfConfig(1)
                antennaRfConfig.setrfModeTableIndex(0)
                antennaRfConfig.tari = 0
                antennaRfConfig.transmitPowerIndex = powerIndex

                // set the configuration
                reader!!.Config.Antennas.setAntennaRfConfig(1, antennaRfConfig)

                return "$powerIndex"

            } else {
                return "Reader not connected."
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
        return "Antenna Failed: Unknown error"
    }
}