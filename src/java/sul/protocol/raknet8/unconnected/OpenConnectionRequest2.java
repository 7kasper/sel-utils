/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.unconnected;

import sul.utils.*;

public class OpenConnectionRequest2 extends Packet {

	public static final byte ID = (byte)7;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public byte[] magic = new byte[16];
	public sul.protocol.raknet8.types.Address serverAddress;
	public short mtuLength;
	public long clientId;

	public OpenConnectionRequest2() {}

	public OpenConnectionRequest2(byte[] magic, sul.protocol.raknet8.types.Address serverAddress, short mtuLength, long clientId) {
		this.magic = magic;
		this.serverAddress = serverAddress;
		this.mtuLength = mtuLength;
		this.clientId = clientId;
	}

	@Override
	public int length() {
		return magic.length + serverAddress.length() + 11;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(magic);
		this.writeBytes(serverAddress.encode());
		this.writeBigEndianShort(mtuLength);
		this.writeBigEndianLong(clientId);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		final int bg1hz2lj=16; magic=new byte[bg1hz2lj]; magic=this.readBytes(bg1hz2lj);
		serverAddress=new sul.protocol.raknet8.types.Address(); serverAddress._index=this._index; serverAddress.decode(this._buffer); this._index=serverAddress._index;
		mtuLength=readBigEndianShort();
		clientId=readBigEndianLong();
	}

	public static OpenConnectionRequest2 fromBuffer(byte[] buffer) {
		OpenConnectionRequest2 ret = new OpenConnectionRequest2();
		ret.decode(buffer);
		return ret;
	}

}
