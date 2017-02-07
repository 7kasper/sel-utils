/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.types;

import java.util.Arrays;

import sul.utils.*;

/**
 * Indicates a game and informations about its accepted protocols.
 */
public class Game extends Packet {

	// type
	public static final byte POCKET = 1;
	public static final byte MINECRAFT = 2;

	/**
	 * Identifier of the game.
	 */
	public byte type;

	/**
	 * Protocols accepted by the server for the game. They should be ordered from oldest
	 * to newest.
	 */
	public int[] protocols;

	public Game() {}

	public Game(byte type, int[] protocols) {
		this.type = type;
		this.protocols = protocols;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(protocols.length) + 1; for(int chjvdg9jb2xz:protocols){ length+=Buffer.varuintLength(chjvdg9jb2xz); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(type);
		this.writeVaruint((int)protocols.length); for(int chjvdg9jb2xz:protocols){ this.writeVaruint(chjvdg9jb2xz); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		type=readBigEndianByte();
		int bhbyb3rvy29scw=this.readVaruint(); protocols=new int[bhbyb3rvy29scw]; for(int chjvdg9jb2xz=0;chjvdg9jb2xz<protocols.length;chjvdg9jb2xz++){ protocols[chjvdg9jb2xz]=this.readVaruint(); }
	}

	@Override
	public String toString() {
		return "Game(type: " + this.type + ", protocols: " + Arrays.toString(this.protocols) + ")";
	}


}
