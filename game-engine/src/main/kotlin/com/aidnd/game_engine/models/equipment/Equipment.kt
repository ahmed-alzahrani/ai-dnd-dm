package com.aidnd.game_engine.models.equipment

import com.aidnd.game_engine.dto.equipment.EquipmentResponse
import com.aidnd.game_engine.models.equipment.enums.EquipmentSlot
import com.aidnd.game_engine.models.equipment.items.*

data class Equipment(
    val mainHand: Weapon? = null,
    val offHand: Shield? = null,
    val armor: Armor? = null,
    val head: Helm? = null,
    val neck: Amulet? = null,
    val hands: Gloves? = null,
    val feet: Boots? = null,
    val ringLeft: Ring? = null,
    val ringRight: Ring? = null,
    val belt: Belt? = null,
    val back: Cloak? = null,
    val wrist: Bracers? = null
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

    fun equipWeapon(weapon: Weapon): Equipment = copy(mainHand = weapon)
    
    fun equipShield(shield: Shield): Equipment = copy(offHand = shield)
    
    fun equipArmor(armor: Armor): Equipment = copy(armor = armor)
    
    fun equipRing(ring: Ring, slot: EquipmentSlot): Equipment {
        return when (slot) {
            EquipmentSlot.RING_LEFT -> copy(ringLeft = ring)
            EquipmentSlot.RING_RIGHT -> copy(ringRight = ring)
            else -> throw IllegalArgumentException("Can only equip rings to RING_LEFT or RING_RIGHT")
        }
    }
    
    fun equipHelm(helm: Helm): Equipment = copy(head = helm)
    
    fun equipAmulet(amulet: Amulet): Equipment = copy(neck = amulet)
    
    fun equipGloves(gloves: Gloves): Equipment = copy(hands = gloves)
    
    fun equipBoots(boots: Boots): Equipment = copy(feet = boots)
    
    fun equipBelt(belt: Belt): Equipment = copy(belt = belt)
    
    fun equipCloak(cloak: Cloak): Equipment = copy(back = cloak)
    
    fun equipBracers(bracers: Bracers): Equipment = copy(wrist = bracers)

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

    fun getAllItems(): List<Pair<EquipmentSlot, Item?>> {
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

    fun getEquippedItems(): List<Pair<EquipmentSlot, Item>> {
        return getAllItems()
            .filter { it.second != null }
            .map { it.first to it.second!! }
    }
    
    fun toResponse(): EquipmentResponse {
        return EquipmentResponse(
            mainHand = mainHand?.toResponse(),
            offHand = offHand?.toResponse(),
            armor = armor?.toResponse(),
            head = head?.toResponse(),
            neck = neck?.toResponse(),
            hands = hands?.toResponse(),
            feet = feet?.toResponse(),
            ringLeft = ringLeft?.toResponse(),
            ringRight = ringRight?.toResponse(),
            belt = belt?.toResponse(),
            back = back?.toResponse(),
            wrist = wrist?.toResponse()
        )
    }
}
