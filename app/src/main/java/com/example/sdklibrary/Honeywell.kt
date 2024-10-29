package com.example.sdklibrary


class Honeywell {

    //Applicable for ALL devices
    //Reading Tags
    //Inventory
    fun inventoryHoneywell(name: String, brand: String): String {
        return "Honeywell Func Inventory: $brand $name"
    }

    //Access Operations
    //Read
    fun readHoneywell(name: String, brand: String): String {
        return "Honeywell Func Read: $brand $name"
    }

    //Write
    fun writeHoneywell(name: String, brand: String): String {
        return "Honeywell Func Write: $brand $name"
    }

    //Block Perm
    fun blockPermLockHoneywell(name: String, brand: String): String {
        return "Honeywell Func Block Perm: $brand $name"
    }

    //Block Erase
    fun blockEraseHoneywell(name: String, brand: String): String {
        return "Honeywell Func Block Erase: $brand $name"
    }


    //Settings
    //Tag Storage
    fun tagStorageHoneywell(name: String, brand: String): String {
        return "Honeywell Func Tag Storage: $brand $name"
    }

    //Antenna
    fun antennaSettingsHoneywell(name: String, brand: String): String {
        return "Honeywell Func Antenna Settings: $brand $name"
    }

    //Singularization
    fun singularizationHoneywell(name: String, brand: String): String {
        return "Honeywell Func Singularization: $brand $name"
    }

    //Pre Filters
    fun preFiltersHoneywell(name: String, brand: String): String {
        return "Honeywell Func Pre Filters: $brand $name"
    }


    //Applicable only for HandHeld Readers
    //General
    //Reader Appeared
    fun readerAppearedHoneywell(name: String, brand: String): String {
        return "Honeywell Func Reader Appeared: $brand $name"
    }

    //Reader Disappeared
    fun readerDisappearedHoneywell(name: String, brand: String): String {
        return "Honeywell Func Reader Disappeared: $brand $name"
    }

    //Listing Reader
    fun listingReaderHoneywell(name: String, brand: String): String {
        return "Honeywell Func Listing Reader: $brand $name"
    }

    //Determining Device Capabilities
    fun determiningDeviceHoneywell(name: String, brand: String): String {
        return "Honeywell Func Determining Device Capabilities: $brand $name"
    }

    //Reader Friendly Name
    fun readerFriendlyHoneywell(name: String, brand: String): String {
        return "Honeywell Func Reader Friendly: $brand $name"
    }

    //USB Support
    fun supportUSBHoneywell(name: String, brand: String): String {
        return "Honeywell Func USB Support: $brand $name"
    }

    //Battery Statistics
    fun batteryStatisticsHoneywell(name: String, brand: String): String {
        return "Honeywell Func Battery Statistics: $brand $name"
    }

    //LED Control
    fun controlLEDHoneywell(name: String, brand: String): String {
        return "Honeywell Func LED Control: $brand $name"
    }

    //Beeper Enable
    fun beeperEnableHoneywell(name: String, brand: String): String {
        return "Honeywell Func Beeper Enable: $brand $name"
    }

    //Firmware Update
    fun firmwareUpdateHoneywell(name: String, brand: String): String {
        return "Honeywell Func Firmware Update: $brand $name"
    }

    //Trigger Mode
    fun triggerModeHoneywell(name: String, brand: String): String {
        return "Honeywell Func Trigger Mode: $brand $name"
    }

    //Trigger Remapping
    fun triggerRemappingHoneywell(name: String, brand: String): String {
        return "Honeywell Func Trigger Remapping: $brand $name"
    }

    //Wlan
    fun wlanHoneywell(name: String, brand: String): String {
        return "Honeywell Func Wlan: $brand $name"
    }


    //Tag Location
    //Locate Tag
    fun locateTagHoneywell(name: String, brand: String): String {
        return "Honeywell Func Locate Tag: $brand $name"
    }

    //Multi Locate Tag
    fun multiLocateTagHoneywell(name: String, brand: String): String {
        return "Honeywell Func Multi Locate Tag: $brand $name"
    }
}



    /**
        private val name : String = "";

     * Function Scan Reader Honeywell
     * params :
     *  name : string | 'test'
     *  brand : string  \ 'hw' | 'zb'

        fun scanReader (name : String, brand : String): String {
            val res = "HW Func : $brand $name";
            return res
        }

        fun connectReader(brand:String) : String {
            val res = "HW Func : $brand";
            return res;
        }

        fun locateTag(tagID: String): String {
            return "$tagID founded";
        }

        fun setAntenna (dbi : Number) : String {
            var res = "DBI : $dbi";
            return res
        }
     */
