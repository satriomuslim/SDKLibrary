package com.example.sdklibrary.zebra

import android.content.Context
import android.bluetooth.BluetoothAdapter
import java.lang.reflect.Method

class BluetoothHandlerScan(private val context: Context) {

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    private fun formatDeviceAddress(address: String): String {
        return address.chunked(2).joinToString(":")
    }

    fun pairDeviceScan(deviceAddress: String) {
        val formattedAddress = formatDeviceAddress(deviceAddress)
        val device = bluetoothAdapter?.getRemoteDevice(formattedAddress)
        try {
            val method: Method = device?.javaClass?.getMethod("createBond") ?: return
            method.invoke(device)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun unpairDeviceScan(deviceAddress: String) {
        val device = bluetoothAdapter?.getRemoteDevice(deviceAddress)
        try {
            val method: Method = device?.javaClass?.getMethod("removeBond") ?: return
            method.invoke(device)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
