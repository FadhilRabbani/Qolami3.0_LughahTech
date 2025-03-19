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
        /*DataPelajaranHuruf(R.drawable.img_fathahtain, "Pelajaran 5","Huruf Berharakat Fathahtain"),
        DataPelajaranHuruf(R.drawable.img_kasrahtain, "Pelajaran 6","Huruf Berharakat Kasrahtain"),
        DataPelajaranHuruf(R.drawable.dhammahtain, "Pelajaran 7","Huruf Berharakat Dhammahtain"),
        DataPelajaranHuruf(R.drawable.img_sukun, "Pelajaran 8","Huruf Berharakat Sukun"),
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
        /*DataPelajaranHurufDetail("Pelajaran 5", R.drawable.img_fathahtain, "Pelajaran 5", "Huruf Berharakat Fathatain", "Pelajari penggunaan harakat Fathahtain pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 6", R.drawable.img_kasrahtain, "Pelajaran 6", "Huruf Berharakat Kasratain", "Pelajari penggunaan harakat Kasrahtain pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 7", R.drawable.dhammahtain, "Pelajaran 7", "Huruf Berharakat Dhammatain", "Pelajari penggunaan harakat Dhammahtain pada kata, frasa, dan konsep tata bahasa"),
        DataPelajaranHurufDetail("Pelajaran 8", R.drawable.img_sukun, "Pelajaran 8", "Huruf Berharakat Sukun", "Pelajari penggunaan harakat Sukun pada kata, frasa, dan konsep tata bahasa"),
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
        DataVidPelajaranHuruf(1,R.drawable.alif_fathah_biru_muda,"Alif Berharakat Fathah","ntD81WB132A", "Warna Hitam merupakan \n huruf Alif dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(2,R.drawable.ba_fathah_biru_muda,"Ba’ Berharakat Fathah","Ii477YjhDVk", "Warna Hitam merupakan \n huruf Ba’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(3,R.drawable.ta_fathah_biru_muda,"Ta’ Berharakat Fathah","6UexQWMnx0I", "Warna Hitam merupakan \n huruf Ta’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(4,R.drawable.tsa_fathah_biru_muda,"Tsa’ Berharakat Fathah","moa8jxvBM_g", "Warna Hitam merupakan \n huruf Tsa’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(5,R.drawable.ja_fathah_biru_muda,"Jim Berharakat Fathah","OF0pHtNcJts", "Warna Hitam merupakan \n huruf Jim dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(6,R.drawable.kha_fathah_biru_muda, "Ha’ Berharakat Fathah" ,"uLXf6TiBhXo", "Warna Hitam merupakan \n huruf Ha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(7,R.drawable.kho_fathah_biru_muda,"Kha’ Berharakat Fathah","06mNtQn5hPM", "Warna Hitam merupakan \n huruf Kha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(8,R.drawable.dal_fathah_biru_muda,"Dal Berharakat Fathah","KLA7uwvxyvg", "Warna Hitam merupakan \n huruf Dal dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(9,R.drawable.dza_fathah_biru_muda,"Dzal Berharakat Fathah","bs-yAjuvs0k", "Warna Hitam merupakan \n huruf Dzal dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(10,R.drawable.ra_fathah_biru_muda,"Ra’ Berharakat Fathah","zTJpyte5QHU", "Warna Hitam merupakan \n huruf Ra’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(11,R.drawable.dzai_fathah_biru_muda,"Za’ Berharakat Fathah","jcL6tk5FIt8", "Warna Hitam merupakan \n huruf Za’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(12,R.drawable.sin_fathah_biru_muda,"Sin Berharakat Fathah","T4rX3SeZH-c", "Warna Hitam merupakan \n huruf Sin dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(13,R.drawable.syin_fathah_biru_muda,"Syin Berharakat Fathah","eEpYreBDeE8", "Warna Hitam merupakan \n huruf Syin dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(14,R.drawable.shod_fathah_biru_muda,"Shad Berharakat Fathah","mLUaUAL-Ty8", "Warna Hitam merupakan \n huruf Shad dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(15,R.drawable.dho_fathah_biru_muda,"Dhad Berharakat Fathah","YWbUdRmyQsQ", "Warna Hitam merupakan \n huruf Dhad dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(16,R.drawable.tho_fathah_biru_muda,"Tha’ Berharakat Fathah","6FzZ3jQrvL8", "Warna Hitam merupakan \n huruf Tha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(17,R.drawable.tzo_fathah_biru_muda,"Zha’ Berharakat Fathah","lg441UMEv_Q", "Warna Hitam merupakan \n huruf Zha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(18,R.drawable.ain_fathah_biru_muda,"‘Ain Berharakat Fathah","06WeCyI7E5c", "Warna Hitam merupakan \n huruf ‘Ain dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(19,R.drawable.goin_fathah_biru_muda,"Ghain Berharakat Fathah","GNDEM9GktSw", "Warna Hitam merupakan \n huruf Ghain dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(20,R.drawable.fa_fathah_biru_muda,"Fa’ Berharakat Fathah","q9W37UTUPIU", "Warna Hitam merupakan \n huruf Fa’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(21,R.drawable.kof_fathah_biru_muda,"Qaf Berharakat Fathah","aBxg0IK6uBI", "Warna Hitam merupakan \n huruf Qaf dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(22,R.drawable.kaf_fathah_biru_muda,"Kaf Berharakat Fathah","7DKP8vW8AOo", "Warna Hitam merupakan \n huruf Kaf dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(23,R.drawable.lam_fathah_biru_muda,"Lam Berharakat Fathah","XQaApdhUYVE", "Warna Hitam merupakan \n huruf Lam dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(24,R.drawable.mim_fathah_biru_muda,"Mim Berharakat Fathah","M6rl_6dC66Q", "Warna Hitam merupakan \n huruf Mim dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(25,R.drawable.nun_fathah_biru_muda,"Nun Berharakat Fathah","PyjozCgnyI8", "Warna Hitam merupakan \n huruf Nun dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(26,R.drawable.waw_fathah_biru_muda,"Waw Berharakat Fathah","VsnSAjDNTXs", "Warna Hitam merupakan \n huruf Waw dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(27,R.drawable.ha_fathah_biru_muda,"Ha’ Berharakat Fathah","WHU0lJbWVuk", "Warna Hitam merupakan \n huruf Ha’ dan yang berwarna \n biru terang adalah \n harakat Fathah."),
        DataVidPelajaranHuruf(28,R.drawable.ya_fathah_biru_muda,"Ya’ Berharakat Fathah","3CzzT9ZO604", "Warna Hitam merupakan \n huruf Ya’ dan yang berwarna \n biru terang adalah \n harakat Fathah.")
    )
    val getDataVidPelajaran2 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran2 (){
        getDataVidPelajaran2.value = hurufListFathah
    }

    val hurufListKasrah: List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.alif_kasrah_hijau_muda,"Alif Berharakat Kasrah","wJ8WaPcZM_M", "Warna Hitam merupakan \n huruf Alif dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(2,R.drawable.ba_kasrah_hijau_muda,"Ba’ Berharakat Kasrah","IrLP1XYuIjs", "Warna Hitam merupakan \n huruf Ba’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(3,R.drawable.ta_kasrah_hijau_muda,"Ta’ Berharakat Kasrah","4zN2OpUqJI8", "Warna Hitam merupakan \n huruf Ta’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(4,R.drawable.tsa_kasrah_hijau_muda,"Tsa’ Berharakat Kasrah","U5xikMGMdTg", "Warna Hitam merupakan \n huruf Tsa’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(5,R.drawable.ja_kasrah_hijau_muda,"Jim Berharakat Kasrah","uXO3saszpSk", "Warna Hitam merupakan \n huruf Jim dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(6,R.drawable.kha_kasrah_hijau_muda,"Ha’ Berharakat Kasrah","Y_-BPpF6AW8", "Warna Hitam merupakan \n huruf Ha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(7,R.drawable.kho_kasrah_hijau_muda,"Kha’ Berharakat Kasrah","sBl7jEm0Xmk", "Warna Hitam merupakan \n huruf Kha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(8,R.drawable.dal_kasrah_hijau_muda,"Dal Berharakat Kasrah","fapuqkYj4kA", "Warna Hitam merupakan \n huruf Dal dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(9,R.drawable.dza_kasrah_hijau_muda,"Dzal Berharakat Kasrah","dz6kejEOMuw", "Warna Hitam merupakan \n huruf Dzal dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(10,R.drawable.ra_kasrah_hijau_muda,"Ra’ Berharakat Kasrah","Vl6wNuQFyT0", "Warna Hitam merupakan \n huruf Ra’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(11,R.drawable.dzai_kasrah_hijau_muda,"Za’ Berharakat Kasrah","If0u90dumo4", "Warna Hitam merupakan \n huruf Za’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(12,R.drawable.sin_kasrah_hijau_muda,"Sin Berharakat Kasrah","Sw2CeqRO5io", "Warna Hitam merupakan \n huruf Sin dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(13,R.drawable.syin_kasrah_hijau_muda,"Syin Berharakat Kasrah","1fAnO0rayPQ", "Warna Hitam merupakan \n huruf Syin dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(14,R.drawable.shod_kasrah_hijau_muda,"Shad Berharakat Kasrah","2AadONAOWi0", "Warna Hitam merupakan \n huruf Shad dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(15,R.drawable.dho_kasrah_hijau_muda,"Dhad Berharakat Kasrah","dr7FL0hgGlI", "Warna Hitam merupakan \n huruf Dhad dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(16,R.drawable.tho_kasrah_hijau_muda,"Tha’ Berharakat Kasrah","QhyQKd6XzWU", "Warna Hitam merupakan \n huruf Tha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(17,R.drawable.tzo_kasrah_hijau_muda,"Zha’ Berharakat Kasrah","PlDEQMjbq2c", "Warna Hitam merupakan \n huruf Zha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(18,R.drawable.ain_kasrah_hijau_muda,"‘Ain Berharakat Kasrah","qIWizx3dfuM", "Warna Hitam merupakan \n huruf ‘Ain dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(19,R.drawable.goin_kasrah_hijau_muda,"Ghain Berharakat Kasrah","rh71lUOKgBE", "Warna Hitam merupakan \n huruf Ghain dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(20,R.drawable.fa_kasrah_hijau_muda,"Fa’ Berharakat Kasrah","ikgPz-gDEGA", "Warna Hitam merupakan \n huruf Fa’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(21,R.drawable.kof_kasrah_hijau_muda,"Qaf Berharakat Kasrah","4qtIQLWgLEk", "Warna Hitam merupakan \n huruf Qaf dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(22,R.drawable.kaf_kasrah_hijau_muda,"Kaf Berharakat Kasrah","6JVs8aeo2D8", "Warna Hitam merupakan \n huruf Kaf dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(23,R.drawable.lam_kasrah_hijau_muda,"Lam Berharakat Kasrah","LTrI62DeOGA", "Warna Hitam merupakan \n huruf Lam dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(24,R.drawable.mim_kasrah_hijau_muda,"Mim Berharakat Kasrah","btjrSC7aDe0", "Warna Hitam merupakan \n huruf Mim dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(25,R.drawable.nun_kasrah_hijau_muda,"Nun Berharakat Kasrah","0byc69KkxU0", "Warna Hitam merupakan \n huruf Nun dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(26,R.drawable.waw_kasrah_hijau_muda,"Waw Berharakat Kasrah","YglXvs0T4XE", "Warna Hitam merupakan \n huruf Waw dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(27,R.drawable.ha_kasrah_hijau_muda,"Ha’ Berharakat Kasrah","6VEPC_Kn4ag", "Warna Hitam merupakan \n huruf Ha’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah."),
        DataVidPelajaranHuruf(28,R.drawable.ya_kasrah_hijau_muda,"Ya’ Berharakat Kasrah","sAr9seaJo1k", "Warna Hitam merupakan \n huruf Ya’ dan yang berwarna \n hijau terang adalah \n harakat Kasrah.")
    )

    val getDataVidPelajaran3 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran3 (){
        getDataVidPelajaran3.value = hurufListKasrah
    }

    val hurufListDhammah: List<DataVidPelajaranHuruf> = listOf(
        DataVidPelajaranHuruf(1,R.drawable.alif_dhammah_orange,"Alif Berharakat Dammah","3p55spJk46s", "Warna Hitam merupakan \n huruf Alif dan yang berwarna \n orange adalah \n harakat Dammah."),
        DataVidPelajaranHuruf(2,R.drawable.ba_dhammah_orange,"Ba’ Berharakat Dammah","5GZIedsx9zQ", "Warna Hitam merupakan \n huruf Ba’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(3,R.drawable.ta_dhammah_orange,"Ta’ Berharakat Dammah","5-UbyYiIq9M", "Warna Hitam merupakan \n huruf Ta’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(4,R.drawable.tsa_dhammah_orange,"Tsa’ Berharakat Dammah","Y-dxKGP6FFE", "Warna Hitam merupakan \n huruf Tsa’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(5,R.drawable.ja_dhammah_orange,"Jim Berharakat Dammah","_P49xmOg_FM", "Warna Hitam merupakan \n huruf Jim dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(6,R.drawable.kha_dhammah_orange,"Ha’ Berharakat Dammah","ho2mp7mcG84", "Warna Hitam merupakan \n huruf Ha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(7,R.drawable.kho_dhammah_orange,"Kha’ Berharakat Dammah","yuAiHzeXBtY", "Warna Hitam merupakan \n huruf Kha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(8,R.drawable.dal_dhammah_orange,"Dal Berharakat Dammah","92U_em94NpY", "Warna Hitam merupakan \n huruf Dal dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(9,R.drawable.dza_dhammah_orange,"Dzal Berharakat Dammah","FC76mXWU_EY", "Warna Hitam merupakan \n huruf Dzal dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(10,R.drawable.ra_dhammah_orange,"Ra’ Berharakat Dammah","Vf26PyueaxY", "Warna Hitam merupakan \n huruf Ra’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(11,R.drawable.dzai_dhammah_orange,"Za’ Berharakat Dammah","87_IBOpsq24", "Warna Hitam merupakan \n huruf Za’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(12,R.drawable.sin_dhammah_orange,"Sin Berharakat Dammah","98IiZhFm_Nk", "Warna Hitam merupakan \n huruf Sin dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(13,R.drawable.syin_dhammah_orange,"Syin Berharakat Dammah","QDPmqg2iSOs", "Warna Hitam merupakan \n huruf Syin dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(14,R.drawable.shod_dhammah_orange,"Shad Berharakat Dammah","Exv3ZFToEnI", "Warna Hitam merupakan \n huruf Shad dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(15,R.drawable.dho_dhammah_orange,"Dhad Berharakat Dammah","3p2zWs7d84Q", "Warna Hitam merupakan \n huruf Dhad dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(16,R.drawable.tho_dhammah_orange,"Tha’ Berharakat Dammah","DhneqkV2qwk", "Warna Hitam merupakan \n huruf Tha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(17,R.drawable.tzo_dhammah_orange,"Zha’ Berharakat Dammah","GRTo3Pc4r1I", "Warna Hitam merupakan \n huruf Zha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(18,R.drawable.ain_dhammah_orange,"‘Ain Berharakat Dammah","VEY2nnIHtK8", "Warna Hitam merupakan \n huruf ‘Ain dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(19,R.drawable.goin_dhammah_orange,"Ghain Berharakat Dammah","ZYlDWl4I4eg", "Warna Hitam merupakan \n huruf Ghain dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(20,R.drawable.fa_dhammah_orange,"Fa’ Berharakat Dammah","-P_TgzRjFcE", "Warna Hitam merupakan \n huruf Fa’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(21,R.drawable.kof_dhammah_orange,"Qaf Berharakat Dammah","GR2a8uLjcfE", "Warna Hitam merupakan \n huruf Qaf dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(22,R.drawable.kaf_dhammah_orange,"Kaf Berharakat Dammah","Zh89LO0ogAo", "Warna Hitam merupakan \n huruf Kaf dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(23,R.drawable.lam_dhammah_orange,"Lam Berharakat Dammah","s5k__k9Yyhs", "Warna Hitam merupakan \n huruf Lam dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(24,R.drawable.mim_dhammah_orange,"Mim Berharakat Dammah","mOS_jK54ryw", "Warna Hitam merupakan \n huruf Mim dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(25,R.drawable.nun_dhammah_orange,"Nun Berharakat Dammah","rq7B6kLOH9w", "Warna Hitam merupakan \n huruf Nun dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(26,R.drawable.waw_dhammah_orange,"Waw Berharakat Dammah","dfj8IJ_DvTw", "Warna Hitam merupakan \n huruf Waw dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(27,R.drawable.ha_dhammah_orange,"Ha’ Berharakat Dammah","RY_v8-_aa1o", "Warna Hitam merupakan \n huruf Ha’ dan yang berwarna \n orange adalah harakat Dammah."),
        DataVidPelajaranHuruf(28,R.drawable.ya_dhammah_orange,"Ya’ Berharakat Dammah","U7goKOpzfzw", "Warna Hitam merupakan \n huruf Ya’ dan yang berwarna \n orange adalah harakat Dammah.")
    )

    val getDataVidPelajaran4 : MutableLiveData<List<DataVidPelajaranHuruf>> = MutableLiveData()
    fun getVidPelajaran4 (){
        getDataVidPelajaran4.value = hurufListDhammah
    }

}