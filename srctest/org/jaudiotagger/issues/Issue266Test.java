package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;

import java.io.File;

/**
 * Test what do we do with files that has valid audio data but appears to have invalid padding chunks causing
 * id3 chunk to be misread
 */
public class Issue266Test extends AbstractTestCase
{
    public void testReadWavWithPaddingBeforeMetadataChunk() throws Exception
    {
        File orig = new File("testdata", "test534.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test534.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavWithPaddingBeforeMetadataChunk() throws Exception
    {
        File orig = new File("testdata", "test534.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test534.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "Album");
            System.out.println(af.getTag());
            af.commit();

            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }
}
