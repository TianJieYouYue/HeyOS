package online.heyworld.heyos.os

import online.heyworld.heyos.device.IDevice

interface BaseOS {
    fun installDevice(device:IDevice)
    fun boot()
    fun shutdown()
}