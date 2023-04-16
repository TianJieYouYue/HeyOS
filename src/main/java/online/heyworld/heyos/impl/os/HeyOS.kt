package online.heyworld.heyos.impl.os

import online.heyworld.heyos.HeyOSManifest
import online.heyworld.heyos.device.IDevice
import online.heyworld.heyos.impl.device.HeyDisplayDevice
import online.heyworld.heyos.os.BaseOS


class HeyOS : BaseOS {

    private lateinit var mDisplayDevice: HeyDisplayDevice
    override fun installDevice(device: IDevice) {
        if(device is HeyDisplayDevice){
            mDisplayDevice = device
        }
    }

    override fun boot() {
        mDisplayDevice.showText(HeyOSManifest.WELCOME)
        mDisplayDevice.showText("\n")
        mDisplayDevice.showText("系统版本:"+HeyOSManifest.OS_VERSION)
        mDisplayDevice.showText("\n")
        mDisplayDevice.showText("系统生成时间:"+HeyOSManifest.OS_CREATE_TIME)
        mDisplayDevice.showText("\n")
        mDisplayDevice.showText("系统源码地址:"+HeyOSManifest.SOURCE_CODE_URL)
        mDisplayDevice.showText("\n")
        Thread.sleep(1000)
        mDisplayDevice.showText("[版本预告]1.1 创建Cpu设备并成功在其上执行输出(嘿，世界)")
        mDisplayDevice.showText("\n")

        mDisplayDevice.showText("第一个版本的空系统，没有运行什么，十秒后关闭")
        mDisplayDevice.showText("\n")


        repeat(10){
            mDisplayDevice.showText("准备关机，剩余${10-it}秒")
            Thread.sleep(1000)
            mDisplayDevice.clearCurrentText()
        }
        shutdown()
    }

    override fun shutdown() {
        mDisplayDevice.showText(HeyOSManifest.SEE_YOU)
    }
}