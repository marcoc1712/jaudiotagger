package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;

import java.io.File;

/**
 * Hires file has wrong chunk size in data chunk, or are we just reading it wrong
 */
public class Issue227Test extends AbstractTestCase
{
    public void testReadingHiRefWav() throws Exception
    {
        File orig = new File("testdata", "test510.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test510.wav");
            AudioFile af = AudioFileIO.read(testFile);
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

    public void testReadingHiRefWavFromQobuz() throws Exception
    {
        File orig = new File("testdata", "test515.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test515.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAndWriteHiRefWavFromQobuz() throws Exception
    {
        File orig = new File("testdata", "test516.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test516.wav");
            AudioFile af = AudioFileIO.read(testFile);
            System.out.println(af.getAudioHeader());
            assertNotNull(af.getTag());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM,"PM");
            Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
//        assertNull(ex);
    }

    public void testReadAndWriteHiRefAifFromQobuz() throws Exception
    {
        File orig = new File("testdata", "test517.aif");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test517.aif");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

            af.getTag().setField(FieldKey.ALBUM,"PM");
            Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAndWriteHiRefFlacFromQobuz() throws Exception
    {
        File orig = new File("testdata", "test518.flac");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test518.flac");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ALBUM,"PM");
            Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAndWriteHiRefM4aFromQobuz() throws Exception
    {
        File orig = new File("testdata", "test519.m4a");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test519.m4a");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ALBUM,"PM");
            Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAndWriteHiRefWmaFromQobuz() throws Exception
    {
        File orig = new File("testdata", "test520.wma");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test520.wma");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            af.getTag().setField(FieldKey.ALBUM,"PM");
            Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAndWriteHiRefAifFromHdTracks() throws Exception
    {
        File orig = new File("testdata", "test521.aif");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test521.aif");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

            assertEquals(af.getTag().getFirst(FieldKey.ALBUM),"The Magic Whip");

            af.getTag().setField(FieldKey.ALBUM,"Whipping");
            //Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            //af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());
            assertNotNull(af.getTag());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM),"Whipping");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadAndWriteHiRefAifFromHdTracks2() throws Exception
    {
        File orig = new File("testdata", "test522.aif");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test522.aif");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());

            assertEquals(af.getTag().getFirst(FieldKey.ALBUM),"American Idiot");
            af.getTag().setField(FieldKey.ALBUM,"Whipping");
            //Artwork newartwork = ArtworkFactory.createArtworkFromFile(new File("testdata", "coverart.png"));
            //af.getTag().setField(newartwork);
            af.commit();

            af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
            System.out.println(af.getAudioHeader());
            System.out.println(af.getTag());
            assertEquals(24, af.getAudioHeader().getBitsPerSample());
            assertEquals(af.getTag().getFirst(FieldKey.ALBUM),"Whipping");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
        assertNull(ex);
    }

    public void testReadingValidAudioInvalidMetadataWav() throws Exception
    {
        File orig = new File("testdata", "test525.wav");
        if (!orig.isFile())
        {
            System.err.println("Unable to test file - not available");
            return;
        }

        Exception ex=null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("test525.wav");
            AudioFile af = AudioFileIO.read(testFile);
            assertNotNull(af.getTag());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ex=e;
        }
//        assertNull(ex);
    }
}
