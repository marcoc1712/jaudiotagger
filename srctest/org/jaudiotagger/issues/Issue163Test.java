package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Test trying to read non existent mp3 file
 */
public class Issue163Test extends AbstractTestCase
{
    public void testReadProblemArtwork()    {
        Exception e=null;
        try
        {
            File orig = new File("testdata", "test163.mp3");
            MP3File f = (MP3File)AudioFileIO.read(orig);
            System.out.println(f.displayStructureAsPlainText());
        }
        catch(Exception ex)
        {
            e=ex;
        }
        assertNull(e);
    }



}