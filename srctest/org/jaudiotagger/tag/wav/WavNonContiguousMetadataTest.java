package org.jaudiotagger.tag.wav;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.wav.WavOptions;
import org.jaudiotagger.audio.wav.WavSaveOptions;
import org.jaudiotagger.audio.wav.WavSaveOrder;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagOptionSingleton;

import java.io.File;

/**
 * Tests for Issue 209, wav with non contiguous existing metadata
 */
public class WavNonContiguousMetadataTest extends AbstractTestCase
{
    public void testWriteFileId3Only() throws Exception
    {
        final TagOptionSingleton tagOptions = TagOptionSingleton.getInstance();
        tagOptions.setToDefault();
        tagOptions.setWavOptions(WavOptions.READ_ID3_ONLY);
        tagOptions.setWavSaveOptions(WavSaveOptions.SAVE_ACTIVE);

        File orig = new File("testdata", "test602.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test602.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ARTIST,"artist");
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ARTIST),"artist");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteFileInfoOnly() throws Exception
    {
        final TagOptionSingleton tagOptions = TagOptionSingleton.getInstance();
        tagOptions.setToDefault();
        tagOptions.setWavOptions(WavOptions.READ_INFO_ONLY);
        tagOptions.setWavSaveOptions(WavSaveOptions.SAVE_ACTIVE);

        File orig = new File("testdata", "test602.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test602.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ARTIST,"artist");
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ARTIST),"artist");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteFileActiveAndExistingOnly() throws Exception
    {
        final TagOptionSingleton tagOptions = TagOptionSingleton.getInstance();
        tagOptions.setToDefault();
        tagOptions.setWavOptions(WavOptions.READ_ID3_ONLY);
        tagOptions.setWavSaveOptions(WavSaveOptions.SAVE_EXISTING_AND_ACTIVE);

        File orig = new File("testdata", "test602.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test602.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ARTIST,"artist");
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ARTIST),"artist");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteFileBothId3First() throws Exception
    {
        final TagOptionSingleton tagOptions = TagOptionSingleton.getInstance();
        tagOptions.setToDefault();
        tagOptions.setWavSaveOrder(WavSaveOrder.ID3_THEN_INFO);
        tagOptions.setWavSaveOptions(WavSaveOptions.SAVE_BOTH);

        File orig = new File("testdata", "test602.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test602.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ARTIST,"artist");
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ARTIST),"artist");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testWriteFileBothInfoFirst() throws Exception
    {
        final TagOptionSingleton tagOptions = TagOptionSingleton.getInstance();
        tagOptions.setToDefault();
        tagOptions.setWavSaveOrder(WavSaveOrder.INFO_THEN_ID3);
        tagOptions.setWavSaveOptions(WavSaveOptions.SAVE_BOTH);

        File orig = new File("testdata", "test602.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test602.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ARTIST,"artist");
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ARTIST),"artist");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }
}
