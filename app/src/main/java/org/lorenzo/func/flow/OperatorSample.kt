package org.lorenzo.func.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking
import org.lorenzo.func.globalSleep

/**
 * Create by Shuo on 2023-07-21
 * <p>
 */
object OperatorSample {

    @JvmStatic
    fun main(args: Array<String>) {
        runBlocking {
            foldSample()
//            reduceSample()
        }
    }

    private suspend fun foldSample() {
        val result1 = (1..5).asFlow().fold(0) { acc, value ->
            println("acc = $acc  value = $value")
            acc + value
        }
        println("result1 = $result1")

        val result2 = listOf(1).asFlow().fold(0) { acc, value ->
            println("acc = $acc  value = $value")
            acc + value
        }
        println("result2 = $result2")

        (1..5).asFlow().map {
            delay(100)
        }.collect {}
    }


    private suspend fun reduceSample() {
        val result0 = listOf("73").asFlow().reduce { accumulator, value ->
            println("accumulator = $accumulator  value = $value")
            accumulator + value
        }
        println("result0 = $result0")


        (1..5).filter { it > 3 }.map { }

        val result1 = (1..5).asFlow().reduce { accumulator, value ->
            println("accumulator = $accumulator  value = $value")
            accumulator + value
        }
        println("result1 = $result1")

        val result2 = listOf("1", "2", "3", "4", "5").asFlow().reduce { accumulator, value ->
            println("accumulator = $accumulator  value = $value")
            accumulator + value
        }
        println("result2 = $result2")


        val result3 =
            listOf(false, true, false).asFlow().reduce { accumulator, value ->
                println("accumulator = $accumulator  value = $value")
                accumulator && value
            }
        println("result3 = $result3")

        val result4 = (1..5).asFlow().reduce { accumulator, value ->
            println("accumulator = $accumulator  value = $value")
            globalSleep(1)
            accumulator + value
        }
        println("result4 = result4")

        val result5 = (1..5).asFlow().collect {
            println("it = $it")
            globalSleep(1)
        }
        println("result5 = $result5")
    }
}
