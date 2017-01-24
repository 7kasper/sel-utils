/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import sul.utils.*;

public class PlayerPositionAndLook extends Packet {

	public static final int ID = (int)6;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public Tuples.DoubleXYZ position;
	public float yaw;
	public float pitch;
	public boolean onGround;

	public PlayerPositionAndLook() {}

	public PlayerPositionAndLook(Tuples.DoubleXYZ position, float yaw, float pitch, boolean onGround) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static PlayerPositionAndLook fromBuffer(byte[] buffer) {
		PlayerPositionAndLook ret = new PlayerPositionAndLook();
		ret.decode(buffer);
		return ret;
	}

}
