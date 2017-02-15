/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Disconnect extends Packet {

	public static final byte ID = (byte)5;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public boolean hideDisconnectionScreen;
	public String message;

	public Disconnect() {}

	public Disconnect(boolean hideDisconnectionScreen, String message) {
		this.hideDisconnectionScreen = hideDisconnectionScreen;
		this.message = message;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBool(hideDisconnectionScreen);
		if(hideDisconnectionScreen==false){ byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hideDisconnectionScreen=this.readBool();
		if(hideDisconnectionScreen==false){ int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8); }
	}

	public static Disconnect fromBuffer(byte[] buffer) {
		Disconnect ret = new Disconnect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Disconnect(hideDisconnectionScreen: " + this.hideDisconnectionScreen + ", message: " + this.message + ")";
	}

}
