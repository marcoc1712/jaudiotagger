package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp4.Mp4AtomTree;
import org.jaudiotagger.audio.mp4.Mp4FileReader;
import org.jaudiotagger.tag.FieldKey;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Test
 */
public class Issue164Test extends AbstractTestCase
{
    public void testReadWriteMp4With64BitMDatLength() throws Exception
    {
        File orig = new File("testdata", "test164.m4a");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            Mp4AtomTree atomTree = new Mp4AtomTree(new RandomAccessFile(orig, "r"));
            atomTree.printAtomTree();

            File testFile = AbstractTestCase.copyAudioToTmp("test164.m4a");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTagOrCreateDefault().setField(FieldKey.PERFORMER,"performer");
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getTag());
            af.getTagOrCreateDefault().setField(FieldKey.ARTIST,"artist");
            af.commit();
            af = AudioFileIO.read(testFile);
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
}
