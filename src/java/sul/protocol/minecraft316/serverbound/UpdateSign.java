/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class UpdateSign extends Packet {

	public static final int ID = (int)25;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public long position;
	public String[] lines = new String[4];

	public UpdateSign() {}

	public UpdateSign(long position, String[] lines) {
		this.position = position;
		this.lines = lines;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + 8; for(String bgluzxm:lines){ length+=Buffer.varuintLength(bgluzxm.getBytes(StandardCharsets.UTF_8).length)+bgluzxm.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		for(String bgluzxm:lines){ byte[] ymdsdxp4bq=bgluzxm.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)ymdsdxp4bq.length); this.writeBytes(ymdsdxp4bq); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		final int bgxpbmvz=4; lines=new String[bgxpbmvz]; for(int bgluzxm=0;bgluzxm<lines.length;bgluzxm++){ int bgvubgluzxnbymds=this.readVaruint(); lines[bgluzxm]=new String(this.readBytes(bgvubgluzxnbymds), StandardCharsets.UTF_8); }
	}

	public static UpdateSign fromBuffer(byte[] buffer) {
		UpdateSign ret = new UpdateSign();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateSign(position: " + this.position + ", lines: " + Arrays.deepToString(this.lines) + ")";
	}

}
