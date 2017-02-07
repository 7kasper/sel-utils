/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class LoginSuccess extends Packet {

	public static final int ID = (int)2;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public String uuid;
	public String username;

	public LoginSuccess() {}

	public LoginSuccess(String uuid, String username) {
		this.uuid = uuid;
		this.username = username;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(uuid.getBytes(StandardCharsets.UTF_8).length) + uuid.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dxvpza=uuid.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxvpza.length); this.writeBytes(dxvpza);
		byte[] dxnlcm5hbwu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxnlcm5hbwu.length); this.writeBytes(dxnlcm5hbwu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvudxvpza=this.readVaruint(); uuid=new String(this.readBytes(bgvudxvpza), StandardCharsets.UTF_8);
		int bgvudxnlcm5hbwu=this.readVaruint(); username=new String(this.readBytes(bgvudxnlcm5hbwu), StandardCharsets.UTF_8);
	}

	public static LoginSuccess fromBuffer(byte[] buffer) {
		LoginSuccess ret = new LoginSuccess();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "LoginSuccess(uuid: " + this.uuid + ", username: " + this.username + ")";
	}

}
