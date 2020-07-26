package com.studytrial.codechallenge_layoutingbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.studytrial.codechallenge_layoutingbasic.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

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

        fun lockPemain() {
            binding.ivRockPemain.isClickable = false
            binding.ivPaperPemain.isClickable = false
            binding.ivScissorPemain.isClickable = false
        }

        fun refresh() {
            binding.ivRockPemain.setBackgroundResource(0)
            binding.ivPaperPemain.setBackgroundResource(0)
            binding.ivScissorPemain.setBackgroundResource(0)
            binding.ivRockKomputer.setBackgroundResource(0)
            binding.ivPaperKomputer.setBackgroundResource(0)
            binding.ivScissorKomputer.setBackgroundResource(0)
        }

        fun komputer(komp: Int): String {
            when (komp) {
                1 -> {
                    binding.ivRockKomputer.setBackgroundResource(R.drawable.bg_transparan)
                    Log.d("Binar", "Komputer memilih Batu")
                    inputKomputer = "rock"
                }
                2 -> {
                    binding.ivPaperKomputer.setBackgroundResource(R.drawable.bg_transparan)
                    Log.d("Binar", "Komputer memilih Kertas")
                    inputKomputer = "paper"
                }
                3 -> {
                    binding.ivScissorKomputer.setBackgroundResource(R.drawable.bg_transparan)
                    Log.d("Binar", "Komputer memilih Gunting")
                    inputKomputer = "scissor"
                }
            }
            return inputKomputer
        }

        fun result(inputPemain: String, inputKomputer: String) {
            if (inputPemain == "rock" && inputKomputer == "rock") {
                binding.ivCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Batu dan Komputer Batu hasil Seri")

            } else if (inputPemain == "rock" && inputKomputer == "paper") {
                binding.ivCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Batu dan Komputer Kertas hasil Komputer Menang")

            } else if (inputPemain == "rock" && inputKomputer == "scissor") {
                binding.ivCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Batu dan Komputer Gunting hasil Pemain Menang")

            } else if (inputPemain == "paper" && inputKomputer == "rock") {
                binding.ivCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Kertas dan Komputer Batu hasil Pemain Menang")

            } else if (inputPemain == "paper" && inputKomputer == "paper") {
                binding.ivCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Kertas dan Komputer Kertas hasil Seri")

            } else if (inputPemain == "paper" && inputKomputer == "scissor") {
                binding.ivCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Kertas dan Komputer Gunting hasil Komputer Menang")

            } else if (inputPemain == "scissor" && inputKomputer == "rock") {
                binding.ivCenter.setImageResource(R.drawable.komputer_menang)
                Log.d("Binar", "Pemain Gunting dan Komputer Batu hasil Komputer Menang")

            } else if (inputPemain == "scissor" && inputKomputer == "paper") {
                binding.ivCenter.setImageResource(R.drawable.pemain_menang)
                Log.d("Binar", "Pemain Gunting dan Komputer Kertas hasil Pemain Menang")

            } else if (inputPemain == "scissor" && inputKomputer == "scissor") {
                binding.ivCenter.setImageResource(R.drawable.draw)
                Log.d("Binar", "Pemain Gunting dan Komputer Gunting hasil Seri")
            }
        }

        binding.ivRockPemain.setOnClickListener {
            binding.ivRockPemain.setBackgroundResource(R.drawable.bg_transparan)
            inputPemain = "rock"
            Log.d("Binar", "Pemain memilih Batu")
            val komp = (1..3).random()
            komputer(komp)
            result(inputPemain, inputKomputer)
            lockPemain()
        }

        binding.ivPaperPemain.setOnClickListener {
            binding.ivPaperPemain.setBackgroundResource(R.drawable.bg_transparan)
            inputPemain = "paper"
            Log.d("Binar", "Pemain memilih Kertas")
            val komp = (1..3).random()
            komputer(komp)
            result(inputPemain, inputKomputer)
            lockPemain()
        }

        binding.ivScissorPemain.setOnClickListener {
            binding.ivScissorPemain.setBackgroundResource(R.drawable.bg_transparan)
            inputPemain = "scissor"
            Log.d("Binar", "Pemain memilih Gunting")
            val komp = (1..3).random()
            komputer(komp)
            result(inputPemain, inputKomputer)
            lockPemain()
        }

        binding.ivRefresh.setOnClickListener {
            binding.ivRockPemain.isClickable = true
            binding.ivPaperPemain.isClickable = true
            binding.ivScissorPemain.isClickable = true
            binding.ivCenter.setImageResource(R.drawable.vs)
            refresh()
        }
    }
}