/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class Login extends Packet {

	public static final byte ID = (byte)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	// edition
	public static final byte CLASSIC = 0;
	public static final byte EDUCATION = 1;

	public int protocol;
	public byte edition;
	public byte[] body;

	public Login() {}

	public Login(int protocol, byte edition, byte[] body) {
		this.protocol = protocol;
		this.edition = edition;
		this.body = body;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(body.length) + body.length + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianInt(protocol);
		this.writeBigEndianByte(edition);
		this.writeVaruint((int)body.length); this.writeBytes(body);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		protocol=readBigEndianInt();
		edition=readBigEndianByte();
		int bgjvzhk=this.readVaruint(); body=new byte[bgjvzhk]; body=this.readBytes(bgjvzhk);
	}

	public static Login fromBuffer(byte[] buffer) {
		Login ret = new Login();
		ret.decode(buffer);
		return ret;
	}

}
