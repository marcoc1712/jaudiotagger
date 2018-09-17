package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.audio.wav.WavSaveOptions;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagOptionSingleton;

import java.io.File;

/**
 * Test
 */
public class Issue265aTest extends AbstractTestCase
{
    public void testReadWavWithInvalidUppercaseID3Chunk() throws Exception
    {
        File orig = new File("testdata", "test532.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_ID3_ONLY);
            File testFile = AbstractTestCase.copyAudioToTmp("test532.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            System.out.println(af.getAudioHeader());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavThathasInvalidUppercaseID3ChunkIdSaveBothSync() throws Exception
    {
        File orig = new File("testdata", "test532.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_ID3_ONLY);
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_BOTH_AND_SYNC);
            File testFile = AbstractTestCase.copyAudioToTmp("test532.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "A new album");
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
            af.commit();
            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavThathasInvalidUppercaseID3ChunkIdSaveBoth() throws Exception
    {
        File orig = new File("testdata", "test532.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_ID3_ONLY);
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_BOTH);
            File testFile = AbstractTestCase.copyAudioToTmp("test532.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "A new album");
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
            af.commit();
            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavThathasInvalidUppercaseID3ChunkIdSaveActive() throws Exception
    {
        File orig = new File("testdata", "test532.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_ID3_ONLY);
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_ACTIVE);
            File testFile = AbstractTestCase.copyAudioToTmp("test532.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "A new album");
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
            af.commit();
            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavThathasInvalidUppercaseID3ChunkIdSaveExistingActive() throws Exception
    {
        File orig = new File("testdata", "test532.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_ID3_ONLY);
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_EXISTING_AND_ACTIVE);
            File testFile = AbstractTestCase.copyAudioToTmp("test532.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "A new album");
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
            af.commit();
            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavThathasInvalidUppercaseID3ChunkIdSaveExistingInfoActive() throws Exception
    {
        File orig = new File("testdata", "test532.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            TagOptionSingleton.getInstance().setWavOptions(WavOptions.READ_INFO_ONLY);
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_EXISTING_AND_ACTIVE);
            File testFile = AbstractTestCase.copyAudioToTmp("test532.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "A new album");
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
            af.commit();
            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "A new album");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }
}
