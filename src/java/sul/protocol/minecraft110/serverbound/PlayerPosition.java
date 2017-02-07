/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import sul.utils.*;

public class PlayerPosition extends Packet {

	public static final int ID = (int)12;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public Tuples.DoubleXYZ position;
	public boolean onGround;

	public PlayerPosition() {}

	public PlayerPosition(Tuples.DoubleXYZ position, boolean onGround) {
		this.position = position;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 25;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		onGround=this.readBool();
	}

	public static PlayerPosition fromBuffer(byte[] buffer) {
		PlayerPosition ret = new PlayerPosition();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerPosition(position: " + this.position.toString() + ", onGround: " + this.onGround + ")";
	}

}
