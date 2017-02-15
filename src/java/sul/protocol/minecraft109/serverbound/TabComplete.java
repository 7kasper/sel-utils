/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.serverbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class TabComplete extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String text;
	public boolean command;
	public boolean hasPosition;
	public long block;

	public TabComplete() {}

	public TabComplete(String text, boolean command, boolean hasPosition, long block) {
		this.text = text;
		this.command = command;
		this.hasPosition = hasPosition;
		this.block = block;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dgv4da=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dgv4da.length); this.writeBytes(dgv4da);
		this.writeBool(command);
		this.writeBool(hasPosition);
		if(hasPosition==true){ this.writeBigEndianLong(block); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvudgv4da=this.readVaruint(); text=new String(this.readBytes(bgvudgv4da), StandardCharsets.UTF_8);
		command=this.readBool();
		hasPosition=this.readBool();
		if(hasPosition==true){ block=readBigEndianLong(); }
	}

	public static TabComplete fromBuffer(byte[] buffer) {
		TabComplete ret = new TabComplete();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TabComplete(text: " + this.text + ", command: " + this.command + ", hasPosition: " + this.hasPosition + ", block: " + this.block + ")";
	}

}
