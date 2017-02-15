/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Rule extends Stream {

	// name
	public static final String DROWNING_DAMAGE = "drowningdamage";
	public static final String FALL_DAMAGE = "falldamage";
	public static final String FIRE_DAMAGE = "firedamage";
	public static final String IMMUTABLE_WORLD = "immutableworld";
	public static final String PVP = "pvp";

	public String name;
	public boolean value;
	public boolean unknown2;

	public Rule() {}

	public Rule(String name, boolean value, boolean unknown2) {
		this.name = name;
		this.value = value;
		this.unknown2 = unknown2;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeBool(value);
		this.writeBool(unknown2);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bgvubmftzq=this.readVaruint(); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		value=this.readBool();
		unknown2=this.readBool();
	}

	@Override
	public String toString() {
		return "Rule(name: " + this.name + ", value: " + this.value + ", unknown2: " + this.unknown2 + ")";
	}


}
