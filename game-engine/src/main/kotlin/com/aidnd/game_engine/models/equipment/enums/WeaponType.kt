package com.aidnd.game_engine.models.equipment.enums

import com.aidnd.game_engine.models.enums.WeaponProficiency

enum class WeaponType(val proficiency: WeaponProficiency) {
    // Simple Melee Weapons
    CLUB(WeaponProficiency.SIMPLE),
    DAGGER(WeaponProficiency.SIMPLE),
    GREATCLUB(WeaponProficiency.SIMPLE),
    HANDAXE(WeaponProficiency.SIMPLE),
    JAVELIN(WeaponProficiency.SIMPLE),
    LIGHT_HAMMER(WeaponProficiency.SIMPLE),
    MACE(WeaponProficiency.SIMPLE),
    QUARTERSTAFF(WeaponProficiency.SIMPLE),
    SICKLE(WeaponProficiency.SIMPLE),
    SPEAR(WeaponProficiency.SIMPLE),
    
    // Simple Ranged Weapons
    LIGHT_CROSSBOW(WeaponProficiency.SIMPLE),
    DART(WeaponProficiency.SIMPLE),
    SHORTBOW(WeaponProficiency.SIMPLE),
    SLING(WeaponProficiency.SIMPLE),
    
    // Martial Melee Weapons
    BATTLEAXE(WeaponProficiency.MARTIAL),
    FLAIL(WeaponProficiency.MARTIAL),
    GLAIVE(WeaponProficiency.MARTIAL),
    GREATAXE(WeaponProficiency.MARTIAL),
    GREATSWORD(WeaponProficiency.MARTIAL),
    HALBERD(WeaponProficiency.MARTIAL),
    LANCE(WeaponProficiency.MARTIAL),
    LONGSWORD(WeaponProficiency.MARTIAL),
    MAUL(WeaponProficiency.MARTIAL),
    MORNINGSTAR(WeaponProficiency.MARTIAL),
    PIKE(WeaponProficiency.MARTIAL),
    RAPIER(WeaponProficiency.MARTIAL),
    SCIMITAR(WeaponProficiency.MARTIAL),
    SHORTSWORD(WeaponProficiency.MARTIAL),
    TRIDENT(WeaponProficiency.MARTIAL),
    WAR_PICK(WeaponProficiency.MARTIAL),
    WARHAMMER(WeaponProficiency.MARTIAL),
    WHIP(WeaponProficiency.MARTIAL),
    
    // Martial Ranged Weapons
    BLOWGUN(WeaponProficiency.MARTIAL),
    HAND_CROSSBOW(WeaponProficiency.MARTIAL),
    HEAVY_CROSSBOW(WeaponProficiency.MARTIAL),
    LONGBOW(WeaponProficiency.MARTIAL),
    NET(WeaponProficiency.MARTIAL)
}
