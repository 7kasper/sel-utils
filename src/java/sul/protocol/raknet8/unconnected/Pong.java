/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.unconnected;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class Pong extends Packet {

	public static final byte ID = (byte)28;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public long pingId;
	public long serverId;
	public byte[] magic = new byte[16];
	public String status;

	public Pong() {}

	public Pong(long pingId, long serverId, byte[] magic, String status) {
		this.pingId = pingId;
		this.serverId = serverId;
		this.magic = magic;
		this.status = status;
	}

	@Override
	public int length() {
		return magic.length + status.getBytes(StandardCharsets.UTF_8).length + 19;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianLong(pingId);
		this.writeBigEndianLong(serverId);
		this.writeBytes(magic);
		byte[] c3rhdhvz=status.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)c3rhdhvz.length); this.writeBytes(c3rhdhvz);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		pingId=readBigEndianLong();
		serverId=readBigEndianLong();
		final int bg1hz2lj=16; magic=this.readBytes(bg1hz2lj);
		short bgvuc3rhdhvz=readBigEndianShort(); status=new String(this.readBytes(bgvuc3rhdhvz), StandardCharsets.UTF_8);
	}

	public static Pong fromBuffer(byte[] buffer) {
		Pong ret = new Pong();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Pong(pingId: " + this.pingId + ", serverId: " + this.serverId + ", magic: " + Arrays.toString(this.magic) + ", status: " + this.status + ")";
	}

}
