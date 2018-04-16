package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyTXXX;

import java.io.File;
import java.util.List;

/**
 * Test if read a tag with a corrupt frame that in certain circumstances continue to read the other frames
 * regardless. 
 */
public class Issue250Test extends AbstractTestCase
{
    public void testReadingFileWithCorruptFirstFrame() throws Exception
    {
        File orig = new File("testdata", "test78.mp3");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }
        File testFile = AbstractTestCase.copyAudioToTmp("test78.mp3");

        MP3File f = (MP3File)AudioFileIO.read(testFile);
        Tag tag = f.getTag();
        assertTrue(f.getTag() instanceof ID3v23Tag);
        ID3v23Tag id3v23tag = (ID3v23Tag)tag;
        //Dodgy frame is not counted
        assertEquals(13,id3v23tag.getFieldCount());
        assertEquals(3,id3v23tag.getFields("PRIV").size());
        assertEquals(1,id3v23tag.getInvalidFrames()); //PRIV frame
        f.commit();
        f = (MP3File)AudioFileIO.read(testFile);
        tag = f.getTag();
        id3v23tag = (ID3v23Tag)tag;
        assertEquals(13,id3v23tag.getFieldCount());
        assertEquals(3,id3v23tag.getFields("PRIV").size());
        assertEquals(0,id3v23tag.getInvalidFrames()); //PRIV frame thrown away
    }

    /**
     * Read UTF-16 multivalues okay
     */
    public void testReadUT16MultiValues()
    {
        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3", new File("test1001.mp3"));
            MP3File mp3File = new MP3File(testFile);

            //Create and Save
            ID3v23Tag tag = new ID3v23Tag();
            tag.addField(FieldKey.ALBUM_ARTISTS,"Dvořák");
            tag.addField(FieldKey.ALBUM_ARTISTS,"Dohnányi");
            tag.addField(FieldKey.ALBUM_ARTISTS,"Fred");
            tag.addField(FieldKey.ALBUM_ARTISTS,"Jim");

            mp3File.setID3v2Tag(tag);
            mp3File.save();

            mp3File = new MP3File(testFile);
            List<String> values = tag.getAll(FieldKey.ALBUM_ARTISTS);
            assertEquals(values.get(0), "Dvořák");
            assertEquals(values.get(1), "Dohnányi");
            assertEquals(values.get(2), "Fred");
            assertEquals(values.get(3), "Jim");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }
}