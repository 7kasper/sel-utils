/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.serverbound;

import sul.utils.*;

public class PlayerLook extends Packet {

	public static final int ID = (int)14;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public float yaw;
	public float pitch;
	public boolean onGround;

	public PlayerLook() {}

	public PlayerLook(float yaw, float pitch, boolean onGround) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		this._buffer[this._index++]=(byte)(onGround?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static PlayerLook fromBuffer(byte[] buffer) {
		PlayerLook ret = new PlayerLook();
		ret.decode(buffer);
		return ret;
	}

}
