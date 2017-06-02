package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyIPLS;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;

import java.io.File;

/**
 * Test trying to read non existent mp3 file
 */
public class Issue181Test extends AbstractTestCase
{
    public void testWavNoNullsInput()
    {
        File orig = new File("testdata", "test162.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }


        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test162.wav");
            AudioFile f = AudioFileIO.read(testFile);

            System.out.println(f.getTag());
            assertFalse(f.getTag().toString().contains("\0"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertNull(exceptionCaught);
    }

}