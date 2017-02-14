/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
/** @module sul/protocol/hncom1/player */

//import Types from 'types';

/**
 * Packets related to a player. The first field of every packet is an `hub id` that
 * uniquely identifies a player in the hub and never changes until it's disconnected.
 */
const Player = {

	/**
	 * Adds a player to the node.
	 */
	Add: class extends Buffer {

		static get ID(){ return 15; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// reason
		static get FIRST_JOIN(){ return 0; }
		static get TRANSFERRED(){ return 1; }
		static get FORCIBLY_TRANSFERRED(){ return 2; }

		// input mode
		static get KEYBOARD(){ return 0; }
		static get TOUCH(){ return 1; }
		static get CONTROLLER(){ return 2; }

		/**
		 * @param reason
		 *        Reason for which the player has been added to the node.
		 * @param type
		 *        Game of the client, which could either be Minecraft or Minecraft: Pocket Edition.
		 * @param protocol
		 *        Version of the protocol used by the client.
		 * @param version
		 *        Version of the game used by the client, usually in the format major.minor[.patch], calculated
		 *        by the server or passed by the client during the authentication process. The node should verify
		 *        that the version exists and matches the protocol in the previous field.
		 * @param username
		 *        Username of the player.
		 * @param displayName
		 *        Display name of the player, which can contain formatting codes. By default it's equals to the username
		 *        but it can be updated by the node using {UpdateDisplayName}.
		 * @param dimension
		 *        Dimension in which the player was playing before being transferred. It could diffent from client's
		 *        game type and version because the dimension's ids are different in Minecraft and Minecraft: Pocket
		 *        Edition.
		 *        It's used to send the game's change dimension packet to despawn old entities and delete old chunks.
		 * @param viewDistance
		 *        Client's view distance (or chunk radius). See {UpdateViewDistance.viewDistance} for more informations.
		 * @param clientAddress
		 *        Remote address of the client.
		 * @param serverAddress
		 *        Ip used by the client to connect to the server. The value of this field is the address the client has
		 *        saved in its servers list. For example a client that joins through `localhost` and a client that
		 *        joins through `127.0.0.1` will connect to the same server but the field of this value will be different
		 *        (`localhost` for the first client and `127.0.0.1` for the second).
		 * @param serverPort
		 *        Port used by the client to connect to the server.
		 * @param uuid
		 *        Client's UUID, given by Mojang's or Microsoft's services if the server is in online mode or given
		 *        by the client (and not verified) if the server is in offline mode.
		 * @param skin
		 *        Client's skin, given by the client or downloaded from Mojang's services in online mode.
		 * @param language
		 *        Client's language, in the same format as {HubInfo.language}, which should be updated from the
		 *        node when the client changes it. See also {UpdateLanguage.language}.
		 * @param inputMode
		 *        Client's input mode. See {UpdateInputMode.inputMode} for more informations.
		 * @param latency
		 *        Client's latency (ping time). See {UpdateLatency.latency} for more informations.
		 */
		constructor(hubId=0, reason=0, type=0, protocol=0, version="", username="", displayName="", dimension=0, viewDistance=0, clientAddress=null, serverAddress="", serverPort=0, uuid=new Uint8Array(16), skin=null, language="", inputMode=0, latency=0) {
			super();
			this.hubId = hubId;
			this.reason = reason;
			this.type = type;
			this.protocol = protocol;
			this.version = version;
			this.username = username;
			this.displayName = displayName;
			this.dimension = dimension;
			this.viewDistance = viewDistance;
			this.clientAddress = clientAddress;
			this.serverAddress = serverAddress;
			this.serverPort = serverPort;
			this.uuid = uuid;
			this.skin = skin;
			this.language = language;
			this.inputMode = inputMode;
			this.latency = latency;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(15);
			this.writeVaruint(this.hubId);
			this.writeBigEndianByte(this.reason);
			this.writeBigEndianByte(this.type);
			this.writeVaruint(this.protocol);
			var dghpcy52zxjzaw9u=this.encodeString(this.version); this.writeVaruint(dghpcy52zxjzaw9u.length); this.writeBytes(dghpcy52zxjzaw9u);
			var dghpcy51c2vybmft=this.encodeString(this.username); this.writeVaruint(dghpcy51c2vybmft.length); this.writeBytes(dghpcy51c2vybmft);
			var dghpcy5kaxnwbgf5=this.encodeString(this.displayName); this.writeVaruint(dghpcy5kaxnwbgf5.length); this.writeBytes(dghpcy5kaxnwbgf5);
			if(reason!=0){ this.writeBigEndianByte(this.dimension); }
			if(reason!=0){ this.writeVaruint(this.viewDistance); }
			this.writeBytes(this.clientAddress.encode());
			var dghpcy5zzxj2zxjb=this.encodeString(this.serverAddress); this.writeVaruint(dghpcy5zzxj2zxjb.length); this.writeBytes(dghpcy5zzxj2zxjb);
			this.writeBigEndianShort(this.serverPort);
			this.writeBytes(this.uuid);
			this.writeBytes(this.skin.encode());
			var dghpcy5syw5ndwfn=this.encodeString(this.language); this.writeVaruint(dghpcy5syw5ndwfn.length); this.writeBytes(dghpcy5syw5ndwfn);
			this.writeBigEndianByte(this.inputMode);
			this.writeVaruint(this.latency);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.reason=this.readBigEndianByte();
			this.type=this.readBigEndianByte();
			this.protocol=this.readVaruint();
			this.version=this.decodeString(this.readBytes(this.readVaruint()));
			this.username=this.decodeString(this.readBytes(this.readVaruint()));
			this.displayName=this.decodeString(this.readBytes(this.readVaruint()));
			if(reason!=0){ this.dimension=this.readBigEndianByte(); }
			if(reason!=0){ this.viewDistance=this.readVaruint(); }
			this.clientAddress=Types.Address.fromBuffer(this._buffer.slice(this._index)); this._index+=this.clientAddress._index;
			this.serverAddress=this.decodeString(this.readBytes(this.readVaruint()));
			this.serverPort=this.readBigEndianShort();
			this.uuid=this.readBytes(16);
			this.skin=Types.Skin.fromBuffer(this._buffer.slice(this._index)); this._index+=this.skin._index;
			this.language=this.decodeString(this.readBytes(this.readVaruint()));
			this.inputMode=this.readBigEndianByte();
			this.latency=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.Add().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Add(hubId: " + this.hubId + ", reason: " + this.reason + ", type: " + this.type + ", protocol: " + this.protocol + ", version: " + this.version + ", username: " + this.username + ", displayName: " + this.displayName + ", dimension: " + this.dimension + ", viewDistance: " + this.viewDistance + ", clientAddress: " + this.clientAddress + ", serverAddress: " + this.serverAddress + ", serverPort: " + this.serverPort + ", uuid: " + this.uuid + ", skin: " + this.skin + ", language: " + this.language + ", inputMode: " + this.inputMode + ", latency: " + this.latency + ")";
		}

	},

	/**
	 * Removes a player from the node. If the player is removed using Kick or Transfer
	 * this packet is not sent.
	 */
	Remove: class extends Buffer {

		static get ID(){ return 16; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// reason
		static get LEFT(){ return 0; }
		static get TIMED_OUT(){ return 1; }
		static get KICKED(){ return 2; }
		static get TRANSFERRED(){ return 3; }

		/**
		 * @param reason
		 *        Reason of the disconnection.
		 */
		constructor(hubId=0, reason=0) {
			super();
			this.hubId = hubId;
			this.reason = reason;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(16);
			this.writeVaruint(this.hubId);
			this.writeBigEndianByte(this.reason);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.reason=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.Remove().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Remove(hubId: " + this.hubId + ", reason: " + this.reason + ")";
		}

	},

	/**
	 * Kicks a player from the node and the whole server. When a player is disconnected
	 * from the node using this packet the hub will not send the Remove packet.
	 */
	Kick: class extends Buffer {

		static get ID(){ return 17; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param reason
		 *        Reason of the disconnection that will be displayed in the client's disconnection screen.
		 * @param translation
		 *        Whether the previous string should be translated client-side or not.
		 * @param parameters
		 *        Optional parameters for the translation.
		 */
		constructor(hubId=0, reason="", translation=false, parameters=[]) {
			super();
			this.hubId = hubId;
			this.reason = reason;
			this.translation = translation;
			this.parameters = parameters;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(17);
			this.writeVaruint(this.hubId);
			var dghpcy5yzwfzb24=this.encodeString(this.reason); this.writeVaruint(dghpcy5yzwfzb24.length); this.writeBytes(dghpcy5yzwfzb24);
			this.writeBigEndianByte(this.translation?1:0);
			if(translation==true){ this.writeVaruint(this.parameters.length); for(var dghpcy5wyxjhbwv0 in this.parameters){ var dghpcy5wyxjhbwv0=this.encodeString(this.parameters[dghpcy5wyxjhbwv0]); this.writeVaruint(dghpcy5wyxjhbwv0.length); this.writeBytes(dghpcy5wyxjhbwv0); } }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.reason=this.decodeString(this.readBytes(this.readVaruint()));
			this.translation=this.readBigEndianByte()!==0;
			if(translation==true){ var bhroaxmucgfyyw1l=this.readVaruint(); this.parameters=[]; for(var dghpcy5wyxjhbwv0 in this.parameters){ this.parameters[dghpcy5wyxjhbwv0]=this.decodeString(this.readBytes(this.readVaruint())); } }
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.Kick().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Kick(hubId: " + this.hubId + ", reason: " + this.reason + ", translation: " + this.translation + ", parameters: " + this.parameters + ")";
		}

	},

	/**
	 * Transfers a player to another node. When a player is transferred from the node the
	 * hub will not send the Remove packet and there's no way, for the node, to know whether
	 * the player was disconnected or successfully transferred, if not using messages through
	 * a user-defined protocol.
	 */
	Transfer: class extends Buffer {

		static get ID(){ return 18; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// on fail
		static get DISCONNECT(){ return 0; }
		static get AUTO(){ return 1; }
		static get RECONNECT(){ return 2; }

		/**
		 * @param node
		 *        Id of the node that player will be transferred to. It should be an id of a connected node (which can
		 *        be calculated using {AddNode} and {RemoveNode}), otherwise the player will be disconnected or
		 *        moved to another node (see the following field).
		 * @param onFail
		 *        Indicates the action to be taken when a transfer fails because the indicated node is not connected
		 *        anymore or it cannot accept the given player's game type or protocol. If the indicated node is full
		 *        the player will be simply disconnected with the `Server Full` message.
		 */
		constructor(hubId=0, node=0, onFail=0) {
			super();
			this.hubId = hubId;
			this.node = node;
			this.onFail = onFail;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(18);
			this.writeVaruint(this.hubId);
			this.writeVaruint(this.node);
			this.writeBigEndianByte(this.onFail);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.node=this.readVaruint();
			this.onFail=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.Transfer().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Transfer(hubId: " + this.hubId + ", node: " + this.node + ", onFail: " + this.onFail + ")";
		}

	},

	/**
	 * Updates the player's display name when it changes.
	 */
	UpdateDisplayName: class extends Buffer {

		static get ID(){ return 19; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param displayName
		 *        Player's display name that can contain formatting codes. Prefixes and suffixes should be avoided.
		 */
		constructor(hubId=0, displayName="") {
			super();
			this.hubId = hubId;
			this.displayName = displayName;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(19);
			this.writeVaruint(this.hubId);
			var dghpcy5kaxnwbgf5=this.encodeString(this.displayName); this.writeVaruint(dghpcy5kaxnwbgf5.length); this.writeBytes(dghpcy5kaxnwbgf5);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.displayName=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdateDisplayName().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateDisplayName(hubId: " + this.hubId + ", displayName: " + this.displayName + ")";
		}

	},

	/**
	 * Updates player's world and dimension.
	 */
	UpdateWorld: class extends Buffer {

		static get ID(){ return 20; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param world
		 *        World's name, used mainly for display purposes.
		 * @param dimension
		 *        World's dimension, that may differ from Minecraft's version. It's used for synchronise entities
		 *        and chunks when changing node as described at {Add.dimension}.
		 */
		constructor(hubId=0, world="", dimension=0) {
			super();
			this.hubId = hubId;
			this.world = world;
			this.dimension = dimension;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(20);
			this.writeVaruint(this.hubId);
			var dghpcy53b3jsza=this.encodeString(this.world); this.writeVaruint(dghpcy53b3jsza.length); this.writeBytes(dghpcy53b3jsza);
			this.writeBigEndianByte(this.dimension);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.world=this.decodeString(this.readBytes(this.readVaruint()));
			this.dimension=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdateWorld().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateWorld(hubId: " + this.hubId + ", world: " + this.world + ", dimension: " + this.dimension + ")";
		}

	},

	UpdateViewDistance: class extends Buffer {

		static get ID(){ return 21; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(hubId=0, viewDistance=0) {
			super();
			this.hubId = hubId;
			this.viewDistance = viewDistance;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(21);
			this.writeVaruint(this.hubId);
			this.writeVaruint(this.viewDistance);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.viewDistance=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdateViewDistance().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateViewDistance(hubId: " + this.hubId + ", viewDistance: " + this.viewDistance + ")";
		}

	},

	/**
	 * Updates the player's language when the client changes it.
	 */
	UpdateLanguage: class extends Buffer {

		static get ID(){ return 22; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param language
		 *        Player's language in the same format as {HubInfo.language}.
		 */
		constructor(hubId=0, language="") {
			super();
			this.hubId = hubId;
			this.language = language;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(22);
			this.writeVaruint(this.hubId);
			var dghpcy5syw5ndwfn=this.encodeString(this.language); this.writeVaruint(dghpcy5syw5ndwfn.length); this.writeBytes(dghpcy5syw5ndwfn);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.language=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdateLanguage().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateLanguage(hubId: " + this.hubId + ", language: " + this.language + ")";
		}

	},

	/**
	 * Update the player's current input mode.
	 */
	UpdateInputMode: class extends Buffer {

		static get ID(){ return 23; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// input mode
		static get KEYBOARD(){ return 0; }
		static get TOUCH(){ return 1; }
		static get CONTROLLER(){ return 2; }

		/**
		 * @param inputMode
		 *        Player's input mode.
		 */
		constructor(hubId=0, inputMode=0) {
			super();
			this.hubId = hubId;
			this.inputMode = inputMode;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(23);
			this.writeVaruint(this.hubId);
			this.writeBigEndianByte(this.inputMode);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.inputMode=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdateInputMode().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateInputMode(hubId: " + this.hubId + ", inputMode: " + this.inputMode + ")";
		}

	},

	/**
	 * Updates the latency between the player and the hub.
	 */
	UpdateLatency: class extends Buffer {

		static get ID(){ return 24; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param latency
		 *        Player's latency in milliseconds. The latency between the client and the node is then calculated
		 *        adding the latency between the node and the hub (calculated using {HubInfo.time}) to this field's
		 *        value.
		 */
		constructor(hubId=0, latency=0) {
			super();
			this.hubId = hubId;
			this.latency = latency;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(24);
			this.writeVaruint(this.hubId);
			this.writeVaruint(this.latency);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.latency=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdateLatency().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateLatency(hubId: " + this.hubId + ", latency: " + this.latency + ")";
		}

	},

	/**
	 * Updates the player's packet loss if it uses a connectionless protocol like UDP.
	 */
	UpdatePacketLoss: class extends Buffer {

		static get ID(){ return 25; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param packetLoss
		 *        Percentage of lost packets in range 0 (no packet lost) to 100 (every packet lost).
		 */
		constructor(hubId=0, packetLoss=.0) {
			super();
			this.hubId = hubId;
			this.packetLoss = packetLoss;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(25);
			this.writeVaruint(this.hubId);
			this.writeBigEndianFloat(this.packetLoss);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.packetLoss=this.readBigEndianFloat();
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.UpdatePacketLoss().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdatePacketLoss(hubId: " + this.hubId + ", packetLoss: " + this.packetLoss + ")";
		}

	},

	/**
	 * Sends data to client or handles data received from the client.
	 */
	GamePacket: class extends Buffer {

		static get ID(){ return 26; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param packet
		 *        Serialised packet ready to be encrypted or encapsulated and sent to the client when this packet
		 *        is serverbound or packet already unencrypted and uncompressed ready to be handled by the node otherwise.
		 */
		constructor(hubId=0, packet=null) {
			super();
			this.hubId = hubId;
			this.packet = packet;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(26);
			this.writeVaruint(this.hubId);
			this.writeBytes(this.packet);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.packet=this.readBytes(this._buffer.length-this._index);
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.GamePacket().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "GamePacket(hubId: " + this.hubId + ", packet: " + this.packet + ")";
		}

	},

	/**
	 * Sends data to the client but order it because it could be sent by the node unordered,
	 * due to compressed packet sent delayed.
	 */
	OrderedGamePacket: class extends Buffer {

		static get ID(){ return 27; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param order
		 *        Order of the packet. If the hub receives a packet with an id different from 0 or the latest ordered
		 *        packet's order + 1 it should wait for the packets with the missing order(s) before sending.
		 * @param packet
		 *        Serialised packet (see {GamePacket.packet}).
		 */
		constructor(hubId=0, order=0, packet=null) {
			super();
			this.hubId = hubId;
			this.order = order;
			this.packet = packet;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(27);
			this.writeVaruint(this.hubId);
			this.writeVaruint(this.order);
			this.writeBytes(this.packet);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.order=this.readVaruint();
			this.packet=this.readBytes(this._buffer.length-this._index);
			return this;
		}

		static fromBuffer(buffer) {
			return new Player.OrderedGamePacket().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "OrderedGamePacket(hubId: " + this.hubId + ", order: " + this.order + ", packet: " + this.packet + ")";
		}

	},

}

//export { Player };
