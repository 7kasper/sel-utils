/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class Map extends Packet {

	public static final int ID = (int)36;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int mapId;
	public byte scale;
	public boolean showIcons;
	public sul.protocol.minecraft316.types.Icon[] icons;
	public byte colums;
	public byte rows;
	public Tuples.ByteXZ offset;
	public byte[] data;

	public Map() {}

	public Map(int mapId, byte scale, boolean showIcons, sul.protocol.minecraft316.types.Icon[] icons, byte colums, byte rows, Tuples.ByteXZ offset, byte[] data) {
		this.mapId = mapId;
		this.scale = scale;
		this.showIcons = showIcons;
		this.icons = icons;
		this.colums = colums;
		this.rows = rows;
		this.offset = offset;
		this.data = data;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + Buffer.varuintLength(mapId) + Buffer.varuintLength(icons.length) + Buffer.varuintLength(data.length) + data.length + 6; for(sul.protocol.minecraft316.types.Icon awnvbnm:icons){ length+=awnvbnm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(mapId);
		this.writeBigEndianByte(scale);
		this.writeBool(showIcons);
		this.writeVaruint((int)icons.length); for(sul.protocol.minecraft316.types.Icon awnvbnm:icons){ this.writeBytes(awnvbnm.encode()); }
		this.writeBigEndianByte(colums);
		this.writeBigEndianByte(rows);
		this.writeBigEndianByte(offset.x); this.writeBigEndianByte(offset.z);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		mapId=this.readVaruint();
		scale=readBigEndianByte();
		showIcons=this.readBool();
		int bgljb25z=this.readVaruint(); icons=new sul.protocol.minecraft316.types.Icon[bgljb25z]; for(int awnvbnm=0;awnvbnm<icons.length;awnvbnm++){ icons[awnvbnm]=new sul.protocol.minecraft316.types.Icon(); icons[awnvbnm]._index=this._index; icons[awnvbnm].decode(this._buffer); this._index=icons[awnvbnm]._index; }
		colums=readBigEndianByte();
		rows=readBigEndianByte();
		offset=new Tuples.ByteXZ(); offset.x=readBigEndianByte(); offset.z=readBigEndianByte();
		int bgrhdge=this.readVaruint(); data=this.readBytes(bgrhdge);
	}

	public static Map fromBuffer(byte[] buffer) {
		Map ret = new Map();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Map(mapId: " + this.mapId + ", scale: " + this.scale + ", showIcons: " + this.showIcons + ", icons: " + Arrays.deepToString(this.icons) + ", colums: " + this.colums + ", rows: " + this.rows + ", offset: " + this.offset.toString() + ", data: " + Arrays.toString(this.data) + ")";
	}

}
