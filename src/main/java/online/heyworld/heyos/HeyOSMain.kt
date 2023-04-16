package online.heyworld.heyos;

import online.heyworld.heyos.device.IDevice
import online.heyworld.heyos.impl.device.HeyDisplayDevice
import online.heyworld.heyos.impl.os.HeyOS
import online.heyworld.heyos.os.BaseOS

fun createDevice(
    type: String, cls: Class<out IDevice>,
    deviceMap: MutableMap<String, IDevice>
) {
    @Suppress("DEPRECATION")
    val device = cls.newInstance()
    device.switchPower(true)
    deviceMap[type] = device
}

fun main() {
    // 给各设备供电
    val deviceMap = mutableMapOf<String, IDevice>()
    createDevice("display", HeyDisplayDevice::class.java, deviceMap)

    // 创建系统，并将各设备装载到系统
    val os: BaseOS = HeyOS()
    deviceMap.values.forEach {
        os.installDevice(it)
    }

    // 执行开机
    os.boot()
}