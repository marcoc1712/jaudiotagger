package org.jaudiotagger.audio.dff;

import java.math.BigInteger;
import org.jaudiotagger.audio.generic.Utils;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.jaudiotagger.audio.dff.BaseChunk.logger;
import org.jaudiotagger.audio.exceptions.CannotReadException;

/**
 * DSD Chunk
 */
public class Frm8Chunk {
	
	public static Logger logger = Logger.getLogger("org.jaudiotagger.audio.dff");
	
    public static final int SIGNATURE_LENGTH = 4;
    public static final int CHUNKSIZE_LENGTH = 8;
	public static final int DSD_ = 4;

    public static final int FRM8_HEADER_LENGTH = SIGNATURE_LENGTH + CHUNKSIZE_LENGTH+DSD_;

	private BigInteger chunkSizeLength;
	private String dsd_;
	
    public static Frm8Chunk readChunk(ByteBuffer dataBuffer) throws CannotReadException
    {
        String frm8Signature = Utils.readFourBytesAsChars(dataBuffer);

        if (!DffChunkType.FRM8.getCode().equals(frm8Signature))
        {

            return null;
        }

        return new Frm8Chunk(dataBuffer);
    }

    private Frm8Chunk(ByteBuffer dataBuffer) throws CannotReadException {

		byte[] b = new byte[CHUNKSIZE_LENGTH];
        dataBuffer.get(b);

		chunkSizeLength = new BigInteger(b);
		
		dsd_=  Utils.readFourBytesAsChars(dataBuffer);

		if (dsd_ == null || !DffChunkType.DSD.getCode().equals(dsd_ )) {
			throw new CannotReadException(" Not a valid dff file. Missing 'DSD '  after 'FRM8' ");
		}
		
		logger.log(Level.INFO, "Frm8Chunk.size: {0}", chunkSizeLength);
    }
	/**
	 * @return the chunkSizeLength
	 */
	public BigInteger getChunkSizeLength() {
		return chunkSizeLength;
	}
    @Override
    public String toString()
    {
        return DffChunkType.FRM8.getCode()+"length: "+chunkSizeLength;
    }
}
