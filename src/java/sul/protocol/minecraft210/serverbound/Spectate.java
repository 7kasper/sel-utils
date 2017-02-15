/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import java.util.UUID;

import sul.utils.*;

public class Spectate extends Packet {

	public static final int ID = (int)27;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public UUID player;

	public Spectate() {}

	public Spectate(UUID player) {
		this.player = player;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 16;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(player.getLeastSignificantBits()); this.writeBigEndianLong(player.getMostSignificantBits());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		long bxbsyxllcg=readBigEndianLong(); long bhbsyxllcg=readBigEndianLong(); player=new UUID(bxbsyxllcg,bhbsyxllcg);
	}

	public static Spectate fromBuffer(byte[] buffer) {
		Spectate ret = new Spectate();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Spectate(player: " + this.player.toString() + ")";
	}

}
