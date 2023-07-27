package org.lorenzo.func.scope

import kotlinx.coroutines.flow.Flow

/**
 * Create by Shuo on 2023-07-26
 * <p>
 */
class ApplySample {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ApplySample().run {
                checkNullable()
//                rapidPrint()
            }
        }
    }

    /**
     * 用途一：是否是可空对象.
     */
    fun checkNullable() {
        (1..10).apply {
        }

        ((1..10) as? IntRange).apply {
        }

        getData().apply {}

        ({ n1: Int, n2: Int -> n1 + n2 }).apply {
            println(this)
            println(this::class.java.toGenericString())
            println(this::class.simpleName)
            println(invoke(1, 10))
        }
    }

    private fun getData() = null as Flow<String>?

    /**
     * 用途三：快速打印当前对象(以及类似调用的方式).
     */
    fun rapidPrint() {
        "New day, Better day!".apply(block = {
            println(this)
        })

        "New day, Better day!".apply { println(this) }

        "New day, Better day!".apply(::println)

        (3..9).toList().apply(::println)

        val jack = Person("Jack", 24)
        val lucy = Person("Lucy", 21)

        (jack + lucy).apply(::println)
        jack.apply(::meetSomebody)
        lucy.apply(Person::sayHi)
    }

    private fun meetSomebody(person: Person) = println("Meet ${person.name}")
}

data class Person(var name: String, var age: Long) {
    /**
     * 用途二：return this的精简方式.
     */
    private fun addAge(added: Long) = apply { age += added }

    /**
     * 正常的版本.
     */
    private fun addAge2(added: Long): Person {
        age += added
        return this
    }

    operator fun plus(soulMate: Person) = Marriage(this, soulMate)

    companion object {
        @JvmStatic
        fun sayHi(person: Person) {
        }
    }
}

data class Marriage(var self: Person, var soulMate: Person) {
    override fun toString() =
        "${self.name} and ${soulMate.name} were married at their ages of ${self.age} and ${soulMate.age}."
}


