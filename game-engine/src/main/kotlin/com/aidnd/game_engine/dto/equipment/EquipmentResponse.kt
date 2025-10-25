package com.aidnd.game_engine.dto.equipment
import com.aidnd.game_engine.dto.equipment.*

data class EquipmentResponse(
    val mainHand: WeaponResponse?,
    val offHand: ShieldResponse?,
    val armor: ArmorResponse?,
    val head: HelmResponse?,
    val neck: AmuletResponse?,
    val hands: GlovesResponse?,
    val feet: BootsResponse?,
    val ringLeft: RingResponse?,
    val ringRight: RingResponse?,
    val belt: BeltResponse?,
    val back: CloakResponse?,
    val wrist: BracersResponse?
)
