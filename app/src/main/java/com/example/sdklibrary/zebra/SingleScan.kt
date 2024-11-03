package com.example.sdklibrary.zebra

import android.os.AsyncTask
import android.util.Log
import com.zebra.rfid.api3.HANDHELD_TRIGGER_EVENT_TYPE
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.RfidEventsListener
import com.zebra.rfid.api3.RfidReadEvents
import com.zebra.rfid.api3.RfidStatusEvents
import com.zebra.rfid.api3.STATUS_EVENT_TYPE
import com.zebra.rfid.api3.TagData

class SingleScan(private val responseHandler: ResponseHandlerInterface) {

    private var reader: RFIDReader? = null

    // Read/Status Notify handler
    // Implement the RfidEventsListener class to receive event notifications
    inner class EventHandler : RfidEventsListener {
        private var isTagProcessed = false // Flag to ensure only one TagID is processed

        // Read Event Notification
        override fun eventReadNotify(e: RfidReadEvents) {
            val myTags = reader!!.Actions.getReadTags(100)
            if (myTags != null && !isTagProcessed) {
                val firstTag = myTags[0]
                val tagID = firstTag.tagID

                Log.d(TAG, "Tag ID $tagID RSSI value ${firstTag.peakRSSI}")
                Log.d(TAG, "RSSI value ${firstTag.peakRSSI}")

                isTagProcessed = true

                AsyncDataUpdate().execute(arrayOf(firstTag))
            }
        }

        // Status Event Notification
        override fun eventStatusNotify(rfidStatusEvents: RfidStatusEvents) {
            Log.d(TAG, "Status Notification: ${rfidStatusEvents.StatusEventData.statusEventType}")
            if (rfidStatusEvents.StatusEventData.statusEventType === STATUS_EVENT_TYPE.HANDHELD_TRIGGER_EVENT) {
                if (rfidStatusEvents.StatusEventData.HandheldTriggerEventData.handheldEvent === HANDHELD_TRIGGER_EVENT_TYPE.HANDHELD_TRIGGER_PRESSED) {
                    object : AsyncTask<Void?, Void?, Void?>() {
                        override fun doInBackground(vararg voids: Void?): Void? {
                            Log.d(TAG, "HANDHELD_TRIGGER_PRESSED")
                            responseHandler.handleTriggerPress(true)
                            isTagProcessed = false // Reset flag for new tag read
                            return null
                        }
                    }.execute()
                }
                if (rfidStatusEvents.StatusEventData.HandheldTriggerEventData.handheldEvent === HANDHELD_TRIGGER_EVENT_TYPE.HANDHELD_TRIGGER_RELEASED) {
                    object : AsyncTask<Void?, Void?, Void?>() {
                        override fun doInBackground(vararg voids: Void?): Void? {
                            responseHandler.handleTriggerPress(false)
                            Log.d(TAG, "HANDHELD_TRIGGER_RELEASED")
                            return null
                        }
                    }.execute()
                }
            }
            if (rfidStatusEvents.StatusEventData.statusEventType === STATUS_EVENT_TYPE.DISCONNECTION_EVENT) {
                object : AsyncTask<Void?, Void?, Void?>() {
                    override fun doInBackground(vararg voids: Void?): Void? {
                        // Handle disconnection
                        return null
                    }
                }.execute()
            }
        }
    }

    private inner class AsyncDataUpdate : AsyncTask<Array<TagData?>?, Void?, Void?>() {
        override fun doInBackground(vararg params: Array<TagData?>?): Void? {
            responseHandler.handleTagdata(params[0])
            return null
        }
    }

    interface ResponseHandlerInterface {
        fun handleTagdata(tagData: Array<TagData?>?)
        fun handleTriggerPress(pressed: Boolean)
        fun barcodeData(`val`: String?)
        fun sendToast(`val`: String?) //void handleStatusEvents(Events.StatusEventData eventData);
    }

    companion object {
        const val TAG = "RFID_SAMPLE"
    }
}