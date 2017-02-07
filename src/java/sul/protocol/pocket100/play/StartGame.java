/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class StartGame extends Packet {

	public static final byte ID = (byte)12;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	// dimension
	public static final int OVERWORLD = 0;
	public static final int NETHER = 1;
	public static final int END = 2;

	// generator
	public static final int OLD = 0;
	public static final int INFINITE = 1;
	public static final int FLAT = 2;

	// world gamemode
	public static final int SURVIVAL = 0;
	public static final int CREATIVE = 1;

	// difficulty
	public static final int PEACEFUL = 0;
	public static final int EASY = 1;
	public static final int NORMAL = 2;
	public static final int HARD = 3;

	// edition
	public static final byte CLASSIC = 0;
	public static final byte EDUCATION = 1;

	public long entityId;
	public long runtimeId;
	public Tuples.FloatXYZ position;
	public float yaw;
	public float pitch;
	public int seed;
	public int dimension;
	public int generator;
	public int worldGamemode;
	public int difficulty;
	public Tuples.IntXYZ spawnPosition;
	public boolean loadedInCreative;
	public int time;
	public byte edition;
	public float rainLevel;
	public float lightingLevel;
	public boolean cheatsEnabled;
	public boolean textureRequired;
	public String levelId;
	public String worldName;

	public StartGame() {}

	public StartGame(long entityId, long runtimeId, Tuples.FloatXYZ position, float yaw, float pitch, int seed, int dimension, int generator, int worldGamemode, int difficulty, Tuples.IntXYZ spawnPosition, boolean loadedInCreative, int time, byte edition, float rainLevel, float lightingLevel, boolean cheatsEnabled, boolean textureRequired, String levelId, String worldName) {
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.seed = seed;
		this.dimension = dimension;
		this.generator = generator;
		this.worldGamemode = worldGamemode;
		this.difficulty = difficulty;
		this.spawnPosition = spawnPosition;
		this.loadedInCreative = loadedInCreative;
		this.time = time;
		this.edition = edition;
		this.rainLevel = rainLevel;
		this.lightingLevel = lightingLevel;
		this.cheatsEnabled = cheatsEnabled;
		this.textureRequired = textureRequired;
		this.levelId = levelId;
		this.worldName = worldName;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + Buffer.varintLength(seed) + Buffer.varintLength(dimension) + Buffer.varintLength(generator) + Buffer.varintLength(worldGamemode) + Buffer.varintLength(difficulty) + Buffer.varintLength(spawnPosition.x) + Buffer.varintLength(spawnPosition.y) + Buffer.varintLength(spawnPosition.z) + Buffer.varintLength(time) + Buffer.varuintLength(levelId.getBytes(StandardCharsets.UTF_8).length) + levelId.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(worldName.getBytes(StandardCharsets.UTF_8).length) + worldName.getBytes(StandardCharsets.UTF_8).length + 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(yaw);
		this.writeLittleEndianFloat(pitch);
		this.writeVarint(seed);
		this.writeVarint(dimension);
		this.writeVarint(generator);
		this.writeVarint(worldGamemode);
		this.writeVarint(difficulty);
		this.writeVarint(spawnPosition.x); this.writeVarint(spawnPosition.y); this.writeVarint(spawnPosition.z);
		this.writeBool(loadedInCreative);
		this.writeVarint(time);
		this.writeBigEndianByte(edition);
		this.writeLittleEndianFloat(rainLevel);
		this.writeLittleEndianFloat(lightingLevel);
		this.writeBool(cheatsEnabled);
		this.writeBool(textureRequired);
		byte[] bgv2zwxjza=levelId.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bgv2zwxjza.length); this.writeBytes(bgv2zwxjza);
		byte[] d29ybgroyw1l=worldName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)d29ybgroyw1l.length); this.writeBytes(d29ybgroyw1l);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		seed=this.readVarint();
		dimension=this.readVarint();
		generator=this.readVarint();
		worldGamemode=this.readVarint();
		difficulty=this.readVarint();
		spawnPosition.x=this.readVarint(); spawnPosition.y=this.readVarint(); spawnPosition.z=this.readVarint();
		loadedInCreative=this.readBool();
		time=this.readVarint();
		edition=readBigEndianByte();
		rainLevel=readLittleEndianFloat();
		lightingLevel=readLittleEndianFloat();
		cheatsEnabled=this.readBool();
		textureRequired=this.readBool();
		int bgvubgv2zwxjza=this.readVaruint(); levelId=new String(this.readBytes(bgvubgv2zwxjza), StandardCharsets.UTF_8);
		int bgvud29ybgroyw1l=this.readVaruint(); worldName=new String(this.readBytes(bgvud29ybgroyw1l), StandardCharsets.UTF_8);
	}

	public static StartGame fromBuffer(byte[] buffer) {
		StartGame ret = new StartGame();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "StartGame(entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", seed: " + this.seed + ", dimension: " + this.dimension + ", generator: " + this.generator + ", worldGamemode: " + this.worldGamemode + ", difficulty: " + this.difficulty + ", spawnPosition: " + this.spawnPosition.toString() + ", loadedInCreative: " + this.loadedInCreative + ", time: " + this.time + ", edition: " + this.edition + ", rainLevel: " + this.rainLevel + ", lightingLevel: " + this.lightingLevel + ", cheatsEnabled: " + this.cheatsEnabled + ", textureRequired: " + this.textureRequired + ", levelId: " + this.levelId + ", worldName: " + this.worldName + ")";
	}

}
