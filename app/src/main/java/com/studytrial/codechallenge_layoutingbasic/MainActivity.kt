package com.studytrial.codechallenge_layoutingbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.studytrial.codechallenge_layoutingbasic.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    var inputKomputer = ""
    var inputPemain = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun refreshKomp() {
            iv_rock_komputer.setBackgroundResource(0)
            iv_paper_komputer.setBackgroundResource(0)
            iv_scissor_komputer.setBackgroundResource(0)
        }

        fun refreshPemain() {
            iv_rock_pemain.setBackgroundResource(0)
            iv_paper_pemain.setBackgroundResource(0)
            iv_scissor_pemain.setBackgroundResource(0)
        }

        binding.ivRockPemain.setOnClickListener {
            binding.ivRockPemain.setBackgroundResource(R.drawable.bg_transparan)
            refreshKomp()
            inputPemain = "rock"
            val komp = (1..3).random()
            komputer(komp)
            result(inputPemain, inputKomputer)
            binding.ivRockPemain.setClickable(false)
            binding.ivPaperPemain.setClickable(false)
            binding.ivScissorPemain.setClickable(false)
        }

        binding.ivPaperPemain.setOnClickListener {
            binding.ivPaperPemain.setBackgroundResource(R.drawable.bg_transparan)
            refreshKomp()
            inputPemain = "paper"
            val komp = (1..3).random()
            komputer(komp)
            result(inputPemain, inputKomputer)
            binding.ivRockPemain.setClickable(false)
            binding.ivPaperPemain.setClickable(false)
            binding.ivScissorPemain.setClickable(false)
        }

        binding.ivScissorPemain.setOnClickListener {
            binding.ivScissorPemain.setBackgroundResource(R.drawable.bg_transparan)
            refreshKomp()
            inputPemain = "scissor"
            val komp = (1..3).random()
            komputer(komp)
            result(inputPemain, inputKomputer)
            binding.ivRockPemain.setClickable(false)
            binding.ivPaperPemain.setClickable(false)
            binding.ivScissorPemain.setClickable(false)
        }

        binding.ivRefresh.setOnClickListener {
            binding.ivRockPemain.setClickable(true)
            binding.ivPaperPemain.setClickable(true)
            binding.ivScissorPemain.setClickable(true)
            binding.ivCenter.setImageResource(R.drawable.vs)
            refreshKomp()
            refreshPemain()
        }
    }

    fun komputer(komp: Int): String {
        when (komp) {
            1 -> {
                iv_rock_komputer.setBackgroundResource(R.drawable.bg_transparan)
                inputKomputer = "rock"
            }
            2 -> {
                iv_paper_komputer.setBackgroundResource(R.drawable.bg_transparan)
                inputKomputer = "paper"
            }
            3 -> {
                iv_scissor_komputer.setBackgroundResource(R.drawable.bg_transparan)
                inputKomputer = "scissor"
            }
        }
        return inputKomputer
    }

    fun result(pemain: String, komputer: String) {
        if (inputPemain == "rock" && inputKomputer == "rock") {
            iv_center.setImageResource(R.drawable.draw)
            Log.d("Binar", "Pemain Batu dan Komputer Batu hasil Seri")

        } else if (inputPemain == "rock" && inputKomputer == "paper") {
            iv_center.setImageResource(R.drawable.komputer_menang)
            Log.d("Binar", "Pemain Batu dan Komputer Kertas hasil Komputer Menang")

        } else if (inputPemain == "rock" && inputKomputer == "scissor") {
            iv_center.setImageResource(R.drawable.pemain_menang)
            Log.d("Binar", "Pemain Batu dan Komputer Gunting hasil Pemain Menang")

        } else if (inputPemain == "paper" && inputKomputer == "rock") {
            iv_center.setImageResource(R.drawable.pemain_menang)
            Log.d("Binar", "Pemain Kertas dan Komputer Batu hasil Pemain Menang")

        } else if (inputPemain == "paper" && inputKomputer == "paper") {
            iv_center.setImageResource(R.drawable.draw)
            Log.d("Binar", "Pemain Kertas dan Komputer Kertas hasil Seri")

        } else if (inputPemain == "paper" && inputKomputer == "scissor") {
            iv_center.setImageResource(R.drawable.komputer_menang)
            Log.d("Binar", "Pemain Kertas dan Komputer Gunting hasil Komputer Menang")

        } else if (inputPemain == "scissor" && inputKomputer == "rock") {
            iv_center.setImageResource(R.drawable.komputer_menang)
            Log.d("Binar", "Pemain Gunting dan Komputer Batu hasil Komputer Menang")

        } else if (inputPemain == "scissor" && inputKomputer == "paper") {
            iv_center.setImageResource(R.drawable.pemain_menang)
            Log.d("Binar", "Pemain Gunting dan Komputer Kertas hasil Pemain Menang")

        } else if (inputPemain == "scissor" && inputKomputer == "scissor") {
            iv_center.setImageResource(R.drawable.draw)
            Log.d("Binar", "Pemain Gunting dan Komputer Gunting hasil Seri")
        }
    }
}