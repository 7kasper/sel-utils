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

public class SetEntityMotion extends Packet {

	public static final byte ID = (byte)40;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public long entityId;
	public Tuples.FloatXYZ motion;

	public SetEntityMotion() {}

	public SetEntityMotion(long entityId, Tuples.FloatXYZ motion) {
		this.entityId = entityId;
		this.motion = motion;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + 13;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
	}

	public static SetEntityMotion fromBuffer(byte[] buffer) {
		SetEntityMotion ret = new SetEntityMotion();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetEntityMotion(entityId: " + this.entityId + ", motion: " + this.motion.toString() + ")";
	}

}
