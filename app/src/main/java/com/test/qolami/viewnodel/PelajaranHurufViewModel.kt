package com.test.qolami.viewnodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.qolami.R
import com.test.qolami.view.pelajaran.data.*

class PelajaranHurufViewModel:ViewModel() {
    val listData = arrayListOf(
        DataPelajaranHuruf(R.drawable.img_hijaiyah, "Pelajaran 1","Huruf Hijaiyah"),
        DataPelajaranHuruf(R.drawable.img_fathah, "Pelajaran 2","Huruf Berharakat Fathah"),
        DataPelajaranHuruf(R.drawable.img_kasroh, "Pelajaran 3","Huruf Berharakat Kasrah"),
        DataPelajaranHuruf(R.drawable.img_dhammah, "Pelajaran 4","Huruf Berharakat Dhammah"),
        DataPelajaranHuruf(R.drawable.img_fathahtain, "Pelajaran 5","Huruf Berharakat Fathahtain"),
        DataPelajaranHuruf(R.drawable.img_kasrahtain, "Pelajaran 6","Huruf Berharakat Kasrahtain"),
        DataPelajaranHuruf(R.drawable.dhammahtain, "Pelajaran 7","Huruf Berharakat Dhammahtain"),
        /*DataPelajaranHuruf(R.drawable.img_sukun, "Pelajaran 8","Huruf Berharakat Sukun"),
        DataPelajaranHuruf(R.drawable.img_tasyjid, "Pelajaran 9","Huruf Berharakat Tasydid")*/
    )
    val getDataHuruf : MutableLiveData<List<DataPelajaranHuruf>> = MutableLiveData()
    fun getData(){
        getDataHuruf.value = listData
    }
    val listDataPelajaranDetail = arrayListOf(
        DataPelajaranHurufDetail("Pelajaran 1", R.drawable.img_hijaiyah, "Pelajaran 1", "Huruf Hijaiyah", "Mulai dari Huruf Hijaiyah dan  pengenalan sistem penulisan dalam bahasa Arab"),
        DataPelajaranHurufDetail("Pelajaran 2", R.drawable.img_fathah, "Pelajaran 2", "Huruf Berharakat Fathah", "Pelajari penggunaan harakat Fathah pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 3", R.drawable.img_kasroh, "Pelajaran 3", "Huruf Berharakat Kasrah", "Pelajari penggunaan harakat Kasrah pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 4", R.drawable.img_dhammah, "Pelajaran 4", "Huruf Berharakat Dhammah", "Pelajari penggunaan harakat Dhammah pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 5", R.drawable.img_fathahtain, "Pelajaran 5", "Huruf Berharakat Fathatain", "Pelajari penggunaan harakat Fathahtain pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 6", R.drawable.img_kasrahtain, "Pelajaran 6", "Huruf Berharakat Kasratain", "Pelajari penggunaan harakat Kasrahtain pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 7", R.drawable.dhammahtain, "Pelajaran 7", "Huruf Berharakat Dhammatain", "Pelajari penggunaan harakat Dhammahtain pada kata, frasa, dan konsep tata bahasa"),
        /*DataPelajaranHurufDetail("Pelajaran 8", R.drawable.img_sukun, "Pelajaran 8", "Huruf Berharakat Sukun", "Pelajari penggunaan harakat Sukun pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 9", R.drawable.img_tasyjid, "Pelajaran 9", "Huruf Berharakat Tasydid/ Syiddah", "Pelajari penggunaan harakat Taydid / Syiddah pada kata, frasa, dan konsep tata bahasa")*/
    )
    val getDataHurufDetail : MutableLiveData<List<DataPelajaranHurufDetail>> = MutableLiveData()
    fun getDataDetail(){
        getDataHurufDetail.value = listDataPelajaranDetail
    }


