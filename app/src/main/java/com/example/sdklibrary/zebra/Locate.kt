package com.example.sdklibrary.zebra

import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader

class Locate {

    private var reader: RFIDReader? = null

    fun findTagID(tagID: String) {
        try {
            reader?.Actions?.TagLocationing?.Perform(tagID, null, null)
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun findMultiTagID() {
        try {
            reader?.Actions?.MultiTagLocate?.perform()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }
}