package com.example.sdklibrary.zebra

import android.bluetooth.BluetoothAdapter
import android.content.Context
import java.lang.reflect.Method

class BluetoothHandlerBT(private val context: Context) {

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    private fun formatDeviceAddress(address: String): String {
        return address.chunked(2).joinToString(":")
    }

    fun pairDeviceInput(deviceAddress: String) {
        val formattedAddress = formatDeviceAddress(deviceAddress)
        val device = bluetoothAdapter?.getRemoteDevice(formattedAddress)
        try {
            val method: Method = device?.javaClass?.getMethod("createBond") ?: return
            method.invoke(device)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun unpairDeviceInput(deviceAddress: String) {
        val device = bluetoothAdapter?.getRemoteDevice(deviceAddress)
        try {
            val method: Method = device?.javaClass?.getMethod("removeBond") ?: return
            method.invoke(device)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}