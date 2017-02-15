/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
/** @module sul/protocol/hncom1/login */

//import Types from 'types';

/**
 * Packets used during the authentication process to exchange informations.
 */
const Login = {

	/**
	 * First real packet sent by the client with its informations.
	 */
	ConnectionRequest: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param protocol
		 *        Version of the protocol used by the client that must match the hub's one
		 * @param password
		 *        Password, if the hub requires one, or an empty string.
		 * @param name
		 *        Name of the node that will be validated by the hub. It should always be lowercase and only contain
		 *        letters, numbers and basic punctuation symbols.
		 * @param main
		 *        Indicates whether the node accepts clients when they first connect to the hub or exclusively when
		 *        they are manually transferred.
		 */
		constructor(protocol=0, password="", name="", main=false) {
			super();
			this.protocol = protocol;
			this.password = password;
			this.name = name;
			this.main = main;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(1);
			this.writeVaruint(this.protocol);
			var dghpcy5wyxnzd29y=this.encodeString(this.password); this.writeVaruint(dghpcy5wyxnzd29y.length); this.writeBytes(dghpcy5wyxnzd29y);
			var dghpcy5uyw1l=this.encodeString(this.name); this.writeVaruint(dghpcy5uyw1l.length); this.writeBytes(dghpcy5uyw1l);
			this.writeBigEndianByte(this.main?1:0);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.protocol=this.readVaruint();
			this.password=this.decodeString(this.readBytes(this.readVaruint()));
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			this.main=this.readBigEndianByte()!==0;
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.ConnectionRequest().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ConnectionRequest(protocol: " + this.protocol + ", password: " + this.password + ", name: " + this.name + ", main: " + this.main + ")";
		}

	},

	/**
	 * Reply always sent after the ConnectionRequest packet. It indicates the status of
	 * the connection, which is accepted only when every field of the packet is true.
	 */
	ConnectionResponse: class extends Buffer {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// status
		static get OK(){ return 0; }
		static get OUTDATED_HUB(){ return 1; }
		static get OUTDATED_NODE(){ return 2; }
		static get PASSWORD_REQUIRED(){ return 3; }
		static get WRONG_PASSWORD(){ return 4; }
		static get INVALID_NAME_LENGTH(){ return 5; }
		static get INVALID_NAME_CHARACTERS(){ return 6; }
		static get NAME_ALREADY_USED(){ return 7; }
		static get NAME_RESERVED(){ return 8; }

		/**
		 * @param protocol
		 *        Protocol used by the hub. It must match the node's one otherwise the connection cannot be established.
		 * @param status
		 *        Indicates the status of connection. If not 0, it indicates an error.
		 */
		constructor(protocol=0, status=0) {
			super();
			this.protocol = protocol;
			this.status = status;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(2);
			this.writeVaruint(this.protocol);
			this.writeBigEndianByte(this.status);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.protocol=this.readVaruint();
			this.status=this.readBigEndianByte();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.ConnectionResponse().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ConnectionResponse(protocol: " + this.protocol + ", status: " + this.status + ")";
		}

	},

	/**
	 * Informations about the hub.
	 */
	HubInfo: class extends Buffer {

		static get ID(){ return 3; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// max
		static get UNLIMITED(){ return -1; }

		/**
		 * @param time
		 *        Unix time in microseconds precision that indicates the exact moment when this packet was created.
		 *        It's used by the node to calculate the latency.
		 * @param serverId
		 *        Server's id, either given by a snoop system or randomly generated at runtime.
		 * @param reservedUuids
		 *        First number of the 4,294,967,296 (2³²) reserved by the hub to create the node's UUIDs. Every
		 *        UUID generated by the node is formed by the server's id (most signicant) and the next reserved uuid
		 *        (least significant). This way every UUID in the hub and in the connected nodes is always different.
		 * @param displayName
		 *        Unformatted name of the server as indicated in the hub's configuration file.
		 * @param onlineMode
		 *        Indicates whether the player are authenticated using the games' official authentication services
		 *        and their identity should be trusted.
		 * @param gamesInfo
		 *        Informations about the games supported by the hub.
		 * @param online
		 *        Number of players currently online and connected to other nodes.
		 * @param max
		 *        Number of maximum players that can connect to the server. The number may change after this node connects.
		 * @param language
		 *        Default server's language in format (language_COUNTRY, e.g. en_GB) and also the default language
		 *        for players that don't specify their language or for the ones which language is not supported by
		 *        the server.
		 * @param acceptedLanguages
		 *        Languages accepted by the server in the same format as {language}. The list should always contain
		 *        at least one element (the default language).
		 * @param socialJson
		 *        Optional informations about the server's website and social accounts in the format indicated
		 *        below.
		 * @param additionalJson
		 *        Optional informations about the server's software, system and options in the format indicated
		 *        below.
		 */
		constructor(time=0, serverId=0, reservedUuids=0, displayName="", onlineMode=false, gamesInfo=[], online=0, max=0, language="", acceptedLanguages=[], socialJson="", additionalJson="") {
			super();
			this.time = time;
			this.serverId = serverId;
			this.reservedUuids = reservedUuids;
			this.displayName = displayName;
			this.onlineMode = onlineMode;
			this.gamesInfo = gamesInfo;
			this.online = online;
			this.max = max;
			this.language = language;
			this.acceptedLanguages = acceptedLanguages;
			this.socialJson = socialJson;
			this.additionalJson = additionalJson;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(3);
			this.writeVarulong(this.time);
			this.writeVarulong(this.serverId);
			this.writeVarulong(this.reservedUuids);
			var dghpcy5kaxnwbgf5=this.encodeString(this.displayName); this.writeVaruint(dghpcy5kaxnwbgf5.length); this.writeBytes(dghpcy5kaxnwbgf5);
			this.writeBigEndianByte(this.onlineMode?1:0);
			this.writeVaruint(this.gamesInfo.length); for(var dghpcy5nyw1lc0lu in this.gamesInfo){ this.writeBytes(this.gamesInfo[dghpcy5nyw1lc0lu].encode()); }
			this.writeVaruint(this.online);
			this.writeVarint(this.max);
			var dghpcy5syw5ndwfn=this.encodeString(this.language); this.writeVaruint(dghpcy5syw5ndwfn.length); this.writeBytes(dghpcy5syw5ndwfn);
			this.writeVaruint(this.acceptedLanguages.length); for(var dghpcy5hy2nlchrl in this.acceptedLanguages){ var dghpcy5hy2nlchrl=this.encodeString(this.acceptedLanguages[dghpcy5hy2nlchrl]); this.writeVaruint(dghpcy5hy2nlchrl.length); this.writeBytes(dghpcy5hy2nlchrl); }
			var dghpcy5zb2npywxk=this.encodeString(this.socialJson); this.writeVaruint(dghpcy5zb2npywxk.length); this.writeBytes(dghpcy5zb2npywxk);
			var dghpcy5hzgrpdglv=this.encodeString(this.additionalJson); this.writeVaruint(dghpcy5hzgrpdglv.length); this.writeBytes(dghpcy5hzgrpdglv);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.time=this.readVarulong();
			this.serverId=this.readVarulong();
			this.reservedUuids=this.readVarulong();
			this.displayName=this.decodeString(this.readBytes(this.readVaruint()));
			this.onlineMode=this.readBigEndianByte()!==0;
			var bhroaxmuz2ftzxnj=this.readVaruint(); this.gamesInfo=[]; for(var dghpcy5nyw1lc0lu in this.gamesInfo){ this.gamesInfo[dghpcy5nyw1lc0lu]=Types.GameInfo.fromBuffer(this._buffer); this._buffer=this.gamesInfo[dghpcy5nyw1lc0lu]._buffer; }
			this.online=this.readVaruint();
			this.max=this.readVarint();
			this.language=this.decodeString(this.readBytes(this.readVaruint()));
			var bhroaxmuywnjzxb0=this.readVaruint(); this.acceptedLanguages=[]; for(var dghpcy5hy2nlchrl in this.acceptedLanguages){ this.acceptedLanguages[dghpcy5hy2nlchrl]=this.decodeString(this.readBytes(this.readVaruint())); }
			this.socialJson=this.decodeString(this.readBytes(this.readVaruint()));
			this.additionalJson=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.HubInfo().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "HubInfo(time: " + this.time + ", serverId: " + this.serverId + ", reservedUuids: " + this.reservedUuids + ", displayName: " + this.displayName + ", onlineMode: " + this.onlineMode + ", gamesInfo: " + this.gamesInfo + ", online: " + this.online + ", max: " + this.max + ", language: " + this.language + ", acceptedLanguages: " + this.acceptedLanguages + ", socialJson: " + this.socialJson + ", additionalJson: " + this.additionalJson + ")";
		}

	},

	/**
	 * Informations about the node.
	 */
	NodeInfo: class extends Buffer {

		static get ID(){ return 4; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// max
		static get UNLIMITED(){ return 0; }

		/**
		 * @param time
		 *        Unix time in microseconds precision that indicates the exact moment when this packet was created.
		 *        It's used by the hub to calculate the latency.
		 * @param max
		 *        Maximum number of players accepted by node.
		 * @param acceptedGames
		 *        Informations about the games accepted by the node. There should be at least one combination of game/protocol
		 *        that is also accepted by hub as indicated in {HubInfo.gamesInfo}, otherwise the node will never
		 *        receive any player.
		 * @param plugins
		 *        List of plugins loaded on the node for creating queries on the hub.
		 * @param additionalJson
		 *        Optional informations about the server's software and system, similar to {HubInfo.additionalJson}.
		 */
		constructor(time=0, max=0, acceptedGames=[], plugins=[], additionalJson="") {
			super();
			this.time = time;
			this.max = max;
			this.acceptedGames = acceptedGames;
			this.plugins = plugins;
			this.additionalJson = additionalJson;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(4);
			this.writeVarulong(this.time);
			this.writeVaruint(this.max);
			this.writeVaruint(this.acceptedGames.length); for(var dghpcy5hy2nlchrl in this.acceptedGames){ this.writeBytes(this.acceptedGames[dghpcy5hy2nlchrl].encode()); }
			this.writeVaruint(this.plugins.length); for(var dghpcy5wbhvnaw5z in this.plugins){ this.writeBytes(this.plugins[dghpcy5wbhvnaw5z].encode()); }
			var dghpcy5hzgrpdglv=this.encodeString(this.additionalJson); this.writeVaruint(dghpcy5hzgrpdglv.length); this.writeBytes(dghpcy5hzgrpdglv);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readBigEndianByte();
			this.time=this.readVarulong();
			this.max=this.readVaruint();
			var bhroaxmuywnjzxb0=this.readVaruint(); this.acceptedGames=[]; for(var dghpcy5hy2nlchrl in this.acceptedGames){ this.acceptedGames[dghpcy5hy2nlchrl]=Types.Game.fromBuffer(this._buffer); this._buffer=this.acceptedGames[dghpcy5hy2nlchrl]._buffer; }
			var bhroaxmucgx1z2lu=this.readVaruint(); this.plugins=[]; for(var dghpcy5wbhvnaw5z in this.plugins){ this.plugins[dghpcy5wbhvnaw5z]=Types.Plugin.fromBuffer(this._buffer); this._buffer=this.plugins[dghpcy5wbhvnaw5z]._buffer; }
			this.additionalJson=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Login.NodeInfo().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "NodeInfo(time: " + this.time + ", max: " + this.max + ", acceptedGames: " + this.acceptedGames + ", plugins: " + this.plugins + ", additionalJson: " + this.additionalJson + ")";
		}

	},

}

//export { Login };
