package com.deanveloper.kbukkit

import net.md_5.bungee.api.chat.*

/**
 * @author Dean B on 11/21/2016.
 */

@JvmOverloads
inline fun textComponent(text: String = "", cb: TextComponent.() -> Unit): TextComponent {
    return TextComponent(text).apply { cb() }
}

fun textComponent(text: String): TextComponent {
    return TextComponent(text)
}

inline fun translatableComponent(text: String, cb: TranslatableComponent.() -> Unit): TranslatableComponent {
    return TranslatableComponent(text).apply { cb() }
}

fun translatableComponent(text: String): TranslatableComponent {
    return TranslatableComponent(text)
}

@JvmOverloads
inline fun BaseComponent.addExtraText(text: String = "", cb: TextComponent.() -> Unit) {
    addExtra(TextComponent(text).apply { cb() })
}

inline fun BaseComponent.addExtraTranslate(text: String, cb: TranslatableComponent.() -> Unit) {
    addExtra(TranslatableComponent(text).apply { cb() })
}

operator fun BaseComponent.plus(base: BaseComponent): Array<BaseComponent> {
    return arrayOf(this, base)
}

operator fun Array<BaseComponent>.plus(base: BaseComponent): Array<BaseComponent> {
    return arrayOf(*this, base)
}

operator fun BaseComponent.plus(base: Array<BaseComponent>): Array<BaseComponent> {
    return arrayOf(this, *base)
}