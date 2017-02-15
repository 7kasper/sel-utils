/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class ServerDifficulty extends Packet {

	public static final int ID = (int)13;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// difficulty
	public static final byte PEACEFUL = 0;
	public static final byte EASY = 1;
	public static final byte NORMAL = 2;
	public static final byte HARD = 3;

	public byte difficulty;

	public ServerDifficulty() {}

	public ServerDifficulty(byte difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(difficulty);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		difficulty=readBigEndianByte();
	}

	public static ServerDifficulty fromBuffer(byte[] buffer) {
		ServerDifficulty ret = new ServerDifficulty();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ServerDifficulty(difficulty: " + this.difficulty + ")";
	}

}
