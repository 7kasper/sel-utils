/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class TabComplete extends Packet {

	public static final int ID = (int)14;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public String[] matches;

	public TabComplete() {}

	public TabComplete(String[] matches) {
		this.matches = matches;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + Buffer.varuintLength(matches.length) + 0; for(String bwf0y2hlcw:matches){ length+=Buffer.varuintLength(bwf0y2hlcw.getBytes(StandardCharsets.UTF_8).length)+bwf0y2hlcw.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)matches.length); for(String bwf0y2hlcw:matches){ byte[] yndmmhkyagxjdw=bwf0y2hlcw.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)yndmmhkyagxjdw.length); this.writeBytes(yndmmhkyagxjdw); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bg1hdgnozxm=this.readVaruint(); matches=new String[bg1hdgnozxm]; for(int bwf0y2hlcw=0;bwf0y2hlcw<matches.length;bwf0y2hlcw++){ int bgvubwf0y2hlc1ti=this.readVaruint(); matches[bwf0y2hlcw]=new String(this.readBytes(bgvubwf0y2hlc1ti), StandardCharsets.UTF_8); }
	}

	public static TabComplete fromBuffer(byte[] buffer) {
		TabComplete ret = new TabComplete();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "TabComplete(matches: " + Arrays.deepToString(this.matches) + ")";
	}

}
