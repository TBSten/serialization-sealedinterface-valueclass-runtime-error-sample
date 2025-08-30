# Serialization crash sample

Value classes that inherit from sealed interfaces marked as @Serializable cannot be decoded and will crash.
This is because the type of the sealed interface cannot be set during serialization.

```kt
// SealedInterface.kt
@Serializable
sealed interface SealedInterface

@Serializable
@JvmInline
value class ValueClass(val value: String): SealedInterface

// App.kt
val valueClass: ValueClass = ValueClass("value-class-value")
println("valueClass: $valueClass")

val valueClassString = Json.encodeToString(valueClass)
println("  encoded: $valueClassString")

// 💥 will be runtime error !
println("  decoded: ${Json.decodeFromString<SealedInterface>(valueClassString).let { it to it::class }}")
```

For the full code, please refer to [app/src/main/kotlin](./app/src/main/kotlin).

Since ValueClasses inheriting from SealedInterface are inherently impossible to deserialize, it may be necessary to treat this as a compile-time error.

## Run this sample

```shell
./gradlew run
```
