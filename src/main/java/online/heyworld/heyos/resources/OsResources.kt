package online.heyworld.heyos.resources

object OsResources {
    val displayStrings = mutableMapOf<String,MutableMap<String,String>>()
    init {
        displayStrings["display_on"] = mutableMapOf(
            "zh" to "显示器电源已开启",
            "en" to "displayer is power on"
        )

        displayStrings["display_off"] = mutableMapOf(
            "zh" to "显示器电源已关闭",
            "en" to "displayer is power off"
        )
    }
}