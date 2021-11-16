package com.mistershorr.soundboard

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mistershorr.soundboard.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val TAG = "MainActivity"
    /*lateinit var buttonA : Button
    lateinit var buttonBb : Button
    lateinit var buttonB : Button
    lateinit var buttonC : Button
    lateinit var buttonCc : Button
    lateinit var buttonD : Button
    lateinit var buttonDd : Button
    lateinit var buttonE : Button
    lateinit var buttonF : Button
    lateinit var buttonFf : Button
    lateinit var buttonG : Button
    lateinit var buttonGg : Button*/


    lateinit var soundPool : SoundPool
    val noteMap = HashMap<String,Int>()

    var aNote = 0
    var bbNote = 0
    var bNote = 0
    var cNote = 0
    var ccNote = 0
    var dNote = 0
    var ddNote = 0
    var eNote = 0
    var fNote = 0
    var ffNote = 0
    var gNote = 0
    var ggNote = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        initializeSoundPool()
        setListeners()
    }

    private fun setListeners() {
        val soundBoardListener = SoundBoardListener()
        binding.buttonMainA.setOnClickListener(soundBoardListener)
        binding.buttonMainB.setOnClickListener(soundBoardListener)
        binding.buttonMainBb.setOnClickListener(soundBoardListener)
        binding.buttonMainC.setOnClickListener(soundBoardListener)
        binding.buttonMainCc.setOnClickListener(soundBoardListener)
        binding.buttonMainD.setOnClickListener(soundBoardListener)
        binding.buttonMainDd.setOnClickListener(soundBoardListener)
        binding.buttonMainE.setOnClickListener(soundBoardListener)
        binding.buttonMainF.setOnClickListener(soundBoardListener)
        binding.buttonMainFf.setOnClickListener(soundBoardListener)
        binding.buttonMainG.setOnClickListener(soundBoardListener)
        binding.buttonMainGg.setOnClickListener(soundBoardListener)

        binding.buttonMainPlaySong.setOnClickListener {
            GlobalScope.launch{
                playSimpleSong()
            }
        }

        binding.playSong.setOnClickListener {
            GlobalScope.launch{
                playJsonSong()
            }
        }





    }


   /* private fun wireWidgets() {
        buttonA = findViewById(R.id.button_main_a)
        buttonBb = findViewById(R.id.button_main_bb)
        buttonB = findViewById(R.id.button_main_b)
        buttonC = findViewById(R.id.button_main_c)
        buttonCc = findViewById(R.id.button_main_cc)
        buttonD = findViewById(R.id.button_main_d)
        buttonDd = findViewById(R.id.button_main_dd)
        buttonE = findViewById(R.id.button_main_e)
        buttonF = findViewById(R.id.button_main_f)
        buttonFf = findViewById(R.id.button_main_ff)
        buttonG = findViewById(R.id.button_main_g)
        buttonGg = findViewById(R.id.button_main_gg)





    }*/

    private fun initializeSoundPool() {

        this.volumeControlStream = AudioManager.STREAM_MUSIC
        soundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 0)
//        soundPool.setOnLoadCompleteListener(SoundPool.OnLoadCompleteListener { soundPool, sampleId, status ->
//           // isSoundPoolLoaded = true
//        })
        aNote = soundPool.load(this, R.raw.scalea, 1)
        bbNote = soundPool.load(this, R.raw.scalebb, 1)
        bNote = soundPool.load(this, R.raw.scaleb, 1)
        cNote =  soundPool.load(this, R.raw.scalec, 1)
        ccNote = soundPool.load(this, R.raw.scalecs, 1)
        dNote = soundPool.load(this, R.raw.scaled,1)
        ddNote = soundPool.load(this, R.raw.scaleds,1)
        eNote = soundPool.load(this, R.raw.scalee,1)
        fNote = soundPool.load(this, R.raw.scalef,1)
        ffNote = soundPool.load(this, R.raw.scalefs,1)
        gNote = soundPool.load(this, R.raw.scaleg,1)
        ggNote = soundPool.load(this, R.raw.scalegs,1)


        noteMap.put("A", aNote)
        noteMap.put("B", bNote)
        noteMap.put("BB", bbNote)
        noteMap.put("C", cNote)
        noteMap.put("CC", ccNote)
        noteMap.put("D", dNote)
        noteMap.put("DD", ddNote)
        noteMap.put("E", eNote)
        noteMap.put("F", fNote)
        noteMap.put("FF", ffNote)
        noteMap.put("G", gNote)
        noteMap.put("GG", ggNote)



    }

    //given a string of the note ("D" or "FS") play the corresponding sound from the soundpool
    private fun playNote(noteId : Int) {
        soundPool.play(noteId, 1f, 1f, 1, 0, 1f)
    }

    //private suspend fun playSong(song : List<Note>) {

    //}

    private suspend fun playSimpleSong() {

        //launch a coroutine by starting up a scope and calling launch function

        playNote("G")
        delay(170)
        playNote("D")
        delay(330)
        playNote("G")
        delay(170)
        playNote("D")
        delay(700)
        playNote("G")
        delay(170)
        playNote("D")
        delay(330)
        playNote("G")
        delay(170)
        playNote("D")
        delay(700)
        playNote("E")
        delay(170)
        playNote("B")
        delay(330)
        playNote("E")
        delay(170)
        playNote("B")
        delay(700)
        playNote("E")
        delay(170)
        playNote("B")
        delay(330)
        playNote("E")
        delay(170)
        playNote("B")
        delay(700)
        playNote("G")
        delay(170)
        playNote("D")
        delay(330)
        playNote("G")
        delay(170)
        playNote("D")
        delay(700)
        playNote("G")
        delay(170)
        playNote("D")
        delay(330)
        playNote("G")
        delay(170)
        playNote("D")
        delay(700)
        playNote("E")
        delay(170)
        playNote("B")
        delay(330)
        playNote("E")
        delay(170)
        playNote("B")
        delay(700)
        playNote("E")
        delay(170)
        playNote("B")
        delay(330)
        playNote("E")
        delay(170)
        playNote("B")


    }


    private fun playNote(note: String) {
        playNote(noteMap.get(note) ?: 0)
    }

    fun read() : List<Note> {
        val inputStream = resources.openRawResource(R.raw.song)
        val jsonText = inputStream.bufferedReader().use{it.readText()}
        val gson = Gson()
        val type = object : TypeToken<List<Note>>(){}.type
        return gson.fromJson(jsonText,type)
    }

    private fun playJsonSong() {
        GlobalScope.launch {
            var notes = read()
            for (i in 0 until notes.size) {
                playNote( notes[i].note)
                delay(500)



            }
        }
    }

    private inner class SoundBoardListener : View.OnClickListener {
        override fun onClick(v: View?) {
            when(v?.id) {
                R.id.button_main_a -> playNote(aNote)
                R.id.button_main_bb -> playNote(bbNote)
                R.id.button_main_b -> playNote(bNote)
                R.id.button_main_c -> playNote(cNote)
                R.id.button_main_cc -> playNote(ccNote)
                R.id.button_main_d -> playNote(dNote)
                R.id.button_main_dd -> playNote(ddNote)
                R.id.button_main_e -> playNote(eNote)
                R.id.button_main_f -> playNote(fNote)
                R.id.button_main_ff -> playNote(ffNote)
                R.id.button_main_g -> playNote(ggNote)




            }
        }
    }
}