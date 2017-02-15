/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class NamedSoundEffect extends Packet {

	public static final int ID = (int)25;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String name;
	public int category;
	public Tuples.IntXYZ position;
	public float volume;
	public float pitch;

	public NamedSoundEffect() {}

	public NamedSoundEffect(String name, int category, Tuples.IntXYZ position, float volume, float pitch) {
		this.name = name;
		this.category = category;
		this.position = position;
		this.volume = volume;
		this.pitch = pitch;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(category) + 20;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeVaruint(category);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.y); this.writeBigEndianInt(position.z);
		this.writeBigEndianFloat(volume);
		this.writeBigEndianFloat(pitch);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvubmftzq=this.readVaruint(); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		category=this.readVaruint();
		position=new Tuples.IntXYZ(); position.x=readBigEndianInt(); position.y=readBigEndianInt(); position.z=readBigEndianInt();
		volume=readBigEndianFloat();
		pitch=readBigEndianFloat();
	}

	public static NamedSoundEffect fromBuffer(byte[] buffer) {
		NamedSoundEffect ret = new NamedSoundEffect();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "NamedSoundEffect(name: " + this.name + ", category: " + this.category + ", position: " + this.position.toString() + ", volume: " + this.volume + ", pitch: " + this.pitch + ")";
	}

}
