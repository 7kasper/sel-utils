/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class PluginMessage extends Packet {

	public static final int ID = (int)9;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String channel;
	public byte[] data;

	public PluginMessage() {}

	public PluginMessage(String channel, byte[] data) {
		this.channel = channel;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(channel.getBytes(StandardCharsets.UTF_8).length) + channel.getBytes(StandardCharsets.UTF_8).length + data.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] y2hhbm5lba=channel.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y2hhbm5lba.length); this.writeBytes(y2hhbm5lba);
		this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvuy2hhbm5lba=this.readVaruint(); channel=new String(this.readBytes(bgvuy2hhbm5lba), StandardCharsets.UTF_8);
		data=this.readBytes(this._buffer.length-this._index);
	}

	public static PluginMessage fromBuffer(byte[] buffer) {
		PluginMessage ret = new PluginMessage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PluginMessage(channel: " + this.channel + ", data: " + Arrays.toString(this.data) + ")";
	}

}
