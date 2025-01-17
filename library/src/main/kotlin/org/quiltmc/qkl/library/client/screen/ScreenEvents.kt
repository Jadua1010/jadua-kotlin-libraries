/*
 * Copyright 2022 QuiltMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")
@file:ClientOnly

package org.quiltmc.qkl.library.client.screen

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.util.math.MatrixStack
import org.quiltmc.loader.api.minecraft.ClientOnly
import org.quiltmc.qkl.library.EventRegistration
import org.quiltmc.qsl.base.api.util.TriState
import org.quiltmc.qsl.screen.api.client.ScreenEvents
import org.quiltmc.qsl.screen.api.client.ScreenKeyboardEvents.*
import org.quiltmc.qsl.screen.api.client.ScreenMouseEvents.*

//region: Mouse events

public typealias MouseClick<T> = Screen.(
    mouseX: Double,
    mouseY: Double,
    button: Int
) -> T

public typealias MouseScroll<T> = Screen.(
    mouseX: Double,
    mouseY: Double,
    scrollX: Double,
    scrollY: Double
) -> T

/**
 * @see ALLOW_MOUSE_CLICK
 * @see AllowMouseClick.allowMouseClick
 *
 * @author sschr15
 */
public fun EventRegistration.allowMouseClick(callback: MouseClick<TriState>) {
    ALLOW_MOUSE_CLICK.register(AllowMouseClick(callback))
}

/**
 * @see BEFORE_MOUSE_CLICK
 * @see BeforeMouseClick.beforeMouseClick
 *
 * @author sschr15
 */
public fun EventRegistration.beforeMouseClick(callback: MouseClick<Unit>) {
    BEFORE_MOUSE_CLICK.register(BeforeMouseClick(callback))
}

/**
 * @see AFTER_MOUSE_CLICK
 * @see AfterMouseClick.afterMouseClick
 *
 * @author sschr15
 */
public fun EventRegistration.afterMouseClick(callback: MouseClick<Unit>) {
    AFTER_MOUSE_CLICK.register(AfterMouseClick(callback))
}

/**
 * @see ALLOW_MOUSE_RELEASE
 * @see AllowMouseRelease.allowMouseRelease
 *
 * @author sschr15
 */
public fun EventRegistration.allowMouseRelease(callback: MouseClick<TriState>) {
    ALLOW_MOUSE_RELEASE.register(AllowMouseRelease(callback))
}

/**
 * @see BEFORE_MOUSE_RELEASE
 * @see BeforeMouseRelease.beforeMouseRelease
 *
 * @author sschr15
 */
public fun EventRegistration.beforeMouseRelease(callback: MouseClick<Unit>) {
    BEFORE_MOUSE_RELEASE.register(BeforeMouseRelease(callback))
}

/**
 * @see AFTER_MOUSE_RELEASE
 * @see AfterMouseRelease.afterMouseRelease
 *
 * @author sschr15
 */
public fun EventRegistration.afterMouseRelease(callback: MouseClick<Unit>) {
    AFTER_MOUSE_RELEASE.register(AfterMouseRelease(callback))
}

/**
 * @see ALLOW_MOUSE_SCROLL
 * @see AllowMouseScroll.allowMouseScroll
 *
 * @author sschr15
 */
public fun EventRegistration.allowMouseScroll(callback: MouseScroll<TriState>) {
    ALLOW_MOUSE_SCROLL.register(AllowMouseScroll(callback))
}

/**
 * @see BEFORE_MOUSE_SCROLL
 * @see BeforeMouseScroll.beforeMouseScroll
 *
 * @author sschr15
 */
public fun EventRegistration.beforeMouseScroll(callback: MouseScroll<Unit>) {
    BEFORE_MOUSE_SCROLL.register(BeforeMouseScroll(callback))
}

/**
 * @see AFTER_MOUSE_SCROLL
 * @see AfterMouseScroll.afterMouseScroll
 *
 * @author sschr15
 */
public fun EventRegistration.afterMouseScroll(callback: MouseScroll<Unit>) {
    AFTER_MOUSE_SCROLL.register(AfterMouseScroll(callback))
}

//endregion

//region: Keyboard events

public typealias KeyboardKey<T> = Screen.(
    key: Int,
    scanCode: Int,
    modifiers: Int
) -> T

/**
 * @see ALLOW_KEY_PRESS
 * @see AllowKeyPress.allowKeyPress
 *
 * @author sschr15
 */
public fun EventRegistration.allowKeyPress(callback: KeyboardKey<TriState>) {
    ALLOW_KEY_PRESS.register(AllowKeyPress(callback))
}

