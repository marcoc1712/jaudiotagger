package org.jaudiotagger.audio.dff;


import junit.framework.TestCase;
import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.reference.ID3V2Version;

import java.io.File;

public class DffAudioFileTest extends TestCase {

    public void testReadDffNoTag() {
        Exception exceptionCaught = null;

        File testFile = AbstractTestCase.copyAudioToTmp("test229.dff",new File("test229read.dff"));
        try {
            AudioFile f = AudioFileIO.read(testFile);
            AudioHeader ah = f.getAudioHeader();
            System.out.println(ah);
            assertEquals("5644800", ah.getBitRate());
            assertEquals(5644800,ah.getBitRateAsNumber());
            assertEquals("2",ah.getChannels());
            assertEquals("2822400",ah.getSampleRate());
            assertEquals(5,ah.getTrackLength());
            assertFalse(ah.isLossless());
            Tag tag = f.getTag();
            assertNull(tag);
        }
        catch (Exception e) {
            e.printStackTrace();
            exceptionCaught = e;
        }
        assertNull(exceptionCaught);

    }
}
