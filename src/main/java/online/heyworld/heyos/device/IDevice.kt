package online.heyworld.heyos.device

interface IDevice {
    fun name():String
    fun version():String

    fun switchPower(on:Boolean)
}