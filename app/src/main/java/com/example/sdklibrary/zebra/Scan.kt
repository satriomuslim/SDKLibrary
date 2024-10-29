package com.example.sdklibrary.zebra

import com.zebra.rfid.api3.ACCESS_OPERATION_CODE
import com.zebra.rfid.api3.InvalidUsageException
import com.zebra.rfid.api3.MEMORY_BANK
import com.zebra.rfid.api3.OperationFailureException
import com.zebra.rfid.api3.RFIDReader
import com.zebra.rfid.api3.TagAccess

class Scan {

    private var reader: RFIDReader? = null

    fun startScan() {
        try {
            reader!!.Actions.Inventory.perform()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun stopScan() {
        try {
            reader!!.Actions.Inventory.stop()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun performInventoryAll() {
        try {
            val memoryBanksToRead = arrayOf(MEMORY_BANK.MEMORY_BANK_EPC, MEMORY_BANK.MEMORY_BANK_TID, MEMORY_BANK.MEMORY_BANK_USER, MEMORY_BANK.MEMORY_BANK_RESERVED);
            for (bank in memoryBanksToRead) {
                val ta = TagAccess()
                val sequence = ta.Sequence(ta)
                val op = sequence.Operation()
                op.accessOperationCode = ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
                op.ReadAccessParams.memoryBank = bank ?: throw IllegalArgumentException("bank must not be null")
                reader!!.Actions.TagAccess.OperationSequence.add(op)
            }

            reader!!.Actions.TagAccess.OperationSequence.performSequence()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun performInventoryEPC() {
        try {
            val ta = TagAccess()
            val sequence = ta.Sequence(ta)
            val op = sequence.Operation()
            op.accessOperationCode = ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
            op.ReadAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_EPC
            reader!!.Actions.TagAccess.OperationSequence.add(op)

            reader!!.Actions.TagAccess.OperationSequence.performSequence()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun performInventoryReserved() {
        try {
            val ta = TagAccess()
            val sequence = ta.Sequence(ta)
            val op = sequence.Operation()
            op.accessOperationCode = ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
            op.ReadAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_RESERVED
            reader!!.Actions.TagAccess.OperationSequence.add(op)

            reader!!.Actions.TagAccess.OperationSequence.performSequence()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun performInventoryTID() {
        try {
            val ta = TagAccess()
            val sequence = ta.Sequence(ta)
            val op = sequence.Operation()
            op.accessOperationCode = ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
            op.ReadAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_TID
            reader!!.Actions.TagAccess.OperationSequence.add(op)

            reader!!.Actions.TagAccess.OperationSequence.performSequence()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun performInventoryUser() {
        try {
            val ta = TagAccess()
            val sequence = ta.Sequence(ta)
            val op = sequence.Operation()
            op.accessOperationCode = ACCESS_OPERATION_CODE.ACCESS_OPERATION_READ
            op.ReadAccessParams.memoryBank = MEMORY_BANK.MEMORY_BANK_USER
            reader!!.Actions.TagAccess.OperationSequence.add(op)

            reader!!.Actions.TagAccess.OperationSequence.performSequence()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }

    fun stopInventory() {
        try {
            reader!!.Actions.TagAccess.OperationSequence.stopSequence()
        } catch (e: InvalidUsageException) {
            e.printStackTrace()
        } catch (e: OperationFailureException) {
            e.printStackTrace()
        }
    }
}