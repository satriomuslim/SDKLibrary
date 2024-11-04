package com.example.sdklibrary.zebra

import android.os.AsyncTask
import android.util.Log
import com.zebra.rfid.api3.HANDHELD_TRIGGER_EVENT_TYPE
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.RfidEventsListener
import com.zebra.rfid.api3.RfidReadEvents
import com.zebra.rfid.api3.RfidStatusEvents
import com.zebra.rfid.api3.STATUS_EVENT_TYPE
import com.zebra.rfid.api3.TagData

class SingleScan(
    private val handlerRFID: Connect,
    private val responseHandler: ResponseHandlerInterface
) {

    private var reader: RFIDReader? = null

    fun connectReader() {
        reader = handlerRFID.reader
        if (reader == null) {
            Log.e("Scan", "Reader not connected.")
        } else {
            reader?.Events?.addEventsListener(EventHandler())
        }
    }

    fun startScan() {
        try {
            if (reader != null && reader!!.isConnected) {
                reader!!.Actions.Inventory.perform()
            } else {
                Log.e("Scan", "Reader is null or not connected.")
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun stopScan() {
        try {
            if (reader != null && reader!!.isConnected) {
                reader!!.Actions.Inventory.stop()
            } else {
                Log.e("Scan", "Reader is null or not connected.")
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    // Read/Status Notify handler
    // Implement the RfidEventsLister class to receive event notifications
    inner class EventHandler : RfidEventsListener {
        // Read Event Notification
        override fun eventReadNotify(e: RfidReadEvents) {
            val myTags = reader!!.Actions.getReadTags(100)
            if (myTags != null) {
                for (index in myTags.indices) {
                    //  Log.d(TAG, "Tag ID " + myTags[index].getTagID());
                    Log.d(
                        TAG,
                        "Tag ID" + myTags[index].tagID + "RSSI value " + myTags[index].peakRSSI
                    )
                    Log.d(TAG, "RSSI value " + myTags[index].peakRSSI)
                    /* To get the RSSI value*/   //   Log.d(TAG, "RSSI value "+ myTags[index].getPeakRSSI());
                }
                AsyncDataUpdate().execute(arrayOf(*myTags))
            }
        }

        // Status Event Notification
        override fun eventStatusNotify(rfidStatusEvents: RfidStatusEvents) {
            Log.d(TAG, "Status Notification: " + rfidStatusEvents.StatusEventData.statusEventType)
            if (rfidStatusEvents.StatusEventData.statusEventType === STATUS_EVENT_TYPE.HANDHELD_TRIGGER_EVENT) {
                if (rfidStatusEvents.StatusEventData.HandheldTriggerEventData.handheldEvent === HANDHELD_TRIGGER_EVENT_TYPE.HANDHELD_TRIGGER_PRESSED) {
                    object : AsyncTask<Void?, Void?, Void?>() {
                        override fun doInBackground(vararg voids: Void?): Void? {
                            Log.d(TAG, "HANDHELD_TRIGGER_PRESSED")
                            responseHandler.handleTriggerPress(true)
                            return null                        }
                    }.execute()
                }
                if (rfidStatusEvents.StatusEventData.HandheldTriggerEventData.handheldEvent === HANDHELD_TRIGGER_EVENT_TYPE.HANDHELD_TRIGGER_RELEASED) {
                    object : AsyncTask<Void?, Void?, Void?>() {
                        override fun doInBackground(vararg voids: Void?): Void? {
                            responseHandler.handleTriggerPress(false)
                            Log.d(TAG, "HANDHELD_TRIGGER_RELEASED")
                            return null                        }
                    }.execute()
                }
            }
            if (rfidStatusEvents.StatusEventData.statusEventType === STATUS_EVENT_TYPE.DISCONNECTION_EVENT) {
                object : AsyncTask<Void?, Void?, Void?>() {
                    override fun doInBackground(vararg voids: Void?): Void? {
                        TODO("Not yet implemented")
                    }
                }.execute()
            }
        }
    }

    private inner class AsyncDataUpdate :
        AsyncTask<Array<TagData?>?, Void?, Void?>() {
        override fun doInBackground(vararg params: Array<TagData?>?): Void? {
            responseHandler.handleTagdata(params[0])
            return null
        }
    }

    interface ResponseHandlerInterface {
        fun handleTagdata(tagData: Array<TagData?>?)
        fun handleTriggerPress(pressed: Boolean)
        fun barcodeData(value: String?)
        fun sendToast(value: String?)
    }

    companion object {
        const val TAG = "RFID_SAMPLE"
    }
}