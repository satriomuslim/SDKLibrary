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

class Read (private var context: Context) {

    private var reader: RFIDReader? = null

    fun setReadEPC(tagID : String) {
        try {
            val tagAccess = TagAccess()
            val readAccessParams = tagAccess.ReadAccessParams()
            readAccessParams.accessPassword = 0

            readAccessParams.count = 4

            readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_EPC

            readAccessParams.offset = 0

            val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

            if (tagData != null) {
                val readAccessOperation: ACCESS_OPERATION_CODE = tagData.opCode
                if (readAccessOperation != null) {
                    if (tagData.opStatus != null && !tagData.opStatus
                            .equals(ACCESS_OPERATION_STATUS.ACCESS_SUCCESS)
                    ) {
                        val strErr: String = tagData.opStatus.toString().replace("_", " ")
                        Toast.makeText(context, strErr.lowercase(Locale.getDefault()), Toast.LENGTH_SHORT).show()
                    } else {
                        if (tagData.opCode === ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ) {
                            Toast.makeText(context, "Berhasil " + tagData.memoryBankData, Toast.LENGTH_SHORT).show()
                            Log.d("MEMORY BANK", "Memory TID : ${tagData.memoryBankData}")
                        } else {

                        }
                    }
                } else {
                    Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
            }

        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
    }

    fun setReadReserved(tagID : String) {
        try {
            val tagAccess = TagAccess()
            val readAccessParams = tagAccess.ReadAccessParams()
            readAccessParams.accessPassword = 0

            readAccessParams.count = 4

            readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_RESERVED

            readAccessParams.offset = 0

            val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

            if (tagData != null) {
                val readAccessOperation: ACCESS_OPERATION_CODE = tagData.opCode
                if (readAccessOperation != null) {
                    if (tagData.opStatus != null && !tagData.opStatus
                            .equals(ACCESS_OPERATION_STATUS.ACCESS_SUCCESS)
                    ) {
                        val strErr: String = tagData.opStatus.toString().replace("_", " ")
                        Toast.makeText(context, strErr.lowercase(Locale.getDefault()), Toast.LENGTH_SHORT).show()
                    } else {
                        if (tagData.opCode === ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ) {
                            Toast.makeText(context, "Berhasil " + tagData.memoryBankData, Toast.LENGTH_SHORT).show()
                            Log.d("MEMORY BANK", "Memory TID : ${tagData.memoryBankData}")
                        } else {

                        }
                    }
                } else {
                    Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
            }

        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
    }

    fun setReadTID(tagID : String) {
        try {
            val tagAccess = TagAccess()
            val readAccessParams = tagAccess.ReadAccessParams()
            readAccessParams.accessPassword = 0

            readAccessParams.count = 4

            readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_TID

            readAccessParams.offset = 0

            val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

            if (tagData != null) {
                val readAccessOperation: ACCESS_OPERATION_CODE = tagData.opCode
                if (readAccessOperation != null) {
                    if (tagData.opStatus != null && !tagData.opStatus
                            .equals(ACCESS_OPERATION_STATUS.ACCESS_SUCCESS)
                    ) {
                        val strErr: String = tagData.opStatus.toString().replace("_", " ")
                        Toast.makeText(context, strErr.lowercase(Locale.getDefault()), Toast.LENGTH_SHORT).show()
                    } else {
                        if (tagData.opCode === ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ) {
                            Toast.makeText(context, "Berhasil " + tagData.memoryBankData, Toast.LENGTH_SHORT).show()
                            Log.d("MEMORY BANK", "Memory TID : ${tagData.memoryBankData}")
                        } else {

                        }
                    }
                } else {
                    Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
            }

        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
    }

    fun setReadUser(tagID : String) {
        try {
            val tagAccess = TagAccess()
            val readAccessParams = tagAccess.ReadAccessParams()
            readAccessParams.accessPassword = 0

            readAccessParams.count = 4

            readAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_USER

            readAccessParams.offset = 0

            val tagData = reader!!.Actions.TagAccess.readWait(tagID, readAccessParams, null)

            if (tagData != null) {
                val readAccessOperation: ACCESS_OPERATION_CODE = tagData.opCode
                if (readAccessOperation != null) {
                    if (tagData.opStatus != null && !tagData.opStatus
                            .equals(ACCESS_OPERATION_STATUS.ACCESS_SUCCESS)
                    ) {
                        val strErr: String = tagData.opStatus.toString().replace("_", " ")
                        Toast.makeText(context, strErr.lowercase(Locale.getDefault()), Toast.LENGTH_SHORT).show()
                    } else {
                        if (tagData.opCode === ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ) {
                            Toast.makeText(context, "Berhasil " + tagData.memoryBankData, Toast.LENGTH_SHORT).show()
                            Log.d("MEMORY BANK", "Memory TID : ${tagData.memoryBankData}")
                        } else {

                        }
                    }
                } else {
                    Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Data success to write", Toast.LENGTH_SHORT).show()
            }

        } catch (e: InvalidUsageException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data", Toast.LENGTH_SHORT).show()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to set data 1", Toast.LENGTH_SHORT).show()
        }
    }

}