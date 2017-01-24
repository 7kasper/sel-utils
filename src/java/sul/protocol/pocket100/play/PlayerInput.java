/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class PlayerInput extends Packet {

	public static final byte ID = (byte)57;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public Tuples.FloatXYZ motion;
	public byte flags;
	public boolean unknown2;

	public PlayerInput() {}

	public PlayerInput(Tuples.FloatXYZ motion, byte flags, boolean unknown2) {
		this.motion = motion;
		this.flags = flags;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return 15;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		this.writeBigEndianByte(flags);
		this._buffer[this._index++]=(byte)(unknown2?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
		flags=readBigEndianByte();
		unknown2=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static PlayerInput fromBuffer(byte[] buffer) {
		PlayerInput ret = new PlayerInput();
		ret.decode(buffer);
		return ret;
	}

}
