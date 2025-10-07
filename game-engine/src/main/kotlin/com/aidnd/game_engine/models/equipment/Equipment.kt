package com.aidnd.game_engine.models.equipment

import com.aidnd.game_engine.models.equipment.enums.EquipmentSlot

data class Equipment(
    val mainHand: Item? = null,
    val offHand: Item? = null,
    val armor: Item? = null,
    val head: Item? = null,
    val neck: Item? = null,
    val hands: Item? = null,
    val feet: Item? = null,
    val ringLeft: Item? = null,
    val ringRight: Item? = null,
    val belt: Item? = null,
    val back: Item? = null,
    val wrist: Item? = null
) {
    fun getItemInSlot(slot: EquipmentSlot): Item? {
        return when (slot) {
            EquipmentSlot.MAIN_HAND -> mainHand
            EquipmentSlot.OFF_HAND -> offHand
            EquipmentSlot.ARMOR -> armor
            EquipmentSlot.HEAD -> head
            EquipmentSlot.NECK -> neck
            EquipmentSlot.HANDS -> hands
            EquipmentSlot.FEET -> feet
            EquipmentSlot.RING_LEFT -> ringLeft
            EquipmentSlot.RING_RIGHT -> ringRight
            EquipmentSlot.BELT -> belt
            EquipmentSlot.BACK -> back
            EquipmentSlot.WRIST -> wrist
        }
    }

    fun equipItem(slot: EquipmentSlot, item: Item): Equipment {
        return when (slot) {
            EquipmentSlot.MAIN_HAND -> copy(mainHand = item)
            EquipmentSlot.OFF_HAND -> copy(offHand = item)
            EquipmentSlot.ARMOR -> copy(armor = item)
            EquipmentSlot.HEAD -> copy(head = item)
            EquipmentSlot.NECK -> copy(neck = item)
            EquipmentSlot.HANDS -> copy(hands = item)
            EquipmentSlot.FEET -> copy(feet = item)
            EquipmentSlot.RING_LEFT -> copy(ringLeft = item)
            EquipmentSlot.RING_RIGHT -> copy(ringRight = item)
            EquipmentSlot.BELT -> copy(belt = item)
            EquipmentSlot.BACK -> copy(back = item)
            EquipmentSlot.WRIST -> copy(wrist = item)
        }
    }

    fun unequipItem(slot: EquipmentSlot): Equipment {
        return when (slot) {
            EquipmentSlot.MAIN_HAND -> copy(mainHand = null)
            EquipmentSlot.OFF_HAND -> copy(offHand = null)
            EquipmentSlot.ARMOR -> copy(armor = null)
            EquipmentSlot.HEAD -> copy(head = null)
            EquipmentSlot.NECK -> copy(neck = null)
            EquipmentSlot.HANDS -> copy(hands = null)
            EquipmentSlot.FEET -> copy(feet = null)
            EquipmentSlot.RING_LEFT -> copy(ringLeft = null)
            EquipmentSlot.RING_RIGHT -> copy(ringRight = null)
            EquipmentSlot.BELT -> copy(belt = null)
            EquipmentSlot.BACK -> copy(back = null)
            EquipmentSlot.WRIST -> copy(wrist = null)
        }
    }

    fun getItems(): List<Pair<EquipmentSlot, Item?>> {
        return listOf(
            EquipmentSlot.MAIN_HAND to mainHand,
            EquipmentSlot.OFF_HAND to offHand,
            EquipmentSlot.ARMOR to armor,
            EquipmentSlot.HEAD to head,
            EquipmentSlot.NECK to neck,
            EquipmentSlot.HANDS to hands,
            EquipmentSlot.FEET to feet,
            EquipmentSlot.RING_LEFT to ringLeft,
            EquipmentSlot.RING_RIGHT to ringRight,
            EquipmentSlot.BELT to belt,
            EquipmentSlot.BACK to back,
            EquipmentSlot.WRIST to wrist
        )
    }
}
