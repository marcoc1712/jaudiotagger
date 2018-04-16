package org.jaudiotagger.audio.dff;

import java.io.IOException;

import org.jaudiotagger.audio.generic.Utils;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.jaudiotagger.audio.exceptions.InvalidChunkException;

/**
 * Base Chunk for all chuncks in the dff FRM8 Chunk.
 */
public class BaseChunk
{

    public static final int ID_LENGHT = 4;
    private Long chunkSize;
    private Long chunkStart;

    public static BaseChunk readIdChunk(ByteBuffer dataBuffer) throws InvalidChunkException
    {

        String type = Utils.readFourBytesAsChars(dataBuffer);
        System.out.println("BaseChunk.type: "+type);

        if (DffChunkType.FS.getCode().equals(type))
        {

            return new FsChunk(dataBuffer);

        }
        else if (DffChunkType.CHNL.getCode().equals(type))
        {

            return new ChnlChunk(dataBuffer);

        }
        else if (DffChunkType.CMPR.getCode().equals(type))
        {

            return new CmprChunk(dataBuffer);

        }
        else if (DffChunkType.END.getCode().equals(type) || DffChunkType.DSD.getCode().equals(type))
        {

            return new EndChunk(dataBuffer);

        }
        else if (DffChunkType.DST.getCode().equals(type))
        {

            return new DstChunk(dataBuffer);

        }
        else if (DffChunkType.FRTE.getCode().equals(type))
        {

            return new FrteChunk(dataBuffer);

        }
        else if (DffChunkType.ID3.getCode().equals(type))
        {

            return new Id3Chunk(dataBuffer);

        }
        else
        {
			return new GenericChunk(dataBuffer);
            //throw new InvalidChunkException(type + " is not recognized as a valid DFF chunk");
        }
    }

    protected BaseChunk(ByteBuffer dataBuffer)
    {
    }
	
    protected void readDataChunch(FileChannel fc) throws IOException
    {

        ByteBuffer audioData = Utils.readFileDataIntoBufferLE(fc, 8);
        chunkSize = Long.reverseBytes(audioData.getLong());
        chunkStart = fc.position();

        //System.out.println("chunck: "+this+" size: "+this.getChunkSize()+" starts at: "+this.getChunkStart());
    }

    protected void skipToChunkEnd(FileChannel fc) throws IOException
    {

        Long skip = (this.getChunkEnd() - fc.position());

        if (skip > 0)
        {
            ByteBuffer audioData = Utils.readFileDataIntoBufferLE(fc, skip.intValue());
            //System.out.println("New postion: "+fc.position());
        }
    }

    /**
     * @return the chunk Start position
     */
    public Long getChunkStart()
    {
        return chunkStart;
    }

    /**
     * @return the chunkSize
     */
    public Long getChunkSize()
    {
        return chunkSize;
    }

    /**
     * @return the chunk End position.
     */
    public Long getChunkEnd()
    {
        return chunkStart + chunkSize;
    }
}
