/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.Arrays;

import sul.utils.*;

public class ResourcePacksInfo extends Packet {

	public static final byte ID = (byte)7;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public boolean mustAccept;
	public sul.protocol.pocket100.types.Pack[] behaviourPacks;
	public sul.protocol.pocket100.types.Pack[] resourcePacks;

	public ResourcePacksInfo() {}

	public ResourcePacksInfo(boolean mustAccept, sul.protocol.pocket100.types.Pack[] behaviourPacks, sul.protocol.pocket100.types.Pack[] resourcePacks) {
		this.mustAccept = mustAccept;
		this.behaviourPacks = behaviourPacks;
		this.resourcePacks = resourcePacks;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(behaviourPacks.length) + Buffer.varuintLength(resourcePacks.length) + 2; for(sul.protocol.pocket100.types.Pack ymvoyxzpb3vyugfj:behaviourPacks){ length+=ymvoyxzpb3vyugfj.length(); };for(sul.protocol.pocket100.types.Pack cmvzb3vyy2vqywnr:resourcePacks){ length+=cmvzb3vyy2vqywnr.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBool(mustAccept);
		this.writeVaruint((int)behaviourPacks.length); for(sul.protocol.pocket100.types.Pack ymvoyxzpb3vyugfj:behaviourPacks){ this.writeBytes(ymvoyxzpb3vyugfj.encode()); }
		this.writeVaruint((int)resourcePacks.length); for(sul.protocol.pocket100.types.Pack cmvzb3vyy2vqywnr:resourcePacks){ this.writeBytes(cmvzb3vyy2vqywnr.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		mustAccept=this.readBool();
		int bgjlagf2aw91clbh=this.readVaruint(); behaviourPacks=new sul.protocol.pocket100.types.Pack[bgjlagf2aw91clbh]; for(int ymvoyxzpb3vyugfj=0;ymvoyxzpb3vyugfj<behaviourPacks.length;ymvoyxzpb3vyugfj++){ behaviourPacks[ymvoyxzpb3vyugfj]=new sul.protocol.pocket100.types.Pack(); behaviourPacks[ymvoyxzpb3vyugfj]._index=this._index; behaviourPacks[ymvoyxzpb3vyugfj].decode(this._buffer); this._index=behaviourPacks[ymvoyxzpb3vyugfj]._index; }
		int bhjlc291cmnlugfj=this.readVaruint(); resourcePacks=new sul.protocol.pocket100.types.Pack[bhjlc291cmnlugfj]; for(int cmvzb3vyy2vqywnr=0;cmvzb3vyy2vqywnr<resourcePacks.length;cmvzb3vyy2vqywnr++){ resourcePacks[cmvzb3vyy2vqywnr]=new sul.protocol.pocket100.types.Pack(); resourcePacks[cmvzb3vyy2vqywnr]._index=this._index; resourcePacks[cmvzb3vyy2vqywnr].decode(this._buffer); this._index=resourcePacks[cmvzb3vyy2vqywnr]._index; }
	}

	public static ResourcePacksInfo fromBuffer(byte[] buffer) {
		ResourcePacksInfo ret = new ResourcePacksInfo();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePacksInfo(mustAccept: " + this.mustAccept + ", behaviourPacks: " + Arrays.deepToString(this.behaviourPacks) + ", resourcePacks: " + Arrays.deepToString(this.resourcePacks) + ")";
	}

}
