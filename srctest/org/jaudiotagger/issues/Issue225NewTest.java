package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.dsf.DsdChunk;
import org.jaudiotagger.audio.generic.Utils;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

import java.io.File;
import java.nio.channels.FileChannel;

/**
 * Ensure Dsf File size header matches actual filesize after modification
 */
public class Issue225NewTest extends AbstractTestCase
{
    public void testReadDsf() throws Exception
    {
        File orig = new File("testdata", "test513.dsf");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        File testFile = AbstractTestCase.copyAudioToTmp("test513.dsf");
        Exception ex=null;
        try
        {

            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getAudioHeader());
            System.out.println("IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());
            System.out.println(af.getAudioHeader());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":MetadataSize:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }
    }

    public void testReadThenRewriteDsfSmaller() throws Exception
    {
        File orig = new File("testdata", "test513.dsf");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        File testFile = AbstractTestCase.copyAudioToTmp("test513.dsf");

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("BEFORE:ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":metadatasizeinfile:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }

        try
        {

            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println("BEFORE IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());
            af.getTag().deleteArtworkField();
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println("AFTER IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("AFTER :ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":metadatasizeinfile:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }
    }


    public void testReadThenRewriteDsfLargerEvenSizeID3Header() throws Exception
    {
        File orig = new File("testdata", "test513.dsf");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        File testFile = AbstractTestCase.copyAudioToTmp("test513.dsf");

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("BEFORE:ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":metadatasizeinfile:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }

        try
        {

            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            af.getTag().addField(FieldKey.BPM,"1231111111111111111111111111111111111111");
            System.out.println("BEFORE IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println("AFTER IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("AFTER :ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":metadatasizeinfile:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }
    }

    public void testReadThenRewriteDsfLargerOddSizeID3Header() throws Exception
    {
        File orig = new File("testdata", "test513.dsf");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        File testFile = AbstractTestCase.copyAudioToTmp("test513.dsf");

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("BEFORE:ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":metadatasizeinfile:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }

        try
        {

            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            af.getTag().addField(FieldKey.BPM,"123111111111111111111111111111111111111");
            System.out.println("BEFORE IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());
            af.commit();
            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println("AFTER IDTAGSIZE:"+((AbstractID3v2Tag)af.getTag()).getSize());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);

        try(FileChannel fc = FileChannel.open(testFile.toPath()))
        {
            DsdChunk dsd = DsdChunk.readChunk(Utils.readFileDataIntoBufferLE(fc, DsdChunk.DSD_HEADER_LENGTH));
            System.out.println("AFTER :ActualFileSize:"+fc.size()+":DSDHeader:"+dsd+":metadatasizeinfile:"+(fc.size() - dsd.getMetadataOffset()));
            assertEquals(dsd.getFileLength(),fc.size());
        }
    }
}
