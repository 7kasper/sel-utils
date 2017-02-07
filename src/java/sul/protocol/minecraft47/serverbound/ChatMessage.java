/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ChatMessage extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public String text;

	public ChatMessage() {}

	public ChatMessage(String text) {
		this.text = text;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dgv4da=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dgv4da.length); this.writeBytes(dgv4da);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvudgv4da=this.readVaruint(); text=new String(this.readBytes(bgvudgv4da), StandardCharsets.UTF_8);
	}

	public static ChatMessage fromBuffer(byte[] buffer) {
		ChatMessage ret = new ChatMessage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChatMessage(text: " + this.text + ")";
	}

}
