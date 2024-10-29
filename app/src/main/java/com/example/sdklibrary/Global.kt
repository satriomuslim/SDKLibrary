package com.example.sdklibrary

class Global {

    private lateinit var scanHw: Honeywell
    private lateinit var scanZB: Zebra

    init {
        initScanDevices()
    }

    private fun initScanDevices() {
        scanHw = Honeywell()
        scanZB = Zebra()
    }

    // Fungsi untuk mengidentifikasi dan melakukan inventory berdasarkan brand
    fun scanIdentity(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.inventoryHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.inventoryZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi Read
    fun scanRead(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.readHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.readZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi Write
    fun scanWrite(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.writeHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.writeZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk memblokir secara permanen
    fun scanBlockPermLock(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.blockPermLockHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.blockPermLockZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk erase block
    fun scanBlockErase(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.blockEraseHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.blockEraseZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk pengaturan antena
    fun scanAntennaSettings(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.antennaSettingsHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.antennaSettingsZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk setting Singularization
    fun scanSingularization(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.singularizationHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.singularizationZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk pre-filters
    fun scanPreFilters(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.preFiltersHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.preFiltersZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk menentukan apakah perangkat muncul
    fun scanReaderAppeared(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.readerAppearedHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.readerAppearedZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk menentukan apakah perangkat hilang
    fun scanReaderDisappeared(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.readerDisappearedHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.readerDisappearedZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk mendapatkan daftar perangkat
    fun scanListingReader(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.listingReaderHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.listingReaderZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk menentukan kemampuan perangkat
    fun scanDeterminingDevice(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.determiningDeviceHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.determiningDeviceZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk mendapatkan nama perangkat yang lebih ramah
    fun scanReaderFriendlyName(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.readerFriendlyHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.readerFriendlyZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk mendapatkan dukungan USB
    fun scanUSBSupport(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.supportUSBHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.supportUSBZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk statistik baterai
    fun scanBatteryStatistics(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.batteryStatisticsHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.batteryStatisticsZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk kontrol LED
    fun scanControlLED(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.controlLEDHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.controlLEDZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk mengaktifkan beeper
    fun scanBeeperEnable(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.beeperEnableHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.beeperEnableZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk update firmware
    fun scanFirmwareUpdate(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.firmwareUpdateHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.firmwareUpdateZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk mode trigger
    fun scanTriggerMode(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.triggerModeHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.triggerModeZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk remapping trigger
    fun scanTriggerRemapping(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.triggerRemappingHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.triggerRemappingZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk pengaturan Wlan
    fun scanWlan(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.wlanHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.wlanZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk mencari tag
    fun scanLocateTag(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.locateTagHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.locateTagZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }

    // Fungsi untuk multi-locate tag
    fun scanMultiLocateTag(brand: String): String {
        return when (brand.lowercase()) {
            "honeywell" -> scanHw.multiLocateTagHoneywell("testHw", "Honeywell")
            "zebra" -> scanZB.multiLocateTagZebra("testZb", "Zebra")
            else -> "Unknown brand"
        }
    }
}


//fun scanBarcode (type : String) : String {
//    var res = "GlobalFunc : Scan Type : $type";
//    return res
//}
//
//fun arithmeticOperation(a: Double, b: Double, operation: String): Double? {
//    return when (operation) {
//        "add" -> a + b
//        "subtract" -> a - b
//        "multiply" -> a * b
//        "divide" -> if (b != 0.0) a / b else null // Handle division by zero
//        else -> null // Invalid operation
//    }
//}
