package com.example.sdklibrary.zebra

import android.content.Context
import android.util.Log
import com.example.sdklibrary.ZebraRFIDSDK.Companion.TAG
import com.zebra.rfid.api3.ENUM_TRANSPORT
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.ReaderDevice
import com.zebra.rfid.api3.Readers


class General(private val context: Context) : Readers.RFIDReaderEventHandler {

    private var reader: RFIDReader? = null

    override fun RFIDReaderAppeared(readerDevice: ReaderDevice) {
        Log.d(TAG, "RFIDReaderAppeared " + readerDevice.name)
    }

    override fun RFIDReaderDisappeared(readerDevice: ReaderDevice?) {
        if (readerDevice != null) {
            Log.d(TAG, "RFIDReaderAppeared " + readerDevice.name)
        }
    }

    fun getListingDevice() {
        try {
            val readers = Readers(context, ENUM_TRANSPORT.BLUETOOTH)
            val readerList = readers.GetAvailableRFIDReaderList()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }
}