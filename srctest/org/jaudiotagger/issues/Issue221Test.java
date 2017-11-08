package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Test Creating Null fields
 */
public class Issue221Test extends AbstractTestCase
{

    public void testCreateNullMp4FrameTitle()
    {
        Exception exceptionCaught = null;
        try
        {
            Mp4Tag tag = new Mp4Tag();
            tag.setField(FieldKey.TITLE,null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullOggVorbisFrameTitle()
    {
        Exception exceptionCaught = null;
        try
        {
            VorbisCommentTag tag = VorbisCommentTag.createNewTag();
            tag.setField(FieldKey.TITLE,null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }


    public void testCreateNullID3v23FrameTitle()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v23Tag tag = new ID3v23Tag();
            tag.setField(FieldKey.TITLE,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v23.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullID3v23FrameAlbum()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v23Tag tag = new ID3v23Tag();
            tag.setField(FieldKey.ALBUM,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v23.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullID3v23FrameArtist()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v23Tag tag = new ID3v23Tag();
            tag.setField(FieldKey.ARTIST,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v23.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullID3v23FrameComment()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v23Tag tag = new ID3v23Tag();
            tag.setField(FieldKey.COMMENT,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v23.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullID3v23FrameGenre()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v23Tag tag = new ID3v23Tag();
            tag.setField(FieldKey.GENRE,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v23.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullID3v23FrameTrack()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v23Tag tag = new ID3v23Tag();
            tag.setField(FieldKey.TRACK,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v23.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof IllegalArgumentException);

    }

    public void testCreateNullID3v24Frame()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v24Tag tag = new ID3v24Tag();
            tag.setField(FieldKey.TITLE,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v24.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }

        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testCreateNullID3v22Frame()
    {
        Exception exceptionCaught = null;
        try
        {
            ID3v22Tag tag = new ID3v22Tag();
            tag.setField(FieldKey.TITLE,null);
            FileOutputStream os = new FileOutputStream("testdatatmp/issue_221_title_v24.mp3");
            tag.write(os.getChannel(),0);
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }

        assertTrue(exceptionCaught instanceof IllegalArgumentException);
    }

    public void testMp4ItunesGroupingKey()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test.m4a");
            AudioFile f = AudioFileIO.read(testFile);
            Tag tag = f.getTag();
            tag.getFields(FieldKey.ITUNES_GROUPING);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof KeyNotFoundException);
    }

    public void testAsfItunesGroupingKey()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test1.wma");
            AudioFile f = AudioFileIO.read(testFile);
            Tag tag = f.getTag();
            tag.getFields(FieldKey.ITUNES_GROUPING);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof KeyNotFoundException);
    }

    public void testOggItunesGroupingKey()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test.ogg");
            AudioFile f = AudioFileIO.read(testFile);
            Tag tag = f.getTag();
            tag.getFields(FieldKey.ITUNES_GROUPING);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof KeyNotFoundException);
    }

    public void testFlacItunesGroupingKey()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test.flac");
            AudioFile f = AudioFileIO.read(testFile);
            Tag tag = f.getTag();
            tag.getFields(FieldKey.ITUNES_GROUPING);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertTrue(exceptionCaught instanceof KeyNotFoundException);
    }

    public void testMp3ItunesGroupingKey()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test23.mp3");
            AudioFile f = AudioFileIO.read(testFile);
            Tag tag = f.getTag();
            tag.getFields(FieldKey.ITUNES_GROUPING);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertNull(exceptionCaught);
    }
}
