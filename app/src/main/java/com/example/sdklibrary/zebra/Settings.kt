package com.example.sdklibrary.zebra

import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader

class Settings {

    private var reader: RFIDReader? = null

    fun setAntenna(powerIndex : Int) {
        try {
            // get the configuration
            val antennaRfConfig = reader!!.Config.Antennas.getAntennaRfConfig(1)
            antennaRfConfig.setrfModeTableIndex(0)
            antennaRfConfig.tari = 0
            antennaRfConfig.transmitPowerIndex = powerIndex

            // set the configuration
            reader!!.Config.Antennas.setAntennaRfConfig(1, antennaRfConfig)
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }
}