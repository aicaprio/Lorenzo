package org.lorenzo.func

import java.util.concurrent.TimeUnit

/**
 * Create by Shuo on 2023-07-21
 * <p>
 */
fun globalSleep(second: Long) {
    TimeUnit.SECONDS.sleep(second)
}