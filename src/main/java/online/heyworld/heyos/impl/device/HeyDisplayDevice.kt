package online.heyworld.heyos.impl.device

import online.heyworld.heyos.device.AbsDevice
import online.heyworld.heyos.device.display.IDisplayDevice
import online.heyworld.heyos.resources.OsResources

class HeyDisplayDevice : AbsDevice("display","hey-1.0"), IDisplayDevice {

    private var mShowText = ""

    override fun showText(text: String) {
        if(powerOn){
            mShowText = text
            print(text)
        }else{
            System.err.print("display power off, not print [$text]")
        }
    }

    override fun currentShowText(): String {
        return mShowText
    }

    override fun clearCurrentText() {
        print("\b".repeat(mShowText.length))
        mShowText = ""
    }


    override fun onPowerOn() {
        StringProgress("正在初始化显示器",3000L,10).run()
        print(OsResources.displayStrings["display_on"]!!["zh"]!!)
        println(" $deviceVersion")
    }

    override fun onPowerOff() {
        println(OsResources.displayStrings["display_off"]!!["zh"]!!)
    }


}

class StringProgress(val prefix:String,val stillTime:Long,val maxProgress:Int){
    private var showingText = ""

    fun run(){
        val stepTime = stillTime/maxProgress
        repeat(maxProgress){
            clear()
            showingText = prefix+".".repeat(it)
            print(showingText)
            Thread.sleep(stepTime)
        }
        println()
    }

    private fun clear(){
        print("\b".repeat(showingText.length))
    }
}