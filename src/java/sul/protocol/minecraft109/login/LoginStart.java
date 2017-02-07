/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class LoginStart extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public String username;

	public LoginStart() {}

	public LoginStart(String username) {
		this.username = username;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dxnlcm5hbwu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxnlcm5hbwu.length); this.writeBytes(dxnlcm5hbwu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvudxnlcm5hbwu=this.readVaruint(); username=new String(this.readBytes(bgvudxnlcm5hbwu), StandardCharsets.UTF_8);
	}

	public static LoginStart fromBuffer(byte[] buffer) {
		LoginStart ret = new LoginStart();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "LoginStart(username: " + this.username + ")";
	}

}
