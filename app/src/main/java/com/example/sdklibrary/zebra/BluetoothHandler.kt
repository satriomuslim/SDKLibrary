package com.example.sdklibrary.zebra

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.ArrayAdapter
import java.lang.reflect.Method

class BluetoothHandler (private val context: Context, private val adapter: ArrayAdapter<String>, private val pairedAdapter: ArrayAdapter<String>) {

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private val discoveredDevices = HashSet<String>()

    @SuppressLint("MissingPermission")
    private val pairedDevicesReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED == action) {
                // Discovery finished
            } else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED == action) {
                // Discovery started
            } else if (BluetoothDevice.ACTION_FOUND == action) {
                // A new device is found
                val device: BluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)!!
                val deviceName = device.name ?: "Unknown"
                val deviceAddress = device.address

                if (!discoveredDevices.contains(deviceAddress) && !isDevicePaired(deviceAddress)) {
                    discoveredDevices.add(deviceAddress)
                    adapter.add("$deviceName - $deviceAddress")
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun startDiscovery() {
        if (bluetoothAdapter?.isEnabled == true) {
            val pairedDevices = bluetoothAdapter.bondedDevices
            for (device in pairedDevices) {
                val deviceName = device.name ?: "Unknown"
                val deviceAddress = device.address
                pairedAdapter.add("$deviceName - $deviceAddress")
            }

            val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
            context.registerReceiver(pairedDevicesReceiver, filter)
            bluetoothAdapter.startDiscovery()
        } else {
            // Handle case when Bluetooth is not enabled
        }
    }

    @SuppressLint("MissingPermission")
    fun stopDiscovery() {
        bluetoothAdapter?.cancelDiscovery()
        context.unregisterReceiver(pairedDevicesReceiver)
    }

    @SuppressLint("MissingPermission")
    private fun isDevicePaired(deviceAddress: String): Boolean {
        val pairedDevices = bluetoothAdapter?.bondedDevices
        for (device in pairedDevices ?: emptySet()) {
            if (device.address == deviceAddress) {
                return true
            }
        }
        return false
    }

    fun pairDeviceClick(deviceAddress: String) {
        val device = bluetoothAdapter?.getRemoteDevice(deviceAddress)
        try {
            val method: Method = device?.javaClass?.getMethod("createBond") ?: return
            method.invoke(device)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun unpairDeviceClick(deviceAddress: String) {
        val device = bluetoothAdapter?.getRemoteDevice(deviceAddress)
        try {
            val method: Method = device?.javaClass?.getMethod("removeBond") ?: return
            method.invoke(device)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}