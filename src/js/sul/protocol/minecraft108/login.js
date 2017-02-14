/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
/** @module sul/protocol/minecraft108/login */

//import Types from 'types';

const Login = {

	Disconnect: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(reason="") {
			super();
			this.reason = reason;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			var dghpcy5yzwfzb24=this.encodeString(this.reason); this.writeVaruint(dghpcy5yzwfzb24.length); this.writeBytes(dghpcy5yzwfzb24);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.reason=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.Disconnect().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Disconnect(reason: " + this.reason + ")";
		}

	},

	LoginStart: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(username="") {
			super();
			this.username = username;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			var dghpcy51c2vybmft=this.encodeString(this.username); this.writeVaruint(dghpcy51c2vybmft.length); this.writeBytes(dghpcy51c2vybmft);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.username=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.LoginStart().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "LoginStart(username: " + this.username + ")";
		}

	},

	EncryptionRequest: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(serverId="", publicKey=[], verifyToken=[]) {
			super();
			this.serverId = serverId;
			this.publicKey = publicKey;
			this.verifyToken = verifyToken;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(1);
			var dghpcy5zzxj2zxjj=this.encodeString(this.serverId); this.writeVaruint(dghpcy5zzxj2zxjj.length); this.writeBytes(dghpcy5zzxj2zxjj);
			this.writeVaruint(this.publicKey.length); this.writeBytes(this.publicKey);
			this.writeVaruint(this.verifyToken.length); this.writeBytes(this.verifyToken);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.serverId=this.decodeString(this.readBytes(this.readVaruint()));
			var bhroaxmuchvibglj=this.readVaruint(); this.publicKey=this.readBytes(bhroaxmuchvibglj);
			var bhroaxmudmvyawz5=this.readVaruint(); this.verifyToken=this.readBytes(bhroaxmudmvyawz5);
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.EncryptionRequest().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "EncryptionRequest(serverId: " + this.serverId + ", publicKey: " + this.publicKey + ", verifyToken: " + this.verifyToken + ")";
		}

	},

	EncryptionResponse: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(sharedSecret=[], verifyToken=[]) {
			super();
			this.sharedSecret = sharedSecret;
			this.verifyToken = verifyToken;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(1);
			this.writeVaruint(this.sharedSecret.length); this.writeBytes(this.sharedSecret);
			this.writeVaruint(this.verifyToken.length); this.writeBytes(this.verifyToken);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			var bhroaxmuc2hhcmvk=this.readVaruint(); this.sharedSecret=this.readBytes(bhroaxmuc2hhcmvk);
			var bhroaxmudmvyawz5=this.readVaruint(); this.verifyToken=this.readBytes(bhroaxmudmvyawz5);
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.EncryptionResponse().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "EncryptionResponse(sharedSecret: " + this.sharedSecret + ", verifyToken: " + this.verifyToken + ")";
		}

	},

	LoginSuccess: class extends Buffer {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(uuid="", username="") {
			super();
			this.uuid = uuid;
			this.username = username;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(2);
			var dghpcy51dwlk=this.encodeString(this.uuid); this.writeVaruint(dghpcy51dwlk.length); this.writeBytes(dghpcy51dwlk);
			var dghpcy51c2vybmft=this.encodeString(this.username); this.writeVaruint(dghpcy51c2vybmft.length); this.writeBytes(dghpcy51c2vybmft);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.uuid=this.decodeString(this.readBytes(this.readVaruint()));
			this.username=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.LoginSuccess().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "LoginSuccess(uuid: " + this.uuid + ", username: " + this.username + ")";
		}

	},

	SetCompression: class extends Buffer {

		static get ID(){ return 3; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(thresold=0) {
			super();
			this.thresold = thresold;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(3);
			this.writeVaruint(this.thresold);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.thresold=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.SetCompression().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "SetCompression(thresold: " + this.thresold + ")";
		}

	},

}

//export { Login };
