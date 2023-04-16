package online.heyworld.heyos.device.display

import online.heyworld.heyos.device.IDevice

interface IDisplayDevice :IDevice{
    fun showText(text:String)

    fun currentShowText():String

    fun clearCurrentText()
}