package com.example.sdklibrary.zebra

import android.os.AsyncTask
import android.util.ArrayMap
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

class MultiLocate (
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

    fun initMultiTagLocate(tagID: ArrayMap<String, String>) {
        try {
            reader?.Actions?.MultiTagLocate?.purgeItemList()
            reader?.Actions?.MultiTagLocate?.importItemList(tagID)
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun startMultiTagLocate() {
        try {
            if (reader != null && reader!!.isConnected) {
                reader?.Actions?.MultiTagLocate?.perform()
            } else {
                Log.e("RFIDHandler", "Reader is not connected")
            }
        } catch (e: Exception) {
            Log.e("RFIDHandler", "Failed to perform tag locationing", e)
        }
    }

    fun stopMultiTagLocate() {
        try {
            if (reader != null && reader!!.isConnected) {
                reader?.Actions?.MultiTagLocate?.stop()
            } else {
                Log.e("RFIDHandler", "Reader is not connected")
            }
        } catch (e: Exception) {
            Log.e("RFIDHandler", "Failed to perform tag locationing", e)
        }
    }

    // Read/Status Notify handler
    // Implement the RfidEventsLister class to receive event notifications
    inner class EventHandler : RfidEventsListener {
        // Read Event Notification
        override fun eventReadNotify(e: RfidReadEvents) {
            val myTags: Array<TagData>? = reader?.Actions?.getMultiTagLocateTagInfo(100)
            if (myTags != null) {
                for (index in myTags.indices) {
                    Log.d("MultiTagLocate", "Tag ID " + myTags[index].tagID)
                    if (myTags[index].isContainsMultiTagLocateInfo) {
                        //Get correcponding Tag locate info
                        Log.d("MultiTagLocate", "${myTags[index].tagID} - Distance: ${myTags[index].MultiTagLocateInfo.relativeDistance}")
                    }
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