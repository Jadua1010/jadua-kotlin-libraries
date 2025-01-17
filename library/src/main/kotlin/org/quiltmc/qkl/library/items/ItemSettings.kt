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

package org.quiltmc.qkl.library.items

import net.minecraft.entity.EquipmentSlot
import net.minecraft.feature_flags.FeatureFlag
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Rarity
import org.quiltmc.qsl.item.setting.api.CustomDamageHandler
import org.quiltmc.qsl.item.setting.api.CustomItemSetting
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

/**
 * Create a [QuiltItemSettings] with the given information.
 * Calling without specifying any parameters will create the default settings.
 * This is enough for many items.
 *
 * @author sschr15
 */
public fun itemSettingsOf(
    maxCount: Int? = null,
    maxDamage: Int? = null,
    recipeRemainder: Item? = null,
    rarity: Rarity? = null,
    foodComponent: FoodComponent? = null,
    fireproof: Boolean = false,
    requiredFlags: List<FeatureFlag>? = null,
    customDamage: CustomDamageHandler? = null,
    equipmentSlot: ((ItemStack) -> EquipmentSlot)? = null,
    otherSettings: List<Pair<CustomItemSetting<*>, *>> = emptyList()
): QuiltItemSettings = buildItemSettings {
    if (maxDamage != null) maxDamage(maxDamage)
    if (maxCount != null) maxCount(maxCount)
    if (recipeRemainder != null) recipeRemainder(recipeRemainder)
    if (rarity != null) rarity(rarity)
    if (foodComponent != null) food(foodComponent)
    if (fireproof) fireproof()
    if (requiredFlags != null) requiredFlags(*requiredFlags.toTypedArray())
    if (customDamage != null) customDamage(customDamage)
    if (equipmentSlot != null) equipmentSlot(equipmentSlot)
    otherSettings.forEach { (setting, value) ->
        @Suppress("UNCHECKED_CAST")
        customSetting(setting as CustomItemSetting<Any>, value)
    }
}

/**
 * Build a [QuiltItemSettings] with builder-style syntax.
 */
public fun buildItemSettings(block: QuiltItemSettings.() -> Unit): QuiltItemSettings =
    QuiltItemSettings().apply(block)

/**
 * Add a [CustomItemSetting] to this item settings.
 */
public fun <T> QuiltItemSettings.customSetting(value: T, setting: CustomItemSetting<T>) {
    customSetting(setting, value)
}
