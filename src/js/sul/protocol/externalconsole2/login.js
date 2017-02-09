/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole2.xml
 */
/** @module sul/protocol/externalconsole2/login */

//import Types from 'types';

/**
 * Packets used during the authentication process and to exhange the initial server's
 * informations.
 */
const Login = {

	/**
	 * First packet sent by the server when the connection is successfully established.
	 * It contains informations about how the external console shall authenticate itself.
	 */
	AuthCredentials: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param protocol
		 *        Protocol used by the server. If the client uses a different one it should close the connection without
		 *        trying to perform authentication.
		 * @param hash
		 *        Whether to perform hashing on the password or not.
		 * @param hashAlgorithm
		 *        Algorithm used by the server to hash the concatenation of the password and the payload. The value
		 *        should be sent in lower case without any separation symbol (for example `md5` instead of `MD5`,
		 *        `sha256` instead of `SHA-256`).See Auth.hash for more details.
		 * @param payload
		 *        Payload to cancatenate to the password before hashing it, as described in the Auth.hash's field
		 *        description.
		 */
		constructor(protocol=0, hash=false, hashAlgorithm="", payload=[]) {
			this.protocol = protocol;
			this.hash = hash;
			this.hashAlgorithm = hashAlgorithm;
			this.payload = payload;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeByte(this.ID);
			this.writeByte(protocol);
			this.writeBool(hash);
			this.writeString(hashAlgorithm);
			this.writeBigEndianShort(payload.length); for(cgf5bg9hza in payload){ this.writeByte(payload[cgf5bg9hza]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.AuthCredentials().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "AuthCredentials(protocol: " + this.protocol + ", hash: " + this.hash + ", hashAlgorithm: " + this.hashAlgorithm + ", payload: " + this.payload + ")";
		}

	},

	/**
	 * Performs authentication following the instruncions given by the AuthCredentials
	 * packet.
	 */
	Auth: class {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param hash
		 *        Pasword encoded as UTF-8 if AuthCredentials.hash is `false` or the hash (specified in AuthCredentials.hashAlgorithm)
		 *        of the password encoded as UTF-8 concatenated with the bytes from AuthCredentials.payload if
		 *        `true`.The hash can be done with a function (if hashAlgorithm is `sha1`) in D:```dsha1Of(cast(ubyte[])password
		 *        ~ authCredentials.payload);```Or using `MessageDigest` in Java:```javaMessageDigest md
		 *        = MessageDigest.getInstance(authCredentials.hashAlgorithm);md.update(password.getBytes(StandardCharsets.UTF_8));md.update(authCredentials.payload);byte[]
		 *        hash = md.digest();```
		 */
		constructor(hash=[]) {
			this.hash = hash;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeByte(this.ID);
			this.writeBigEndianShort(hash.length); for(agfzaa in hash){ this.writeByte(hash[agfzaa]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.Auth().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Auth(hash: " + this.hash + ")";
		}

	},

	/**
	 * Indicates the status of the authentication process.
	 */
	Welcome: class {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(status=0) {
			this.status = status;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeByte(this.ID);
			this.writeByte(status);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		static fromBuffer(buffer) {
			return new Login.Welcome().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Welcome(status: " + this.status + ")";
		}

	},

}

//export { Login };
