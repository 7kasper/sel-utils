/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class Attribute extends Stream {

	public String key;
	public double value;
	public sul.protocol.minecraft316.types.Modifier[] modifiers;

	public Attribute() {}

	public Attribute(String key, double value, sul.protocol.minecraft316.types.Modifier[] modifiers) {
		this.key = key;
		this.value = value;
		this.modifiers = modifiers;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(key.getBytes(StandardCharsets.UTF_8).length) + key.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(modifiers.length) + 8; for(sul.protocol.minecraft316.types.Modifier bw9kawzpzxjz:modifiers){ length+=bw9kawzpzxjz.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] a2v5=key.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)a2v5.length); this.writeBytes(a2v5);
		this.writeBigEndianDouble(value);
		this.writeVaruint((int)modifiers.length); for(sul.protocol.minecraft316.types.Modifier bw9kawzpzxjz:modifiers){ this.writeBytes(bw9kawzpzxjz.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		int bgvua2v5=this.readVaruint(); key=new String(this.readBytes(bgvua2v5), StandardCharsets.UTF_8);
		value=readBigEndianDouble();
		int bg1vzglmawvycw=this.readVaruint(); modifiers=new sul.protocol.minecraft316.types.Modifier[bg1vzglmawvycw]; for(int bw9kawzpzxjz=0;bw9kawzpzxjz<modifiers.length;bw9kawzpzxjz++){ modifiers[bw9kawzpzxjz]=new sul.protocol.minecraft316.types.Modifier(); modifiers[bw9kawzpzxjz]._index=this._index; modifiers[bw9kawzpzxjz].decode(this._buffer); this._index=modifiers[bw9kawzpzxjz]._index; }
	}

	@Override
	public String toString() {
		return "Attribute(key: " + this.key + ", value: " + this.value + ", modifiers: " + Arrays.deepToString(this.modifiers) + ")";
	}


}
