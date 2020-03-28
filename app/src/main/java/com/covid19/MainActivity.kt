package com.covid19

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.covid19.bantuan.BantuanFragment
import com.covid19.informasi.InformasiFragment
import com.covid19.kasus.KasusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentKasus      = KasusFragment()
        val fragmentInformasi  = InformasiFragment()
        val fragmentBantuan    = BantuanFragment()

        setFragment(fragmentKasus)

        btbantuan.setOnClickListener {
            setFragment(fragmentBantuan)
            changeIcon(ikasus,R.drawable.kasus)
            changeIcon(iinformasi,R.drawable.informasi)
            changeIcon(ibantuan,R.drawable.bantuan_on)
            colortextOn(tbantuan)
            colortextOff(tkasus)
            colortextOff(tinformasi)
        }
        btinformasi.setOnClickListener {
            setFragment(fragmentInformasi)
            changeIcon(ikasus,R.drawable.kasus)
            changeIcon(iinformasi,R.drawable.informasi_on)
            changeIcon(ibantuan,R.drawable.bantuan)
            colortextOn(tinformasi)
            colortextOff(tkasus)
            colortextOff(tbantuan)
        }
        btkasus.setOnClickListener {
            setFragment(fragmentKasus)
            changeIcon(ikasus,R.drawable.kasus_on)
            changeIcon(iinformasi,R.drawable.informasi)
            changeIcon(ibantuan,R.drawable.bantuan)
            colortextOn(tkasus)
            colortextOff(tinformasi)
            colortextOff(tbantuan)
        }
    }

    private fun colortextOn(text: TextView){
        text.setTextColor(Color.rgb(103, 197, 123))
    }
    private fun colortextOff(text: TextView){
        text.setTextColor(Color.rgb(153, 166, 192))
    }

    private fun changeIcon(imageView: ImageView, int: Int){
        imageView.setImageResource(int)
    }


    //Ganti Fragment
    private fun setFragment(frg: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framefragment,frg)
        fragmentTransaction.commit()
    }
}
