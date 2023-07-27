package org.lorenzo.func.scope

/**
 * Create by Shuo on 2023-07-25
 * <p>
 */
object RunSample {
    @JvmStatic
    fun main(args: Array<String>) {
        (1..10).toMutableList().run {
            this.map { "Num$it" }
        }.apply(::print)

        println()

        (1..10).toMutableList().apply {
            this.map { "Num$it" }
        }.apply(::print)
    }
}