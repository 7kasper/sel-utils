/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import java.util.Arrays;

import sul.utils.*;

/**
 * Receives a binary message sent by another node using MessageServerbound.
 */
public class MessageClientbound extends Packet {

	public static final byte ID = (byte)7;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	/**
	 * Id of the node that has sent the message.
	 */
	public int sender;

	/**
	 * Bytes received. It could be a serialised packet of a plugin-defined packet.
	 */
	public byte[] payload;

	public MessageClientbound() {}

	public MessageClientbound(int sender, byte[] payload) {
		this.sender = sender;
		this.payload = payload;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(sender) + Buffer.varuintLength(payload.length) + payload.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(sender);
		this.writeVaruint((int)payload.length); this.writeBytes(payload);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		sender=this.readVaruint();
		int bhbhewxvywq=this.readVaruint(); payload=this.readBytes(bhbhewxvywq);
	}

	public static MessageClientbound fromBuffer(byte[] buffer) {
		MessageClientbound ret = new MessageClientbound();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MessageClientbound(sender: " + this.sender + ", payload: " + Arrays.toString(this.payload) + ")";
	}

}
