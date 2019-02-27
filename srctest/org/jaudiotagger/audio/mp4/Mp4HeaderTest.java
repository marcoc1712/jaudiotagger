package org.jaudiotagger.audio.mp4;

import junit.framework.TestCase;
import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.flac.FlacInfoReader;
import org.jaudiotagger.audio.flac.metadatablock.MetadataBlockDataPicture;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.flac.FlacTag;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.reference.PictureTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * basic Flac tests
 */
public class Mp4HeaderTest extends TestCase
{

    public void testReadFile()
    {
        File orig = new File("testdata", "test.m4a");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test.m4a");
            AudioFile f = AudioFileIO.read(testFile);
            System.out.println(f.getAudioHeader());


            assertEquals("128", f.getAudioHeader().getBitRate());
            assertEquals("Aac", f.getAudioHeader().getEncodingType());
            assertEquals("2", f.getAudioHeader().getChannels());
            assertEquals("44100", f.getAudioHeader().getSampleRate());
            assertEquals(242, f.getAudioHeader().getTrackLength());
            assertEquals(241.71972789115645d, f.getAudioHeader().getPreciseTrackLength());
            assertTrue(f.getTag() instanceof Mp4Tag);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertNull(exceptionCaught);
    }

    public void testReadFile2()
    {
        File orig = new File("testdata", "test100.mp4");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test100.mp4");
            AudioFile f = AudioFileIO.read(testFile);
            System.out.println(f.getAudioHeader());


            assertEquals("56", f.getAudioHeader().getBitRate());
            assertEquals("Aac", f.getAudioHeader().getEncodingType());
            assertEquals("-14", f.getAudioHeader().getChannels());
            assertEquals("32000", f.getAudioHeader().getSampleRate());
            assertEquals(224, f.getAudioHeader().getTrackLength());
            assertEquals(224.35166666666666d, f.getAudioHeader().getPreciseTrackLength());
            assertTrue(f.getTag() instanceof Mp4Tag);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertNull(exceptionCaught);
    }

}
