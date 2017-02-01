/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ResourcePackDataInfo extends Packet {

	public static final byte ID = (byte)79;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public String id;
	public int unknown1;
	public int unknown2;
	public long unknown3;
	public String unknown4;

	public ResourcePackDataInfo() {}

	public ResourcePackDataInfo(String id, int unknown1, int unknown2, long unknown3, String unknown4) {
		this.id = id;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
		this.unknown3 = unknown3;
		this.unknown4 = unknown4;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(unknown4.getBytes(StandardCharsets.UTF_8).length) + unknown4.getBytes(StandardCharsets.UTF_8).length + 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] awq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)awq.length); this.writeBytes(awq);
		this.writeBigEndianInt(unknown1);
		this.writeBigEndianInt(unknown2);
		this.writeBigEndianLong(unknown3);
		byte[] dw5rbm93bjq=unknown4.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dw5rbm93bjq.length); this.writeBytes(dw5rbm93bjq);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bgvuawq=this.readVaruint(); id=new String(this.readBytes(bgvuawq), StandardCharsets.UTF_8);
		unknown1=readBigEndianInt();
		unknown2=readBigEndianInt();
		unknown3=readBigEndianLong();
		int bgvudw5rbm93bjq=this.readVaruint(); unknown4=new String(this.readBytes(bgvudw5rbm93bjq), StandardCharsets.UTF_8);
	}

	public static ResourcePackDataInfo fromBuffer(byte[] buffer) {
		ResourcePackDataInfo ret = new ResourcePackDataInfo();
		ret.decode(buffer);
		return ret;
	}

}
