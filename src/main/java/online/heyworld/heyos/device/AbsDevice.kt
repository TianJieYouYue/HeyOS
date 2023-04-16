package online.heyworld.heyos.device

abstract class AbsDevice(val deviceName:String,val deviceVersion:String) : IDevice {

    var powerOn = false
    override fun name(): String {
        return deviceName
    }

    override fun version(): String {
        return deviceVersion
    }

    override fun switchPower(on: Boolean) {
        this.powerOn = on
        if(powerOn){
            onPowerOn()
        }else{
            onPowerOff()
        }
    }

    abstract fun onPowerOn()
    abstract fun onPowerOff()
}