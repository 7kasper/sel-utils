/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class MultiBlockChange extends Packet {

	public static final int ID = (int)16;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.IntXZ chunk;
	public sul.protocol.minecraft107.types.BlockChange[] changes;

	public MultiBlockChange() {}

	public MultiBlockChange(Tuples.IntXZ chunk, sul.protocol.minecraft107.types.BlockChange[] changes) {
		this.chunk = chunk;
		this.changes = changes;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + Buffer.varuintLength(changes.length) + 8; for(sul.protocol.minecraft107.types.BlockChange y2hhbmdlcw:changes){ length+=y2hhbmdlcw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(chunk.x); this.writeBigEndianInt(chunk.z);
		this.writeVaruint((int)changes.length); for(sul.protocol.minecraft107.types.BlockChange y2hhbmdlcw:changes){ this.writeBytes(y2hhbmdlcw.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		chunk=new Tuples.IntXZ(); chunk.x=readBigEndianInt(); chunk.z=readBigEndianInt();
		int bgnoyw5nzxm=this.readVaruint(); changes=new sul.protocol.minecraft107.types.BlockChange[bgnoyw5nzxm]; for(int y2hhbmdlcw=0;y2hhbmdlcw<changes.length;y2hhbmdlcw++){ changes[y2hhbmdlcw]=new sul.protocol.minecraft107.types.BlockChange(); changes[y2hhbmdlcw]._index=this._index; changes[y2hhbmdlcw].decode(this._buffer); this._index=changes[y2hhbmdlcw]._index; }
	}

	public static MultiBlockChange fromBuffer(byte[] buffer) {
		MultiBlockChange ret = new MultiBlockChange();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "MultiBlockChange(chunk: " + this.chunk.toString() + ", changes: " + Arrays.deepToString(this.changes) + ")";
	}

}
