/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class DisplayScoreboard extends Packet {

	public static final int ID = (int)56;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	// position
	public static final byte LIST = 0;
	public static final byte SIDEBAR = 1;
	public static final byte BELOW_NAME = 2;

	public byte position;
	public String scoreName;

	public DisplayScoreboard() {}

	public DisplayScoreboard(byte position, String scoreName) {
		this.position = position;
		this.scoreName = scoreName;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(scoreName.getBytes(StandardCharsets.UTF_8).length) + scoreName.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(position);
		byte[] c2nvcmvoyw1l=scoreName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c2nvcmvoyw1l.length); this.writeBytes(c2nvcmvoyw1l);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianByte();
		int bgvuc2nvcmvoyw1l=this.readVaruint(); scoreName=new String(this.readBytes(bgvuc2nvcmvoyw1l), StandardCharsets.UTF_8);
	}

	public static DisplayScoreboard fromBuffer(byte[] buffer) {
		DisplayScoreboard ret = new DisplayScoreboard();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "DisplayScoreboard(position: " + this.position + ", scoreName: " + this.scoreName + ")";
	}

}
