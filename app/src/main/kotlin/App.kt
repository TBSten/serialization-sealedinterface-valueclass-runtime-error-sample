@file:Suppress("unused", "DuplicatedCode", "RedundantExplicitType", "FunctionName")

package me.tbsten.serializatin.sealedinterface.valueclass.crash.sample.app

import kotlinx.serialization.json.Json

fun main() {
    `value class (implements sealed interface) encode and decode test`()
    `sealed interface encode and decode test`()
}

fun `value class (implements sealed interface) encode and decode test`() {
    val valueClass: ValueClass = ValueClass("value-class-value")
    println("valueClass: $valueClass")
    val valueClassString = Json.encodeToString(valueClass)
    println("  encoded: $valueClassString")
    println("  decoded: ${Json.decodeFromString<SealedInterface>(valueClassString).let { it to it::class }}")
}

fun `sealed interface encode and decode test`() {
    val valueClass: SealedInterface = ValueClass("value-class-value")
    println("valueClass: $valueClass")
    val valueClassString = Json.encodeToString(valueClass)
    println("  encoded: $valueClassString")
    println("  decoded: ${Json.decodeFromString<SealedInterface>(valueClassString).let { it to it::class }}")
}
