/*
 * Classe responsável pelo som ao abrir jFrame sobre
 */

package com.sisgaming.Audio;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * SisGaming / Audio / Song
 * @author MrX
 */

public class Song {
    
     public void playSong() {
        
        try {
            
            String audio = "about.wav";
            InputStream is = getClass().getResourceAsStream(audio);
            InputStream buf = new BufferedInputStream(is);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(buf);
            clip.open(ais);
            clip.loop(0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
