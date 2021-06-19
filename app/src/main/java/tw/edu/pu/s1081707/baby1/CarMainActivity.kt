package tw.edu.pu.s1081707.baby1

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_car_main.*

class CarMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_main)

        var mSoundPool: SoundPool? = null
        var audioAttributes: AudioAttributes? = null
        var soundId = 0

        audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()

        mSoundPool = SoundPool.Builder()
                .setMaxStreams(3)
                .setAudioAttributes(audioAttributes)
                .build()

        soundId = mSoundPool.load(assets.openFd("ambutlance_mc.mp3"), 1)



        ambulance_btn.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {
                println("play")
                mSoundPool.play(soundId, 1F, 1F, 0, 0, 1F);
            }

        })

    }
}