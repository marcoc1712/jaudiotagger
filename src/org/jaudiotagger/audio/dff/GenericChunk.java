package org.jaudiotagger.audio.dff;

import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Generic Chunk
 */
public class GenericChunk extends BaseChunk
{
    public GenericChunk(ByteBuffer dataBuffer)
    {
        super(dataBuffer);
    }

    @Override
    public void readDataChunch(FileChannel fc) throws IOException
    {

        super.readDataChunch(fc);

        skipToChunkEnd(fc);
    }

    @Override
    public String toString()
    {
        return "generic";
    }
}
