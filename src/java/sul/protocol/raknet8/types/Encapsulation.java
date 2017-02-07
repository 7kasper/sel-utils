/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.types;

import java.util.Arrays;

import sul.utils.*;

public class Encapsulation extends Packet {

	public byte info;
	public short length;
	public int messageIndex;
	public int orderIndex;
	public byte orderChannel;
	public sul.protocol.raknet8.types.Split split;
	public byte[] payload;

	public Encapsulation() {}

	public Encapsulation(byte info, short length, int messageIndex, int orderIndex, byte orderChannel, sul.protocol.raknet8.types.Split split, byte[] payload) {
		this.info = info;
		this.length = length;
		this.messageIndex = messageIndex;
		this.orderIndex = orderIndex;
		this.orderChannel = orderChannel;
		this.split = split;
		this.payload = payload;
	}

	@Override
	public int length() {
		return split.length() + payload.length + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(info);
		this.writeBigEndianShort(length);
		if((info&0x7F)>=64){ this.writeLittleEndianTriad(messageIndex); }
		if((info&0x7F)>=96){ this.writeLittleEndianTriad(orderIndex); }
		if((info&0x7F)>=96){ this.writeBigEndianByte(orderChannel); }
		if((info&0x10)!=0){ this.writeBytes(split.encode()); }
		this.writeBytes(payload);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		info=readBigEndianByte();
		length=readBigEndianShort();
		if((info&0x7F)>=64){ messageIndex=readLittleEndianTriad(); }
		if((info&0x7F)>=96){ orderIndex=readLittleEndianTriad(); }
		if((info&0x7F)>=96){ orderChannel=readBigEndianByte(); }
		if((info&0x10)!=0){ split=new sul.protocol.raknet8.types.Split(); split._index=this._index; split.decode(this._buffer); this._index=split._index; }
		payload=this.readBytes(this._buffer.length-this._index);
	}

	@Override
	public String toString() {
		return "Encapsulation(info: " + this.info + ", length: " + this.length + ", messageIndex: " + this.messageIndex + ", orderIndex: " + this.orderIndex + ", orderChannel: " + this.orderChannel + ", split: " + this.split.toString() + ", payload: " + Arrays.toString(this.payload) + ")";
	}


}
