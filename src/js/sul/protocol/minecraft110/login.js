/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
/** @module sul/protocol/minecraft110/login */

//import Types from 'types';

const Login = {

	Disconnect: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(reason="") {
			this.reason = reason;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(reason);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	LoginStart: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(username="") {
			this.username = username;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(username);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	EncryptionRequest: class {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(serverId="", publicKey=[], verifyToken=[]) {
			this.serverId = serverId;
			this.publicKey = publicKey;
			this.verifyToken = verifyToken;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(serverId);
			this.writeVaruint(publicKey.length); for(chvibgljs2v5 in publicKey){ this.writeByte(publicKey[chvibgljs2v5]); }
			this.writeVaruint(verifyToken.length); for(dmvyawz5vg9rzw4 in verifyToken){ this.writeByte(verifyToken[dmvyawz5vg9rzw4]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	EncryptionResponse: class {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor(sharedSecret=[], verifyToken=[]) {
			this.sharedSecret = sharedSecret;
			this.verifyToken = verifyToken;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(sharedSecret.length); for(c2hhcmvku2vjcmv0 in sharedSecret){ this.writeByte(sharedSecret[c2hhcmvku2vjcmv0]); }
			this.writeVaruint(verifyToken.length); for(dmvyawz5vg9rzw4 in verifyToken){ this.writeByte(verifyToken[dmvyawz5vg9rzw4]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	LoginSuccess: class {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(uuid="", username="") {
			this.uuid = uuid;
			this.username = username;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(uuid);
			this.writeString(username);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	SetCompression: class {

		static get ID(){ return 3; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(thresold=0) {
			this.thresold = thresold;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(thresold);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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
