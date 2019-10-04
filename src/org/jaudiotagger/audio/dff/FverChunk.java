package org.jaudiotagger.audio.dff;

import org.jaudiotagger.audio.generic.Utils;

import java.nio.ByteBuffer;
import java.util.logging.Logger;
;


/**
 * DSD Chunk
 */
public class FverChunk
{
    public static Logger logger = Logger.getLogger("org.jaudiotagger.audio.dff");
	
	public static final int CHUNKSIZE_LENGTH = 12;
    public static final int SIGNATURE_LENGTH = 4;

    public static final int FVER_HEADER_LENGTH = SIGNATURE_LENGTH + CHUNKSIZE_LENGTH;
	
	private  int majorVersionNumber;
	private  int additionVersionNumber;
	private  int reservedVersion1;
	private  int reservedVersion2;
	
	private String version;
	
    public static FverChunk readChunk(ByteBuffer dataBuffer)
    {
        String type = Utils.readFourBytesAsChars(dataBuffer);
        if (DffChunkType.FVER.getCode().equals(type))
        {
            return new FverChunk(dataBuffer);
        }
        return null;
    }

    private FverChunk(ByteBuffer dataBuffer) {

		majorVersionNumber = dataBuffer.get() & 0xFF;
		additionVersionNumber = dataBuffer.get() & 0xFF;
		reservedVersion1 = dataBuffer.get() & 0xFF;
		reservedVersion2 = dataBuffer.get() & 0xFF;
		
		version =	majorVersionNumber+"."+
					additionVersionNumber+"."+
					reservedVersion1+"."+
					reservedVersion2;
    }

    @Override
    public String toString()
    {
        return DffChunkType.FVER.getCode()+" version: "+version;
    }

	/**
	 * @return the majorVersionNumber
	 */
	public Integer getMajorVersionNumber() {
		return majorVersionNumber;
	}

	/**
	 * @return the additionVersionNumber
	 */
	public Integer getAdditionVersionNumber() {
		return additionVersionNumber;
	}

	/**
	 * @return the reservedVersion1
	 */
	public Integer getReservedVersion1() {
		return reservedVersion1;
	}

	/**
	 * @return the reservedVersion2
	 */
	public Integer getReservedVersion2() {
		return reservedVersion2;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
}
