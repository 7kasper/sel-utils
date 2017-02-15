/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import sul.utils.*;

public class Player extends Packet {

	public static final int ID = (int)15;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public boolean onGround;

	public Player() {}

	public Player(boolean onGround) {
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		onGround=this.readBool();
	}

	public static Player fromBuffer(byte[] buffer) {
		Player ret = new Player();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Player(onGround: " + this.onGround + ")";
	}

}
