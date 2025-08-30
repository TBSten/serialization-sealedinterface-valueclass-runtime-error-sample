package me.tbsten.serializatin.sealedinterface.valueclass.crash.sample.app

import kotlinx.serialization.Serializable

@Serializable
sealed interface SealedInterface

@Serializable
@JvmInline
value class ValueClass(val value: String): SealedInterface

