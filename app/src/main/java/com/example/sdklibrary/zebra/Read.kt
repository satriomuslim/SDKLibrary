package com.example.sdklibrary.zebra

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.zebra.rfid.api3.ACCESS_OPERATION_CODE
import com.zebra.rfid.api3.ACCESS_OPERATION_STATUS
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.MEMORY_BANK
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.TagAccess
import java.util.Locale

class Read (private var context: Context, private val handlerRFID: Connect) {

    private var reader: RFIDReader? = null

    fun connectReader() {
        reader = handlerRFID.reader
        if (reader == null) {
            Log.e("Beeper", "Reader not connected.")
        } else {
            Log.e("Beeper", "Reader not connect.")
        }
    }

    fun setReadEPC(tagID: String): String {
        try {
            if (reader != null && reader!!.isConnected) {
                val tagAccess = TagAccess()
                val readAccessParams = tagAccess.ReadAccessParams()
                readAccessParams.accessPassword = 0
                readAccessParams.count = 4
                readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_EPC
                readAccessParams.offset = 0

                val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

                if (tagData != null) {
                    if (tagData.opStatus == ACCESS_OPERATION_STATUS.ACCESS_SUCCESS &&
                        tagData.opCode == ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
                    ) {
                        return "Read Successful: ${tagData.memoryBankData}"
                    } else {
                        val error = tagData.opStatus.toString().replace("_", " ")
                        return "Read Failed: $error"
                    }
                }
            } else {
                return "Reader not connected."
            }
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            return "Read Failed: Invalid usage"
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            return "Read Failed: Operation failure"
        }
        return "Read Failed: Unknown error"
    }

    fun setReadReserved(tagID : String): String{
        try {
            if (reader != null && reader!!.isConnected) {
                val tagAccess = TagAccess()
                val readAccessParams = tagAccess.ReadAccessParams()
                readAccessParams.accessPassword = 0

                readAccessParams.count = 4

                readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_RESERVED

                readAccessParams.offset = 0

                val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

                if (tagData != null) {
                    if (tagData.opStatus == ACCESS_OPERATION_STATUS.ACCESS_SUCCESS &&
                        tagData.opCode == ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
                    ) {
                        return "Read Successful: ${tagData.memoryBankData}"
                    } else {
                        val error = tagData.opStatus.toString().replace("_", " ")
                        return "Read Failed: $error"
                    }
                }
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
        return "Read Failed: Unknown error"
    }

    fun setReadTID(tagID : String): String {
        try {
            if (reader != null && reader!!.isConnected) {
                val tagAccess = TagAccess()
                val readAccessParams = tagAccess.ReadAccessParams()
                readAccessParams.accessPassword = 0

                readAccessParams.count = 4

                readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_TID

                readAccessParams.offset = 0

                val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

                if (tagData != null) {
                    if (tagData.opStatus == ACCESS_OPERATION_STATUS.ACCESS_SUCCESS &&
                        tagData.opCode == ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
                    ) {
                        return "Read Successful: ${tagData.memoryBankData}"
                    } else {
                        val error = tagData.opStatus.toString().replace("_", " ")
                        return "Read Failed: $error"
                    }
                }
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
        return "Read Failed: Unknown error"
    }

    fun setReadUser(tagID : String): String {
        try {
            if (reader != null && reader!!.isConnected) {

                val tagAccess = TagAccess()
                val readAccessParams = tagAccess.ReadAccessParams()
                readAccessParams.accessPassword = 0

                readAccessParams.count = 4

                readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_USER

                readAccessParams.offset = 0

                val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

                if (tagData != null) {
                    if (tagData.opStatus == ACCESS_OPERATION_STATUS.ACCESS_SUCCESS &&
                        tagData.opCode == ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
                    ) {
                        return "Read Successful: ${tagData.memoryBankData}"
                    } else {
                        val error = tagData.opStatus.toString().replace("_", " ")
                        return "Read Failed: $error"
                    }
                }
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
        return "Read Failed: Unknown error"
    }

}