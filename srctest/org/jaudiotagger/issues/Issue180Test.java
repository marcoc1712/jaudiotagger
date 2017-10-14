/*
 * =================================================
 * Copyright 2017 tagtraum industries incorporated
 * All rights reserved.
 * =================================================
 */
package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.generic.AudioFileReader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagOptionSingleton;
import org.jaudiotagger.tag.aiff.AiffTag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.wav.WavTag;

import java.io.File;

/**
 * Issue180Test.
 *
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class Issue180Test extends AbstractTestCase {

    public void testWriteIDv22ForITunes12_6() throws Exception 
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with special iTunes 12.6 mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");
        final MP3File mp3File = new MP3File(testFile);
        final ID3v22Tag v2Tag = new ID3v22Tag();
        v2Tag.setField(FieldKey.GROUPING,"grouping");
        v2Tag.setField(FieldKey.WORK,"work");
        mp3File.setID3v2Tag(v2Tag);
        mp3File.save();

        //Read using new Interface
        final AudioFile v22File = AudioFileIO.read(testFile);
        assertEquals("grouping", v22File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v22File.getTag().getFirst(FieldKey.WORK));

        // now switch to regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final AudioFile regV22File = AudioFileIO.read(testFile);
        assertEquals("work", regV22File.getTag().getFirst(FieldKey.GROUPING));
        final String w = regV22File.getTag().getFirst(FieldKey.WORK);
        assertTrue(w == null || w.isEmpty());
    }

    public void testWriteIDv22Regular() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");
        final MP3File mp3File = new MP3File(testFile);
        final ID3v22Tag v2Tag = new ID3v22Tag();
        v2Tag.setField(FieldKey.GROUPING,"grouping");
        v2Tag.setField(FieldKey.WORK,"work");
        mp3File.setID3v2Tag(v2Tag);
        mp3File.save();

        //Read using new Interface
        final AudioFile v22File = AudioFileIO.read(testFile);
        assertEquals("grouping", v22File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v22File.getTag().getFirst(FieldKey.WORK));

        // now switch to iTunes mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final AudioFile iTunesV22File = AudioFileIO.read(testFile);
        final String g = iTunesV22File.getTag().getFirst(FieldKey.GROUPING);
        assertTrue(g == null || g.isEmpty());
        assertEquals("grouping", iTunesV22File.getTag().getFirst(FieldKey.WORK));
    }

    public void testWriteIDv23ForITunes12_6() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with special iTunes 12.6 mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");
        final MP3File mp3File = new MP3File(testFile);
        final ID3v23Tag v2Tag = new ID3v23Tag();
        v2Tag.setField(FieldKey.GROUPING,"grouping");
        v2Tag.setField(FieldKey.WORK,"work");
        mp3File.setID3v2Tag(v2Tag);
        mp3File.save();

        //Read using new Interface
        final AudioFile v23File = AudioFileIO.read(testFile);
        assertEquals("grouping", v23File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v23File.getTag().getFirst(FieldKey.WORK));

        // now switch to regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final AudioFile regV23File = AudioFileIO.read(testFile);
        assertEquals("work", regV23File.getTag().getFirst(FieldKey.GROUPING));
        final String w = regV23File.getTag().getFirst(FieldKey.WORK);
        assertTrue(w == null || w.isEmpty());
    }

    public void testWriteIDv23Regular() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");
        final MP3File mp3File = new MP3File(testFile);
        final ID3v23Tag v2Tag = new ID3v23Tag();
        v2Tag.setField(FieldKey.GROUPING,"grouping");
        v2Tag.setField(FieldKey.WORK,"work");
        mp3File.setID3v2Tag(v2Tag);
        mp3File.save();

        //Read using new Interface
        final AudioFile v23File = AudioFileIO.read(testFile);
        assertEquals("grouping", v23File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v23File.getTag().getFirst(FieldKey.WORK));

        // now switch to iTunes mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final AudioFile iTunesV23File = AudioFileIO.read(testFile);
        final String g = iTunesV23File.getTag().getFirst(FieldKey.GROUPING);
        assertTrue(g == null || g.isEmpty());
        assertEquals("grouping", iTunesV23File.getTag().getFirst(FieldKey.WORK));
    }

    public void testWriteIDv24ForITunes12_6() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with special iTunes 12.6 mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");
        final MP3File mp3File = new MP3File(testFile);
        final ID3v24Tag v2Tag = new ID3v24Tag();
        v2Tag.setField(FieldKey.GROUPING,"grouping");
        v2Tag.setField(FieldKey.WORK,"work");
        mp3File.setID3v2Tag(v2Tag);
        mp3File.save();

        //Read using new Interface
        final AudioFile v24File = AudioFileIO.read(testFile);
        assertEquals("grouping", v24File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v24File.getTag().getFirst(FieldKey.WORK));

        // now switch to regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final AudioFile regV24File = AudioFileIO.read(testFile);
        assertEquals("work", regV24File.getTag().getFirst(FieldKey.GROUPING));
        final String w = regV24File.getTag().getFirst(FieldKey.WORK);
        assertTrue(w == null || w.isEmpty());
    }

    public void testWriteIDv24Regular() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");
        final MP3File mp3File = new MP3File(testFile);
        final ID3v24Tag v2Tag = new ID3v24Tag();
        v2Tag.setField(FieldKey.GROUPING,"grouping");
        v2Tag.setField(FieldKey.WORK,"work");
        mp3File.setID3v2Tag(v2Tag);
        mp3File.save();

        //Read using new Interface
        final AudioFile v24File = AudioFileIO.read(testFile);
        assertEquals("grouping", v24File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v24File.getTag().getFirst(FieldKey.WORK));

        // now switch to iTunes mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final AudioFile iTunesV24File = AudioFileIO.read(testFile);
        final String g = iTunesV24File.getTag().getFirst(FieldKey.GROUPING);
        assertTrue(g == null || g.isEmpty());
        assertEquals("grouping", iTunesV24File.getTag().getFirst(FieldKey.WORK));
    }

    public void testWriteIDv23AifForITunes12_6() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with special iTunes 12.6 mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final File testFile = AbstractTestCase.copyAudioToTmp("test119.aif");
        final AudioFile audioFile = AudioFileIO.read(testFile);
        audioFile.getTag().setField(FieldKey.GROUPING, "grouping");
        audioFile.getTag().setField(FieldKey.WORK, "work");
        System.out.println(((AiffTag) audioFile.getTag()));
        audioFile.commit();

        //Read using new Interface
        final AudioFile v22File = AudioFileIO.read(testFile);
        assertEquals("grouping", v22File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v22File.getTag().getFirst(FieldKey.WORK));

        // now switch to regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final AudioFile regV22File = AudioFileIO.read(testFile);
        assertEquals("work", regV22File.getTag().getFirst(FieldKey.GROUPING));
        final String w = regV22File.getTag().getFirst(FieldKey.WORK);
        assertTrue(w == null || w.isEmpty());
    }

    public void testWriteIDv23AifRegular() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);


        final File testFile = AbstractTestCase.copyAudioToTmp("test119.aif");
        final AudioFile audioFile = AudioFileIO.read(testFile);
        audioFile.getTag().setField(FieldKey.GROUPING, "grouping");
        audioFile.getTag().setField(FieldKey.WORK, "work");
        System.out.println(((AiffTag) audioFile.getTag()));
        audioFile.commit();


        //Read using new Interface
        final AudioFile v22File = AudioFileIO.read(testFile);
        assertEquals("grouping", v22File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v22File.getTag().getFirst(FieldKey.WORK));

        // now switch to iTunes mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final AudioFile iTunesV22File = AudioFileIO.read(testFile);
        final String g = iTunesV22File.getTag().getFirst(FieldKey.GROUPING);
        assertTrue(g == null || g.isEmpty());
        assertEquals("grouping", iTunesV22File.getTag().getFirst(FieldKey.WORK));
    }

    public void testWriteIDv2WavForITunes12_6() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with special iTunes 12.6 mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final File testFile = AbstractTestCase.copyAudioToTmp("test.wav");
        final AudioFile audioFile = AudioFileIO.read(testFile);
        audioFile.getTag().setField(FieldKey.GROUPING, "grouping");
        audioFile.getTag().setField(FieldKey.WORK,"work");
        System.out.println(((WavTag)audioFile.getTag()));
        audioFile.commit();

        //Read using new Interface
        final AudioFile v22File = AudioFileIO.read(testFile);
        assertEquals("grouping", v22File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v22File.getTag().getFirst(FieldKey.WORK));

        // now switch to regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);

        final AudioFile regV22File = AudioFileIO.read(testFile);
        assertEquals("work", regV22File.getTag().getFirst(FieldKey.GROUPING));
        final String w = regV22File.getTag().getFirst(FieldKey.WORK);
        assertTrue(w == null || w.isEmpty());
    }

    public void testWriteIDv23WavRegular() throws Exception
    {
        final TagOptionSingleton options = TagOptionSingleton.getInstance();
        // start with regular mode
        options.setId3v2ITunes12_6WorkGroupingMode(false);


        final File testFile = AbstractTestCase.copyAudioToTmp("test.wav");
        final AudioFile audioFile = AudioFileIO.read(testFile);
        audioFile.getTag().setField(FieldKey.GROUPING, "grouping");
        audioFile.getTag().setField(FieldKey.WORK,"work");
        System.out.println(((WavTag)audioFile.getTag()));
        audioFile.commit();


        //Read using new Interface
        final AudioFile v22File = AudioFileIO.read(testFile);
        assertEquals("grouping", v22File.getTag().getFirst(FieldKey.GROUPING));
        assertEquals("work", v22File.getTag().getFirst(FieldKey.WORK));

        // now switch to iTunes mode
        options.setId3v2ITunes12_6WorkGroupingMode(true);

        final AudioFile iTunesV22File = AudioFileIO.read(testFile);
        final String g = iTunesV22File.getTag().getFirst(FieldKey.GROUPING);
        assertTrue(g == null || g.isEmpty());
        assertEquals("grouping", iTunesV22File.getTag().getFirst(FieldKey.WORK));
    }
}
