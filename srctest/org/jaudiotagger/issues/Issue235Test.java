package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.audio.wav.WavSaveOptions;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagOptionSingleton;

import java.io.File;



public class Issue235Test extends AbstractTestCase
{
    public void testReadAudioHijackWavInfoActiveEmptyInfoBeforeEmptyId3() throws Exception
    {
        File orig = new File("testdata", "test523.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_INFO_ONLY);
        TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_ACTIVE);
        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test523.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ARTIST, "fred");
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAudioHijackWavInfoBothEmptyInfoBeforeEmptyId3() throws Exception
    {
        File orig = new File("testdata", "test523.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_INFO_ONLY);
        TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_BOTH);
        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test523.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ARTIST, "fred");
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAudioHijackWavId3ActiveEmptyInfoBeforeEmptyId3() throws Exception
    {
        File orig = new File("testdata", "test523.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_ID3_ONLY);
        TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_ACTIVE);
        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test523.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ARTIST, "fred");
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
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
