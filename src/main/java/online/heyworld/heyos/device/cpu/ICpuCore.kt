package online.heyworld.heyos.device.cpu

import online.heyworld.heyos.util.ExecuteUnit

/**
 * Cpu核心
 */
interface ICpuCore {
    /**
     * 启动
     */
    fun start()

    fun stop()

    fun execute(unit: ExecuteUnit)
}