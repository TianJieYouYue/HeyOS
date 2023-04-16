package online.heyworld.heyos.device.cpu

import online.heyworld.heyos.device.IDevice

interface ICpu :IDevice{
    fun coreList():List<ICpuCore>
}