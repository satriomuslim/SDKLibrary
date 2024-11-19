package com.example.sdklibrary.zebra

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.MEMORY_BANK
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.TagAccess
import com.zebra.rfid.api3.TagData

class Write (private var context: Context, private val handlerRFID: Connect) {

    private var reader: RFIDReader? = null

    fun connectReader() {
        reader = handlerRFID.reader
        if (reader == null) {
            Log.e("Beeper", "Reader not connected.")
        } else {
            Log.e("Beeper", "Reader not connect.")
        }
    }

    fun setWriteEPC(tagId: String, writeData: String) : String {
        try {
            if (reader != null && reader!!.isConnected) {
                val tagData: TagData? = null
                val tagAccess = TagAccess()
                val writeAccessParams = tagAccess.WriteAccessParams()
                writeAccessParams.accessPassword = 0
                writeAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_EPC
                writeAccessParams.offset = 2
                writeAccessParams.setWriteData(writeData)

                writeAccessParams.writeDataLength =   writeData.length / 4

                reader!!.Actions.TagAccess.writeWait(tagId, writeAccessParams, null, tagData)

                return "Write Successful: Data written to tag $tagId"
            } else {
                return "Reader not connected."
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
        return "Write Failed: Unknown error"
    }

    fun setWriteReserved(tagId: String, writeData: String) : String {
        try {
            if (reader != null && reader!!.isConnected) {
                val tagData: TagData? = null
                val tagAccess = TagAccess()
                val writeAccessParams = tagAccess.WriteAccessParams()
                writeAccessParams.accessPassword = 0
                writeAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_RESERVED
                writeAccessParams.offset = 2
                writeAccessParams.setWriteData(writeData)

                writeAccessParams.writeDataLength =   writeData.length / 4

                reader!!.Actions.TagAccess.writeWait(tagId, writeAccessParams, null, tagData)

                return "Write Successful: Data written to tag $tagId"
            } else {
                return "Reader not connected."
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
        return "Write Failed: Unknown error"
    }

    fun setWriteTID(tagId: String, writeData: String): String {
        try {
            if (reader != null && reader!!.isConnected) {
                val tagData: TagData? = null
                val tagAccess = TagAccess()
                val writeAccessParams = tagAccess.WriteAccessParams()
                writeAccessParams.accessPassword = 0
                writeAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_TID
                writeAccessParams.offset = 2
                writeAccessParams.setWriteData(writeData)

                writeAccessParams.writeDataLength =   writeData.length / 4

                reader!!.Actions.TagAccess.writeWait(tagId, writeAccessParams, null, tagData)

                return "Write Successful: Data written to tag $tagId"
            } else {
                return "Reader not connected."
            }

        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
        return "Write Failed: Unknown error"
    }

    fun setWriteUser(tagId: String, writeData: String): String{
        try {
            if (reader != null && reader!!.isConnected) {
                val tagData: TagData? = null
                val tagAccess = TagAccess()
                val writeAccessParams = tagAccess.WriteAccessParams()
                writeAccessParams.accessPassword = 0
                writeAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_USER
                writeAccessParams.offset = 2
                writeAccessParams.setWriteData(writeData)

                writeAccessParams.writeDataLength =   writeData.length / 4

                reader!!.Actions.TagAccess.writeWait(tagId, writeAccessParams, null, tagData)

                return "Write Successful: Data written to tag $tagId"
            } else {
                return "Reader not connected."
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
        return "Write Failed: Unknown error"
    }

}