package org.lorenzo.func.scope

/**
 * Create by Shuo on 2023-07-25
 * <p>
 */
object TotalSample {
    @JvmStatic
    fun main(args: Array<String>) {
//        checkNullable()
        val result = (1..5).toList().takeIf { it.size > 3 }
        print("result: $result")

        run {

        }

//        with(1L) {
//
//        }
//
//        "1".apply {
//            if (true) {
//
//            }
//
//            kotlin.run {
//
//            }
//        }
//
//        this.apply {
//            kotlin.run {
//
//            }
//            age.apply {
//                run {
//
//                }
//            }
//        }
//    }

}

    /**
     * 用途一：是否是可空对象.
     */
    private fun checkNullable() {
        (1..10).apply {}

        ((1..10) as? IntRange).apply {}

        getData().apply {}

        getData()?.apply {

        } ?: kotlin.run {

        }
    }

    private fun getData() = 3 as Int?

    private fun getData2(): Int = 3
}
