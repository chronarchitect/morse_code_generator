import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Morse_sound
{
    static String morse[] = {"._", "_...", "_._.", "_..", ".", ".._.", "__.", "....", "..", ".___", "_._", "._..",
            "__", "_.", "___", ".__.", "__._", "._.", "...", "_", "..__", "..._", ".__", "_.._", 
            "_.__", "__.."};

    public static void play(String filename)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public static void main(String[] args)throws Exception
    {
        System.out.print("\nEnter a message : ");
        String s = ((new BufferedReader(new InputStreamReader(System.in))).readLine()).toUpperCase();
        String code = "";
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) != ' ')
            {
                code = morse[s.charAt(i) - 65];
                for (int j = 0; j < code.length(); ++j)
                {
                    System.out.print(code.charAt(j));
                    Thread.sleep(100);
                    if (code.charAt(j) == '.')
                    {
                        play("dot.wav");
                        Thread.sleep(25);
                    }
                    else if (code.charAt(j) == '_')
                    {
                        play("dash.wav");
                        Thread.sleep(150);
                    }
                }
                System.out.print(" ");
            }
            else
            {
                System.out.print("\b/");
                Thread.sleep(350);
            }
        }
        Thread.sleep(1000);
        System.out.println("\n");
        final String os = System.getProperty("os.name");
        if (!os.contains("Windows"))
        {
            //new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else
            Runtime.getRuntime().exec("clear");
    }
}
