package org.lorenzo.func.colletion

/**
 * Create by Shuo on 2023-07-24
 * <p>
 */
object CollectionSample {

    @JvmStatic
    fun main(args: Array<String>) {
        eachSample()
    }

    private fun eachSample() {
        (1..5).onEach(::print).onEach { it * it }
            .onEachIndexed { index, item ->
                if (index == 0) {
                    println()
                }
                print(item)
            }.apply {  }

        println()

        (1..5).onEach(::print).map { it * it }
            .onEachIndexed { index, item ->
                if (index == 0) {
                    println()
                }
                print(item)
            }

        listOf((1..5), (6..10), ((11..15))).onEach(::println).flatMap { outIt ->
            outIt.filter { it % 2 == 0 }.map { "Num$it \n" }.apply(::println)
        }.onEach(::print)

        (1..5).onEach(::print).onEach { it * it }.onEach(::print)
        println()
        (1..5).forEach(::print)
    }
}