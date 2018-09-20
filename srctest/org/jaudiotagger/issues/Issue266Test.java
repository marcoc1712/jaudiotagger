package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.wav.WavSaveOptions;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.wav.WavTag;

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
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertTrue(((WavTag)af.getTag()).isNonStandardPadding());
            System.out.println(af.getTag());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavWithPaddingBeforeMetadataChunkSaveActive() throws Exception
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
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertTrue(((WavTag)af.getTag()).isNonStandardPadding());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "Album");
            System.out.println(af.getTag());
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_ACTIVE);
            af.commit();

            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "Album");
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertFalse(((WavTag)af.getTag()).isNonStandardPadding());


        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavWithPaddingBeforeMetadataChunkSaveBoth() throws Exception
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
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertTrue(((WavTag)af.getTag()).isNonStandardPadding());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "Album");
            System.out.println(af.getTag());
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_BOTH);
            af.commit();

            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "Album");
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertFalse(((WavTag)af.getTag()).isNonStandardPadding());


        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavWithPaddingBeforeMetadataChunkSaveExistingAndActive() throws Exception
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
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertTrue(((WavTag)af.getTag()).isNonStandardPadding());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "Album");
            System.out.println(af.getTag());
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_EXISTING_AND_ACTIVE);
            af.commit();

            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "Album");
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertFalse(((WavTag)af.getTag()).isNonStandardPadding());


        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteWavWithPaddingBeforeMetadataChunkSaveExisitingActiveSync() throws Exception
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
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertTrue(((WavTag)af.getTag()).isNonStandardPadding());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM, "Album");
            System.out.println(af.getTag());
            TagOptionSingleton.getInstance().setWavSaveOptions(WavSaveOptions.SAVE_EXISTING_AND_ACTIVE_AND_SYNC);
            af.commit();

            af = AudioFileIO.read(testFile);
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM), "Album");
            assertFalse(((WavTag)af.getTag()).isBadChunkData());
            assertFalse(((WavTag)af.getTag()).isNonStandardPadding());


        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }
}