/**
 * @see BEFORE_KEY_PRESS
 * @see BeforeKeyPress.beforeKeyPress
 *
 * @author sschr15
 */
public fun EventRegistration.beforeKeyPress(callback: KeyboardKey<Unit>) {
    BEFORE_KEY_PRESS.register(BeforeKeyPress(callback))
}

/**
 * @see AFTER_KEY_PRESS
 * @see AfterKeyPress.afterKeyPress
 *
 * @author sschr15
 */
public fun EventRegistration.afterKeyPress(callback: KeyboardKey<Unit>) {
    AFTER_KEY_PRESS.register(AfterKeyPress(callback))
}

/**
 * @see ALLOW_KEY_RELEASE
 * @see AllowKeyRelease.allowKeyRelease
 *
 * @author sschr15
 */
public fun EventRegistration.allowKeyRelease(callback: KeyboardKey<TriState>) {
    ALLOW_KEY_RELEASE.register(AllowKeyRelease(callback))
}

/**
 * @see BEFORE_KEY_RELEASE
 * @see BeforeKeyRelease.beforeKeyRelease
 *
 * @author sschr15
 */
public fun EventRegistration.beforeKeyRelease(callback: KeyboardKey<Unit>) {
    BEFORE_KEY_RELEASE.register(BeforeKeyRelease(callback))
}

/**
 * @see AFTER_KEY_RELEASE
 * @see AfterKeyRelease.afterKeyRelease
 *
 * @author sschr15
 */
public fun EventRegistration.afterKeyRelease(callback: KeyboardKey<Unit>) {
    AFTER_KEY_RELEASE.register(AfterKeyRelease(callback))
}

//endregion

//region: General Screen events

public typealias ScreenGenericCallback = Screen.() -> Unit
public typealias ScreenInitCallback = Screen.(
    client: MinecraftClient,
    scaledWidth: Int,
    scaledHeight: Int
) -> Unit

public typealias ScreenRenderCallback = Screen.(
    matrices: MatrixStack,
    mouseX: Int,
    mouseY: Int,
    tickDelta: Float
) -> Unit

/**
 * @see ScreenEvents.BEFORE_INIT
 * @see ScreenEvents.BeforeInit.beforeInit
 *
 * @author sschr15
 */
public fun EventRegistration.beforeScreenInit(callback: ScreenInitCallback) {
    ScreenEvents.BEFORE_INIT.register(ScreenEvents.BeforeInit(callback))
}

/**
 * @see ScreenEvents.AFTER_INIT
 * @see ScreenEvents.AfterInit.afterInit
 *
 * @author sschr15
 */
public fun EventRegistration.afterScreenInit(callback: ScreenInitCallback) {
    ScreenEvents.AFTER_INIT.register(ScreenEvents.AfterInit(callback))
}

/**
 * @see ScreenEvents.REMOVE
 * @see ScreenEvents.Remove.onRemove
 *
 * @author sschr15
 */
public fun EventRegistration.onScreenRemoved(callback: ScreenGenericCallback) {
    ScreenEvents.REMOVE.register(ScreenEvents.Remove(callback))
}

/**
 * @see ScreenEvents.BEFORE_RENDER
 * @see ScreenEvents.BeforeRender.beforeRender
 *
 * @author sschr15
 */
public fun EventRegistration.beforeScreenRender(callback: ScreenRenderCallback) {
    ScreenEvents.BEFORE_RENDER.register(ScreenEvents.BeforeRender(callback))
}

/**
 * @see ScreenEvents.AFTER_RENDER
 * @see ScreenEvents.AfterRender.afterRender
 *
 * @author sschr15
 */
public fun EventRegistration.afterScreenRender(callback: ScreenRenderCallback) {
    ScreenEvents.AFTER_RENDER.register(ScreenEvents.AfterRender(callback))
}

/**
 * @see ScreenEvents.BEFORE_TICK
 * @see ScreenEvents.BeforeTick.beforeTick
 *
 * @author sschr15
 */
public fun EventRegistration.beforeScreenTick(callback: ScreenGenericCallback) {
    ScreenEvents.BEFORE_TICK.register(ScreenEvents.BeforeTick(callback))
}

/**
 * @see ScreenEvents.AFTER_TICK
 * @see ScreenEvents.AfterTick.afterTick
 *
 * @author sschr15
 */
public fun EventRegistration.afterScreenTick(callback: ScreenGenericCallback) {
    ScreenEvents.AFTER_TICK.register(ScreenEvents.AfterTick(callback))
}

//endregion
