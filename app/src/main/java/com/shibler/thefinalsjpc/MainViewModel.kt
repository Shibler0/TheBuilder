package com.shibler.thefinalsjpc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shibler.thefinalsjpc.db.ItemData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//type : 0 = Specializations, 1 = weapons, 2 = gadgets
data class SkinsRarity(val camo: Int, val rarity: String)
data class SkinsCamos(val camo: List<SkinsRarity>)
data class GunStatsCamo(val skinsCamo: SkinsCamos, val dps: Int, val magSize:Int, val damagerPerBullet: Int, val critDamage: Int, val name: String, val reloadTime : Double)


class MainViewModel: ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()

    private val _imageResourceHeavy = MutableStateFlow<List<ItemData?>?>(null)
    val imageResourceHeavy = _imageResourceHeavy.asStateFlow()

    private val _imageResourceMedium = MutableStateFlow<List<ItemData?>?>(null)
    val imageResourceMedium = _imageResourceMedium.asStateFlow()

    private val _imageResourceLight = MutableStateFlow<List<ItemData?>?>(null)
    val imageResourceLight = _imageResourceLight.asStateFlow()

    private val _imageResourceWeapon = MutableStateFlow<List<ItemData?>?>(null)
    val imageResourceWeapon = _imageResourceWeapon.asStateFlow()

    private val _weaponStats = MutableStateFlow<List<GunStatsCamo>?>(null)
    val weaponStats = _weaponStats.asStateFlow()

    init {
        viewModelScope.launch {

            val imageListHeavy = listOf(
                ItemData("GOO-GUN", R.drawable.goo_gun, 0),
                ItemData("M60", R.drawable.m60_standard, 1),
                ItemData("BARRICADE", R.drawable.barricade_gadget, 2),
                ItemData("C4", R.drawable.c4_charge, 2),
                ItemData("DOME SHIELD", R.drawable.dome_shield, 2),
                ItemData("FLAMETHROWER", R.drawable.flamethrower, 1),
                ItemData("FLASHBANG", R.drawable.flashbang, 2),
                ItemData("GAS GRENADE", R.drawable.gas_grenade, 2),
                ItemData("GOO GRENADE", R.drawable.goo_grenade, 2),
                ItemData("CHARGE N SLAM", R.drawable.heavy_charg_n_slam, 0),
                ItemData("MESH SHIELD   ", R.drawable.mesh_shield, 0),
                ItemData("LEWIS GUN", R.drawable.lewis_gun_side_view, 1),
                ItemData("M32GL", R.drawable.m23gl_sideview, 1),
                ItemData("PYRO GRENADE", R.drawable.pyro_grenade, 2),
                ItemData("PYRO MINE", R.drawable.pyro_mine, 2),
                ItemData("RPG", R.drawable.rpg_sideview, 2),
                ItemData("SA1216", R.drawable.sa1216_sideview, 1),
                ItemData("SLEDGEHAMMER", R.drawable.sledgehammer_infobox, 1)
            )

            val imageListMedium = listOf(
                ItemData("AKM", R.drawable.akm_sideview, 1),
                ItemData("CL40", R.drawable.cl40, 1),
                ItemData("FCAR", R.drawable.fcar, 1),
                ItemData("GUARDIAN TURRET", R.drawable.guardian_turret, 0),
                ItemData("HEALING BEAM", R.drawable.healing_beam, 0),
                ItemData("MODEL 1887", R.drawable.model_1887, 1),
                ItemData("R 357", R.drawable.r_357, 1),
                ItemData("RECON SENSE", R.drawable.recon_senses, 0),
                ItemData("RIOT SHIELD", R.drawable.riot_shield, 1),
                ItemData("SONAR GRENADE", R.drawable.sonar_grenade, 2),
                ItemData("GAS GRENADE", R.drawable.gas_grenade, 2),
                ItemData("GAS MINE", R.drawable.gas_mine, 2),
                ItemData("GLITCH TRAP", R.drawable.glitch_trap, 2),
                ItemData("RIOT SHIELD", R.drawable.zipline, 2),
                ItemData("TRACKING DART", R.drawable.tracking_dart, 2),
                ItemData("APS TURRET", R.drawable.aps_turret, 2),
                ItemData("GOO GRENADE", R.drawable.goo_grenade, 2),
                ItemData("EXPLOSIVE MINE", R.drawable.explosive_mine, 2),
                ItemData("DEFIBRILLATOR", R.drawable.defibrillator, 2),
                ItemData("PYRO MINE", R.drawable.pyro_grenade, 2),
                ItemData("FRAG GRENADE", R.drawable.frag_grenade, 2),
                ItemData("FLASHBANG", R.drawable.flashbang, 2),
            )

            val imageListLight = listOf(
                ItemData("CLOAKING DEVICE", R.drawable.cloaking_device, 0),
                ItemData("GRAPPLING HOOK", R.drawable.grappling_hook, 0),
                ItemData("EVASIVE DASH", R.drawable.evasive_dash, 0),
                ItemData("KNIFE", R.drawable.knife_sideview, 1),
                ItemData("LH1", R.drawable.lh1_sideview, 1),
                ItemData("M11", R.drawable.m11_sideview, 1),
                ItemData("SH1900", R.drawable.sawnoff_sideview, 1),
                ItemData("SR 84", R.drawable.sr_84_sideview, 1),
                ItemData("THROWING KNIVES", R.drawable.throwingknives_sideview, 1),
                ItemData("V9S", R.drawable.v9s_sideview, 1),
                ItemData("XP54", R.drawable.xp54_sideview, 1),
                ItemData("SWORD", R.drawable.sword_sideview, 1),
                ItemData("FLASHBANG", R.drawable.flashbang, 2),
                ItemData("FRAG GRENADE", R.drawable.frag_grenade, 2),
                ItemData("GAS GRENADE", R.drawable.gas_grenade, 2),
                ItemData("GOO GRENADE", R.drawable.goo_grenade, 2),
                ItemData("GLITCH GRENADE", R.drawable.glitch_grenade, 2),
                ItemData("MOTION SENSOR", R.drawable.motion_sensor, 2),
                ItemData("SMOKE GRENADE", R.drawable.smoke_grenade, 2),
                ItemData("STUN GUN", R.drawable.stun_gun, 2),
                ItemData("THERMAL VISION", R.drawable.thermal_vision, 2),
                ItemData("PYRO GRENADE", R.drawable.pyro_grenade, 2),
                ItemData("VANISHING BOMB", R.drawable.vanishing_bomb, 2),
            )

            val listOfGunStats = mutableListOf(
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.akm_sideview, "common"),
                    SkinsRarity(R.drawable.akm_eerie, "rare"),
                    SkinsRarity(R.drawable.akm_ospubze, "legendary"),
                    SkinsRarity(R.drawable.akm_dragon, "legendary"),
                    SkinsRarity(R.drawable.akm_bullseye, "rare"),
                    SkinsRarity(R.drawable.akm_diamond, "legendary"),
                    SkinsRarity(R.drawable.akm_catacomb, "epic"),
                    SkinsRarity(R.drawable.akm_golddust, "legendary"),
                    SkinsRarity(R.drawable.akm_cb2_aura, "epic"),
                    SkinsRarity(R.drawable.akm_shop, "legendary"),
                    SkinsRarity(R.drawable.akm_vhs, "epic"),
                    SkinsRarity(R.drawable.akm_lvl6, "epic"),
                    SkinsRarity(R.drawable.akm_decoded_spirit, "epic")
                    )), 205, 36, 20, 30, "AKM", 2.6),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.fcar, "common"),
                    SkinsRarity(R.drawable.fcar_downshifts, "legendary"),
                    SkinsRarity(R.drawable.fcar_fractal, "epic"),
                    SkinsRarity(R.drawable.fcar_polygon, "rare"),
                    SkinsRarity(R.drawable.fcar_scrapyard, "rare"),
                    SkinsRarity(R.drawable.fcar_lvl6, "epic")
                )), 250, 20, 25, 39, "FCAR", 1.8),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.model_1887, "common"),
                    SkinsRarity(R.drawable.model_boreal, "epic"),
                    SkinsRarity(R.drawable.model_closedbeta, "epic"),
                    SkinsRarity(R.drawable.model_lvl6, "epic"),
                    SkinsRarity(R.drawable.model_galaxy, "rare"),
                    SkinsRarity(R.drawable.model_paragon, "rare"),
                    SkinsRarity(R.drawable.model_neon, "legendary"),
                    SkinsRarity(R.drawable.model_dough, "legendary")
                )), 154,6, 128, 128,"MODEL 1887", 4.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.riot_shield_standard, "common"),
                        SkinsRarity(R.drawable.riot_shield_galaxy, "rare"),
                        SkinsRarity(R.drawable.riot_shield_polygon, "rare"),
                        SkinsRarity(R.drawable.riot_shield_playstationexclu, "epic"),
                        SkinsRarity(R.drawable.riot_shield_lvl6, "epic"))),
                    140, 1, 84, 140, "RIOT SHIELD",0.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.cl40, "common"),
                        SkinsRarity(R.drawable.cl40_impromptu, "epic"),
                        SkinsRarity(R.drawable.cl40_lvl6, "epic"),
                        SkinsRarity(R.drawable.cl40_off_panel, "rare"),
                        SkinsRarity(R.drawable.cl40_posh, "rare"),
                        SkinsRarity(R.drawable.cl40_mettalicorange, "orange"),
                        SkinsRarity(R.drawable.cl40_secretscrawls, "orange"))),
                    1, 4, 75, 110, "CL40",3.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.revolver_crisscross, "rare"),
                        SkinsRarity(R.drawable.revolver_crows, "legendary"),
                        SkinsRarity(R.drawable.revolver_diamond, "epic"),
                        SkinsRarity(R.drawable.revolver_ospuze, "legendary"),
                        SkinsRarity(R.drawable.revolver_posh, "rare"),
                        SkinsRarity(R.drawable.revolver_highnoon, "legendary"),
                        SkinsRarity(R.drawable.revolver_snub, "legendary"),
                        SkinsRarity(R.drawable.revolver_lvl6, "epic"),
                        SkinsRarity(R.drawable.revolver_lvl6, "epic"),
                        SkinsRarity(R.drawable.revolver_vandals, "epic"))),
                222, 6, 74, 148, "R 357", 2.5),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.flamethrower_asmat, "legendary"),
                        SkinsRarity(R.drawable.flamethrower_catacomb, "epic"),
                        SkinsRarity(R.drawable.flamethrower_lvl6, "epic"),
                        SkinsRarity(R.drawable.flamethrower_impromptu, "epic"),
                        SkinsRarity(R.drawable.flamethrower_posh, "rare"),
                        SkinsRarity(R.drawable.flamethrower_scrapyard, "rare"),
                        SkinsRarity(R.drawable.flamethrower_neon, "legendary"))),
                85, 30, 30, 30, "FLAMETHROWER", 4.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.lewis_casino, "legendary"), SkinsRarity(
                        R.drawable.lewis_galaxy, "rare"
                    ), SkinsRarity(R.drawable.lewis_lvl6, "epic"), SkinsRarity(
                        R.drawable.lewis_scrapyard, "rare"))),
                200, 47, 25, 38, "LEWIS", 3.4),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.m23gl_sideview, "common"),
                        SkinsRarity(R.drawable.m32gl_closedbeta, "epic"),
                        SkinsRarity(R.drawable.m32gl_eerie, "rare"),
                        SkinsRarity(R.drawable.m32gl_decodedspirit, "epic"),
                        SkinsRarity(R.drawable.m32gl_fractal, "rare"),
                        SkinsRarity(R.drawable.m32gl_golddust, "legendary"),
                        SkinsRarity(R.drawable.m32gl_lvl6, "epic"),
                        SkinsRarity(R.drawable.m32gl_polygon, "rare"))),
                125, 6, 83, 83, "MGL32", 3.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.sledgehammer_infobox, "common"),
                        SkinsRarity(R.drawable.sledgehammer_crisscross, "rare"),
                        SkinsRarity(R.drawable.sledgehammer_diamond, "legendary"),
                        SkinsRarity(R.drawable.sledgehammer_lvl6, "epic"),
                        SkinsRarity(R.drawable.sledgehammer_marble, "epic"),
                        SkinsRarity(R.drawable.sledgehammer_polygon, "rare"),
                        SkinsRarity(R.drawable.sledgehammer_squire, "legendary"),
                        SkinsRarity(R.drawable.sledgehammer_rock, "legendary"),
                        SkinsRarity(R.drawable.sledgehammer_natural, "legendary"))),
                75, 1, 90, 200, "SLEDGEHAMMER", 0.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.m60_standard, "common"),
                        SkinsRarity(R.drawable.m60_crisscross, "rare"),
                        SkinsRarity(R.drawable.m60_dragonblast, "legendary"),
                        SkinsRarity(R.drawable.m60_cb2aura, "epic"),
                        SkinsRarity(R.drawable.m60_lvl6, "epic"),
                        SkinsRarity(R.drawable.m60_vandal, "epic"),
                        SkinsRarity(R.drawable.m60_vhs, "epic"),
                        SkinsRarity(R.drawable.m60_neverevanesce, "legendary"),
                        SkinsRarity(R.drawable.m60_ospuze, "legendary"),
                        SkinsRarity(R.drawable.m60_offpanel, "rare"))),
                220, 70, 22, 35, "M60", 3.9),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.sa1216_sideview, "common"),
                        SkinsRarity(R.drawable.sa1216_anticache, "epic"),
                        SkinsRarity(R.drawable.sa1216_boreal, "epic"),
                        SkinsRarity(R.drawable.sa1216_kawaii, "epic"),
                        SkinsRarity(R.drawable.sa1216_lvl6, "epic"),
                        SkinsRarity(R.drawable.sa1216_volpe, "epic"),
                        SkinsRarity(R.drawable.sa1216_posh, "rare"),
                        SkinsRarity(R.drawable.sa1216_eerie, "rare"))),
                212, 16, 91, 91, "SA1216", 3.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.m11_sideview, "common"),
                        SkinsRarity(R.drawable.m11_decodedspirit, "epic"),
                        SkinsRarity(R.drawable.m11_diamond, "legendary"),
                        SkinsRarity(R.drawable.m11_galaxy, "rare"),
                        SkinsRarity(R.drawable.m11_holtow, "legendary"),
                        SkinsRarity(R.drawable.m11_glint, "legendary"),
                        SkinsRarity(R.drawable.m11_lvl6, "epic"),
                        SkinsRarity(R.drawable.m11_marble, "epic"),
                        SkinsRarity(R.drawable.m11_ospuze, "legendary"),
                        SkinsRarity(R.drawable.m11_decodedspirit, "epic"))),
                272, 40, 16, 23, "M11", 2.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.lh1_sideview, "common"),
                        SkinsRarity(R.drawable.lh1_fractal, "rare"),
                        SkinsRarity(R.drawable.lh1_offpanel, "rare"),
                        SkinsRarity(R.drawable.lh1_polygon, "rare"),
                        SkinsRarity(R.drawable.lh1_lvl6, "epic"),
                        SkinsRarity(R.drawable.lh1_vandal, "epic"),
                        SkinsRarity(R.drawable.lh1_neon, "legendary"))),
                245, 40, 49, 98, "LH1", 2.8),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.knife_sideview, "common"),
                        SkinsRarity(R.drawable.knife_ammolite, "legendary"),
                        SkinsRarity(R.drawable.knife_key, "legendary"),
                        SkinsRarity(R.drawable.knife_ominous, "legendary"))),
                100, 1, 50, 320, "KNIFE", 0.0),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.throwingknives_sideview, "common"),
                        SkinsRarity(R.drawable.throwing_knives_as, "legendary"),
                        SkinsRarity(R.drawable.throwing_knives_lvl6, "epic"),
                        SkinsRarity(R.drawable.throwing_knives_spades, "legendary"),
                        SkinsRarity(R.drawable.throwing_knives_galaxy, "rare"),
                        SkinsRarity(R.drawable.throwing_knives_polygon, "rare"))),
                60, 1, 60, 90, "THROWING KNIVES", 0.6),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.sawnoff_sideview, "common"),
                        SkinsRarity(R.drawable.sh1900_boutonniere, "legendary"),
                        SkinsRarity(R.drawable.sh1900_bullseye, "rare"),
                        SkinsRarity(R.drawable.sh1900_catacomb, "epic"),
                        SkinsRarity(R.drawable.sh1900_bullseye, "rare"),
                        SkinsRarity(R.drawable.sh1900_vhs, "epic"),
                        SkinsRarity(R.drawable.sh1900_lvl6, "epic"))),
                450, 2, 150, 150,"SH1900", 2.7),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.sr_84_sideview, "common"),
                        SkinsRarity(R.drawable.sr84_cb2, "epic"),
                        SkinsRarity(R.drawable.sr84_kawai, "epic"),
                        SkinsRarity(R.drawable.sr_84_dragon, "legendary"),
                        SkinsRarity(R.drawable.sr_84_lvl6, "epic"),
                        SkinsRarity(R.drawable.sr_84_eerie, "rare"),
                        SkinsRarity(R.drawable.sr84_scrapyard, "rare"))),
                96, 6, 115, 230, "SR-84", 3.1),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.v9s_sideview, "common"),
                        SkinsRarity(R.drawable.v9s_closedbeta, "epic"),
                        SkinsRarity(R.drawable.v9s_evanesce, "legendary"),
                        SkinsRarity(R.drawable.v9s_prima, "legendary"),
                        SkinsRarity(R.drawable.v9s_offpanel, "rare"),
                        SkinsRarity(R.drawable.v9s_posh, "rare"),
                        SkinsRarity(R.drawable.v9s_lvl6, "epic"),
                        SkinsRarity(R.drawable.v9s_diamond, "epic"))),
                360, 20, 36, 53, "V9S", 1.3),
                GunStatsCamo(
                    SkinsCamos(listOf(SkinsRarity(R.drawable.xp54_sideview, "common"),
                        SkinsRarity(R.drawable.xp54_anticache, "epic"),
                        SkinsRarity(R.drawable.xp54_boreal, "epic"),
                        SkinsRarity(R.drawable.xp54_bullseye, "rare"),
                        SkinsRarity(R.drawable.xp54_impromptu, "epic"),
                        SkinsRarity(R.drawable.xp54_lvl6, "epic"),
                        SkinsRarity(R.drawable.xp54_polygon, "rare"))),
                245, 20, 36, 53, "XP54", 1.3)
            )

            val imageListWeapon = listOf(
                ItemData("AKM", R.drawable.akm_sideview, 1),
                ItemData("M60", R.drawable.m60_standard, 1),
                ItemData("CL40", R.drawable.cl40, 1),
                ItemData("FCAR", R.drawable.fcar, 1),
                ItemData("FLAMETHROWER", R.drawable.flamethrower, 1),
                ItemData("LEWIS GUN", R.drawable.lewis_gun_side_view, 1),
                ItemData("M32GL", R.drawable.m23gl_sideview, 1),
                ItemData("SA1216", R.drawable.sa1216_sideview, 1),
                ItemData("MODEL 1887", R.drawable.model_1887, 1),
                ItemData("R 357", R.drawable.r_357, 1),
                ItemData("KNIFE", R.drawable.knife_sideview, 1),
                ItemData("LH1", R.drawable.lh1_sideview, 1),
                ItemData("M11", R.drawable.m11_sideview, 1),
            )

            _weaponStats.value = listOfGunStats
            _imageResourceWeapon.value = imageListWeapon
            _imageResourceLight.value = imageListLight
            _imageResourceHeavy.value = imageListHeavy
            _imageResourceMedium.value = imageListMedium
            _isReady.value = true


        }
    }

}