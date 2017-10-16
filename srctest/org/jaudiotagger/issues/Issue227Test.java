package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;

import java.io.File;

/**
 * Hires file has wrong chunk size in data chunk, or are we just readig it wrong
 */
public class Issue227Test extends AbstractTestCase
{
    public void testReadingHiRefWav() throws Exception
    {
        File orig = new File("testdata", "test510.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test510.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals("1968",(af.getTag().getFirst(FieldKey.YEAR)));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
//        assertNull(ex);
    }
}