    val listDataMenuPelajaran2 = arrayListOf(
        DataMenuPelajaran1Huruf(1, R.drawable.hfp_alif_fathah_putih),
        DataMenuPelajaran1Huruf(2, R.drawable.hfp_ba_fathah_putih),
        DataMenuPelajaran1Huruf(3, R.drawable.hfp_ta_fathah_putih),
        DataMenuPelajaran1Huruf(4, R.drawable.hfp_tsa_fathah_putih),
        DataMenuPelajaran1Huruf(5, R.drawable.hfp_ja_fathah_putih),
        DataMenuPelajaran1Huruf(6, R.drawable.hfp_ha_fathah_putih),
        DataMenuPelajaran1Huruf(7, R.drawable.hfp_kho_fathah_putih),
        DataMenuPelajaran1Huruf(8, R.drawable.hfp_dal_fathah_putih),
        DataMenuPelajaran1Huruf(9, R.drawable.hfp_dza_fathah_putih),
        DataMenuPelajaran1Huruf(10, R.drawable.hfp_ra_fathah_putih),
        DataMenuPelajaran1Huruf(11, R.drawable.hfp_dzai_fathah_putih),
        DataMenuPelajaran1Huruf(12, R.drawable.hfp_sin_fathah_putih),
        DataMenuPelajaran1Huruf(13, R.drawable.hfp_syin_fathah_putih),
        DataMenuPelajaran1Huruf(14, R.drawable.hfp_shod_fathah_putih),
        DataMenuPelajaran1Huruf(15, R.drawable.hfp_dzo_fathah_putih),
        DataMenuPelajaran1Huruf(16, R.drawable.hfp_tho_fathah_putih),
        DataMenuPelajaran1Huruf(17, R.drawable.hfp_tzo_fathah_putih),
        DataMenuPelajaran1Huruf(18, R.drawable.hfp_ain_fathah_putih),
        DataMenuPelajaran1Huruf(19, R.drawable.hfp_ghain_fathah_putih),
        DataMenuPelajaran1Huruf(20, R.drawable.hfp_fa_fathah_putih),
        DataMenuPelajaran1Huruf(21, R.drawable.hfp_ko_fathah_putih),
        DataMenuPelajaran1Huruf(22, R.drawable.hfp_kaf_fathah_putih),
        DataMenuPelajaran1Huruf(23, R.drawable.hfp_lam_fathah_putih),
        DataMenuPelajaran1Huruf(24, R.drawable.hfp_mim_fathah_putih),
        DataMenuPelajaran1Huruf(25, R.drawable.hfp_nun_fathah_putih),
        DataMenuPelajaran1Huruf(26, R.drawable.hfp_waw_fathah_putih),
        DataMenuPelajaran1Huruf(27, R.drawable.hfp_hah_fathah_putih),
        DataMenuPelajaran1Huruf(28, R.drawable.hfp_ya_fathah_putih)
    )
    val getDataPelajaran2 : MutableLiveData<List<DataMenuPelajaran1Huruf>> = MutableLiveData()
    fun getPelajaran2(){
        getDataPelajaran2.value = listDataMenuPelajaran2
    }
    val listDataMenuPelajaran3 = arrayListOf(
        DataMenuPelajaran1Huruf(1, R.drawable.hkp_alif_kasrah_putih),
        DataMenuPelajaran1Huruf(2, R.drawable.hkp_ba_kasrah_putih),
        DataMenuPelajaran1Huruf(3, R.drawable.hkp_ta_kasrah_putih),
        DataMenuPelajaran1Huruf(4, R.drawable.hkp_tsa_kasrah_putih),
        DataMenuPelajaran1Huruf(5, R.drawable.hkp_ji_kasrah_putih),
        DataMenuPelajaran1Huruf(6, R.drawable.hkp_kha_kasrah_putih),
        DataMenuPelajaran1Huruf(7, R.drawable.hkp_kho_kasrah_putih),
        DataMenuPelajaran1Huruf(8, R.drawable.hkp_dal_kasrah_putih),
        DataMenuPelajaran1Huruf(9, R.drawable.hkp_dza_kasrah_putih),
        DataMenuPelajaran1Huruf(10, R.drawable.hkp_ra_kasrah_putih),
        DataMenuPelajaran1Huruf(11, R.drawable.hkp_zai_kasrah_putih),
        DataMenuPelajaran1Huruf(12, R.drawable.hkp_sin_kasrah_putih),
        DataMenuPelajaran1Huruf(13, R.drawable.hkp_syin_kasrah_putih),
        DataMenuPelajaran1Huruf(14, R.drawable.hkp_shod_kasrah_putih),
        DataMenuPelajaran1Huruf(15, R.drawable.hkp_dho_kasrah_putih),
        DataMenuPelajaran1Huruf(16, R.drawable.hkp_tho_kasrah_putih),
        DataMenuPelajaran1Huruf(17, R.drawable.hkp_dzo_kasrah_putih),
        DataMenuPelajaran1Huruf(18, R.drawable.hkp_ain_kasrah_putih),
        DataMenuPelajaran1Huruf(19, R.drawable.hkp_goin_kasrah_putih),
        DataMenuPelajaran1Huruf(20, R.drawable.hkp_fa_kasrah_putih),
        DataMenuPelajaran1Huruf(21, R.drawable.hkp_kof_kasrah_putih),
        DataMenuPelajaran1Huruf(22, R.drawable.hkp_kaf_kasrah_putih),
        DataMenuPelajaran1Huruf(23, R.drawable.hkp_lam_kasrah_putih),
        DataMenuPelajaran1Huruf(24, R.drawable.hkp_mim_kasrah_putih),
        DataMenuPelajaran1Huruf(25, R.drawable.hkp_nun_kasrah_putih),
        DataMenuPelajaran1Huruf(26, R.drawable.hkp_waw_kasrah_putih),
        DataMenuPelajaran1Huruf(27, R.drawable.hkp_ha_kasrah_putih),
        DataMenuPelajaran1Huruf(28, R.drawable.hkp_ya_kasrah_putih),
    )
    val getDataPelajaran3 : MutableLiveData<List<DataMenuPelajaran1Huruf>> = MutableLiveData()
    fun getPelajaran3 (){
        getDataPelajaran3.value = listDataMenuPelajaran3
    }
    val listDataMenuPelajaran4 = arrayListOf(
        DataMenuPelajaran1Huruf(1, R.drawable.hdp_alif_dhammah_putih),
        DataMenuPelajaran1Huruf(2, R.drawable.hdp_ba__dhammah_putih),
        DataMenuPelajaran1Huruf(3, R.drawable.hdp_ta_dhammah_putih),
        DataMenuPelajaran1Huruf(4, R.drawable.hdp_tsa_dhammah_putih),
        DataMenuPelajaran1Huruf(5, R.drawable.hdp_ja_dhammah_putih),
        DataMenuPelajaran1Huruf(6, R.drawable.hdp_kha_dhammah_putih),
        DataMenuPelajaran1Huruf(7, R.drawable.hdp_kho_dhammah_putih),
        DataMenuPelajaran1Huruf(8, R.drawable.hdp_dal_dhammah_putih),
        DataMenuPelajaran1Huruf(9, R.drawable.hdp_dza_dhammah_putih),
        DataMenuPelajaran1Huruf(10, R.drawable.hdp_ra_dhammah_putih),
        DataMenuPelajaran1Huruf(11, R.drawable.hdp_zai_dhammah_putih),
        DataMenuPelajaran1Huruf(12, R.drawable.hdp_sin_dhammah_putih),
        DataMenuPelajaran1Huruf(13, R.drawable.hdp_syin_dhammah_putih),
        DataMenuPelajaran1Huruf(14, R.drawable.hdp_shod_dhammah_putih),
        DataMenuPelajaran1Huruf(15, R.drawable.hdp_dho_dhammah_putih),
        DataMenuPelajaran1Huruf(16, R.drawable.hdp_tho_dhammah_putih),
        DataMenuPelajaran1Huruf(17, R.drawable.hdp_tzo_dhammah_putih),
        DataMenuPelajaran1Huruf(18, R.drawable.hdp_ain_dhammah_putih),
        DataMenuPelajaran1Huruf(19, R.drawable.hdp_goin_dhammah_putih),
        DataMenuPelajaran1Huruf(20, R.drawable.hdp_fa_dhammah_putih),
        DataMenuPelajaran1Huruf(21, R.drawable.hdp_kof_dhammah_putih),
        DataMenuPelajaran1Huruf(22, R.drawable.hdp_kaf_dhammah_putih),
        DataMenuPelajaran1Huruf(23, R.drawable.hdp_lam_dhammah_putih),
        DataMenuPelajaran1Huruf(24, R.drawable.hdp_mim_dhammah_putih),
        DataMenuPelajaran1Huruf(25, R.drawable.hdp_nun_dhammah_putih),
        DataMenuPelajaran1Huruf(26, R.drawable.hdp_waw_dhammah_putih),
        DataMenuPelajaran1Huruf(27, R.drawable.hdp_ha_dhammah_putih),
        DataMenuPelajaran1Huruf(28, R.drawable.hdp_ya_dhammah_putih),
    )
    val getDataPelajaran4 : MutableLiveData<List<DataMenuPelajaran1Huruf>> = MutableLiveData()
    fun getPelajaran4 (){
        getDataPelajaran4.value = listDataMenuPelajaran4
    }
    val listDataMenuPelajaran5 = arrayListOf(
        DataMenuPelajaran1Huruf(1,R.drawable.alif_fathahain),
        DataMenuPelajaran1Huruf(2,R.drawable.ba_fathahain),
        DataMenuPelajaran1Huruf(3,R.drawable.ta_fathahain),
        DataMenuPelajaran1Huruf(4,R.drawable.tsa_fathahain),
        DataMenuPelajaran1Huruf(5,R.drawable.jim_fathahain),
        DataMenuPelajaran1Huruf(6,R.drawable.ha_fathahain),
        DataMenuPelajaran1Huruf(7,R.drawable.kha_fathahain),
        DataMenuPelajaran1Huruf(8,R.drawable.dal_fathahain),
        DataMenuPelajaran1Huruf(9,R.drawable.dzal_fathahain),
        DataMenuPelajaran1Huruf(10,R.drawable.ro_fathahain),
        DataMenuPelajaran1Huruf(11,R.drawable.zal_fathahain),
        DataMenuPelajaran1Huruf(12,R.drawable.shin_fathahain),
        DataMenuPelajaran1Huruf(13,R.drawable.syin_fathahain),
        DataMenuPelajaran1Huruf(14,R.drawable.shod_fathahain),
        DataMenuPelajaran1Huruf(15,R.drawable.dhod_fathahain),
        DataMenuPelajaran1Huruf(16,R.drawable.to_fathahain),
        DataMenuPelajaran1Huruf(17,R.drawable.dzo_fathahain),
        DataMenuPelajaran1Huruf(18,R.drawable.ain_fathahain),
        DataMenuPelajaran1Huruf(19,R.drawable.ghain_fathahain),
        DataMenuPelajaran1Huruf(20,R.drawable.fa_fathahain),
        DataMenuPelajaran1Huruf(21,R.drawable.qof_fathahain),
        DataMenuPelajaran1Huruf(22,R.drawable.kam_fathahain),
        DataMenuPelajaran1Huruf(23,R.drawable.lam_fathahain),
        DataMenuPelajaran1Huruf(24,R.drawable.mim_fathahain),
        DataMenuPelajaran1Huruf(25,R.drawable.nin_fathahain),
        DataMenuPelajaran1Huruf(26,R.drawable.wau_fathahain),
        DataMenuPelajaran1Huruf(27,R.drawable.hamza_fathahain),
        DataMenuPelajaran1Huruf(28,R.drawable.ya_fathahain),
    )
    val getDataPelajaran5 : MutableLiveData<List<DataMenuPelajaran1Huruf>> = MutableLiveData()
    fun getPelajaran5 (){
        getDataPelajaran5.value = listDataMenuPelajaran5
    }
    val listDataMenuPelajaran6 = arrayListOf(
        DataMenuPelajaran1Huruf(1,R.drawable.alif_kasrahtain),
        DataMenuPelajaran1Huruf(2,R.drawable.ba_kasrahtain),
        DataMenuPelajaran1Huruf(3,R.drawable.ta_kasrahtain),
        DataMenuPelajaran1Huruf(4,R.drawable.tsa_kasrahtain),
        DataMenuPelajaran1Huruf(5,R.drawable.jim_kasrahtain),
        DataMenuPelajaran1Huruf(6,R.drawable.ha_kasrahtain),
        DataMenuPelajaran1Huruf(7,R.drawable.kha_kasrahtain),
        DataMenuPelajaran1Huruf(8,R.drawable.dal_kasrahtain),
        DataMenuPelajaran1Huruf(9,R.drawable.dzal_kasrahtain),
        DataMenuPelajaran1Huruf(10,R.drawable.ra_kasrahtain),
        DataMenuPelajaran1Huruf(11,R.drawable.zal_kasrahtain),
        DataMenuPelajaran1Huruf(12,R.drawable.shin_kasrahtain),
        DataMenuPelajaran1Huruf(13,R.drawable.syin_kasrahtain),
        DataMenuPelajaran1Huruf(14,R.drawable.shod_kasrahtain),
        DataMenuPelajaran1Huruf(15,R.drawable.dhod_kasrahtain),
        DataMenuPelajaran1Huruf(16,R.drawable.tho_kasrahtain),
        DataMenuPelajaran1Huruf(17,R.drawable.dzo_kasrahtain),
        DataMenuPelajaran1Huruf(18,R.drawable.ain_kasrahtain),
        DataMenuPelajaran1Huruf(19,R.drawable.ghain_kasrahtain),
        DataMenuPelajaran1Huruf(20,R.drawable.fa_kasrahtain),
        DataMenuPelajaran1Huruf(21,R.drawable.qof_kasrahtain),
        DataMenuPelajaran1Huruf(22,R.drawable.kam_kasrahtain),
        DataMenuPelajaran1Huruf(23,R.drawable.lam_kasrahtain),
        DataMenuPelajaran1Huruf(24,R.drawable.mim_kasrahtain),
        DataMenuPelajaran1Huruf(25,R.drawable.nun_kasrahtain),
        DataMenuPelajaran1Huruf(26,R.drawable.wau_kasrahtain),
        DataMenuPelajaran1Huruf(27,R.drawable.hamza_kasrahtain),
        DataMenuPelajaran1Huruf(28,R.drawable.ya_kasrahtain),
    )
    val getDataPelajaran6 : MutableLiveData<List<DataMenuPelajaran1Huruf>> = MutableLiveData()
    fun getPelajaran6 (){
        getDataPelajaran6.value = listDataMenuPelajaran6
    }
    val listDataMenuPelajaran7 = arrayListOf(
        DataMenuPelajaran1Huruf(1,R.drawable.alif_dammahtain),
        DataMenuPelajaran1Huruf(2,R.drawable.ba_dammahtain),
        DataMenuPelajaran1Huruf(3,R.drawable.ta_dammahtain),
        DataMenuPelajaran1Huruf(4,R.drawable.tsa_dammahtain),
        DataMenuPelajaran1Huruf(5,R.drawable.jim_dammahtain),
        DataMenuPelajaran1Huruf(6,R.drawable.ha_dammahtain),
        DataMenuPelajaran1Huruf(7,R.drawable.kha_dammahtain),
        DataMenuPelajaran1Huruf(8,R.drawable.dal_dammahtain),
        DataMenuPelajaran1Huruf(9,R.drawable.dzal_dammahtain),
        DataMenuPelajaran1Huruf(10,R.drawable.ro_dammahtain),
        DataMenuPelajaran1Huruf(11,R.drawable.zal_dammahtain),
        DataMenuPelajaran1Huruf(12,R.drawable.shin_dammahtain),
        DataMenuPelajaran1Huruf(13,R.drawable.syin_dammahtain),
        DataMenuPelajaran1Huruf(14,R.drawable.shod_dammahtain),
        DataMenuPelajaran1Huruf(15,R.drawable.dhod_dammahtain),
        DataMenuPelajaran1Huruf(16,R.drawable.thot_dammahtain),
        DataMenuPelajaran1Huruf(17,R.drawable.dzo_dammahtain),
        DataMenuPelajaran1Huruf(18,R.drawable.ain_dammahtain),
        DataMenuPelajaran1Huruf(19,R.drawable.gain_dammahtain),
        DataMenuPelajaran1Huruf(20,R.drawable.fa_dammahtain),
        DataMenuPelajaran1Huruf(21,R.drawable.qaf_dammahtain),
        DataMenuPelajaran1Huruf(22,R.drawable.kam_dammahtain),
        DataMenuPelajaran1Huruf(23,R.drawable.lam_dammahtain),
        DataMenuPelajaran1Huruf(24,R.drawable.mim_dammahtain),
        DataMenuPelajaran1Huruf(25,R.drawable.nun_dammahtain),
        DataMenuPelajaran1Huruf(26,R.drawable.wau_dammahtain),
        DataMenuPelajaran1Huruf(27,R.drawable.hamza_dammahtain),
        DataMenuPelajaran1Huruf(28,R.drawable.ya_dammahtain),
    )
    val getDataPelajaran7: MutableLiveData<List<DataMenuPelajaran1Huruf>> = MutableLiveData()
    fun getPelajaran7 (){
        getDataPelajaran7.value = listDataMenuPelajaran7
    }
    val hurufListHijaiyah = arrayListOf (
        DataAudioHijaiyaj(1, R.drawable.h_alif,    R.raw.sound1),
        DataAudioHijaiyaj(2, R.drawable.h_ba,      R.raw.sound2),
        DataAudioHijaiyaj(3, R.drawable.h_ta,      R.raw.sound3),
        DataAudioHijaiyaj(4, R.drawable.h_sa,      R.raw.sound4),
        DataAudioHijaiyaj(5, R.drawable.h_jim,     R.raw.sound5),
        DataAudioHijaiyaj(6, R.drawable.h_kha,     R.raw.sound6),
        DataAudioHijaiyaj(7, R.drawable.h_kho,     R.raw.sound7),
        DataAudioHijaiyaj(8, R.drawable.h_dal,     R.raw.sound8),
        DataAudioHijaiyaj(9, R.drawable.h_dzal,    R.raw.sound9),
        DataAudioHijaiyaj(10, R.drawable.h_ra,     R.raw.sound10),
        DataAudioHijaiyaj(11, R.drawable.h_za,     R.raw.sound11),
        DataAudioHijaiyaj(12, R.drawable.h_sin,    R.raw.sound12),
        DataAudioHijaiyaj(13, R.drawable.h_syin,   R.raw.sound13),
        DataAudioHijaiyaj(14, R.drawable.h_shod,   R.raw.sound14),
        DataAudioHijaiyaj(15, R.drawable.h_dzo,    R.raw.sound15),
        DataAudioHijaiyaj(16, R.drawable.h_tho,    R.raw.sound16),
        DataAudioHijaiyaj(17, R.drawable.h_tzo,    R.raw.sound17),
        DataAudioHijaiyaj(18, R.drawable.h_ain,    R.raw.sound18),
        DataAudioHijaiyaj(19, R.drawable.h_goin,   R.raw.sound19),
        DataAudioHijaiyaj(20, R.drawable.h_fa,     R.raw.sound20),
        DataAudioHijaiyaj(21, R.drawable.h_kof,    R.raw.sound21),
        DataAudioHijaiyaj(22, R.drawable.h_kaf,    R.raw.sound22),
        DataAudioHijaiyaj(23, R.drawable.h_lam,    R.raw.sound23),
        DataAudioHijaiyaj(24, R.drawable.h_mim,    R.raw.sound24),
        DataAudioHijaiyaj(25, R.drawable.h_nun,    R.raw.sound25),
        DataAudioHijaiyaj(26, R.drawable.h_waw,    R.raw.sound26),
        DataAudioHijaiyaj(27, R.drawable.h_ha,     R.raw.sound27),
        DataAudioHijaiyaj(28, R.drawable.h_lamalif,R.raw.sound28),
        DataAudioHijaiyaj(29, R.drawable.h_hamzah, R.raw.sound29),
        DataAudioHijaiyaj(30, R.drawable.h_ya,      R.raw.sound30)
    )
    val getDataAudPelajaran1 : MutableLiveData<List<DataAudioHijaiyaj>> = MutableLiveData()
    fun getAudioPelajaran1 (){
        getDataAudPelajaran1.value = hurufListHijaiyah
    }
    val hurufListFathah: List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.alif_fathah_biru_muda,"Alif Berharakat Fathah","ZWVKzD0Jqak", "Warna Hitam merupakan \nhuruf Alif dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(2,R.drawable.ba_fathah_biru_muda,"Ba’ Berharakat Fathah","gj_Gq8-FVK8", "Warna Hitam merupakan \nhuruf Ba’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(3,R.drawable.ta_fathah_biru_muda,"Ta’ Berharakat Fathah","fq7N2dYyyR0", "Warna Hitam merupakan \nhuruf Ta’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(4,R.drawable.tsa_fathah_biru_muda,"Tsa’ Berharakat Fathah","leDOqAntr50", "Warna Hitam merupakan \nhuruf Tsa’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(5,R.drawable.ja_fathah_biru_muda,"Jim Berharakat Fathah","9NKNevVpDoc", "Warna Hitam merupakan \nhuruf Jim dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(6,R.drawable.kha_fathah_biru_muda, "Ha’ Berharakat Fathah" ,"9pUcEaAZYsQ", "Warna Hitam merupakan \nhuruf Ha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(7,R.drawable.kho_fathah_biru_muda,"Kha’ Berharakat Fathah","cj7sRM3eu-w", "Warna Hitam merupakan \nhuruf Kha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(8,R.drawable.dal_fathah_biru_muda,"Dal Berharakat Fathah","vaDFivGpbEg", "Warna Hitam merupakan \nhuruf Dal dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(9,R.drawable.dza_fathah_biru_muda,"Dzal Berharakat Fathah","z5LsF9yKJ68", "Warna Hitam merupakan \nhuruf Dzal dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(10,R.drawable.ra_fathah_biru_muda,"Ra’ Berharakat Fathah","j96jfnm40Mg", "Warna Hitam merupakan \nhuruf Ra’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(11,R.drawable.dzai_fathah_biru_muda,"Za’ Berharakat Fathah","va9YaTSB36o", "Warna Hitam merupakan \nhuruf Za’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(12,R.drawable.sin_fathah_biru_muda,"Sin Berharakat Fathah","1_OUylBiZ7A", "Warna Hitam merupakan \nhuruf Sin dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(13,R.drawable.syin_fathah_biru_muda,"Syin Berharakat Fathah","szd9W5iYBgA", "Warna Hitam merupakan \nhuruf Syin dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(14,R.drawable.shod_fathah_biru_muda,"Shad Berharakat Fathah","oSwJ7oxJmlY", "Warna Hitam merupakan \nhuruf Shad dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(15,R.drawable.dho_fathah_biru_muda,"Dhad Berharakat Fathah","IiNLsVub7wk", "Warna Hitam merupakan \nhuruf Dhad dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(16,R.drawable.tho_fathah_biru_muda,"Tha’ Berharakat Fathah","9ph2NRlqQzw", "Warna Hitam merupakan \nhuruf Tha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(17,R.drawable.tzo_fathah_biru_muda,"Zha’ Berharakat Fathah","OOfBE7MXFGw", "Warna Hitam merupakan \nhuruf Zha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(18,R.drawable.ain_fathah_biru_muda,"‘Ain Berharakat Fathah","YXcXcuPQ6mA", "Warna Hitam merupakan \nhuruf ‘Ain dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(19,R.drawable.goin_fathah_biru_muda,"Ghain Berharakat Fathah","fKkIhqHdz8k", "Warna Hitam merupakan \nhuruf Ghain dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(20,R.drawable.fa_fathah_biru_muda,"Fa’ Berharakat Fathah","HByY4ofzAEI", "Warna Hitam merupakan \nhuruf Fa’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(21,R.drawable.kof_fathah_biru_muda,"Qaf Berharakat Fathah","B_GumZPWXHo", "Warna Hitam merupakan \nhuruf Qaf dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(22,R.drawable.kaf_fathah_biru_muda,"Kaf Berharakat Fathah","rJ4E17ZWHho", "Warna Hitam merupakan \nhuruf Kaf dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(23,R.drawable.lam_fathah_biru_muda,"Lam Berharakat Fathah","hB2kAS3DDG4", "Warna Hitam merupakan \nhuruf Lam dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(24,R.drawable.mim_fathah_biru_muda,"Mim Berharakat Fathah","MOF5ly2_9Vw", "Warna Hitam merupakan \nhuruf Mim dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(25,R.drawable.nun_fathah_biru_muda,"Nun Berharakat Fathah","byEs2u-Fhs0", "Warna Hitam merupakan \nhuruf Nun dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(26,R.drawable.waw_fathah_biru_muda,"Waw Berharakat Fathah","6OkfRbmyvwk", "Warna Hitam merupakan \nhuruf Waw dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(27,R.drawable.ha_fathah_biru_muda,"Ha’ Berharakat Fathah","C4JOtEeFxcE", "Warna Hitam merupakan \nhuruf Ha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(28,R.drawable.ya_fathah_biru_muda,"Ya’ Berharakat Fathah","a6gT5aHGTUw", "Warna Hitam merupakan \nhuruf Ya’ dan yang berwarna \n biru terang adalah \n harakat Fathah.")
    )
    val getDataVidPelajaran2 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran2 (){
        getDataVidPelajaran2.value = hurufListFathah
    }

    val hurufListKasrah: List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.alif_kasrah_hijau_muda,"Alif Berharakat Kasrah","aFHTSWXb7Ao", "Warna Hitam merupakan \nhuruf Alif dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(2,R.drawable.ba_kasrah_hijau_muda,"Ba’ Berharakat Kasrah","YOUEqo50fpE", "Warna Hitam merupakan \nhuruf Ba’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(3,R.drawable.ta_kasrah_hijau_muda,"Ta’ Berharakat Kasrah","ym7dRYcLF3c", "Warna Hitam merupakan \nhuruf Ta’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(4,R.drawable.tsa_kasrah_hijau_muda,"Tsa’ Berharakat Kasrah","mwGSjIypTtU", "Warna Hitam merupakan \nhuruf Tsa’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(5,R.drawable.ja_kasrah_hijau_muda,"Jim Berharakat Kasrah","FNhs68v2Fss", "Warna Hitam merupakan \nhuruf Jim dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(6,R.drawable.kha_kasrah_hijau_muda,"Ha’ Berharakat Kasrah","a0O0LUTpviU", "Warna Hitam merupakan \nhuruf Ha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(7,R.drawable.kho_kasrah_hijau_muda,"Kha’ Berharakat Kasrah","t6P1GiWPxZg", "Warna Hitam merupakan \nhuruf Kha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(8,R.drawable.dal_kasrah_hijau_muda,"Dal Berharakat Kasrah","zH2Id40NYe0", "Warna Hitam merupakan \nhuruf Dal dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(9,R.drawable.dza_kasrah_hijau_muda,"Dzal Berharakat Kasrah","9PLQoJa9Na4", "Warna Hitam merupakan \nhuruf Dzal dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(10,R.drawable.ra_kasrah_hijau_muda,"Ra’ Berharakat Kasrah","ghJ2Q5kyx8o", "Warna Hitam merupakan \nhuruf Ra’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(11,R.drawable.dzai_kasrah_hijau_muda,"Za’ Berharakat Kasrah","jcBhpBQA3Ek", "Warna Hitam merupakan \nhuruf Za’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(12,R.drawable.sin_kasrah_hijau_muda,"Sin Berharakat Kasrah","yA6-lxjnDqo", "Warna Hitam merupakan \nhuruf Sin dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(13,R.drawable.syin_kasrah_hijau_muda,"Syin Berharakat Kasrah","fbhAJlNuljk", "Warna Hitam merupakan \nhuruf Syin dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(14,R.drawable.shod_kasrah_hijau_muda,"Shad Berharakat Kasrah","FrbUZ6NWcFU", "Warna Hitam merupakan \nhuruf Shad dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(15,R.drawable.dho_kasrah_hijau_muda,"Dhad Berharakat Kasrah","Lt6_c-2u74U", "Warna Hitam merupakan \nhuruf Dhad dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(16,R.drawable.tho_kasrah_hijau_muda,"Tha’ Berharakat Kasrah","PD49yH504QY", "Warna Hitam merupakan \nhuruf Tha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(17,R.drawable.tzo_kasrah_hijau_muda,"Zha’ Berharakat Kasrah","cYzJzD-vgwc", "Warna Hitam merupakan \nhuruf Zha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(18,R.drawable.ain_kasrah_hijau_muda,"‘Ain Berharakat Kasrah","CXjX0OW0LxU", "Warna Hitam merupakan \nhuruf ‘Ain dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(19,R.drawable.goin_kasrah_hijau_muda,"Ghain Berharakat Kasrah","kmCOGCbm4UI", "Warna Hitam merupakan \nhuruf Ghain dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(20,R.drawable.fa_kasrah_hijau_muda,"Fa’ Berharakat Kasrah","aS89eTkjijc", "Warna Hitam merupakan \nhuruf Fa’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(21,R.drawable.kof_kasrah_hijau_muda,"Qaf Berharakat Kasrah","lEUgoTqtbR0", "Warna Hitam merupakan \nhuruf Qaf dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(22,R.drawable.kaf_kasrah_hijau_muda,"Kaf Berharakat Kasrah","-dwP0SepzY4", "Warna Hitam merupakan \nhuruf Kaf dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(23,R.drawable.lam_kasrah_hijau_muda,"Lam Berharakat Kasrah","VRRQ9aJ2EAM", "Warna Hitam merupakan \nhuruf Lam dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(24,R.drawable.mim_kasrah_hijau_muda,"Mim Berharakat Kasrah","FCzIBVixDqo", "Warna Hitam merupakan \nhuruf Mim dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(25,R.drawable.nun_kasrah_hijau_muda,"Nun Berharakat Kasrah","RVDnwN8795I", "Warna Hitam merupakan \nhuruf Nun dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(26,R.drawable.waw_kasrah_hijau_muda,"Waw Berharakat Kasrah","tP5e4wEQRvs", "Warna Hitam merupakan \nhuruf Waw dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(27,R.drawable.ha_kasrah_hijau_muda,"Ha’ Berharakat Kasrah","-kB68BmGNyE", "Warna Hitam merupakan \nhuruf Ha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(28,R.drawable.ya_kasrah_hijau_muda,"Ya’ Berharakat Kasrah","NDbsB0C5zyQ", "Warna Hitam merupakan \nhuruf Ya’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah.")
    )

    val getDataVidPelajaran3 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran3 (){
        getDataVidPelajaran3.value = hurufListKasrah
    }

    val hurufListDhammah: List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.alif_dhammah_orange,"Alif Berharakat Dammah","pw7YIq4M6wI", "Warna Hitam merupakan \nhuruf Alif dan yang berwarna \n orange adalah \n harakat Dammah."),
        DataVidPelajaranHuruf(2,R.drawable.ba_dhammah_orange,"Ba’ Berharakat Dammah","U9-u1kfJ5zc", "Warna Hitam merupakan \nhuruf Ba’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(3,R.drawable.ta_dhammah_orange,"Ta’ Berharakat Dammah","irglmdv_Bn4", "Warna Hitam merupakan \nhuruf Ta’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(4,R.drawable.tsa_dhammah_orange,"Tsa’ Berharakat Dammah","tBpXpOKEZio", "Warna Hitam merupakan \nhuruf Tsa’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(5,R.drawable.ja_dhammah_orange,"Jim Berharakat Dammah","tK7jwJhhjtw", "Warna Hitam merupakan \nhuruf Jim dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(6,R.drawable.kha_dhammah_orange,"Ha’ Berharakat Dammah","LhuR70AC_9M", "Warna Hitam merupakan \nhuruf Ha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(7,R.drawable.kho_dhammah_orange,"Kha’ Berharakat Dammah","CIM0yXbjbow", "Warna Hitam merupakan \nhuruf Kha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(8,R.drawable.dal_dhammah_orange,"Dal Berharakat Dammah","twFhtmXNk5o", "Warna Hitam merupakan \nhuruf Dal dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(9,R.drawable.dza_dhammah_orange,"Dzal Berharakat Dammah","m617coi4TuM", "Warna Hitam merupakan \nhuruf Dzal dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(10,R.drawable.ra_dhammah_orange,"Ra’ Berharakat Dammah","A1HKy1fMcU0", "Warna Hitam merupakan \nhuruf Ra’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(11,R.drawable.dzai_dhammah_orange,"Za’ Berharakat Dammah","LRGOxiOyQbs", "Warna Hitam merupakan \nhuruf Za’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(12,R.drawable.sin_dhammah_orange,"Sin Berharakat Dammah","R04_o9EMrgg", "Warna Hitam merupakan \nhuruf Sin dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(13,R.drawable.syin_dhammah_orange,"Syin Berharakat Dammah","nwISmAsu-RI", "Warna Hitam merupakan \nhuruf Syin dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(14,R.drawable.shod_dhammah_orange,"Shad Berharakat Dammah","FSzlKhq46mI", "Warna Hitam merupakan \nhuruf Shad dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(15,R.drawable.dho_dhammah_orange,"Dhad Berharakat Dammah","-CCux7USWxo", "Warna Hitam merupakan \nhuruf Dhad dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(16,R.drawable.tho_dhammah_orange,"Tha’ Berharakat Dammah","mzZtTYhCKk0", "Warna Hitam merupakan \nhuruf Tha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(17,R.drawable.tzo_dhammah_orange,"Zha’ Berharakat Dammah","QVweJ6eV91w", "Warna Hitam merupakan \nhuruf Zha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(18,R.drawable.ain_dhammah_orange,"‘Ain Berharakat Dammah","sROVmD7HEhw", "Warna Hitam merupakan \nhuruf ‘Ain dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(19,R.drawable.goin_dhammah_orange,"Ghain Berharakat Dammah","4w8B3RR4h-s", "Warna Hitam merupakan \nhuruf Ghain dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(20,R.drawable.fa_dhammah_orange,"Fa’ Berharakat Dammah","vIhYL216k0I", "Warna Hitam merupakan \nhuruf Fa’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(21,R.drawable.kof_dhammah_orange,"Qaf Berharakat Dammah","tdNYNCyc6d8", "Warna Hitam merupakan \nhuruf Qaf dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(22,R.drawable.kaf_dhammah_orange,"Kaf Berharakat Dammah","J3vBKN7FJL8", "Warna Hitam merupakan \nhuruf Kaf dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(23,R.drawable.lam_dhammah_orange,"Lam Berharakat Dammah","KMB0V5mI2zQ", "Warna Hitam merupakan \nhuruf Lam dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(24,R.drawable.mim_dhammah_orange,"Mim Berharakat Dammah","4D1Yu2Vm2js", "Warna Hitam merupakan \nhuruf Mim dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(25,R.drawable.nun_dhammah_orange,"Nun Berharakat Dammah","nCy0n19w6Pw", "Warna Hitam merupakan \nhuruf Nun dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(26,R.drawable.waw_dhammah_orange,"Waw Berharakat Dammah","8FfFzLwCtS0", "Warna Hitam merupakan \nhuruf Waw dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(27,R.drawable.ha_dhammah_orange,"Ha’ Berharakat Dammah","brjWNBg6qw0", "Warna Hitam merupakan \nhuruf Ha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(28,R.drawable.ya_dhammah_orange,"Ya’ Berharakat Dammah","0Y58zr9Cjxc", "Warna Hitam merupakan \nhuruf Ya’ dan yang berwarna \n orange adalah harakat Dammah.")
    )

    val getDataVidPelajaran4 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran4 (){
        getDataVidPelajaran4.value = hurufListDhammah
    }
    
    val hurufListFathahtain:List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.alif_fathahain_hitam,"Alif Berharakat Fathahtain","m6jE4M6v514","Warna Hitam merupakan \nhuruf Alif dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(2,R.drawable.ba_fathahain_hitam,"Ba Berharakat Fathahtain","CmjiAQ2bB00","Warna Hitam merupakan \nhuruf Ba dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(3,R.drawable.ta_fathahain_hitam,"Ta Berharakat Fathahtain","a3Fd-DBC8V0","Warna Hitam merupakan \nhuruf Ta dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(4,R.drawable.tsa_fathahain_hitam,"Tsa Berharakat Fathahtain","XTSkFoWHUlQ","Warna Hitam merupakan \nhuruf Tsa dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(5,R.drawable.jim_fathahain_hitam,"Jim Berharakat Fathahtain","HQDI6KN5C4I","Warna Hitam merupakan \nhuruf Jim dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(6,R.drawable.ha_fathahain_hitam,"Ha Berharakat Fathahtain","oNJPzQ1475k","Warna Hitam merupakan \nhuruf Ha dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(7,R.drawable.kha_fathahain_hitam,"Kha Berharakat Fathahtain","PqqN25lhbg8","Warna Hitam merupakan \nhuruf Kha dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(8,R.drawable.dal_fathahain_hitam,"Dal Berharakat Fathahtain","5WVZdEBb1a0","Warna Hitam merupakan \nhuruf Dal dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(9,R.drawable.dzal_fathahain_hitam,"Dzal Berharakat Fathahtain","zHtrkRQvhtc","Warna Hitam merupakan \nhuruf Dzal dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(10,R.drawable.ro_fathahain_hitam,"Ro Berharakat Fathahtain","uvDX3LXW1XI","Warna Hitam merupakan \nhuruf Ro dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(11,R.drawable.zal_fathahain_hitam,"Zay Berharakat Fathahtain","PnGN6ubNxZk","Warna Hitam merupakan \nhuruf Zay dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(12,R.drawable.shin_fathahain_hitam,"Sin Berharakat Fathahtain","prGjjnXko3g","Warna Hitam merupakan \nhuruf Sin dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(13,R.drawable.syin_fathahain_hitam,"Syin Berharakat Fathahtain","ySI5rCDun34","Warna Hitam merupakan \nhuruf Syin dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(14,R.drawable.shod_fathahain_hitam,"Shod Berharakat Fathahtain","ixt3zlJq96s","Warna Hitam merupakan \nhuruf Shod dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(15,R.drawable.dhod_fathahain_hitam,"Dhod Berharakat Fathahtain","SxICLpm_taY","Warna Hitam merupakan \nhuruf Dhod dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(16,R.drawable.to_fathahain_hitam,"Tho Berharakat Fathahtain","X1mfud8Q2Bg","Warna Hitam merupakan \nhuruf Tho dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(17,R.drawable.dzal_fathahain_hitam,"Dzho Berharakat Fathahtain","wnDQFU4CxRM","Warna Hitam merupakan \nhuruf Dzho dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(18,R.drawable.ain_fathahain_hitam,"Ain Berharakat Fathahtain","yRuwMNfoJB0","Warna Hitam merupakan \nhuruf Ain dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(19,R.drawable.ghain_fathahain_hitam,"Ghain Berharakat Fathahtain","eEiC2taG-sw","Warna Hitam merupakan \nhuruf Ghain dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(20,R.drawable.fa_fathahain_hitam,"Fa Berharakat Fathahtain","7oUTJ8wAxQk","Warna Hitam merupakan \nhuruf Fa dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(21,R.drawable.qof_fathahain_hitam,"Qaf Berharakat Fathahtain","NLdfMzW1LKk","Warna Hitam merupakan \nhuruf Qaf dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(22,R.drawable.kam_fathahain_hitam,"Kaf Berharakat Fathahtain","JNRMdXYeJ44","Warna Hitam merupakan \nhuruf Kaf dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(23,R.drawable.lam_fathahain_hitam,"Lam Berharakat Fathahtain","irl-NfoCC9E","Warna Hitam merupakan \nhuruf Lam dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(24,R.drawable.mim_fathahain_hitam,"Mim Berharakat Fathahtain","hToSD2nwMGc","Warna Hitam merupakan \nhuruf Mim dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(25,R.drawable.nun_fathahain_hitam,"Nun Berharakat Fathahtain","ek5NxiUQi28","Warna Hitam merupakan \nhuruf Nun dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(26,R.drawable.wau_fathahain_hitam,"Waw Berharakat Fathahtain","kNMV7aOBn1Q","Warna Hitam merupakan \nhuruf Waw dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(27,R.drawable.hamza_fathahain_hitam,"Ha Berharakat Fathahtain","m8cji03gmzc","Warna Hitam merupakan \nhuruf Ha dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        DataVidPelajaranHuruf(28,R.drawable.ya_fathahain_hitam,"Ya Berharakat Fathahtain","Z8fnAbN0Vpk","Warna Hitam merupakan \nhuruf Ya dan yang berwarna \nBiru Tua adalah harakat\nFathahtain"),
        )
    val getDataVidPelajaran5 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran5 (){
        getDataVidPelajaran5.value = hurufListFathahtain
    }
    val hurufListKasrahtain:List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.kasrotain_alif,"Alif Berharakat Kasrahtain","A0gJOFiXLgM","Warna Hitam merupakan \nhuruf Alif dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(2,R.drawable.kasrotain_ba,"Ba Berharakat Kasrahtain","2abng5qbUl0","Warna Hitam merupakan \nhuruf Ba dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(3,R.drawable.kasrotain_ta,"Ta Berharakat Kasrahtain","GyIsCCJXsRI","Warna Hitam merupakan \nhuruf Ta dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(4,R.drawable.kasrotain_tsa,"Tsa Berharakat Kasrahtain","rEYrisQKMXQ","Warna Hitam merupakan \nhuruf Tsa dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(5,R.drawable.kasrotain_jim,"Jim Berharakat Kasrahtain","Wo32Dvaqny4","Warna Hitam merupakan \nhuruf Jim dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(6,R.drawable.kasrotain_ha,"Ha Berharakat Kasrahtain","Cj6FTpl-8Yk","Warna Hitam merupakan \nhuruf Ha dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(7,R.drawable.kasrotain_kha,"Kha Berharakat Kasrahtain","CiLoiCLoNMw","Warna Hitam merupakan \nhuruf Kha dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(8,R.drawable.kasrotain_dal,"Dal Berharakat Kasrahtain","rkOen3u3Z1I","Warna Hitam merupakan \nhuruf Dal dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(9,R.drawable.kasrotain_dzal,"Dzal Berharakat Kasrahtain","VUSUjW_Wqks","Warna Hitam merupakan \nhuruf Dzal dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(10,R.drawable.kasrotain_ro,"Ro Berharakat Kasrahtain","dNdeBh6eb3E","Warna Hitam merupakan \nhuruf Ro dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(11,R.drawable.kasrotain_zay,"Zay Berharakat Kasrahtain","zM5hhIwYKnE","Warna Hitam merupakan \nhuruf Zay dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(12,R.drawable.kasrotain_sin,"Sin Berharakat Kasrahtain","AvwqggZKflc","Warna Hitam merupakan \nhuruf Sin dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(13,R.drawable.kasrotain_syin,"Syin Berharakat Kasrahtain","vJ-6LpbADEI","Warna Hitam merupakan \nhuruf Syin dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(14,R.drawable.kasrotain_shod,"Shod Berharakat Kasrahtain","wFfHg90IShQ","Warna Hitam merupakan \nhuruf Shod dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(15,R.drawable.kasrotain_dhod,"Dhod Berharakat Kasrahtain","o3IJYbMpaYo","Warna Hitam merupakan \nhuruf Dhod dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(16,R.drawable.kasrotain_tho,"Tho Berharakat Kasrahtain","PCUDkb6Lk6k","Warna Hitam merupakan \nhuruf Tho dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(17,R.drawable.kasrotain_dzho,"Dzho Berharakat Kasrahtain","jZ6XTr10vPU","Warna Hitam merupakan \nhuruf Dzho dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(18,R.drawable.kasrotain_ain,"Ain Berharakat Kasrahtain","TsJeuU11hN4","Warna Hitam merupakan \nhuruf Ain dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(19,R.drawable.kasrotain_ghain,"Ghain Berharakat Kasrahtain","cClQ9M_pEps","Warna Hitam merupakan \nhuruf Ghain dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(20,R.drawable.kasrotain_fa,"Fa Berharakat Kasrahtain","PdVqCndjf5w","Warna Hitam merupakan \nhuruf Fa dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(21,R.drawable.kasrotain_qof,"Qaf Berharakat Kasrahtain","HRhfWMaJBac","Warna Hitam merupakan \nhuruf Qaf dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(22,R.drawable.kasrotain_kam,"Kaf Berharakat Kasrahtain","EDILzRQTJak","Warna Hitam merupakan \nhuruf Kaf dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(23,R.drawable.kasrotain_lam,"Lam Berharakat Kasrahtain","y9BLkkSIa2o","Warna Hitam merupakan \nhuruf Lam dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(24,R.drawable.kasrotain_mim,"Mim Berharakat Kasrahtain","RNIBpDz_rGc","Warna Hitam merupakan \nhuruf Mim dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(25,R.drawable.kasrotain_nun,"Nun Berharakat Kasrahtain","NInrR6OiYHs","Warna Hitam merupakan \nhuruf Nun dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(26,R.drawable.kasrotain_wawu,"Waw Berharakat Kasrahtain","VB6yE9VsbVo","Warna Hitam merupakan \nhuruf Waw dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(27,R.drawable.kasrotain_ha_besar,"Ha Berharakat Kasrahtain","reFdrDc3NSk","Warna Hitam merupakan \nhuruf Ha dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
        DataVidPelajaranHuruf(28,R.drawable.kasrotain_ya,"Ya Berharakat Kasrahtain","jVDHTCM3JUw","Warna Hitam merupakan \nhuruf Ya dan yang berwarna \n Hijau Cerah adalah harakat Kasrahtain"),
    )
    val getDataVidPelajaran6 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran6 (){
        getDataVidPelajaran6.value = hurufListKasrahtain
    }
    val hurufListDhammahtain:List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.dhommahtain_alif,"Alif Berharakat Dhammahtain","W_Zcwu1Tcso","Warna Hitam merupakan \nhuruf Alif dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(2,R.drawable.dhommahtain_ba,"Ba Berharakat Dhammahtain","9lSHVApfHqI","Warna Hitam merupakan \nhuruf Ba dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(3,R.drawable.dhommahtain_ta,"Ta Berharakat Dhammahtain","Unavx5nUP-A","Warna Hitam merupakan \nhuruf Ta dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(4,R.drawable.dhommahtain_tsa,"Tsa Berharakat Dhammahtain","LFHOw4uUfcs","Warna Hitam merupakan \nhuruf Tsa dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(5,R.drawable.dhommahtain_jim,"Jim Berharakat Dhammahtain","mHV2EK50h-E","Warna Hitam merupakan \nhuruf Jim dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(6,R.drawable.dhommahtain_ha,"Ha Berharakat Dhammahtain","XWksThX6loc","Warna Hitam merupakan \nhuruf Ha dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(7,R.drawable.dhommahtain_kha,"Kha Berharakat Dhammahtain","bHAL36gbKr4","Warna Hitam merupakan \nhuruf Kha dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(8,R.drawable.dhommahtain_dal,"Dal Berharakat Dhammahtain","ZTM622uwrFE","Warna Hitam merupakan \nhuruf Dal dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(9,R.drawable.dhommahtain_dzal,"Dzal Berharakat Dhammahtain","X0TWE7MUzSo","Warna Hitam merupakan \nhuruf Dzal dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(10,R.drawable.dhommahtain_ro,"Ro Berharakat Dhammahtain","cJs41prvdpo","Warna Hitam merupakan \nhuruf Ro dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(11,R.drawable.dhommahtain_zay,"Zay Berharakat Dhammahtain","hffTX8ugO2s","Warna Hitam merupakan \nhuruf Zay dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(12,R.drawable.dhommahtain_sin,"Sin Berharakat Dhammahtain","4Wf3dqf70sg","Warna Hitam merupakan \nhuruf Sin dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(13,R.drawable.dhommahtain_syin,"Syin Berharakat Dhammahtain","9xOTf1ZsncQ","Warna Hitam merupakan \nhuruf Syin dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(14,R.drawable.dhommahtain_shod,"Shod Berharakat Dhammahtain","jvV5CBMde7w","Warna Hitam merupakan \nhuruf Shod dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(15,R.drawable.dhommahtain_dhod,"Dhod Berharakat Dhammahtain","171-yRZgDNc","Warna Hitam merupakan \nhuruf Dhod dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(16,R.drawable.dhommahtain_tho,"Tho Berharakat Dhammahtain","fgbYWym97YM","Warna Hitam merupakan \nhuruf Tho dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(17,R.drawable.dhommahtain_dzho,"Dzho Berharakat Dhammahtain","DfTk1aoWWc","Warna Hitam merupakan \nhuruf Dzho dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(18,R.drawable.dhommahtain_ain,"Ain Berharakat Dhammahtain","rYjbUSddsyI","Warna Hitam merupakan \nhuruf Ain dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(19,R.drawable.dhommahtain_ghain,"Ghain Berharakat Dhammahtain","CmV8AUnuZsY","Warna Hitam merupakan \nhuruf Ghain dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(20,R.drawable.dhommahtain_fa,"Fa Berharakat Dhammahtain","1NckOm86jCI","Warna Hitam merupakan \nhuruf Fa dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(21,R.drawable.dhommahtain_qof,"Qaf Berharakat Dhammahtain","LtyX7fUFpig","Warna Hitam merupakan \nhuruf Qaf dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(22,R.drawable.dhommahtain_kam,"Kaf Berharakat Dhammahtain","37jblIJ82vU","Warna Hitam merupakan \nhuruf Kaf dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(23,R.drawable.dhommahtain_lam,"Lam Berharakat Dhammahtain","rzHpMgVoxZ0","Warna Hitam merupakan \nhuruf Lam dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(24,R.drawable.dhommahtain_mim,"Mim Berharakat Dhammahtain","GJi_O0Hg7xI","Warna Hitam merupakan \nhuruf Mim dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(25,R.drawable.dhommahtain_nun,"Nun Berharakat Dhammahtain","FHoNYrAIUDg","Warna Hitam merupakan \nhuruf Nun dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(26,R.drawable.dhommahtain_wawu,"Waw Berharakat Dhammahtain","gVLQ1BoG2_Y","Warna Hitam merupakan \nhuruf Waw dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(27,R.drawable.dhommahtain_ha_besar,"Ha Berharakat Dhammahtain","g98wnOcCiS4","Warna Hitam merupakan \nhuruf Ha dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
        DataVidPelajaranHuruf(28,R.drawable.dhommahtain_ya,"Ya Berharakat Dhammahtain","Ohvd0loE764","Warna Hitam merupakan \nhuruf Ya dan yang berwarna \n Oranye Tua adalah harakat Dhammahtain"),
    )
    val getDataVidPelajaran7 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran7 (){
        getDataVidPelajaran7.value = hurufListDhammahtain
    }
}